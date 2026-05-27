package com.Examen.controllers; // Doit être la TOUTE PREMIÈRE ligne

import com.Examen.controllers.ReclamationController;
import com.Examen.Service.ReclamationService;
import com.Examen.entities.Reclamation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

    private final ReclamationService reclamationService;

    public ReclamationController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @PostMapping("/add")
    public Reclamation ajouter(@RequestBody Reclamation reclamation) {
        return reclamationService.ajouter(reclamation);
    }

    @GetMapping("/getall")
    public List<Reclamation> afficherTout() {
        return reclamationService.afficherTout();
    }

    @GetMapping("/getbyid/{id}")
    public Reclamation afficherParId(@PathVariable Long id) {
        return reclamationService.afficherParId(id);
    }

    // Récupérer toutes les réclamations d'un user
    @GetMapping("/byuser/{userId}")
    public List<Reclamation> afficherParUserId(@PathVariable Long userId) {
        return reclamationService.afficherParUserId(userId);
    }

    @PutMapping("/update")
    public Reclamation modifier(@RequestBody Reclamation reclamation) {
        return reclamationService.modifier(reclamation);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        reclamationService.supprimer(id);
    }
}