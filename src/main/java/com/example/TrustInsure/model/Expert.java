package com.example.TrustInsure.model;


import com.example.TrustInsure.model.Expertise;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String specialite; // Ex: "Auto", "Incendie", "Vol"

    @OneToMany(mappedBy = "expert", cascade = CascadeType.ALL)
    private List<Expertise> expertises;

    public Expert() {}

    public Expert(String nom, String specialite) {
        this.nom = nom;
        this.specialite = specialite;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public List<Expertise> getExpertises() { return expertises; }
    public void setExpertises(List<Expertise> expertises) { this.expertises = expertises; }
}
