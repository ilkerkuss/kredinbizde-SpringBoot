package com.patika.kredinbizdeservice.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LogProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;


    public void sendLog(String topic,String message){
        kafkaTemplate.send(topic,message);

    }
}
