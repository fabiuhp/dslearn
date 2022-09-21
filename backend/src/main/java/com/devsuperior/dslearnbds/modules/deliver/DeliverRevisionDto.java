package com.devsuperior.dslearnbds.modules.deliver;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliverRevisionDto {

    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    public DeliverRevisionDto(Deliver deliver) {
        status = deliver.getStatus();
        feedback = deliver.getFeedback();
        correctCount = deliver.getCorrectCount();
    }
}
