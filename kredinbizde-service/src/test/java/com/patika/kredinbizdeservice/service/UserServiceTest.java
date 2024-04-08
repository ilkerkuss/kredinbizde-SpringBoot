package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.INotificationProducer;
import com.patika.kredinbizdeservice.producer.LogProducer;
import com.patika.kredinbizdeservice.producer.NotificationLocator;
import com.patika.kredinbizdeservice.producer.NotificationProducer;
import com.patika.kredinbizdeservice.producer.concretes.MailNotification;
import com.patika.kredinbizdeservice.producer.concretes.MobileNotification;
import com.patika.kredinbizdeservice.producer.concretes.SmsNotification;
import com.patika.kredinbizdeservice.producer.dto.NotificationDTO;
import com.patika.kredinbizdeservice.producer.enums.NotificationType;
import com.patika.kredinbizdeservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private NotificationProducer notificationProducer;

    @Mock
    private NotificationLocator notificationLocator;
    @Mock
    private LogProducer logProducer;


    @Test
    public void should_create_user_with_email_successfully() {
        // Given
        User user = prepareUser();
        NotificationType notificationType = NotificationType.EMAIL;
        INotificationProducer notificationProducerMock = mock(INotificationProducer.class);


        // When
        when(notificationLocator.getProducer(notificationType)).thenReturn(notificationProducerMock);
        userService.save(user, notificationType);

        // Then
        verify(userRepository, times(1)).save(user);

    }

    @Test
    public void should_get_all_users_successfully() {
        List<User> userList = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(userList);

        List<User> allUsers = userService.getAll();

        assertNotNull(allUsers);
        assertEquals(userList.size(), allUsers.size());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void should_get_user_with_email_successfully() {
        User user = prepareUser();
        String email = prepareUser().getEmail();

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        User foundUser = userService.getByEmail(email);

        assertNotNull(foundUser);
        assertEquals(user, foundUser);

        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    public void should_update_user_with_email_successfully() {
        User user = prepareUser();
        String email = prepareUser().getEmail();

        User updatedUser = new User();

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User returnedUser = userService.update(email, updatedUser);

        assertNotNull(returnedUser);
        assertEquals(user, returnedUser);

        verify(userRepository, times(1)).findByEmail(email);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void should_get_user_with_id_successfully(){
        User user = prepareUser();
        Long userId = prepareUser().getUserId();

        when(userRepository.findByUserId(userId)).thenReturn(Optional.of(user));

        User foundUser = userService.getById(userId);

        assertNotNull(foundUser);
        assertEquals(user, foundUser);

        verify(userRepository, times(1)).findByUserId(userId);
    }

    private User prepareUser() {

        User user = new User();

        user.setName("test name");
        user.setSurname("test surname");
        user.setEmail("test@mail.com");
        user.setPassword("testpassword");

        return user;
    }
}
