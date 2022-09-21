package com.devsuperior.dslearnbds.modules.notification;

import com.devsuperior.dslearnbds.modules.user.User;
import com.devsuperior.dslearnbds.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public Page<NotificationDto> notificationsForCurrentUser(Pageable pageable){
        User user = authService.authenticated();
        Page<Notification> page = notificationRepository.findByUser(user, pageable);
        return page.map(NotificationDto::new);
    }
}
