package com.example.uea.Controllers;

import com.example.uea.Entities.Etudiant;
import com.example.uea.Repositories.EtudiantRepository;
import jdk.jfr.Relational;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    final EtudiantRepository etudiantRepository;

    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants(){
        return new ResponseEntity<>(etudiantRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Etudiant> createPerson(@RequestBody Etudiant etudiant){
        Etudiant MyEtudiant = etudiantRepository.save(etudiant);
        return new ResponseEntity<>(MyEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Etudiant> getPersonById(@PathVariable Long id){
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if(etudiant.isPresent()){
            return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
        }else{
            Throwable throwable = new Throwable();
            throwable.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updatePerson(@PathVariable Long id, @RequestBody Etudiant etudiantDetails){

        Optional<Etudiant> etudiantFound = etudiantRepository.findById(id);
        if(etudiantFound.isPresent()){
            Etudiant etudiantToUpdate = etudiantFound.get();
            etudiantToUpdate.setNom(etudiantDetails.getNom());
            etudiantToUpdate.setPostnom(etudiantDetails.getPostnom());
            etudiantToUpdate.setMatricule(etudiantDetails.getPostnom());
            etudiantToUpdate.setFaculte(etudiantDetails.getFaculte());
            etudiantToUpdate.setEmail(etudiantDetails.getEmail());
            Etudiant updatedEtudiant = etudiantRepository.save(etudiantToUpdate);
            return new ResponseEntity<>(updatedEtudiant, HttpStatus.CREATED);
        }else{
            Throwable throwable = new Throwable();
            throwable.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Etudiant> deletePerson(@PathVariable Long id){
        Optional<Etudiant> personFound = etudiantRepository.findById(id);
        if(personFound.isPresent()){
            etudiantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            Throwable throwable = new Throwable();
            throwable.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
