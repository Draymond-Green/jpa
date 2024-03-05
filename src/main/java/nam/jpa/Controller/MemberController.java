package nam.jpa.Controller;

import nam.jpa.Dto.MemberDto;
import nam.jpa.entitiy.Member;
import nam.jpa.repository.MemberRepository;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members")
    public Page<MemberDto> list(Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        Page<MemberDto> pageDto = page.map((m) -> new MemberDto(m.getId(), m.getUsername()));
        return pageDto;
    }

    public AuditorAware<String> test() {
        AuditorAware<String> ans = () -> Optional.of(UUID.randomUUID().toString());
        return ans;
    }

    @GetMapping("/members/{id}")
    public Member findMember(@PathVariable("id") Long id) {
        Optional<Member> result = memberRepository.findById(id);
        return result.orElse(null);
    }

    @PostMapping("/mebers/patch/{id}")
    public void patchMember(@PathVariable("id") Long id, @RequestBody Member member) {
        Optional<Member> result = memberRepository.findById(id);
        Member findMember = result.orElse(null);
        findMember.setAge(member.getAge());
        findMember.setTeam(member.getTeam());
        findMember.setAge(member.getAge());
    }

    @PostMapping("/members/delete/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        memberRepository.delete(member);
    }


}
