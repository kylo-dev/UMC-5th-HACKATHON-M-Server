package api.hackathon.iaiq.domain.comment.converter;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.dto.BoardRequest;
import api.hackathon.iaiq.domain.board.dto.BoardResponse;
import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import api.hackathon.iaiq.domain.comment.domain.Comment;
import api.hackathon.iaiq.domain.comment.dto.CommentRequest;
import api.hackathon.iaiq.domain.comment.dto.CommentResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {


    public static Comment toComment(CommentRequest.WriteDTO request, Member member,Board board){
        return Comment.builder()
                .content(request.getContent())
                .member(member)
                .board(board)
                .build();
    }

    public static CommentResponse.CommentResultDTO toCommentResultDTO(Comment comment) {
        return CommentResponse.CommentResultDTO.builder()
                .commentId(comment.getId())
                .build();
    }
    public static CommentResponse.CommentPreViewListDTO toCommentPreViewListDTO(Page<Comment> comments) {

        List<CommentResponse.CommentPreViewDTO> commentPreViewDTOS = comments.stream()
                .map(CommentConverter::toCommentPreViewDTO)
                .collect(Collectors.toList());

        return CommentResponse.CommentPreViewListDTO.builder()
                .commentList(commentPreViewDTOS)
                .isFirst(comments.isFirst())
                .isLast(comments.isLast())
                .totalPage(comments.getTotalPages())
                .totalElements(comments.getTotalElements())
                .listSize(commentPreViewDTOS.size())
                .build();
    }

    // Comment -> CommentPreViewDTO로 변환 함수
    public static CommentResponse.CommentPreViewDTO toCommentPreViewDTO(Comment comment) {
        return CommentResponse.CommentPreViewDTO.builder()
                .nickname(comment.getMember().getNickname())
                .profileUrl(comment.getMember().getProfileImgUrl())
                .content(comment.getContent())
                .build();
    }

}
