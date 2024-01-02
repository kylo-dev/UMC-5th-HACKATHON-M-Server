package api.hackathon.iaiq.global.security.ouath;


import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.Member.repository.MemberRepository;
import api.hackathon.iaiq.global.security.ouath.userInfo.KakaoUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(request);
        log.info("------------------ getAttributes : {}", oAuth2User.getAttributes());

        String provider = request.getClientRegistration().getRegistrationId();

        ///kakao user
        KakaoUserInfo kakaoUserInfo = new KakaoUserInfo(oAuth2User.getAttributes());

        // 회원가입 유무 확인
        Optional<Member> member = memberRepository.findMemberByEmailAndProvider(kakaoUserInfo.getEmail(), provider);

        // 없다면 회원가입
        if(member.isEmpty()) {

            // 멤버 생성 및 저장
            Member newMember = Member.builder()
                    .nickname(kakaoUserInfo.getName())
                    .email(kakaoUserInfo.getEmail())
                    .profileImgUrl(kakaoUserInfo.getProfile())
                    .build();

            memberRepository.save(newMember);  // 변경된 user 저장


            return new CustomOAuth2User(newMember, kakaoUserInfo);
        }

        return new CustomOAuth2User(member.get(), kakaoUserInfo);
    }

}
