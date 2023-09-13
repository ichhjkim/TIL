package com.template.pattern.speed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeedService {
    private final SpeedRepository speedRepository;

    public void save() {
        for (int i=0;i<100000;i++) {
            speedRepository.save(new Speed());
        }
    }

    public List<Speed> getSpeeds() {
        return speedRepository.findCustom();
    }
}
