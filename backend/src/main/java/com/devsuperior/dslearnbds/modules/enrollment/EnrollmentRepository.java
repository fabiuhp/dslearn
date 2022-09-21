package com.devsuperior.dslearnbds.modules.enrollment;

import com.devsuperior.dslearnbds.modules.enrollment.Enrollment;
import com.devsuperior.dslearnbds.modules.enrollment.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
