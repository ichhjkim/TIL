package com.strategy.v0;

import com.strategy.trace.logtrace.LogTrace;
import com.strategy.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemplateService {
    private final LogTrace logTrace;
    private final TemplateRepository templateRepository;

    public void test(String code) {
        AbstractTemplate<Void> abstractTemplate = new AbstractTemplate<Void>(logTrace) {
            @Override
            protected Void call() {
                if ("ex".equals(code)) {
                    throw new IllegalArgumentException();
                }
                templateRepository.save(code);
                return null;
            }
        };

        abstractTemplate.execute("TemplateService.test() 호출");


    }
}
