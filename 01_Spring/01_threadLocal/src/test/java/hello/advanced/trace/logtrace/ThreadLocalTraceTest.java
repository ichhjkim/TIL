package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.*;

class ThreadLocalTraceTest {
    ThreadLocalTrace threadLocalTrace = new ThreadLocalTrace();

    @Test
    void beginEnd() {
        TraceStatus traceStatus1 = threadLocalTrace.begin("Level1");
        TraceStatus traceStatus2 = threadLocalTrace.begin("Level2");
        threadLocalTrace.end(traceStatus2);
        threadLocalTrace.end(traceStatus1);
    }

    @Test
    void beginException() {
        TraceStatus traceStatus1 = threadLocalTrace.begin("Level1");
        TraceStatus traceStatus2 = threadLocalTrace.begin("Level2");
        TraceStatus traceStatus3 = threadLocalTrace.begin("Level3");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        threadLocalTrace.exception(traceStatus3, illegalArgumentException);
        threadLocalTrace.exception(traceStatus2, illegalArgumentException);
        threadLocalTrace.exception(traceStatus1, illegalArgumentException);
    }

    @Test
    void exception() {
    }
}