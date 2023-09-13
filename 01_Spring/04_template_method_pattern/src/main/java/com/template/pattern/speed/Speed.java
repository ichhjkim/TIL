package com.template.pattern.speed;

import lombok.Getter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
public class Speed {
    @Id
    private String id;

    private String gradeSeq;

    private String starSeq;
    private LocalDateTime regDate;

    private LocalDateTime expireDate;

    public Speed() {
        this.id = UUID.randomUUID().toString().split("-")[0]+UUID.randomUUID().toString().split("-")[4];
        this.regDate = LocalDateTime.now().withNano(0);
        this.expireDate = LocalDateTime.now().withNano(0);
        this.gradeSeq = UUID.randomUUID().toString();
        this.starSeq = UUID.randomUUID().toString();
    }
}
