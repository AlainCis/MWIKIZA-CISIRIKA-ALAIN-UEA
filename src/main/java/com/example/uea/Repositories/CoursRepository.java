package com.example.uea.Repositories;

import com.example.uea.Entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
