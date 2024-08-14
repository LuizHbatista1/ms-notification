package com.api.ms_notification.infra.scheduler;


import com.api.ms_notification.service.NotificationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class NotificationTaskScheduler implements NotificationTaskSchedulerService{

    private final NotificationServiceImpl notificationService;

    @Autowired
    public NotificationTaskScheduler(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    private static final Logger logger = LoggerFactory.getLogger(NotificationTaskScheduler.class);


    @Scheduled(fixedDelay = 1 , timeUnit = TimeUnit.MINUTES)
    @Override
    public void runTask() {

        var dateTime = LocalDateTime.now();
        logger.info("Running at {}" , dateTime);
        notificationService.checkAndSenderNotification(dateTime);

    }
}
