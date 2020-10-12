package com.learn.Kafkaconsumer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.learn.Kafkaconsumer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerController.class);
    List<String> messages = new ArrayList<>();

    User userFromTopic = null;

/*    @GetMapping("/consumeStringMessage")
    public List<String> consumeMsg() {
        return messages;
    }*/

    @GetMapping("/consumeJsonMessage")
    public User consumeJsonMessage() {
        return userFromTopic;
    }

/*    @KafkaListener(groupId = "mytopic-1", topics = "mytopic", containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMsgFromTopic(String data) {
        messages.add(data);
        return messages;
    }*/

    @KafkaListener(groupId = "javatechie-2", topics = "javatechie", containerFactory = "userKafkaListenerContainerFactory")
    public User getJsonMsgFromTopic(@Payload User user, @Headers MessageHeaders headers) throws IOException {

        userFromTopic = user;
        LOGGER.info(String.format("\n ===== Consumed message in JSON ===== \n"+user));
        return userFromTopic;
    }

}