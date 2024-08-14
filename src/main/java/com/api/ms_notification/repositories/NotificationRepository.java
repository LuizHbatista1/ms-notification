package com.api.ms_notification.repositories;

import com.api.ms_notification.domain.notification.Notification;
import com.api.ms_notification.domain.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification , Long> {

    List<Notification> findByStatusInAndAndDateTime(List<Status> status, LocalDateTime dateTime);

}
