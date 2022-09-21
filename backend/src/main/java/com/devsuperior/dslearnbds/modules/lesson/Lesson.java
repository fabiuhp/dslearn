package com.devsuperior.dslearnbds.modules.lesson;

import com.devsuperior.dslearnbds.modules.enrollment.Enrollment;
import com.devsuperior.dslearnbds.modules.section.Section;
import com.devsuperior.dslearnbds.modules.deliver.Deliver;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "lesson")
    private List<Deliver> deliveries;

    @ManyToMany
    @JoinTable(name = "lessons_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id"),
                    @JoinColumn(name = "offer_id")
            })
    private Set<Enrollment> enrollmentsDone = new HashSet<>();

    public Lesson(Long id, String title, Integer position, Section section) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
    }
}
