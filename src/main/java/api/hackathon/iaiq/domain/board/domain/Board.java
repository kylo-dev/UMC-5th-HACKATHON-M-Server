package api.hackathon.iaiq.domain.board.domain;

import api.hackathon.iaiq.domain.base.BaseTimeEntity;
import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_category_id")
    private BoardCategory boardCategory;


    public void update(String title, String content, BoardCategory boardCategory) {
        this.title =title;
        this.content = content;
        this.boardCategory = boardCategory;
    }
}

