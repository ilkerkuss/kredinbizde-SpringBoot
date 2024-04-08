package com.patika.kredinbizdeservice.producer;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.dto.NotificationDTO;

public interface INotificationProducer {
    NotificationDTO produceNotification(User user);
}
