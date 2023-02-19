package com.strategy.trace.template;


import com.strategy.trace.TraceStatus;
import com.strategy.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {
    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public T execute(String message) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = logTrace.begin(message);
            // 로직 호출
            T result = call();
            logTrace.end(traceStatus);
            return result;
        } catch (Exception e) {
            logTrace.exception(traceStatus, e);
            throw e;
        }
    }

    protected abstract T call();


}
