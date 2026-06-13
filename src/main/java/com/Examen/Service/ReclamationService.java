package com.Examen.Service;

import com.Examen.NotificationPublisher;
import com.Examen.RabbitMQConfig;
import com.Examen.clients.UserClient;
import com.Examen.clients.UserDTO;
import com.Examen.entities.Reclamation;
import com.Examen.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReclamationService {
    @Autowired
    private NotificationPublisher notificationPublisher;
    private final ReclamationRepository reclamationRepository;
    private final UserClient userClient;

    public ReclamationService(ReclamationRepository reclamationRepository, UserClient userClient) {
        this.reclamationRepository = reclamationRepository;
        this.userClient = userClient;
    }

    public Reclamation ajouter(Reclamation reclamation) {
        UserDTO user = userClient.getById(reclamation.getUserId());
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable avec l'id : " + reclamation.getUserId());
        }

        Reclamation saved = reclamationRepository.save(reclamation);

        Map<String, Object> data = new HashMap<>();
        data.put("sujet",  saved.getSujet());
        data.put("statut", saved.getStatut());

        notificationPublisher.publier(
                RabbitMQConfig.KEY_RECLAMATION,
                saved.getUserId(),
                "Réclamation créée : " + saved.getSujet(),
                data
        );

        return saved;
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

    public Reclamation changerStatut(Long id, String statut) {
        Reclamation r = reclamationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réclamation introuvable : " + id));
        r.setStatut(statut);
        Reclamation saved = reclamationRepository.save(r);

        Map<String, Object> data = new HashMap<>();
        data.put("sujet",  saved.getSujet());
        data.put("statut", saved.getStatut());
        notificationPublisher.publier(
                RabbitMQConfig.KEY_RECLAMATION,
                saved.getUserId(),
                "Statut de votre réclamation mis à jour : " + statut,
                data
        );
        return saved;
    }

    public Reclamation repondre(Long id, String reponse) {
        Reclamation r = reclamationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réclamation introuvable : " + id));
        r.setReponse(reponse);
        r.setDateReponse(java.time.LocalDateTime.now());
        if (r.getStatut() == null || "EN_ATTENTE".equals(r.getStatut())) {
            r.setStatut("EN_TRAITEMENT");
        }
        Reclamation saved = reclamationRepository.save(r);

        Map<String, Object> data = new HashMap<>();
        data.put("sujet",   saved.getSujet());
        data.put("statut",  saved.getStatut());
        data.put("reponse", saved.getReponse());
        notificationPublisher.publier(
                RabbitMQConfig.KEY_RECLAMATION,
                saved.getUserId(),
                "Réponse à votre réclamation : " + saved.getSujet(),
                data
        );
        return saved;
    }

    public void supprimer(Long id) {
        reclamationRepository.deleteById(id);
    }
}