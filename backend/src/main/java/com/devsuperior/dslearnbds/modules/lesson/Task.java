package com.devsuperior.dslearnbds.modules.lesson;

import com.devsuperior.dslearnbds.modules.section.Section;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task extends Lesson {

    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double weight;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dueDate;

    public Task(Long id, String title, Integer position, Section section, String description, Integer questionCount, Integer approvalCount, Double weight, Instant dueDate) {
        super(id, title, position, section);
        this.description = description;
        this.questionCount = questionCount;
        this.approvalCount = approvalCount;
        this.weight = weight;
        this.dueDate = dueDate;
    }
}
