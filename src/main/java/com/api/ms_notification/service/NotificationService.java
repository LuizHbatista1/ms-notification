package com.api.ms_notification.service;

import com.api.ms_notification.DTOS.NotificationDTO;
import com.api.ms_notification.domain.notification.Notification;

import java.time.LocalDateTime;
import java.util.Optional;

public interface NotificationService {

    Notification createNotification(NotificationDTO notificationDTO);

    Optional<Notification> findNotificationById(Long notificationId);

    void saveNotification(Notification notification);

    void cancelNotification(Long notificationId);

    void checkAndSenderNotification(LocalDateTime dateTime);


}
