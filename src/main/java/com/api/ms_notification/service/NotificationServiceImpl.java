package com.api.ms_notification.service;

import com.api.ms_notification.DTOS.NotificationDTO;
import com.api.ms_notification.domain.notification.Notification;
import com.api.ms_notification.domain.status.Status;
import com.api.ms_notification.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {

        this.notificationRepository = notificationRepository;

    }


    @Override
    public Optional<Notification> findNotificationById(Long notificationId) {

        return notificationRepository.findById(notificationId);

    }

    @Override
    public Notification createNotification(NotificationDTO notificationDTO) {

        Notification newNotification = new Notification(notificationDTO);
        newNotification.setDateTime(newNotification.getDateTime());
        newNotification.setDestination(newNotification.getDestination());
        newNotification.setMessage(newNotification.getMessage());
        newNotification.setChannel(newNotification.getChannel());
        newNotification.setStatus(Status.Values.PENDING.toStatus());
        this.saveNotification(newNotification);
        return newNotification;

    }

    @Override
    public void saveNotification(Notification notification) {

        this.notificationRepository.save(notification);

    }

    @Override
    public void cancelNotification(Long notificationId) {

        var notification = findNotificationById(notificationId);

        if(notification.isPresent()){

            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());

        }
    }

    @Override
    public void checkAndSenderNotification(LocalDateTime dateTime) {

        var notifications = notificationRepository.findByStatusInAndAndDateTime(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()),dateTime
        );

        notifications.forEach(sendNotification());

    }

    private Consumer<Notification>sendNotification(){

        return n -> {

            // send notification

            n.setStatus(Status.Values.SUCESS.toStatus());
            notificationRepository.save(n);

        };

    }
}
