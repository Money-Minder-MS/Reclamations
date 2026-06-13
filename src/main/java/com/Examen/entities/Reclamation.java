package com.Examen.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sujet;
    private String message;
    private String statut; // Ex: "EN_ATTENTE" | "EN_TRAITEMENT" | "RESOLUE"
    private LocalDateTime dateCreation;

    @Column(columnDefinition = "TEXT")
    private String reponse;          // Réponse de l'admin
    private LocalDateTime dateReponse;

    // Ajout de l'attribut userId pour lier au microservice User
    private Long userId;

    // Constructeur par défaut
    public Reclamation() {
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSujet() { return sujet; }
    public void setSujet(String sujet) { this.sujet = sujet; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public String getReponse() { return reponse; }
    public void setReponse(String reponse) { this.reponse = reponse; }

    public LocalDateTime getDateReponse() { return dateReponse; }
    public void setDateReponse(LocalDateTime dateReponse) { this.dateReponse = dateReponse; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}