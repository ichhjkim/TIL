package com.strategy.trace.logtrace;

import com.strategy.trace.TraceId;
import com.strategy.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalTrace implements LogTrace{

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    /**
     * 동시성이 발생하지 않도록
     */
    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = this.traceIdHolder.get();
        Long starTimeMillis = System.currentTimeMillis();
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, starTimeMillis, message);
    }

    private void syncTraceId() {
        TraceId traceId = traceIdHolder.get();
        if (traceId==null) {
            traceIdHolder.set(new TraceId());
        } else {
            traceIdHolder.set(traceId.createNextId());
        }
    }

    @Override
    public void end(TraceStatus traceStatus) {
        complete(traceStatus, null);
    }

    @Override
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
        releaseTraceId();
    }

    private void releaseTraceId() {
        TraceId traceId = traceIdHolder.get();
        if (traceId.isFirstLevel()) {
            traceIdHolder.remove(); // destroy 해당 Thread가 저장한 데이터가 다 지워짐. 다른 Thread가 저장한 데이터는 안지워짐
            log.info("ThreadLocal.remove() 호출, ThreadLocal={}", traceIdHolder.get());
        } else {
            traceIdHolder.set(traceId.createPreviousId());
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
