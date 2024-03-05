package nam.jpa.Dto;


import com.querydsl.core.annotations.QueryProjection;
import nam.jpa.entitiy.Member;

public class MemberDto {
    Long id;
    String username;

    public MemberDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }


    public MemberDto() {
    }
    @QueryProjection
    public MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
    }
}
