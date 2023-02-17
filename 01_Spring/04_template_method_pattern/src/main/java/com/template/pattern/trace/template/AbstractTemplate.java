package com.template.pattern.trace.template;

import com.template.pattern.trace.TraceStatus;
import com.template.pattern.trace.logtrace.LogTrace;
import lombok.extern.java.Log;

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
