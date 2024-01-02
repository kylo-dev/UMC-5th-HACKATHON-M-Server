package api.hackathon.iaiq.domain.Member.service;

import api.hackathon.iaiq.domain.Member.converter.MemberConverter;
import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.Member.dto.MemberRequest;
import api.hackathon.iaiq.domain.Member.dto.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static api.hackathon.iaiq.global.utils.SecurityUtil.getCurrentMember;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandService {

    public MemberResponse.ProfileEditDTO editProfile(MemberRequest.ProfileNicknameDTO request){
        Member currentMember = getCurrentMember();
        currentMember.updateNickname(request.getNickname());
        return MemberConverter.toProfileEditDTO(currentMember);
    }
}
