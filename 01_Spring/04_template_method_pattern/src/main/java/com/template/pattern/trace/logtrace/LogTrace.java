package com.template.pattern.trace.logtrace;


import com.template.pattern.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus traceStatus);
    void exception(TraceStatus traceStatus, Exception e);

}
