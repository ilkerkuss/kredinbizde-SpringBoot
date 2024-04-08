package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.exceptions.ExceptionMessages;
import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.INotificationProducer;
import com.patika.kredinbizdeservice.producer.LogProducer;
import com.patika.kredinbizdeservice.producer.NotificationLocator;
import com.patika.kredinbizdeservice.producer.NotificationProducer;
import com.patika.kredinbizdeservice.producer.dto.NotificationDTO;
import com.patika.kredinbizdeservice.producer.enums.NotificationType;
import com.patika.kredinbizdeservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = "singleton")
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final NotificationProducer notificationProducer;
    private final NotificationLocator notificationLocator;

    private final LogProducer logProducer;

    @Transactional(value = Transactional.TxType.REQUIRES_NEW, rollbackOn = KredinbizdeException.class)
    public User save(User user,NotificationType notificationType) {
        System.out.println("userRepository: " + userRepository.hashCode());

        user.setCreatedDate(LocalDate.now());
        user.setUpdatedDate(LocalDate.now());

        userRepository.save(user);

        INotificationProducer iNotificationProducer = notificationLocator.getProducer(notificationType);
        NotificationDTO notificationDTO = iNotificationProducer.produceNotification(user);

        notificationProducer.sendNotification(notificationDTO);
        String sendMessage = user.getEmail() + " ile kayıt yapıldı.";
        logProducer.sendLog("patika-log",sendMessage);

        return user;

    }

    public List<User> getAll() {
        System.out.println("userRepository: " + userRepository.hashCode());
        return userRepository.findAll();
    }


    public User getByEmail(String email) {

        log.info("user db'den alındı.");

        Optional<User> foundUser = userRepository.findByEmail(email);

        if (foundUser.isEmpty()) {
            throw new KredinbizdeException(ExceptionMessages.USER_NOT_FOUND);
        }

        User user = foundUser.get();
        log.info(email + "'emailli User Bulundu...");

        return user;

    }

    @CachePut(value = "users", key = "#email")
    public User update(String email, User user) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        foundUser.get().setName(user.getName());

        foundUser.get().setSurname(user.getSurname());

        userRepository.delete(user);

        userRepository.save(foundUser.get());

        return foundUser.get();
    }

    public User getById(Long userId) {

        log.info("user db'den alındı.");

        Optional<User> foundUser = userRepository.findByUserId(userId);

        if (foundUser.isEmpty()) {
            throw new KredinbizdeException(ExceptionMessages.USER_NOT_FOUND);
        }

        User user = foundUser.get();
        log.info(userId + "'IDli User Bulundu...");

        return user;
    }
}
