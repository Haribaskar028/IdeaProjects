package com.learn.Kafkapublisher.Controller;

import com.learn.Kafkapublisher.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaPublishController {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaPublishController.class);
    @Autowired
    private KafkaTemplate<String,Object> template;
    String topic = "javatechie";

/*    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name){
        template.send(topic,"Hi"+name+"Welcome!");
        return  "Data published";
    }*/

    @GetMapping("/publishJson")
    public String publishJsonMessage(){
        User user = new User(1,"hari","north street");
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        template.send(message);
        //template.send(topic,user);
        LOGGER.info(String.format("\n ===== Producing message in JSON ===== \n"+user));
        return  "Data published";
    }
}
