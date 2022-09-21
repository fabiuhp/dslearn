package com.devsuperior.dslearnbds.modules.deliver;

import com.devsuperior.dslearnbds.modules.notification.*;
import com.devsuperior.dslearnbds.modules.user.User;
import com.devsuperior.dslearnbds.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    public void saveRevision(Long id, DeliverRevisionDto deliverRevisionDto) {
        Deliver deliver = deliveryRepository.getOne(id);
        deliver.setStatus(deliverRevisionDto.getStatus());
        deliver.setFeedback(deliverRevisionDto.getFeedback());
        deliver.setCorrectCount(deliverRevisionDto.getCorrectCount());
        deliveryRepository.save(deliver);
    }
}
