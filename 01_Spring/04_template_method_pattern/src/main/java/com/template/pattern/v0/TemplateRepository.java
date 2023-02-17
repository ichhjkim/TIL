package com.template.pattern.v0;

import com.template.pattern.trace.logtrace.LogTrace;
import com.template.pattern.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TemplateRepository {
    private final LogTrace logTrace;

    public void save(String code) {
        AbstractTemplate<Void> abstractTemplate = new AbstractTemplate<Void>(logTrace) {
            @Override
            protected Void call() {
                log.info("SAVING CODE={}", code);
                return null;
            }
        };

        abstractTemplate.execute("TemplateRepository.save() 호출");
    }
}
