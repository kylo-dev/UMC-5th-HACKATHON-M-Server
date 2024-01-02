package api.hackathon.iaiq.domain.board.repository;

import api.hackathon.iaiq.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
