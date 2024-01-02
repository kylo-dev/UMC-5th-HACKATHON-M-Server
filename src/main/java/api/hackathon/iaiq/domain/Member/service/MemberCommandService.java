package api.hackathon.iaiq.domain.Member.service;

import api.hackathon.iaiq.domain.Member.converter.MemberConverter;
import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.Member.dto.MemberRequest;
import api.hackathon.iaiq.domain.Member.dto.MemberResponse;
import api.hackathon.iaiq.domain.Member.repository.MemberRepository;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static api.hackathon.iaiq.global.utils.SecurityUtil.getCurrentMember;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandService {

    private final MemberRepository memberRepository;
    private final EntityManager em;

    public MemberResponse.ProfileEditDTO editProfile(MemberRequest.ProfileNicknameDTO request){
        Member editMember = memberRepository.findById(getCurrentMember().getId()).orElseThrow(
                () -> new ApiException(ErrorType._USER_NOT_FOUND_DB)
        );
        editMember.updateNickname(request.getNickname());
        em.flush();
        em.clear();

        Member member = memberRepository.findById(getCurrentMember().getId()).orElseThrow(
                () -> new ApiException(ErrorType._USER_NOT_FOUND_DB)
        );
        return MemberConverter.toProfileEditDTO(member);
    }
}
