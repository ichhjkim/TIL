package com.strategy.v0;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class Test {
    private String id;
    private LocalDateTime regDate;
    private LocalDateTime expireDate;

    private String gradeSeq;
    private String starSeq;

    public Test() {
        this.id = UUID.randomUUID().toString().split("-")[0] + UUID.randomUUID().toString().split("-")[1];
        this.regDate = LocalDateTime.now();
        this.expireDate = LocalDateTime.now();
        int a = (int)(Math.random()*100);
        int b = (int)(Math.random()*100);
        //15270544
        //8979401
        //6579475
        // payload 크기 전달부터 안되네.. ㅋ
        if (a%10 != 1) {
            this.gradeSeq = "Y";
        }
        if (b%10 != 9) {
            this.starSeq = "Y";
        }
    }
}
