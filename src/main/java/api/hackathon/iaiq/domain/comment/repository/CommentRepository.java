package api.hackathon.iaiq.domain.comment.repository;

import api.hackathon.iaiq.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
}
