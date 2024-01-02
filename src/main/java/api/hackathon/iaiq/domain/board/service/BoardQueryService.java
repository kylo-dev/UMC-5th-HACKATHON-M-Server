package api.hackathon.iaiq.domain.board.service;

import api.hackathon.iaiq.domain.board.converter.BoardConverter;
import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.dto.BoardResponse;
import api.hackathon.iaiq.domain.board.repository.BoardRepository;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        return BoardConverter.toBoardDetailDTO(board);
    }


    /*
    게시글 전체 조회(페이징)
     */
    public Page<Board> getBoardPreViewList(Integer page){
        return boardRepository.findAll(PageRequest.of(page, 10));
    }
}
