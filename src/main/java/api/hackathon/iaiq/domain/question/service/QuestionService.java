package api.hackathon.iaiq.domain.question.service;

import api.hackathon.iaiq.domain.question.answer.dto.request.AnswerRequest;
import api.hackathon.iaiq.domain.question.answer.dto.response.AnswerResponse;
import api.hackathon.iaiq.domain.question.domain.Category;
import api.hackathon.iaiq.domain.question.domain.Question;
import api.hackathon.iaiq.domain.question.dto.request.QuestionRequest;
import api.hackathon.iaiq.domain.question.dto.request.QuestionResponse;
import api.hackathon.iaiq.domain.question.repository.QuestionRepository;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionResponse findByCategory(QuestionRequest questionRequest) {
        Category category = questionRequest.getCategory();

        List<Question> questions = questionRepository.findByQnaType(category);
        int randomIndex = ThreadLocalRandom.current().nextInt(questions.size());
        Question question = questions.get(randomIndex);
        return QuestionResponse.builder()
                .question(question)
                .build();
    }

    public AnswerResponse register(AnswerRequest answerRequest) {
        return null;
    }

    public AnswerResponse edit(Long answerId, AnswerRequest answerRequest) {
        return null;
    }
}
