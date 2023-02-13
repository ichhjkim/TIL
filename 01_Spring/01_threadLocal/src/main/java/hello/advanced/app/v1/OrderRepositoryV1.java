package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 helloTraceV1;

    public void save(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV1.begin("OrderController.save()");
            // 저장로직
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외발생");
            }
            sleep(1000);
            helloTraceV1.end(traceStatus);
        } catch (Exception e) {
            helloTraceV1.exception(traceStatus, e);
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
