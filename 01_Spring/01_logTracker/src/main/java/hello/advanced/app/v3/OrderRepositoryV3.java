package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace logTrace;

    public void save(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = logTrace.begin("OrderRepository.save()");
            // 저장로직
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외발생");
            }
            sleep(1000);
            logTrace.end(traceStatus);
        } catch (Exception e) {
            logTrace.exception(traceStatus, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
