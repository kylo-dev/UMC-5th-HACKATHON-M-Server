package api.hackathon.iaiq.domain.board.data;

import api.hackathon.iaiq.domain.boardCategory.domain.BoardCategory;
import api.hackathon.iaiq.domain.boardCategory.repository.BoardCategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class BoardCategoryDataInit {

    private final BoardCategoryRepository boardCategoryRepository;

    //@PostConstruct
    public void init() {
        String[] topics = {"가족", "사랑", "모험", "비밀", "희망", "도시", "숲", "바다", "여행", "음악",
                "친구", "추억", "환상", "꿈", "우주", "시간", "마법", "기술", "미래", "과거",
                "행복", "슬픔", "두려움", "용기", "자유", "평화", "전쟁", "사랑", "미움", "성장",
                "변화", "운명", "축제", "학교", "연구", "발견", "아름다움", "진실", "거짓", "창조",
                "소멸", "생활", "근무", "존경", "배신", "용서", "복수", "유머", "놀이", "경쟁",
                "스포츠", "예술", "자연", "동물", "식물", "기후", "환경", "지구", "별", "탐험",
                "신비", "기적", "과학", "철학", "정치", "경제", "사회", "문화", "종교", "신화",
                "전설", "영웅", "악당", "유령", "외계인", "로봇", "인간", "신", "정령", "마녀",
                "요정", "동화", "소설", "시", "노래", "춤", "영화", "극장", "무대", "페스티벌",
                "선물", "축하", "파티", "음식", "음료", "여름", "겨울", "봄", "가을", "모든 것"};

        for (String topic : topics) {
            BoardCategory result = BoardCategory.builder().topic(topic).build();
            boardCategoryRepository.save(result);
        }
    }
}
