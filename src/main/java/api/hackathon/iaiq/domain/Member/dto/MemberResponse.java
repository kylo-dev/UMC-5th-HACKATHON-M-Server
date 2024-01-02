package api.hackathon.iaiq.domain.Member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProfileEditDTO {

        private Long memberId;
        private LocalDateTime lastModified;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProfileDTO {
        private String nickname;
        private String profileUrl;
    }
}
