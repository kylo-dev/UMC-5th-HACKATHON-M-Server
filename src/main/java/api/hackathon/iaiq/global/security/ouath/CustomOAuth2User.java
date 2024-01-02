package api.hackathon.iaiq.global.security.ouath;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.global.security.ouath.userInfo.KakaoUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;


@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User {
    private final Member member;
    private final KakaoUserInfo kakaoUserInfo;

    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return kakaoUserInfo.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_MEMBER"));
    }

    @Override
    public String getName() {
        return kakaoUserInfo.getName();
    }
}