package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.assertj.core.internal.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {

    FieldLogTrace logTrace = new FieldLogTrace();

    @Test
    void beginEnd() {
        TraceStatus traceStatus1 = logTrace.begin("Level1");
        TraceStatus traceStatus2 = logTrace.begin("Level2");
        logTrace.end(traceStatus2);
        logTrace.end(traceStatus1);
    }

    @Test
    void beginException() {
        TraceStatus traceStatus1 = logTrace.begin("Level1");
        TraceStatus traceStatus2 = logTrace.begin("Level2");
        TraceStatus traceStatus3 = logTrace.begin("Level3");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        logTrace.exception(traceStatus3, illegalArgumentException);
        logTrace.exception(traceStatus2, illegalArgumentException);
        logTrace.exception(traceStatus1, illegalArgumentException);
    }

    @Test
    void exception() {
    }
}