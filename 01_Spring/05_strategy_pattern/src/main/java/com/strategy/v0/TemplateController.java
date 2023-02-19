package com.strategy.v0;

import com.strategy.trace.logtrace.LogTrace;
import com.strategy.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/template")
@RequiredArgsConstructor
public class TemplateController {
    private final LogTrace logTrace;
    private final TemplateService templateService;

    @GetMapping("/v0")
    public ResponseEntity<Object> getTemplate(@RequestParam(required = false) String code) {

        // 제네릭에서 반환 타입이 필요한다. 반환할 내용이 없으면 Void를 사용하고 null을 반환하면 된다.
        // 이때, void, int등은 사용할 수 없다.
        AbstractTemplate<Void> abstractTemplate = new AbstractTemplate<Void>(logTrace) {
            @Override
            protected Void call() {
                templateService.test(code);
                return null;
            }
        };

        abstractTemplate.execute("Template.controller() 호출");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
