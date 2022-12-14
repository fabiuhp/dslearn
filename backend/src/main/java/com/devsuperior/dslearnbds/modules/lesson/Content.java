package com.devsuperior.dslearnbds.modules.lesson;

import com.devsuperior.dslearnbds.modules.section.Section;
import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Content extends Lesson {

    private String textContent;
    private String videoUri;

    public Content(Long id, String title, Integer position, Section section, String textContent, String videoUri) {
        super(id, title, position, section);
        this.textContent = textContent;
        this.videoUri = videoUri;
    }
}
