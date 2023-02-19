package com.strategy.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드의 전략을 보관하는 방식
 */
@Slf4j
public class ContextV1 {
    private Strategy strategy;

    // 여기에서 전략을 주입
    // 템플릿은 자식클래스가 부모클래스를 상속받아서 구현하는데
    // 전략 패턴은 context가 인터페이스를 구현한 구현체를 주입받는다.

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
