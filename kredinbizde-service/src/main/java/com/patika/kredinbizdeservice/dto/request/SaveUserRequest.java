package com.patika.kredinbizdeservice.dto.request;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.enums.NotificationType;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SaveUserRequest {

    private User user;

    private NotificationType notificationType;

}
