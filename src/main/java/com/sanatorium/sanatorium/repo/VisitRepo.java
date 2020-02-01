package com.sanatorium.sanatorium.repo;

import com.sanatorium.sanatorium.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepo extends JpaRepository<Visit,Integer> {
}
