package api.hackathon.iaiq.domain.boardCategory.repository;

import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {

    Optional<BoardCategory> findByTopic(String topic);
}
