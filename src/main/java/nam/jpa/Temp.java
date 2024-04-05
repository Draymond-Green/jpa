package nam.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import nam.jpa.entitiy.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class Temp {
    @Autowired
    EntityManager em;
    private int age;



    Member member;

    @Autowired
    public Temp(Member member) {
        this.member = member;
    }

    public Temp(int age) {
        this.age = age;
    }


    JPAQueryFactory queryFactory = new JPAQueryFactory(em);
}
