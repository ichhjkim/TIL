package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {

    @Test
    void beginEnd() {
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus traceStatus = traceV1.begin("hello");
        traceV1.end(traceStatus);
    }
    @Test
    void beginException() {
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus traceStatus = traceV1.begin("hello");
        NullPointerException nullPointerException = new NullPointerException();
        traceV1.exception(traceStatus, nullPointerException);
    }
}