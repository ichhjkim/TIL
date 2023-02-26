package com.strategy.v1;

import com.strategy.trace.callback.TraceCallback;
import com.strategy.trace.callback.TraceTemplate;
import com.strategy.trace.logtrace.LogTrace;
import com.strategy.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TemplateRepositoryV1 {
    private final TraceTemplate traceTemplate;

    public TemplateRepositoryV1(LogTrace logTrace) {
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void save(String code) {
        traceTemplate.execute(
                "TemplateRepositoryV1 Message",
                new TraceCallback<String>() {
                    @Override
                    public String call() {
                        log.info("saved");
                        return code;
                    }
                }
        );
    }
}
