package com.example.springbasic.order;

import com.example.springbasic.discount.DiscountPolicy;
import com.example.springbasic.discount.FixDiscountPolicy;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberRepository;
import com.example.springbasic.member.MemoryMemberRepiository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepiository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discouont(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
