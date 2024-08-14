package com.api.ms_notification.service;

import com.api.ms_notification.DTOS.NotificationDTO;
import com.api.ms_notification.domain.notification.Notification;
import com.api.ms_notification.domain.status.Status;
import com.api.ms_notification.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {

        this.notificationRepository = notificationRepository;

    }

    @Override
    public Notification findNotificationById(Long notificationId) {

        return this.notificationRepository.findById(notificationId).orElseThrow(()-> new RuntimeException());

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
}
