package com.devsuperior.dslearnbds.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String edition;
    private Instant startMoment;
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
