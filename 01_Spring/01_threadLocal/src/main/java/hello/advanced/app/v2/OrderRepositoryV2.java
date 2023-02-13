package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final HelloTraceV2 helloTraceV2;

    public void save(TraceId traceId, String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV2.beginSync(traceId, "OrderRepository.save()");
            // 저장로직
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("예외발생");
            }
            sleep(1000);
            helloTraceV2.end(traceStatus);
        } catch (Exception e) {
            helloTraceV2.exception(traceStatus, e);
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
