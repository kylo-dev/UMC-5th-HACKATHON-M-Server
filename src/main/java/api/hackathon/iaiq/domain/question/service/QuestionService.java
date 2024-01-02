package api.hackathon.iaiq.domain.question.service;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.question.answer.domain.Answer;
import api.hackathon.iaiq.domain.question.answer.dto.request.AnswerCreateRequest;
import api.hackathon.iaiq.domain.question.answer.dto.request.AnswerEditRequest;
import api.hackathon.iaiq.domain.question.answer.dto.request.SearchCondition;
import api.hackathon.iaiq.domain.question.answer.dto.response.AnswerResponse;
import api.hackathon.iaiq.domain.question.answer.service.AnswerService;
import api.hackathon.iaiq.domain.question.domain.Category;
import api.hackathon.iaiq.domain.question.domain.Question;
import api.hackathon.iaiq.domain.question.dto.request.QuestionRequest;
import api.hackathon.iaiq.domain.question.dto.request.QuestionResponse;
import api.hackathon.iaiq.domain.question.repository.QuestionRepository;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    public QuestionResponse findByCategory(QuestionRequest questionRequest) {
        Category category = questionRequest.getCategory();

        List<Question> questions = questionRepository.findByQnaType(category);
        int randomIndex = ThreadLocalRandom.current().nextInt(questions.size());
        Question question = questions.get(randomIndex);
        return QuestionResponse.builder()
                .questionId(question.getId())
                .qnaType(question.getQnaType())
                .content(question.getContent())
                .build();
    }

    public AnswerResponse register(AnswerCreateRequest answerCreateRequest) {

        Long questionId = answerCreateRequest.getQuestionId();
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ApiException(ErrorType._QUESTION_NOT_FOUND));

        // 현재 시간에서 날짜 포멧
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = now.format(formatter);

        Member currentMember = getCurrentMember();

        Answer newAnswer = Answer.builder()
                .content(answerCreateRequest.getContent())
                .question(question)
                .formatDate(formattedDate)
                .member(currentMember)
                .build();

        answerService.register(newAnswer);

        AnswerResponse answerResponse = AnswerResponse.builder()
                .answerId(newAnswer.getId())
                .content(newAnswer.getContent())
                .build();

        return answerResponse;
    }

    private Member getCurrentMember() {
        // ToDo Util에 있는 것으로 수정
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Member) authentication.getPrincipal();
    }

    public Long edit(AnswerEditRequest answerEditRequest) {

        LocalDate localDate = answerEditRequest.getSearchDate();

        String content = answerEditRequest.getContent();

        Long editId = answerService.edit(localDate, content);

        return editId;
    }

    public Long delete(SearchCondition searchCondition) {

        Member currentMember = getCurrentMember();
        Long memberId = currentMember.getId();

        LocalDate localDate = searchCondition.getSearchDate();

        Long deleteById = answerService.deleteByCondition(memberId, localDate);

        return deleteById;
    }

    public AnswerResponse findByCondition(SearchCondition searchCondition) {
        // 날짜와 생성자 이름으로 갖고 오면됨

        Member currentMember = getCurrentMember();
        Long memberId = currentMember.getId();

        LocalDate localDate = searchCondition.getSearchDate();

        AnswerResponse response = answerService.findByCondition(memberId, localDate);

        return response;
    }

}
