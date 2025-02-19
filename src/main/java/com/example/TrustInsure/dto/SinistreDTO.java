package com.example.TrustInsure.dto;


import java.time.LocalDateTime;
import java.util.List;



public class SinistreDTO {
    private Long id;
    private String typeSinistre;
    private LocalDateTime dateSinistre;
    private String description;
    private String statut; // "En attente", "En cours d'expertise", "Indemnisé"
    private Long contratId;
    private List<String> documentsUrls; // Liste des URLs des documents

    public SinistreDTO() {}

    public SinistreDTO(Long id, String typeSinistre, LocalDateTime dateSinistre, String description, String statut, Long contratId, List<String> documentsUrls) {
        this.id = id;
        this.typeSinistre = typeSinistre;
        this.dateSinistre = dateSinistre;
        this.description = description;
        this.statut = statut;
        this.contratId = contratId;
        this.documentsUrls = documentsUrls;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTypeSinistre() { return typeSinistre; }
    public void setTypeSinistre(String typeSinistre) { this.typeSinistre = typeSinistre; }

    public LocalDateTime getDateSinistre() { return dateSinistre; }
    public void setDateSinistre(LocalDateTime dateSinistre) { this.dateSinistre = dateSinistre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Long getContratId() { return contratId; }
    public void setContratId(Long contratId) { this.contratId = contratId; }

    public List<String> getDocumentsUrls() { return documentsUrls; }
    public void setDocumentsUrls(List<String> documentsUrls) { this.documentsUrls = documentsUrls; }
}
