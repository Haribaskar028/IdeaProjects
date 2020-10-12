package com.learn.springcloudstreampublisher.Controller;

import com.learn.springcloudstreampublisher.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudStreamPublisherController {
    @Autowired
    private MessageChannel output;

    @PostMapping("/publish")
    public Book publish(@RequestBody Book book){
         output.send(MessageBuilder.withPayload(book).build());
        return book;
    }
}
