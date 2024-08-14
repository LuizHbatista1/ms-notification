package com.api.ms_notification.domain.notification;

import com.api.ms_notification.DTOS.NotificationDTO;
import com.api.ms_notification.domain.channel.Channel;
import com.api.ms_notification.domain.status.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "notifications")
@Table(name = "tb_notification")

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long notificationId;
    private String destination;
    private LocalDateTime dateTime;
    private String message;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Notification(){

    }

    public Notification(NotificationDTO data) {

        this.dateTime = data.dateTime();
        this.destination = data.destination();
        this.message = data.message();
        this.channel = data.channel().toChannel();




    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
