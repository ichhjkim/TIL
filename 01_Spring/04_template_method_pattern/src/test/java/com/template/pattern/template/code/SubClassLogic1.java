package com.template.pattern.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate{

    // 변화하는 부분은 자식 클래스에서 오버라이딩해서 쓴다.
    @Override
    public void call() {
        log.info("비즈니스 로직1 실행");
    }
}
