package api.hackathon.iaiq.domain.question.answer.dto.response;

import lombok.Builder;

@Builder
public record AnswerResponse(Long answerId, String content) {
}
