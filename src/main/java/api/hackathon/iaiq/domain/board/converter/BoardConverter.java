package api.hackathon.iaiq.domain.board.converter;

import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.dto.BoardRequest;
import api.hackathon.iaiq.domain.board.dto.BoardResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BoardConverter {

    // WriteDTO -> Board 엔티티로 변환 함수
    public static Board toBoard(BoardRequest.WriteDTO request){
        return Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public static BoardResponse.BoardResultDTO toBoardResultDTO(Board board) {
        return BoardResponse.BoardResultDTO.builder()
                .boardId(board.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // Page<Board> -> Page<BoardPreViewListDTO>로 변환 함수
    public static BoardResponse.BoardPreViewListDTO toBoardPreViewListDTO(Page<Board> boards) {

        List<BoardResponse.BoardPreViewDTO> boardPreViewDTOS = boards.stream()
                .map(BoardConverter::toBoardPreViewDTO)
                .collect(Collectors.toList());

        return BoardResponse.BoardPreViewListDTO.builder()
                .boardList(boardPreViewDTOS)
                .isFirst(boards.isFirst())
                .isLast(boards.isLast())
                .totalPage(boards.getTotalPages())
                .totalElements(boards.getTotalElements())
                .listSize(boardPreViewDTOS.size())
                .build();
    }

    // Board -> BoardPreViewDTO로 변환 함수
    public static BoardResponse.BoardPreViewDTO toBoardPreViewDTO(Board board) {
        return BoardResponse.BoardPreViewDTO.builder()
                .topic(board.getBoardCategory().getTopic())
                .nickname(null) // member 연결시 추가
                .profileUrl(null) // member 연결시 추가
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
