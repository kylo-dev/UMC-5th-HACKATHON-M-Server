package api.hackathon.iaiq.domain.Member.service;

import api.hackathon.iaiq.domain.Member.converter.MemberConverter;
import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.Member.dto.MemberResponse;
import api.hackathon.iaiq.domain.Member.repository.MemberRepository;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import api.hackathon.iaiq.global.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public Member findById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(
                () -> new ApiException(ErrorType._USER_NOT_FOUND_DB));
    }

    public MemberResponse.ProfileDTO getProfile() {
        Member currentMember = SecurityUtil.getCurrentMember();

        return MemberConverter.toProfileDTO(currentMember);

    }

}
