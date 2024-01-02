package api.hackathon.iaiq.domain.board.service;


import api.hackathon.iaiq.domain.board.converter.BoardConverter;
import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.dto.BoardRequest;
import api.hackathon.iaiq.domain.board.repository.BoardRepository;
import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import api.hackathon.iaiq.domain.boardCategory.repository.BoardCategoryRepository;
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
        BoardCategory boardCategory = boardCategoryRepository.findByTopic(request.getTopic());
        Board newBoard = BoardConverter.toBoard(request, boardCategory);
        return boardRepository.save(newBoard);
    }
}
