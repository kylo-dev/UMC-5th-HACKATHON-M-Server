package api.hackathon.iaiq.domain.boardCategory.domain;

import api.hackathon.iaiq.domain.board.domain.Board;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BoardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    @OneToMany(mappedBy = "boardCategory")
    private List<Board> boardList = new ArrayList<>();
}