package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldLogTrace implements LogTrace{
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    /**
     * 동시성이 발생하는 이유
     * 동시에 여러 사용자가 요청하게 되면, 여러 쓰레드가 동시에 애플리케이션 로직을 수행한다.
     * 따라서, 로그는 섞여서 호출된다.
     *
     * FieldLogTrace는 싱글톤으로 등록된 스프링 빈이기 때문에,
     * 여러 쓰레드에서 동시에 접근 해서 문제가 발생한다.
     */
    private TraceId traceIdHolder; // TraceID 동기화, 추후 동시성 이슈 발생할 것

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = this.traceIdHolder;
        Long starTimeMillis = System.currentTimeMillis();
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, starTimeMillis, message);
    }

    private void syncTraceId() {
        if (traceIdHolder==null) {
            traceIdHolder = new TraceId();
        } else {
            traceIdHolder = traceIdHolder.createNextId();
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
        if (traceIdHolder.isFirstLevel()) {
            traceIdHolder = null;
        } else {
            traceIdHolder = traceIdHolder.createPreviousId();
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
