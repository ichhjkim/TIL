package com.strategy.strategy;

import com.strategy.strategy.code.strategy.ContextV2;
import com.strategy.strategy.code.strategy.StrategyLogic1;
import com.strategy.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략패턴을 그때 그때 전략을 실행할 때마다 인수로 적용
     */
    @Test
    void 전략패턴버전1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void 전략패턴버전2_람다() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(()-> log.info("익명 람다1 실행"));
        contextV2.execute(()-> log.info("익명 람다2 실행"));
    }
}
