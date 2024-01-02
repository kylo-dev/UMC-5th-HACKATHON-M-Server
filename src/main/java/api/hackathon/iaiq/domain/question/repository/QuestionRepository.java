package api.hackathon.iaiq.domain.question.repository;

import api.hackathon.iaiq.domain.question.domain.Category;
import api.hackathon.iaiq.domain.question.domain.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQnaType(Category category);
}
