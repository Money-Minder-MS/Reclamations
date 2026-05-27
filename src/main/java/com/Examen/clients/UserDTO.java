package com.Examen.clients;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String telephone;
    private String email;

    public UserDTO() {}

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getTelephone() { return telephone; }
    public String getEmail() { return email; }

    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setEmail(String email) { this.email = email; }
}