package api.hackathon.iaiq.domain.question.dto.request;

import api.hackathon.iaiq.domain.question.domain.Category;
import api.hackathon.iaiq.domain.question.domain.Question;
import lombok.Builder;

@Builder
public record QuestionResponse(Question question) {
}
