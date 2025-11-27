package com.example.uea.Controllers;

import com.example.uea.Entities.Cours;
import com.example.uea.Repositories.CoursRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cours")
public class CoursController {
    final CoursRepository coursRepository;

    public CoursController(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cours>> findAllCours() {
        return new ResponseEntity<>(coursRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cours> createPerson(@RequestBody Cours cours){
        Cours MyCours = coursRepository.save(cours);
        return new ResponseEntity<>(MyCours, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cours> getPersonById(@PathVariable Long id){
        Optional<Cours> cours = coursRepository.findById(id);
        if(cours.isPresent()){
            return new ResponseEntity<>(cours.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cours> updatePerson(@PathVariable Long id, @RequestBody Cours coursDetails){

        Optional<Cours> coursFound = coursRepository.findById(id);
        if(coursFound.isPresent()){
            Cours coursToUpdate = coursFound.get();
            coursToUpdate.setCode(coursDetails.getCode());
            coursToUpdate.setNom(coursDetails.getNom());
            coursToUpdate.setCredits(coursDetails.getCredits());
            coursToUpdate.setEnseignant(coursDetails.getEnseignant());
            Cours updatedCours = coursRepository.save(coursToUpdate);
            return new ResponseEntity<>(updatedCours, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cours> deletePerson(@PathVariable Long id){
        Optional<Cours> coursFound = coursRepository.findById(id);
        if(coursFound.isPresent()){
            coursRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
