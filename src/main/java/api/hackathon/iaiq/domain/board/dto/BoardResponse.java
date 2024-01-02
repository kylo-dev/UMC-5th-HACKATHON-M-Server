package api.hackathon.iaiq.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class BoardResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardPreViewDTO {
        private String topic;
        private String nickname;
        private String profileUrl;
        private String title;
        private String content;
    }

    // 커뮤니티 메인화면 조회 (페이징)
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardPreViewListDTO {
        List<BoardPreViewDTO> boardList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }


    /*
    게시글 상세 조회 dto
     */
    // "댓글" 데이터 추가해야 함
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardDetailDTO {
        private String nickname;
        private String profileUrl;
        private String topic;
        private String title;
        private String content;
    }



    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardResultDTO {
        private Long boardId;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardEditDTO {
        private String topic;
        private String title;
        private String content;
        private LocalDateTime createdAt;
    }

}
