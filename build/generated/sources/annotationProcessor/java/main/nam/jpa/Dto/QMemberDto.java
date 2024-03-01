package nam.jpa.Dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * nam.jpa.Dto.QMemberDto is a Querydsl Projection type for MemberDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberDto extends ConstructorExpression<MemberDto> {

    private static final long serialVersionUID = -586328401L;

    public QMemberDto(com.querydsl.core.types.Expression<? extends nam.jpa.entitiy.Member> member) {
        super(MemberDto.class, new Class<?>[]{nam.jpa.entitiy.Member.class}, member);
    }

}

