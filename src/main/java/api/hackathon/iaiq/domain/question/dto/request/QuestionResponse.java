package api.hackathon.iaiq.domain.question.dto.request;

import api.hackathon.iaiq.domain.question.domain.Category;
import lombok.Builder;

@Builder
public record QuestionResponse(Long questionId, String content, Category qnaType) {
}
