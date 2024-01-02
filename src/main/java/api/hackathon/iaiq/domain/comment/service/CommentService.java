package api.hackathon.iaiq.domain.comment.service;


import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.service.BoardQueryService;
import api.hackathon.iaiq.domain.comment.converter.CommentConverter;
import api.hackathon.iaiq.domain.comment.domain.Comment;
import api.hackathon.iaiq.domain.comment.dto.CommentRequest;
import api.hackathon.iaiq.domain.comment.dto.CommentResponse;
import api.hackathon.iaiq.domain.comment.repository.CommentRepository;

import api.hackathon.iaiq.global.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardQueryService boardQueryService;

    /*
    게시글 댓글 전체 조회(페이징)
    */
    public CommentResponse.CommentPreViewListDTO getCommentPreViewList(Long boardId, Integer page){
        Page<Comment> comments = commentRepository.findByBoardId(boardId,PageRequest.of(page, 10));
        return CommentConverter.toCommentPreViewListDTO(comments);
    }

    /*
    게시글 작성
     */
    @Transactional
    public CommentResponse.CommentResultDTO writeComment(Long boardId, CommentRequest.WriteDTO request) {
        Member currentMember = SecurityUtil.getCurrentMember();
        Board board = boardQueryService.findById(boardId);
        Comment newComment = CommentConverter.toComment(request, currentMember, board);

        commentRepository.save(newComment);
        return CommentConverter.toCommentResultDTO(newComment);
    }



}
