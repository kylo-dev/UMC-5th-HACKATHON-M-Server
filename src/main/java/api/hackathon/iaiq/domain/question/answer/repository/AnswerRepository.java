package api.hackathon.iaiq.domain.question.answer.repository;

import api.hackathon.iaiq.domain.question.answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long>, AnswerRepositoryCustom {
}
