package com.learn.springcloudstreamconsumer.controller;

import com.learn.springcloudstreamconsumer.Model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudStreamConsumerController {
    private Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerController.class);

    @StreamListener("input")
    public void consumeMsg(Book book){
        logger.info("Consumed Message:"+book);
    }
}
