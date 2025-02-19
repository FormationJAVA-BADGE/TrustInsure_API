package com.example.TrustInsure.dto;

import java.time.LocalDateTime;

public class ExpertiseDTO {
    private Long id;
    private Long sinistreId;
    private Long expertId;
    private LocalDateTime dateLimiteExpertise;
    private String statut;

    public ExpertiseDTO() {}

    public ExpertiseDTO(Long id, Long sinistreId, Long expertId, LocalDateTime dateLimiteExpertise, String statut) {
        this.id = id;
        this.sinistreId = sinistreId;
        this.expertId = expertId;
        this.dateLimiteExpertise = dateLimiteExpertise;
        this.statut = statut;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSinistreId() { return sinistreId; }
    public void setSinistreId(Long sinistreId) { this.sinistreId = sinistreId; }

    public Long getExpertId() { return expertId; }
    public void setExpertId(Long expertId) { this.expertId = expertId; }

    public LocalDateTime getDateLimiteExpertise() { return dateLimiteExpertise; }
    public void setDateLimiteExpertise(LocalDateTime dateLimiteExpertise) { this.dateLimiteExpertise = dateLimiteExpertise; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}

