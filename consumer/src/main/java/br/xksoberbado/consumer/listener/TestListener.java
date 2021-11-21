package br.xksoberbado.consumer.listener;

import java.util.List;
import br.xksoberbado.consumer.custom.PersonCustomListener;
import br.xksoberbado.consumer.model.City;
import br.xksoberbado.consumer.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestListener {

//    @KafkaListener(topics = "topic-1", groupId = "group-1")
//    public void listen(String message) {
//        log.info("Thread: {} Message: {}", Thread.currentThread().getId(), message);
//    }

    @KafkaListener(topics = "topic-1", groupId = "group-1")
    public void listen(List<String> messages) {
        log.info("Thread: {} Messages: {}", Thread.currentThread().getId(), messages);
    }

//    @KafkaListener(topics = "my-topic", groupId = "my-group")
//    public void listen2(String message) {
//        log.info("Thread: {} Message: {}", Thread.currentThread().getId(), message);
//    }

//    @KafkaListener(topicPartitions = {@TopicPartition(topic = "my-topic", partitions = "0")}, groupId = "my-group")
//    public void listen2(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        log.info("Partition 0: {} Message: {}", partition, message);
//    }
//
//    @KafkaListener(topicPartitions = {@TopicPartition(topic = "my-topic", partitions = "1-9")}, groupId = "my-group")
//    public void listen3(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        log.info("Partition 1-9: {} Message: {}", partition, message);
//    }

    //    @KafkaListener(topics = "person-topic", groupId = "group-1", containerFactory = "personKafkaListenerContainerFactory")
    @PersonCustomListener(groupId = "group-1")
    public void create(Person person, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) long partition) {
//        log.info("Thread: {}", Thread.currentThread().getId());
        log.info("Criar pessoa: {} Partition: {}", person, partition);
        throw new IllegalArgumentException("Teste");
    }

    @PersonCustomListener(topics= "person-topic.DLT", groupId = "group-1")
    public void dlt(Person person, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) long partition) {
        log.info("DLT: {} Partition: {}", person, partition);
    }


    @KafkaListener(topics = "city-topic", groupId = "group-1", containerFactory = "jsonKafkaListenerContainerFactory")
    public void create(List<Message<City>> messages) {
//        log.info("Criar cidade: {}", city);
//        log.info("Cidades: {}", cities);
//        log.info("Partições: {}", partitions);
        log.info("Messages: {}", messages);
        var city = messages.get(0).getPayload();
        log.info("Cidade: {}", city);
        log.info("Headers: {}", messages.get(0).getHeaders());
    }

//
//    //    @KafkaListener(topics = "person-topic", groupId = "group-2", containerFactory = "personKafkaListenerContainerFactory")
//    @PersonCustomListener(groupId = "group-2")
//    public void history(Person person) {
//        log.info("Thread: {}", Thread.currentThread().getId());
//        log.info("Histórico: {}", person);
//    }


}
