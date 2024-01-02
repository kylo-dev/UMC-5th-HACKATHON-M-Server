package api.hackathon.iaiq.domain.Member.converter;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.Member.dto.MemberResponse;

public class MemberConverter {

    public static MemberResponse.ProfileEditDTO toProfileEditDTO(Member member) {
        return MemberResponse.ProfileEditDTO.builder()
                .memberId(member.getId())
                .lastModified(member.getLastModifiedDate())
                .build();
    }
}
