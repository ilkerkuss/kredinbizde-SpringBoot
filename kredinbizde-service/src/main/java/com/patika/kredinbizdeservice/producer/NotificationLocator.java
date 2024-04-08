package com.patika.kredinbizdeservice.producer;

import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.producer.concretes.MailNotification;
import com.patika.kredinbizdeservice.producer.concretes.MobileNotification;
import com.patika.kredinbizdeservice.producer.concretes.SmsNotification;
import com.patika.kredinbizdeservice.producer.enums.NotificationType;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationLocator {

    private final MailNotification mailNotification;
    private final SmsNotification smsNotification;
    private final MobileNotification mobileNotification;



    public INotificationProducer getProducer(NotificationType notificationType) {

        return switch (notificationType) {
            case EMAIL -> mailNotification;
            case SMS -> smsNotification;
            case MOBILE_NOTIFICATION -> mobileNotification;
            default -> throw new KredinbizdeException(notificationType + "bulunamadı!");
        };

    }
}
