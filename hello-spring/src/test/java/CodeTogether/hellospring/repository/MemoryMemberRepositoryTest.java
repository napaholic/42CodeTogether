package CodeTogether.hellospring.repository;

import CodeTogether.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setIntra_id("spring");

        repository.save(member);

        Member result = repository.findById(member.getMember_id()).get();
        Assertions.assertEquals(result, member);
    }
}
