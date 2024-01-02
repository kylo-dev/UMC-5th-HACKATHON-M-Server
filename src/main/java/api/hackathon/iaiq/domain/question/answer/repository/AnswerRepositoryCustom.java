package api.hackathon.iaiq.domain.question.answer.repository;

import api.hackathon.iaiq.domain.question.answer.domain.Answer;
import java.time.LocalDate;

public interface AnswerRepositoryCustom {
    Answer findByCondition(Long memberId, LocalDate localDate);
}
