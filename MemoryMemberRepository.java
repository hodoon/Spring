package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // HashMap을 사용하여 키값 쌍으로 멤버 정보를 저장한다. 키는 멤버의 ID, 값은 멤버의 객체
    private static long sequence = 0L; // sequence는 키값 생성용
    @Override
    public Member save(Member member){ //
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long Id) {
        return Optional.ofNullable(store.get(Id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
