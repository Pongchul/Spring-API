package Hello.HelloSpring.repository;

import Hello.HelloSpring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // save를 할 때 메모리에 저장하기 위한 기능
    private static long sequence = 0L;  //Sequence는 0,1,2, 이렇게 키값을 생성시켜 주는 얘


    @Override
    public Member save(Member member) {
         member.setId(++sequence);
         store.put(member.getId(), member);
         return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //store id가 null이어도 감쌀 수 있다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // member에서 getName이 Param으로 넘어온 이름이 같은지
                .findAny();  // 하나라도 찾는것 !
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // 실무에선 List많이 씀 루프 돌리기도 편하고
    }

    public void clearStore() {
        store.clear();
    }
}
