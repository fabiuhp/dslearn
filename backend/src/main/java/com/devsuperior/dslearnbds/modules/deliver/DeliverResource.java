package com.devsuperior.dslearnbds.modules.deliver;

import com.devsuperior.dslearnbds.modules.notification.NotificationDto;
import com.devsuperior.dslearnbds.modules.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliverResource {

    @Autowired
    private DeliverService deliverService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody DeliverRevisionDto deliverRevisionDto) {
        deliverService.saveRevision(id, deliverRevisionDto);
        return ResponseEntity.noContent().build();
    }
}
