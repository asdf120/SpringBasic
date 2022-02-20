package com.example.springbasic.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepiository implements MemberRepository{

    // TODO ConcurrentHashMap 확인
    // 실무에서는 동시성 이슈때문에 ConcurrentHashMap 쓰임
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
