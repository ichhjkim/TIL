package com.strategy.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        // UUID의 앞자리 8자리까지만 사용
        // 로그기 때문에 어쩌다 중복이 되어도 크게 문제가 되지 않는다.
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        return new TraceId(id, level+1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level-1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }
}
