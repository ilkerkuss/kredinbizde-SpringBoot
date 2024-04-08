package com.patika.kredinbizdeservice.producer.concretes;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.INotificationProducer;
import com.patika.kredinbizdeservice.producer.dto.NotificationDTO;
import com.patika.kredinbizdeservice.producer.enums.NotificationType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MailNotification implements INotificationProducer {
    @Override
    public NotificationDTO produceNotification(User user) {

        return NotificationDTO.builder()
                .notificationType(NotificationType.EMAIL)
                .email(user.getEmail())
                .message("User Sisteme Kaydedildi.")
                .build();
    }
}
