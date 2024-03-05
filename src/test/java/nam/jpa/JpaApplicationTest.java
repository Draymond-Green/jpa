package nam.jpa;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import nam.jpa.Dto.MemberDto;
import nam.jpa.Dto.QMemberDto;
import nam.jpa.entitiy.Member;
import nam.jpa.entitiy.QMember;
import nam.jpa.entitiy.QTeam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static nam.jpa.entitiy.QMember.*;
import static nam.jpa.entitiy.QTeam.team;

@Transactional
@SpringBootTest
@Slf4j
class JpaApplicationTest {
    @Autowired
    EntityManager em;
    JPAQueryFactory queryFactory= new JPAQueryFactory(em);


    @Test
    public void test1() {
        Member member2= new Member("ac");
        QMember m = new QMember("c");
        QMember mm = new QMember("c");
        BooleanExpression in = m.age.in(10, 20, 30);

        QMember qMember= member;
        QTeam qTeam = team;

        BooleanBuilder booleanBuilder= new BooleanBuilder();
        QMember member10 = new QMember("member100");
        List<MemberDto> fetch = queryFactory
                .select(new QMemberDto(qMember))
                .from(member)
                .fetch();
        List<Member> fetch1 = queryFactory.selectFrom(qMember)
                .join(qMember.team, team)
                .fetch();
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
    }

    private List<Member> searchMember1(String usernameCond, Integer ageCond) {
        BooleanBuilder booleanBuilder= new BooleanBuilder();
        booleanBuilder.and(member.username.eq(usernameCond));
        booleanBuilder.and(member.age.eq(ageCond));
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(booleanBuilder)
                .fetch();
        return result;
    }

    public Temp mmm() {
        Temp temp = new Temp(33);
        return temp;
    }

}