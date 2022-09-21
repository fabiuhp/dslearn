package com.devsuperior.dslearnbds.modules.notification;

import lombok.*;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    private Long id;
    private String text;
    private Instant moment;
    private boolean read;
    private String route;
    private Long userId;

    public NotificationDto(Notification notification) {
        id = notification.getId();
        text = notification.getText();
        moment = notification.getMoment();
        read = notification.isRead();
        route = notification.getRoute();
        userId = notification.getUserId();
    }
}
