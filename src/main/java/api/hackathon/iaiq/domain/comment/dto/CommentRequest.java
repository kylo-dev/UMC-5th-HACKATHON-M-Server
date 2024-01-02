package api.hackathon.iaiq.domain.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

public class CommentRequest {

    @Schema(description = "게시글 작성 DTO")
    @Getter
    public static class WriteDTO{

        @Schema(description = "댓글 내용")
        private String content;
    }
}
