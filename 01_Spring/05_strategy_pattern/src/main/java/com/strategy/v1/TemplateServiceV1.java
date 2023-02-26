package com.strategy.v1;

import com.strategy.trace.callback.TraceCallback;
import com.strategy.trace.callback.TraceTemplate;
import com.strategy.trace.logtrace.LogTrace;
import com.strategy.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceV1 {
    private final TemplateRepositoryV1 templateRepository;
    private final TraceTemplate traceTemplate;

    public TemplateServiceV1(TemplateRepositoryV1 templateRepository1, LogTrace logTrace) {
        this.templateRepository = templateRepository1;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void test(String code) {
        traceTemplate.execute(
                "TemplateServiceV1 Message",
                new TraceCallback<String>() {
                    @Override
                    public String call() {
                        templateRepository.save(code);
                        return code;
                    }
                }
        );
    }
}
