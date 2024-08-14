package com.api.ms_notification.service;

import com.api.ms_notification.DTOS.NotificationDTO;
import com.api.ms_notification.domain.notification.Notification;

public interface NotificationService {

    Notification createNotification(NotificationDTO notificationDTO);

    Notification findNotificationById(Long id);

    void saveNotification(Notification notification);


}
