package api.hackathon.iaiq.global.security.ouath;

import lombok.Builder;

@Builder
public record AuthResponse(Long memberId, String email, String nickName, String profileImgUrl) {
}
