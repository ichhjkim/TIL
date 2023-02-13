package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 helloTraceV1;

    public void orderItem(String itemId) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = helloTraceV1.begin("OrderController.orderItem()");
            orderRepository.save(itemId);
            helloTraceV1.end(traceStatus);
        } catch (Exception e) {
            helloTraceV1.exception(traceStatus, e);
            throw e;
        }
    }
}
