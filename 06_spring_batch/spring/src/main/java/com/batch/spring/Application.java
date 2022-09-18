package com.batch.spring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Batch를 활성화 하기 위한 annotation
// 내부적으로 총 4개의 설정 클래스를 실행시키며, 스프링 배치의 모든 초기화 및 실행 구성이 이루어진다.
// 스프링 부트 배치의 자동 설정 클래스가 실행됨으로서 빈으로 등록된 모든 job을 검색해서 초기화와 동시에 job을 수행하도록 구성된다.

/**
 * BatchAutoConfiguration
 * - Spring batch가 초기화 될때 자동으로 실행되는 설정 클래스
 * - Job을 수행하는 JObLauncherApplicationRunner 빈을 생성
 * SimpleBatchConfiguration
 * - JobBuilderFactory와 StepBuilderFactory 생성
 * - spring batch의 주요 구성 요소 생성 - proxy 객체로 생성됨
 * BatchConfiguerConfiguration
 * - BasicBatchConfiguerer
 * -- simpleBatchConfiguration에서 생성한 프록시 객체의 실제 대상 객체를 생성하는 설정 클래스
 * -- 빈으로 의존성 주입 받아서 주요 객체들을 참조해서 사용
 * - JPABatchConfigure
 * -- JPA관련 객체를 생성하는 설정 클래스
 */
@EnableBatchProcessing
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
