package com.chanzo.animalregistryservice.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class MessagePublisher {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void publish(String payload){
        CompletableFuture<SendResult<String, String>>
                future = kafkaTemplate.send("animal-registered", payload);
    }

}
