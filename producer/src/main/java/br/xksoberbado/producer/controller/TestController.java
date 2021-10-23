package br.xksoberbado.producer.controller;

import br.xksoberbado.producer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Serializable> jsonKafkaTemplate;

    @GetMapping("send")
    public void send() {
        IntStream.range(0, 51)
                .boxed()
                .forEach(n -> kafkaTemplate.send("topic-1", "Número: " + n));
    }

    @GetMapping("send-person")
    public void sendPerson() {
        jsonKafkaTemplate.send("person-topic", new Person("João", new Random().nextInt(50)));
    }

}
