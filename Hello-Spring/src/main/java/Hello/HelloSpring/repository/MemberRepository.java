package Hello.HelloSpring.repository;

import Hello.HelloSpring.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);             //findById, findByName이 Null일 경우 Optional 감싸서 반환    JAVA 8에 들어가 있는 기능 !
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
