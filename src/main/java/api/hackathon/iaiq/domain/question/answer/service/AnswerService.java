package api.hackathon.iaiq.domain.question.answer.service;

import api.hackathon.iaiq.domain.question.answer.domain.Answer;
import api.hackathon.iaiq.domain.question.answer.dto.response.AnswerResponse;
import api.hackathon.iaiq.domain.question.answer.repository.AnswerRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
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
}
