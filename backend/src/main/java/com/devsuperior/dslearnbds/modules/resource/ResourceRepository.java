package com.devsuperior.dslearnbds.modules.resource;

import com.devsuperior.dslearnbds.modules.resource.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
