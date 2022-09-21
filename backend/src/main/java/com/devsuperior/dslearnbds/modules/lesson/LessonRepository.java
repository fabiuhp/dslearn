package com.devsuperior.dslearnbds.modules.lesson;

import com.devsuperior.dslearnbds.modules.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
