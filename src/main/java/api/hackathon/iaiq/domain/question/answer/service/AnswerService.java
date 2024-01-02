package api.hackathon.iaiq.domain.question.answer.service;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.question.answer.domain.Answer;
import api.hackathon.iaiq.domain.question.answer.dto.response.AnswerResponse;
import api.hackathon.iaiq.domain.question.answer.editor.AnswerEditor;
import api.hackathon.iaiq.domain.question.answer.editor.AnswerEditor.AnswerEditorBuilder;
import api.hackathon.iaiq.domain.question.answer.repository.AnswerRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void register(Answer answer) {
        answerRepository.save(answer);
    }

    public AnswerResponse findByCondition(Long memberId, LocalDate localDate) {
        Answer findAnswer = answerRepository.findByCondition(memberId, localDate);

        AnswerResponse response = AnswerResponse.builder()
                .content(findAnswer.getContent())
                .answerId(findAnswer.getId())
                .build();

        return response;
    }

    public Long deleteByCondition(Long memberId, LocalDate localDate) {
        Answer findAnswer = answerRepository.findByCondition(memberId, localDate);

        answerRepository.delete(findAnswer);

        return findAnswer.getId();
    }

    public Long edit(LocalDate localDate, String content) {

        Member currentMember = getCurrentMember();
        Long memberId = currentMember.getId();

        Answer findAnswer = answerRepository.findByCondition(memberId, localDate);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = now.format(formatter);

        AnswerEditorBuilder editorBuilder = findAnswer.toEditor();
        AnswerEditor answerEditor = editorBuilder
                .content(content)
                .formatDate(formattedDate)
                .build();

        findAnswer.edit(answerEditor);

        return findAnswer.getId();
    }

    private Member getCurrentMember() {
        // ToDo Util에 있는 것으로 수정
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Member) authentication.getPrincipal();
    }
}
