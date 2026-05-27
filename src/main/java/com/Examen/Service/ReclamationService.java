package com.Examen.Service;

import com.Examen.clients.UserClient;
import com.Examen.clients.UserDTO;
import com.Examen.entities.Reclamation;
import com.Examen.repositories.ReclamationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService {

    private final ReclamationRepository reclamationRepository;
    private final UserClient userClient;

    public ReclamationService(ReclamationRepository reclamationRepository, UserClient userClient) {
        this.reclamationRepository = reclamationRepository;
        this.userClient = userClient;
    }

    public Reclamation ajouter(Reclamation reclamation) {
        // Vérifier que le userId existe dans le microservice User
        UserDTO user = userClient.getById(reclamation.getUserId());
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable avec l'id : " + reclamation.getUserId());
        }
        return reclamationRepository.save(reclamation);
    }

    public List<Reclamation> afficherTout() {
        return reclamationRepository.findAll();
    }

    public Reclamation afficherParId(Long id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    // Récupérer toutes les réclamations d'un user
    public List<Reclamation> afficherParUserId(Long userId) {
        return reclamationRepository.findByUserId(userId);
    }

    public Reclamation modifier(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    public void supprimer(Long id) {
        reclamationRepository.deleteById(id);
    }
}