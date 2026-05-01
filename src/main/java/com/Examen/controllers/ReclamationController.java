package com.Examen.controllers;

import com.Examen.entities.Reclamation;
import com.Examen.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
@CrossOrigin("*") // Très important pour que ton Angular puisse appeler l'API
public class ReclamationController {

    @Autowired
    private ReclamationRepository repository;

    // 1. Récupérer toutes les réclamations
    @GetMapping
    public List<Reclamation> getAll() {
        return repository.findAll();
    }

    // 2. Ajouter une nouvelle réclamation
    @PostMapping
    public Reclamation create(@RequestBody Reclamation reclamation) {
        return repository.save(reclamation);
    }

    // 3. Supprimer une réclamation par ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
