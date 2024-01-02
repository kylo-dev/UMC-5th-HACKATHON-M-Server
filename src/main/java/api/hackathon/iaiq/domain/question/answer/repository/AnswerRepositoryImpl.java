package api.hackathon.iaiq.domain.question.answer.repository;

import static api.hackathon.iaiq.domain.question.answer.domain.QAnswer.*;

import api.hackathon.iaiq.domain.question.answer.domain.Answer;
import api.hackathon.iaiq.domain.question.answer.domain.QAnswer;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnswerRepositoryImpl implements AnswerRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Answer findByCondition(Long memberId, LocalDate localDate) {

        // 날짜 범위 설정
        LocalDateTime startOfDay = localDate.atStartOfDay(); // 해당 날짜의 시작 시간 (00:00:00)
        LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX); // 해당 날짜의 끝 시간 (23:59:59.999999999)

        return jpaQueryFactory
                .selectFrom(answer)
                .where(answer.member.id.eq(memberId))
                .where(answer.createdDate.between(startOfDay, endOfDay))
                .fetchOne();

    }
}
