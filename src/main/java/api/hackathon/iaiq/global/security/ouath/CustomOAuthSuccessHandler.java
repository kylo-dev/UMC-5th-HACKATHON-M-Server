package api.hackathon.iaiq.global.security.ouath;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.Member.repository.MemberRepository;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import api.hackathon.iaiq.global.security.jwt.JwtProvider;
import api.hackathon.iaiq.global.security.ouath.userInfo.KakaoUserInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomOAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    public static final String REDIRECT_URL = "http://localhost:3000";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        KakaoUserInfo kakaoUserInfo = new KakaoUserInfo(customOAuth2User.getAttributes());
        String email = kakaoUserInfo.getEmail();

        log.info("------------------------- 소셜 로그인 성공: " + email);

        Member loginMember = memberRepository.findMemberByEmail(email)
                .orElseThrow(() -> new ApiException(ErrorType._USER_NOT_FOUND_BY_TOKEN));

        registerHeaderToken(response, loginMember.getEmail());

        AuthResponse authResponse = AuthResponse.builder()
                .memberId(loginMember.getId())
                .email(email)
                .nickName(loginMember.getNickname())
                .profileImgUrl(loginMember.getProfileImgUrl())
                .build();

        // ToDo 아래는 임시 데이터, front와 협의 후 수정
        registerResponse(response, authResponse);
    }

    private void registerHeaderToken(final HttpServletResponse response, final String loginMemberEmail) {
        String ourToken = jwtProvider.generateJwtToken(loginMemberEmail);
        // 어세스 토큰은 헤더에 담아서 응답으로 보냄
        response.setHeader("Authorization", ourToken);
        log.info("ourToken = " + ourToken);
    }

    private void registerResponse(final HttpServletResponse response,
                                  final AuthResponse authResponse) throws IOException {
        String encodedMemberId = URLEncoder.encode(String.valueOf(authResponse.memberId()), StandardCharsets.UTF_8);
        String encodedNickName = URLEncoder.encode(authResponse.nickName(), StandardCharsets.UTF_8);
        String encodedProfileImageUrl = URLEncoder.encode(authResponse.profileImgUrl(), StandardCharsets.UTF_8);

        // 프론트엔드 페이지로 토큰과 함께 리다이렉트
        String frontendRedirectUrl = String.format(
                "%s/?memberId=%s&NickName=%s&profileImgUrl=%s",
                REDIRECT_URL, encodedMemberId, encodedNickName, encodedProfileImageUrl
        );
        response.sendRedirect(frontendRedirectUrl);
    }
}
