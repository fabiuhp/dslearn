package com.devsuperior.dslearnbds.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceType resourceType;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
