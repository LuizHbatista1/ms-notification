package com.api.ms_notification.controller;

import com.api.ms_notification.DTOS.NotificationDTO;
import com.api.ms_notification.domain.notification.Notification;
import com.api.ms_notification.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NotificationController {

    private final NotificationServiceImpl notificationService;

    @Autowired
    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping("/apiV1/notification")
    public ResponseEntity<Notification>createNotification(@RequestBody NotificationDTO notificationDTO){

        Notification newNotification =  notificationService.createNotification(notificationDTO);
        return new ResponseEntity<>(newNotification , HttpStatus.CREATED);

    }

    @GetMapping("/apiV1/notification/{notificationId}")
    public ResponseEntity<Notification>findAllNotificationsById(@PathVariable Long notificationId ){

        Notification newNotifications = notificationService.findNotificationById(notificationId);
        return new ResponseEntity<>(newNotifications , HttpStatus.OK);

    }

}
