package xyz.sandersonsa.kafka_consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Value( "${spring.kafka.consumer.group-id}" )
    private String GROUP_ID_CONFIG;

    @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.groupid}")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}