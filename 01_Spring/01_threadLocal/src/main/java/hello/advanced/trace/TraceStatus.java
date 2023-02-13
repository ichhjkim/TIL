package hello.advanced.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 로그의 상태 정보를 나타낸다.
// 로그를 시작할 때의 정보를 가지고 있다.

@Getter
@AllArgsConstructor
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMillis;
    private String message;

}
