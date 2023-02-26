package com.strategy.template;

import com.strategy.template.callback.Callback;
import com.strategy.template.callback.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void templateCallbackPatter() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("business logic executed!!!");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("business logic2 executed!!!");
            }
        });
    }
}
