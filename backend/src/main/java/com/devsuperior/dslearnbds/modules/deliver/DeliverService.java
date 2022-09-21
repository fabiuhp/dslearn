package com.devsuperior.dslearnbds.modules.deliver;

import org.springframework.beans.factory.annotation.Autowired;
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
