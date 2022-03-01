package com.example.springbasic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFuLServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFuLService stateFuLService1 = ac.getBean(StateFuLService.class);
        StateFuLService stateFuLService2 = ac.getBean(StateFuLService.class);

        //ThreadA : A사용자 10000원 주문
        int userAPrice = stateFuLService1.order("userA", 10000);
        //ThreadA : B사용자 20000원 주문
        int userBPrice = stateFuLService1.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
//        int price = stateFuLService1.getPrice();
        System.out.println("price = " + userAPrice);

        Assertions.assertThat(stateFuLService1.getPrice())
                .isNotEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StateFuLService stateFuLService() {
            return new StateFuLService();
        }
    }
}