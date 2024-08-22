package xyz.sandersonsa.kafka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private xyz.sandersonsa.kafka_consumer.service.MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message, @RequestParam("topic") String topic) {
        messageProducer.sendMessage(topic, message);
        return "## Sent to topic " + topic + " with message " + message;
    }

}