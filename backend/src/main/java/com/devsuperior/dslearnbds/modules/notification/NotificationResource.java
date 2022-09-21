package com.devsuperior.dslearnbds.modules.notification;

import com.devsuperior.dslearnbds.modules.user.UserDto;
import com.devsuperior.dslearnbds.modules.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationResource {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<Page<NotificationDto>> notificationsForCurrentUser(Pageable pageable) {
        Page<NotificationDto> notificationDtos = notificationService.notificationsForCurrentUser(pageable);
        return ResponseEntity.ok(notificationDtos);
    }
}
