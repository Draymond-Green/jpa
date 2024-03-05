package nam.jpa.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import nam.jpa.entitiy.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;
    @Test
    public void test1() {
        Optional<Member> byId = memberRepository.findById(1L);
        Member member = memberRepository.findById(1L).get();
        JPAQueryFactory query = new JPAQueryFactory(em);
        List<Member> result = memberRepository.findByAge(33);
        BooleanBuilder booleanBuilder = new BooleanBuilder();


    }


}