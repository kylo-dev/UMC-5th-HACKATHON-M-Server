package api.hackathon.iaiq.domain.Member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProfileDTO {
        private String nickname;
        private String profileUrl;
    }
}
