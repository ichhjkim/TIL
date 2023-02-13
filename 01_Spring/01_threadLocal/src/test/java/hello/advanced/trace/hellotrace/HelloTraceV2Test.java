package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void beginEnd() {
        HelloTraceV2 traceV1 = new HelloTraceV2();
        TraceStatus traceStatus = traceV1.begin("hello");
        traceV1.end(traceStatus);
    }
    @Test
    void beginException() {
        HelloTraceV2 traceV1 = new HelloTraceV2();
        TraceStatus traceStatus = traceV1.begin("hello");
        NullPointerException nullPointerException = new NullPointerException();
        traceV1.exception(traceStatus, nullPointerException);
    }

    @Test
    void beginSyncEnd() {
        HelloTraceV2 traceV2 = new HelloTraceV2();
        TraceStatus traceStatus1 = traceV2.begin("hello");
        TraceStatus traceStatus2 = traceV2.beginSync(traceStatus1.getTraceId(), "hello2");
        traceV2.end(traceStatus2);
        traceV2.end(traceStatus1);
    }

    @Test
    void beginSyncException() {
        HelloTraceV2 traceV2 = new HelloTraceV2();
        TraceStatus traceStatus1 = traceV2.begin("hello");
        TraceStatus traceStatus2 = traceV2.beginSync(traceStatus1.getTraceId(), "hello2");
        traceV2.exception(traceStatus2, new IllegalArgumentException());
        traceV2.exception(traceStatus1, new IllegalArgumentException());
    }
}