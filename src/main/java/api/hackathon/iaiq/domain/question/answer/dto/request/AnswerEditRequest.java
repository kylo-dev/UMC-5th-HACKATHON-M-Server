package api.hackathon.iaiq.domain.question.answer.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class AnswerEditRequest extends SearchCondition {

    @Schema(description = "질문에 대한 답 내용", example = "오늘은 ~~했어~")
    private String content;
}
