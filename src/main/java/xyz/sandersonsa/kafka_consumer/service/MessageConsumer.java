package xyz.sandersonsa.kafka_consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.groupid}")
    public void listen(String message) {
        logger.info("## RECEIVED MESSAGE: {}\n##ON TOPIC: {}", message, "${kafka.consumer.topic}");
    }

}