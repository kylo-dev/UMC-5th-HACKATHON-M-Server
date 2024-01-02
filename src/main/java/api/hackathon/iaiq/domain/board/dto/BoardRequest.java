package api.hackathon.iaiq.domain.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

public class BoardRequest {

    @Schema(description = "게시글 작성 DTO")
    @Getter
    public static class WriteDTO{

        @Schema(description = "주제")
        private String topic;

        @Schema(description = "게시글 주제")
        private String title;

        @Schema(description = "게시글 내용")
        private String content;
    }
}
