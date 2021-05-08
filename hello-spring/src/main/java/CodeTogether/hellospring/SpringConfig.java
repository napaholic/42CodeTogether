package CodeTogether.hellospring;

import CodeTogether.hellospring.repository.*;
import CodeTogether.hellospring.service.MemberService;
import CodeTogether.hellospring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }

    @Bean
    public SubjectService subjectService() {
        return new SubjectService(subjectRepository());
    }

    @Bean
    public SubjectRepository subjectRepository() {
        return new JdbcSubjectRepository(dataSource);
    }
}
