package com.example.TrustInsure.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Indemnisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montantEstime;
    private double franchise;
    private double montantFinal;
    private LocalDate datePaiement;
    private boolean paye;

    @OneToOne
    private Sinistre sinistre;

    public Indemnisation(double montantEstime, double franchise, double montantFinal, LocalDate datePaiement, boolean paye, Sinistre sinistre) {
        this.montantEstime = montantEstime;
        this.franchise = franchise;
        this.montantFinal = montantFinal;
        this.datePaiement = datePaiement;
        this.paye = paye;
        this.sinistre = sinistre;
    }

    public Indemnisation() {
    }

    // Getters & Setters


    public Sinistre getSinistre() {
        return sinistre;
    }

    public void setSinistre(Sinistre sinistre) {
        this.sinistre = sinistre;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontantFinal() {
        return montantFinal;
    }

    public void setMontantFinal(double montantFinal) {
        this.montantFinal = montantFinal;
    }

    public double getFranchise() {
        return franchise;
    }

    public void setFranchise(double franchise) {
        this.franchise = franchise;
    }

    public double getMontantEstime() {
        return montantEstime;
    }

    public void setMontantEstime(double montantEstime) {
        this.montantEstime = montantEstime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
