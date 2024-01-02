package api.hackathon.iaiq.domain.Member.controller;

import api.hackathon.iaiq.domain.Member.dto.MemberRequest;
import api.hackathon.iaiq.domain.Member.dto.MemberResponse;
import api.hackathon.iaiq.domain.Member.repository.MemberRepository;
import api.hackathon.iaiq.domain.Member.service.MemberCommandService;
import api.hackathon.iaiq.domain.Member.service.MemberQueryService;
import api.hackathon.iaiq.domain.board.dto.BoardRequest;
import api.hackathon.iaiq.domain.board.dto.BoardResponse;
import api.hackathon.iaiq.global.success.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PatchMapping("/")
    @Operation(summary = "사용자 프로필 닉네임 변경", description = "사용자 프로필 닉네임을 수정하는 API입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public SuccessResponse<MemberResponse.ProfileEditDTO> editBoard(@RequestBody MemberRequest.ProfileNicknameDTO request){
        return new SuccessResponse<>(memberCommandService.editProfile(request));
    }
}
