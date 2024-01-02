package api.hackathon.iaiq.domain.board.service;

import api.hackathon.iaiq.domain.board.domain.Board;
import api.hackathon.iaiq.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardQueryService {

    private final BoardRepository boardRepository;

    public Page<Board> getBoardPreViewList(Integer page){
        return boardRepository.findAll(PageRequest.of(page, 10));
    }
}
