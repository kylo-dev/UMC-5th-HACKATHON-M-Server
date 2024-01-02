package api.hackathon.iaiq.domain.question.data;

import static api.hackathon.iaiq.domain.question.domain.Category.*;

import api.hackathon.iaiq.domain.question.domain.Category;
import api.hackathon.iaiq.domain.question.domain.Question;
import api.hackathon.iaiq.domain.question.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//@Component
//@Transactional
@RequiredArgsConstructor
public class DataInit {

    private final QuestionRepository questionRepository;
    @PostConstruct
    public void initTravel() {
        // 여행 관련 질문
        List<Question> questions = Arrays.asList(
            addQuestion("가장 최근에 방문하신 여행지는 어디인가요?", TRAVEL),
            addQuestion("다시 한 번 방문하고 싶은 여행지는 어디인가요?", TRAVEL),
            addQuestion("가장 인상 깊었던 여행 경험은 무엇인가요?", TRAVEL),
            addQuestion("여행을 계획할 때 가장 중요하게 생각하는 요소는 무엇인가요?", TRAVEL),
            addQuestion("여행 가방에 꼭 넣어가는 물건은 무엇인가요?", TRAVEL),
            addQuestion("여행지에서 가장 좋아하는 활동은 무엇인가요?", TRAVEL),
            addQuestion("여행 중에 가장 어려웠던 순간은 언제인가요?", TRAVEL),
            addQuestion("여행지에서 첫 번째로 하는 일은 무엇인가요?", TRAVEL),
            addQuestion("가장 맛있었던 여행지 음식은 무엇인가요?", TRAVEL),
            addQuestion("여행지에서 가장 감동적인 순간은 언제인가요?", TRAVEL),
            addQuestion("꼭 가보고 싶은 국내 여행지는 어디인가요?", TRAVEL),
            addQuestion("꼭 가보고 싶은 해외 여행지는 어디인가요?", TRAVEL),
            addQuestion("가장 기억에 남는 여행 사진은 어떤 것인가요?", TRAVEL),
            addQuestion("좋아하는 여행 스타일은 무엇인가요? (예: 백패킹, 패키지 투어 등)", TRAVEL),
            addQuestion("여행 중 가장 기억에 남는 숙소는 어디인가요?", TRAVEL),
            addQuestion("여행지에서 가장 좋아하는 음식은 무엇인가요?", TRAVEL),
            addQuestion("여행지에서 가장 힘들었던 일은 무엇인가요?", TRAVEL),
            addQuestion("여행 중 만난 가장 인상 깊었던 사람은 누구인가요?", TRAVEL),
            addQuestion("다음 여행지로 선택하려는 곳은 어디인가요?", TRAVEL),
            addQuestion("여행 중 가장 무서웠던 경험은 무엇인가요?", TRAVEL)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initFood() {
        // 음식 관련 질문
        List<Question> questions = Arrays.asList(
            addQuestion("가장 좋아하는 음식은 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 음식 재료는 무엇인가요?", FOOD),
            addQuestion("직접 만들어 먹는 것을 좋아하시나요?", FOOD),
            addQuestion("가장 잘 만드는 요리는 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 음식점은 어디인가요?", FOOD),
            addQuestion("가장 좋아하는 음식의 종류는 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 음식의 향은 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 음식의 맛은 어떤 것인가요?", FOOD),
            addQuestion("싫어하는 음식은 무엇인가요?", FOOD),
            addQuestion("추억이 담긴 음식은 무엇인가요?", FOOD),
            addQuestion("자신만 알고 있는 어떤 음식을 가장 맛있게 먹는 방법이 있나요?", FOOD),
            addQuestion("가장 좋아하는 음료는 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 접시는 무엇인가요?", FOOD),
            addQuestion("음식을 먹을 때 가장 좋아하는 분위기는 어떤 것인가요?", FOOD),
            addQuestion("가장 좋아하는 향신료는 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 소스는 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 디저트는 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 음료는 무엇인가요?", FOOD),
            addQuestion("가장 좋아하는 주류는 무엇인가요?", FOOD)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initBook() {
        // 책 관련 질문
        List<Question> questions = Arrays.asList(
            addQuestion("가장 최근에 읽은 책은 무엇인가요?", BOOK),
            addQuestion("가장 좋아하는 작가는 누구인가요?", BOOK),
            addQuestion("가장 좋아하는 책은 무엇인가요?", BOOK),
            addQuestion("가장 좋아하는 장르는 무엇인가요?", BOOK),
            addQuestion("가장 기억에 남는 책은 무엇인가요?", BOOK),
            addQuestion("가장 많이 읽은 책은 무엇인가요?", BOOK),
            addQuestion("가장 영향을 많이 받은 책은 무엇인가요?", BOOK),
            addQuestion("당신을 가장 많이 울게 한 책은 무엇인가요?", BOOK),
            addQuestion("가장 많이 웃으면서 읽은 책은 무엇인가요?", BOOK),
            addQuestion("가장 이해하기 어려웠던 책은 무엇인가요?", BOOK),
            addQuestion("가장 좋아하는 주인공은 누구인가요?", BOOK)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initMoviesDramas() {
        // 영화/드라마 관련 질문
        List<Question> questions = Arrays.asList(
            addQuestion("가장 최근에 본 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 좋아하는 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 좋아하는 장르는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 기억에 남는 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 많이 본 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("당신이 영향을 많이 받은 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("당신을 가장 많이 울게했던 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 재미있게 본 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 이해하기 어려웠던 영화나 드라마는 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 기억에 남는 영화나 드라마의 장면은 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 좋아하는 영화나 드라마의 캐릭터는 누구인가요?", MOVIES_DRAMAS),
            addQuestion("당신은 해피엔딩과 배드엔딩 중 어느 쪽을 선호하나요?", MOVIES_DRAMAS),
            addQuestion("가장 기억에 남는 영화나 드라마의 결말은 어떤 것인가요?", MOVIES_DRAMAS),
            addQuestion("가장 긴장되었던 영화나 드라마의 갈등은 무엇인가요?", MOVIES_DRAMAS),
            addQuestion("가장 좋아하는 영화나 드라마의 OST는 무엇인가요?", MOVIES_DRAMAS)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initHealthExercise() {
        // 건강/운동 관련 질문
        List<Question> questions = Arrays.asList(
            addQuestion("가장 최근에 해본 운동은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("일주일에 몇 번 운동하시나요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동 장소는 어디인가요?", HEALTH_EXERCISE),
            addQuestion("가장 힘들었던 운동은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("가장 즐거웠던 운동은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("운동을 시작하게 된 계기는 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동복 브랜드는 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동 기구는 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동 음악은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동 파트너는 누구인가요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동 간식은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("가장 좋아하는 운동 음료는 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("운동을 할 때 가장 중요하게 생각하는 것은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("운동을 할 때 가장 어려운 것은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("운동을 할 때 가장 즐거운 것은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("운동을 할 때 가장 필요한 것은 무엇인가요?", HEALTH_EXERCISE),
            addQuestion("당신 만의 운동 방법이 있나요?", HEALTH_EXERCISE),
            addQuestion("당신의 건강 상태는 어떤가요?", HEALTH_EXERCISE)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initMusic() {
        // 음악 관련 질문
        List<Question> questions = Arrays.asList(
            addQuestion("가장 최근에 들은 곡은 무엇인가요?", MUSIC),
            addQuestion("가장 좋아하는 음악 장르는 무엇인가요?", MUSIC),
            addQuestion("가장 좋아하는 가수는 누구인가요?", MUSIC),
            addQuestion("가장 좋아하는 곡은 무엇인가요?", MUSIC),
            addQuestion("가장 좋아하는 앨범은 무엇인가요?", MUSIC),
            addQuestion("가장 좋아하는 뮤직 비디오는 무엇인가요?", MUSIC),
            addQuestion("사용하고 있는 음악 앱은 무엇인가요?", MUSIC),
            addQuestion("가장 좋아하는 악기는 무엇인가요?", MUSIC),
            addQuestion("가장 좋았던 음악 콘서트는 무엇인가요?", MUSIC),
            addQuestion("가장 좋아하는 음악 레이블은 무엇인가요?", MUSIC),
            addQuestion("가장 좋아하는 음악 프로듀서는 누구인가요?", MUSIC),
            addQuestion("당신만 알고 있는 추천할 만한 음악이 있나요?", MUSIC),
            addQuestion("음악에 담긴 추억이 있을까요?", MUSIC)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initDating() {
        // 연애 관련 질문
        List<Question> questions = Arrays.asList(
                addQuestion("첫사랑은 언제였나요?", DATING),
                addQuestion("첫 키스는 언제이고 어떠셨나요?", DATING),
                addQuestion("가장 기억에 남는 데이트는 어떠한 날이었나요?", DATING),
                addQuestion("연인과 가장 행복했던 순간은 언제였나요?", DATING),
                addQuestion("연인과 가장 많이 가는 장소는 어디인가요?", DATING),
                addQuestion("연인에게 가장 중요한 특성은 무엇인가요?", DATING),
                addQuestion("연인과의 통화는 얼마나 자주하나요?", DATING),
                addQuestion("연인과의 관계를 한마디로 표현하면 무엇인가요?", DATING),
                addQuestion("연인에게 가장 마지막으로 한 선물은 무엇인가요?", DATING),
                addQuestion("연인이 가장 좋아하는 음식은 무엇인가요?", DATING),
                addQuestion("연인과의 첫 만남은 어떠셨나요?", DATING),
                addQuestion("연인과 가장 많이 이야기하는 주제는 무엇인가요?", DATING),
                addQuestion("연인과의 관계에서 가장 어려웠던 순간은 언제였나요?", DATING),
                addQuestion("연인을 위해 무엇까지 할 수 있나요?", DATING),
                addQuestion("당신은 결혼을 어떻게 생각하나요?", DATING)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initCareer() {
        // 진로/직업 관련 질문
        List<Question> questions = Arrays.asList(
                addQuestion("가장 원하는 직업은 무엇인가요?", CAREER),
                addQuestion("현재 진행 중인 직업 관련 공부는 무엇인가요?", CAREER),
                addQuestion("가장 본받고 싶은 인물은 누구인가요?", CAREER),
                addQuestion("가장 힘들었던 직무 관련 경험은 무엇인가요?", CAREER),
                addQuestion("가장 기억에 남는 성공 사례는 무엇인가요?", CAREER),
                addQuestion("직장이 없을 때를 위한 대비책이 있나요?", CAREER),
                addQuestion("어떤 회사에서 일하고 싶나요?", CAREER),
                addQuestion("당신이 다니고 싶은 직장에서 가장 큰 어려움은 무엇일까요?", CAREER),
                addQuestion("미래에는 어떤 직종이 주목받고 있을까요?", CAREER),
                addQuestion("직업에 귀천이 있다고 생각하나요?", CAREER)
        );

        questionRepository.saveAll(questions);
    }

    @PostConstruct
    public void initLife() {
        List<Question> questions = Arrays.asList(
                addQuestion("살면서 가장 힘들었던 일은 무엇인가요?", LIFE),
                addQuestion("살면서 가장 후회하고 있는 일은 무엇인가요?", LIFE),
                addQuestion("10년뒤의 당신은 어떤 것을 하고 있을까요?", LIFE),
                addQuestion("5년전 당신은 무엇을 하고 있었나요?", LIFE),
                addQuestion("지금 당신을 힘들게 하는 일이 있나요?", LIFE),
                addQuestion("당신이 진심으로 싫어했던 사람이 있나요?", LIFE),
                addQuestion("지금까지의 인생을 한마디로 표현해보세요.", LIFE),
                addQuestion("살면서 가장 기억에 남는 사람은 누구인가요?", LIFE),
                addQuestion("예상하지 못했던 행운이 찾아온 일이 있나요?", LIFE),
                addQuestion("당신은 어떤 사람이 되고 싶나요?", LIFE)
        );

        questionRepository.saveAll(questions);
    }

    public Question addQuestion(String content, Category category) {
        return Question.builder()
                .qnaType(category)
                .content(content)
                .build();
    }
}