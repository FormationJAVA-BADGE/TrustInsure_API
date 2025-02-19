package com.example.TrustInsure.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Contrat> contrats;

    // Constructeurs, Getters & Setters
    public Client() {}

    public Client(String nom, String prenom, String email, String telephone, List<Contrat> contrats) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.contrats = contrats;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public List<Contrat> getContrats() { return contrats; }
    public void setContrats(List<Contrat> contrats) { this.contrats = contrats; }
}
