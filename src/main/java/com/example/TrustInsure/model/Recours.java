package com.example.TrustInsure.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raison;
    private LocalDateTime dateRecours;
    private String statut; // "En cours", "Accepté", "Rejeté"

    @ManyToOne
    private Sinistre sinistre;

    public Recours(String raison, LocalDateTime dateRecours, String statut, Sinistre sinistre) {
        this.raison = raison;
        this.dateRecours = dateRecours;
        this.statut = statut;
        this.sinistre = sinistre;
    }

    public Recours() {
    }

    // Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public LocalDateTime getDateRecours() {
        return dateRecours;
    }

    public void setDateRecours(LocalDateTime dateRecours) {
        this.dateRecours = dateRecours;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Sinistre getSinistre() {
        return sinistre;
    }

    public void setSinistre(Sinistre sinistre) {
        this.sinistre = sinistre;
    }
}
