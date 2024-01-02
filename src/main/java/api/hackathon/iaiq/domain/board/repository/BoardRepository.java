package api.hackathon.iaiq.domain.board.repository;

import api.hackathon.iaiq.domain.Member.domain.Member;
import api.hackathon.iaiq.domain.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findAllByMember(Member member, Pageable pageable);
}
