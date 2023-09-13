package com.strategy.template;

import com.strategy.template.code.AbstractTemplate;
import com.strategy.template.code.SubClassLogic1;
import com.strategy.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class AbstractTemplateMethodTest {

    @Test
    void templateMethodVO() {
        logic1();
        logic2();
    }

    /**
     * 템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate abstractTemplate1 = new SubClassLogic1();
        abstractTemplate1.execute();
        AbstractTemplate abstractTemplate2 = new SubClassLogic2();
        abstractTemplate2.execute();
    }

    @Test
    void test() {
        try {
            System.out.println("TEST");
            throw new IllegalArgumentException("TEST");
        } catch (Exception e) {
            log.error("{} Exception",  e.getMessage());
            throw e;
        } finally {
            log.error("print");
            System.out.println("finally");

        }
    }

    @Test
    void templateMethodV2() {
        // 객체를 생성하며 동시에 구현할 수 있다.
        // 바로 자식 클래스를 정의할 수 있다.
        AbstractTemplate abstractTemplate1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("클래스1");
            }
        };
        log.info("Class Name1={}", abstractTemplate1.getClass());
        abstractTemplate1.execute();
        AbstractTemplate abstractTemplate2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("클래스2");
            }
        };
        log.info("Class Name2={}", abstractTemplate2.getClass());
        abstractTemplate2.execute();
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
