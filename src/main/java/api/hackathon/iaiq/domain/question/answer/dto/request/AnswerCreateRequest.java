package api.hackathon.iaiq.domain.question.answer.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class AnswerCreateRequest {

    @Schema(description = "질문 index", example = "3")
    private Long questionId;

    @Schema(description = "질문에 대한 답 내용", example = "오늘은 ~~했어~")
    private String content;

}
