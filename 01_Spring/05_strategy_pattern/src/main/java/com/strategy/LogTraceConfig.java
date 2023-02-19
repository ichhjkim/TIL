package com.strategy;

import com.strategy.trace.logtrace.LogTrace;
import com.strategy.trace.logtrace.ThreadLocalTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalTrace();
    }
}
