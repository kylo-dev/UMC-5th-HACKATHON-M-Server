package api.hackathon.iaiq.domain.board.domain;

import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_category_id")
    private BoardCategory boardCategory;

    //== 연관관계 편의 메소드 ==//
    public void setBoardCategory(BoardCategory boardCategory){
        this.boardCategory = boardCategory;
        boardCategory.getBoardList().add(this);
    }
}

