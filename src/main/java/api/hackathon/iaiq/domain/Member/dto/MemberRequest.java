package api.hackathon.iaiq.domain.Member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

public class MemberRequest {

    @Schema(description = "프로필 닉네임 DTO")
    @Getter
    public static class ProfileNicknameDTO{

        @Schema(description = "닉네임")
        private String nickname;
    }
}
