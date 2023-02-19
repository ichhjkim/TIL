package com.strategy.strategy;

import com.strategy.strategy.code.strategy.ContextV1;
import com.strategy.strategy.code.strategy.Strategy;
import com.strategy.strategy.code.strategy.StrategyLogic1;
import com.strategy.strategy.code.strategy.StrategyLogic2;
import com.strategy.template.code.AbstractTemplate;
import com.strategy.template.code.SubClassLogic1;
import com.strategy.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2_익명내부클래스() {
        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("내부 익명클래스 로직1 !!!!");
            }
        };
        log.info("익명 내부 클래스={}", strategy1.getClass());
        ContextV1 contextV1 = new ContextV1(strategy1);
        contextV1.execute();

        Strategy strategy2 = new Strategy() {
            @Override
            public void call() {
                log.info("내부 익명클래스 로직2 !!!!");
            }
        };
        log.info("익명 내부 클래스={}", strategy2.getClass());
        ContextV1 contextV2 = new ContextV1(strategy2);
        contextV2.execute();
    }

    @Test
    void strategyV3_익명내부클래스_람다() {
        // 단, 람다로 구현하려면 해당 인터페이스에 메서드가 '한 개'만 있어야 한다!!
        ContextV1 contextV1 = new ContextV1(()-> log.info("내부 익명클래스 로직1 !!!!"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(()-> log.info("내부 익명클래스 로직2 !!!!"));
        contextV2.execute();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

}
