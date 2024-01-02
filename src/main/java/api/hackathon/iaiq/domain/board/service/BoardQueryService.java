package api.hackathon.iaiq.domain.board.service;

import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.dto.BoardResponse;
import api.hackathon.iaiq.domain.board.repository.BoardRepository;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardQueryService {
    private final BoardRepository boardRepository;


    /*
    게시글 상세 조회
     */
    public BoardResponse.BoardDetailDTO getBoardDetail(Long boardId) {

        Board board = boardRepository.findById(boardId).orElseThrow(() -> new ApiException(ErrorType._BOARD_NOT_FOUND));

        return BoardResponse.BoardDetailDTO.builder()
                .nickname(null) //board.getMember().getNickname())
                .profileUrl(null) //board.getMember().getProfileUrl()
                .topic(board.getBoardCategory().getTopic())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
