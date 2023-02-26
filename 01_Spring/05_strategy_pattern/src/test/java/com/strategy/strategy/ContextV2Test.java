package com.strategy.strategy;

import com.strategy.strategy.code.strategy.ContextV2;
import com.strategy.strategy.code.strategy.StrategyLogic1;
import com.strategy.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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

    @Test
    void 테스트() {
        LocalDateTime localDateTime = LocalDateTime.now();
        byte year = Integer.valueOf(localDateTime.getYear()).byteValue();
        byte month = Integer.valueOf(localDateTime.getMonthValue()).byteValue();
        byte day = Integer.valueOf(localDateTime.getDayOfMonth()).byteValue();
        byte hour = Integer.valueOf(localDateTime.getHour()).byteValue();
        byte mi = Integer.valueOf(localDateTime.getMinute()).byteValue();
        byte second = Integer.valueOf(localDateTime.getSecond()).byteValue();
        byte nano = Integer.valueOf(localDateTime.getNano()).byteValue();
        int result = year + month + day + hour + mi + second + nano;
        log.info("#### {}",result);
    }
}
