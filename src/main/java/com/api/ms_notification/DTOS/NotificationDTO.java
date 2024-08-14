package com.api.ms_notification.DTOS;

import com.api.ms_notification.domain.channel.Channel;
import com.api.ms_notification.domain.status.Status;

import java.time.LocalDateTime;

public record NotificationDTO(LocalDateTime dateTime,
                              String destination,
                              String message,
                              Channel.Values channel,
                              Status.Values status) {
}
