package xyz.sandersonsa.kafka_consumer.service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        try {
            String json = message.replaceAll("=", ":");
            JSONObject jsonObject = new JSONObject(json);
            logger.info("\n\n## RECEIVED JSON MESSAGE: {}\n## ON TOPIC: {}", jsonObject.toString(), "${kafka.consumer.topic}");
        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
        }        
        // logger.info("\n## RECEIVED MESSAGE: {}\n## ON TOPIC: {}", message, "${kafka.consumer.topic}");
    }

}