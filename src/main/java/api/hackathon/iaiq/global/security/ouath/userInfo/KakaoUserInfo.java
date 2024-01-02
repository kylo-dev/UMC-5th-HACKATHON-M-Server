package api.hackathon.iaiq.global.security.ouath.userInfo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public class KakaoUserInfo {
    private final Map<String,Object> attributes;
    public String getProfile() {
        Map<String ,Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        return (String) kakaoProfile.get("profile_image_url");
    }


    public String getEmail() {
        return (String) ((Map) attributes.get("kakao_account")).get("email");
    }


    public String getName() {
        Map<String ,Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> kakaoProfile= (Map<String, Object>)kakaoAccount.get("profile");

        return (String) kakaoProfile.get("nickname");
    }

}
