package api.hackathon.iaiq.domain.comment.controller;



import api.hackathon.iaiq.domain.comment.dto.CommentRequest;
import api.hackathon.iaiq.domain.comment.dto.CommentResponse;
import api.hackathon.iaiq.domain.comment.service.CommentService;
import api.hackathon.iaiq.global.success.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "comment", description = "커뮤니티 게시글 댓글 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class CommentApiController {


    private final CommentService commentService;

    @GetMapping("/{boardId}/comments")
    @Operation(summary = "커뮤니티 게시글 댓글 페이징 조회", description = "커뮤니티에 작성된 모든 글의 댓글 목록을 조회하는 API이며, 페이징을 포함, query string으로 page 번호 전달해 주세요.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameters({
            @Parameter(name = "page", description = "커뮤니티 게시글 댓글의 페이지 번호, query sring으로 전달해주세요."),
            @Parameter(name = "boardId", description = "게시글의 id, path variable으로 주세요.")
    })
    public SuccessResponse<CommentResponse.CommentPreViewListDTO> getCommentList(final @PathVariable Long boardId, @RequestParam(name = "page") Integer page){
        return new SuccessResponse<>(commentService.getCommentPreViewList(boardId,page));
    }

    @PostMapping("/{boardId}/comments")
    @Operation(summary = "커뮤니티 게시글의 댓글 작성", description = "커뮤니티 게시글에 댓글을 작성하는 API입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    @Parameter(name = "boardId", description = "게시글의 id, path variable으로 주세요.")
    public SuccessResponse<CommentResponse.CommentResultDTO> writeComment(final @PathVariable Long boardId, @RequestBody CommentRequest.WriteDTO request) {
        return new SuccessResponse<>(commentService.writeComment(boardId,request));
    }

}
