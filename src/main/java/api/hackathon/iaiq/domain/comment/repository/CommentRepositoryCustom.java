package api.hackathon.iaiq.domain.comment.repository;

import api.hackathon.iaiq.domain.comment.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CommentRepositoryCustom {
    Page<Comment> findByBoardId(Long postId, Pageable pageable);
}
