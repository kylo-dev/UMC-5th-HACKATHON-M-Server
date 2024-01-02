package api.hackathon.iaiq.domain.board.service;


import api.hackathon.iaiq.domain.board.converter.BoardConverter;
import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.dto.BoardRequest;
import api.hackathon.iaiq.domain.board.repository.BoardRepository;
import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import api.hackathon.iaiq.domain.boardCategory.repository.BoardCategoryRepository;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardCommandService {

    private final BoardRepository boardRepository;
    private final BoardCategoryRepository boardCategoryRepository;

    // 게시글 작성 로직
    public Board writeBoard(BoardRequest.WriteDTO request) {
        BoardCategory boardCategory = boardCategoryRepository.findByTopic(request.getTopic()).orElseThrow(
                () -> new ApiException(ErrorType._BOARD_CATEGORY_NOT_FOUND)
        );
        Board newBoard = BoardConverter.toBoard(request, boardCategory);
        return boardRepository.save(newBoard);
    }

    // 게시글 삭제
    public void deleteBoard(Long boardId) {
        boardRepository.findById(boardId).orElseThrow(()-> new ApiException(ErrorType._BOARD_NOT_FOUND));
        boardRepository.deleteById(boardId);
    }
}
