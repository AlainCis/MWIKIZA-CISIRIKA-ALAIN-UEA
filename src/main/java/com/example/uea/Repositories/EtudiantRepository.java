package com.example.uea.Repositories;

import com.example.uea.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> id(Long id);
}
