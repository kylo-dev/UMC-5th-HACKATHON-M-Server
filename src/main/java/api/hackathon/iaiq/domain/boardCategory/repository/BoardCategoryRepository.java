package api.hackathon.iaiq.domain.boardCategory.repository;

import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {

    BoardCategory findByTopic(String topic);
}
