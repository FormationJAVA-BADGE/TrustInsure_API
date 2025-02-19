package com.example.TrustInsure.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Expertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateLimiteExpertise;
    private String statut; // "En attente", "En cours", "Validé", "Rejeté"

    @ManyToOne
    @JoinColumn(name = "expert_id", nullable = false)
    private Expert expert;

    @OneToOne
    @JoinColumn(name = "sinistre_id", nullable = false)
    private Sinistre sinistre;

    public Expertise() {}

    public Expertise(LocalDateTime dateLimiteExpertise, String statut, Expert expert, Sinistre sinistre) {
        this.dateLimiteExpertise = dateLimiteExpertise;
        this.statut = statut;
        this.expert = expert;
        this.sinistre = sinistre;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateLimiteExpertise() { return dateLimiteExpertise; }
    public void setDateLimiteExpertise(LocalDateTime dateLimiteExpertise) { this.dateLimiteExpertise = dateLimiteExpertise; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Expert getExpert() { return expert; }
    public void setExpert(Expert expert) { this.expert = expert; }

    public Sinistre getSinistre() { return sinistre; }
    public void setSinistre(Sinistre sinistre) { this.sinistre = sinistre; }
}


