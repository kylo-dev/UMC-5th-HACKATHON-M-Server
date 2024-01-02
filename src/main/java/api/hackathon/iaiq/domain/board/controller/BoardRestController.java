package api.hackathon.iaiq.domain.board.controller;

import api.hackathon.iaiq.domain.board.dto.BoardRequest;
import api.hackathon.iaiq.domain.board.dto.BoardResponse;
import api.hackathon.iaiq.domain.board.service.BoardCommandService;
import api.hackathon.iaiq.domain.board.service.BoardQueryService;
import api.hackathon.iaiq.global.success.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "board", description = "커뮤니티 게시글 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardRestController {

    private final BoardQueryService boardQueryService;
    private final BoardCommandService boardCommandService;

    @GetMapping("/")
    @Operation(summary = "커뮤니티 게시글 조회", description = "커뮤니티에 작성된 모든 글의 목록을 조회하는 API이며, 페이징을 포함, query string으로 page 번호 전달해 주세요.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "page", description = "커뮤니티 게시글의 페이지 번호, query sring으로 전달해주세요.")
    })
    public SuccessResponse<BoardResponse.BoardPreViewListDTO> getBoardList(@RequestParam(name = "page") Integer page){
        return new SuccessResponse<>(boardQueryService.getBoardPreViewList(page));
    }

    @GetMapping("/{boardId}")
    @Operation(summary = "커뮤니티 게시글 세부정보 조회", description = "커뮤니티에 작성된 특정 글의 세부 정보를 조회하는 API입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "boardId", description = "게시글의 아이디, Path Variable입니다.")
    })
    public SuccessResponse<BoardResponse.BoardDetailDTO> getBoard(@PathVariable(name = "boardId") Long boardId){

        return new SuccessResponse<>(boardQueryService.getBoardDetail(boardId));
    }

    @GetMapping("/my")
    @Operation(summary = "로그인한 사용자의 커뮤니티 모든 게시글 조회", description = "로그인한 사용자의 커뮤니티에 모든 글을 조회하는 API입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "page", description = "내가 작성한 커뮤니티 게시글 목록의 페이지 번호, query sring으로 전달해주세요.")
    })
    public SuccessResponse<BoardResponse.BoardPreViewListDTO> getMemberOfBoard(@RequestParam(name = "page") Integer page){
        return new SuccessResponse<>(boardQueryService.getBoardPreViewListByMember(page));
    }

    @PostMapping("/")
    @Operation(summary = "커뮤니티 게시글 작성", description = "커뮤니티에 글 작성하는 API입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public SuccessResponse<BoardResponse.BoardResultDTO> writeBoard(@RequestBody BoardRequest.WriteDTO request) {
        return new SuccessResponse<>(boardCommandService.writeBoard(request));
    }

    @PatchMapping("/{boardId}/edit")
    @Operation(summary = "커뮤니티 특정 글 수정", description = "커뮤니티 특정 글 수정하는 API입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "boardId", description = "게시글의 아이디, Path Variable입니다.")
    })
    public SuccessResponse<BoardResponse.BoardEditResultDTO> editBoard(@PathVariable(name = "boardId") Long boardId,
                                                                       @RequestBody BoardRequest.BoardEditDTO request){
        return new SuccessResponse<>(boardCommandService.editBoard(boardId,request));
    }

    @DeleteMapping("/{boardId}")
    @Operation(summary = "커뮤니티 특정 글 삭제", description = "커뮤니티 특정 글 삭제하는 API입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "boardId", description = "게시글의 아이디, Path Variable입니다.")
    })
    public SuccessResponse<BoardResponse.BoardResultDTO> deleteBoard(@PathVariable(name = "boardId") Long boardId) {
        return new SuccessResponse<>(boardCommandService.deleteBoard(boardId));
    }
}
