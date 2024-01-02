package api.hackathon.iaiq.domain.question.answer.service;

import api.hackathon.iaiq.domain.question.answer.domain.Answer;
import api.hackathon.iaiq.domain.question.answer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void register(Answer answer) {
        answerRepository.save(answer);
    }
}
