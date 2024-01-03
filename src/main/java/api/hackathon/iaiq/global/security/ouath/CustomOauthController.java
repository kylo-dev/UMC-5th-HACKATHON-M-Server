package api.hackathon.iaiq.global.security.ouath;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "OAuth2.0", description = "카카오 소셜 로그인 API")
@RestController
@RequestMapping("/login")
public class CustomOauthController {

    @Operation(summary = "카카오 로그인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "소셜 로그인 성공")
    })
    @GetMapping("/kakao")
    public void kakaoLogin() {
    }

}
