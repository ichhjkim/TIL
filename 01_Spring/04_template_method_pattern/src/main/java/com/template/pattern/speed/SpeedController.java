package com.template.pattern.speed;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/speed")
@RequiredArgsConstructor
public class SpeedController {
    private final SpeedService speedService;

    @PostMapping()
    public String save() {
        speedService.save();
        return "ok";
    }

    @GetMapping()
    public List<Speed> getSpeedList() {
        List<Speed> result = speedService.getSpeeds();
        AtomicInteger count= new AtomicInteger();
        result.forEach(speed -> {
            count.getAndIncrement();
        });
        return result;
    }
}
