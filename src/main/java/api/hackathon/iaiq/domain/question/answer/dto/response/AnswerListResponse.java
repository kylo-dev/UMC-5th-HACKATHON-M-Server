package api.hackathon.iaiq.domain.question.answer.dto.response;

import java.util.List;

public record AnswerListResponse(List<AnswerResponse> answerResponses, Integer totalPage,
                                 Long totalElements, Boolean isFirst, Boolean isLast) {
}
