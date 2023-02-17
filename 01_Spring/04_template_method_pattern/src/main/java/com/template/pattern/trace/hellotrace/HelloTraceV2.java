package com.template.pattern.trace.hellotrace;

import com.template.pattern.trace.TraceId;
import com.template.pattern.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV2 {
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        Long starTimeMillis = System.currentTimeMillis();
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, starTimeMillis, message);
    }

    public TraceStatus beginSync(TraceId beforeTraceId, String message) {
        TraceId nextId = beforeTraceId.createNextId();
        Long starTimeMillis = System.currentTimeMillis();
        // 로그 출력
        log.info("[{}] {}{}", nextId.getId(), addSpace(START_PREFIX, nextId.getLevel()), message);
        return new TraceStatus(nextId, starTimeMillis, message);
    }
    public void end(TraceStatus traceStatus) {
        complete(traceStatus, null);
    }

    public void exception(TraceStatus traceStatus, Exception exception) {
        complete(traceStatus, exception);
    }

    private void complete(TraceStatus traceStatus, Exception e) {
        Long stopMs = System.currentTimeMillis();
        long resultTimeMs = stopMs - traceStatus.getStartTimeMillis();
        TraceId traceId = traceStatus.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), traceStatus.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), traceStatus.getMessage(), resultTimeMs, e.toString());
        }
    }

    private String addSpace(String prefix, int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<level;i++) {
            stringBuilder.append((i==level-1) ? "|"+prefix: "|   ");
        }
        return stringBuilder.toString();
    }
}
