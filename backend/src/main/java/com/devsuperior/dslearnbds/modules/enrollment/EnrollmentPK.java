package com.devsuperior.dslearnbds.modules.enrollment;

import com.devsuperior.dslearnbds.modules.offer.Offer;
import com.devsuperior.dslearnbds.modules.user.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class EnrollmentPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
