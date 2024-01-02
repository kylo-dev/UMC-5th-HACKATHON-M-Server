package api.hackathon.iaiq.domain.Member.domain;

import api.hackathon.iaiq.domain.board.domain.Board;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String profileImgUrl;

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();
}
