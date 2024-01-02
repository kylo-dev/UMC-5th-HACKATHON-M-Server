package api.hackathon.iaiq.domain.boardLike.repository;

import api.hackathon.iaiq.domain.boardLike.domain.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {
}
