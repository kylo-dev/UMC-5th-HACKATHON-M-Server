package api.hackathon.iaiq.domain.board.data;

import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import api.hackathon.iaiq.domain.boardCategory.repository.BoardCategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
//public class BoardCategoryDataInit {
//
//    private final BoardCategoryRepository boardCategoryRepository;
//
//    @PostConstruct
//    public void init(){
//        BoardCategory result = BoardCategory.builder()
//                .topic("영화")
//                .build();
//
//        boardCategoryRepository.save(result);
//    }
//}
