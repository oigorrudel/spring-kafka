package br.xksoberbado.consumer2.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestListener2 {

    @KafkaListener(topics = "topic-1", groupId = "group-2")
    public void listen(String message) {
//        log.info("Thread: {}", Thread.currentThread().getId());
        log.info(message);
    }

}
