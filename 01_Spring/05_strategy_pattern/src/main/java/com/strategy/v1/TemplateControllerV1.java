package com.strategy.v1;

import com.strategy.trace.callback.TraceCallback;
import com.strategy.trace.callback.TraceTemplate;
import com.strategy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/template")
public class TemplateControllerV1 {
    private final TemplateServiceV1 templateServiceV1;

    private final TraceTemplate traceTemplate;

    @Autowired
    public TemplateControllerV1(TemplateServiceV1 templateServiceV1, LogTrace logTrace) {
        this.templateServiceV1 = templateServiceV1;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    @GetMapping("/v1")
    public String getTemplate(@RequestParam(required = false) String code) {
        
        return traceTemplate.execute(
                "Controller Message",
                new TraceCallback<String>() {
                    @Override
                    public String call() {
                        templateServiceV1.test(code);
                        return code;
                    }
                }
        );

    }
}
