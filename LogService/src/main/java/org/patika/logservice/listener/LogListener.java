package org.patika.logservice.listener;

import lombok.RequiredArgsConstructor;
import org.patika.logservice.entity.Log;
import org.patika.logservice.repository.LogService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogListener {

    private final LogService logService;

    @KafkaListener(topics = "patika-log", groupId = "my-group-id")
    public void listenLog(String message) {

        System.out.println("Kafka Kuyruğundan Okunan: " + message);

        Log kafkaLog = Log.builder().logMessage(message).build(); //Builds Log according to message income from Kafka

        logService.insertLog(kafkaLog); // Inserts Log to DB

    }
}
