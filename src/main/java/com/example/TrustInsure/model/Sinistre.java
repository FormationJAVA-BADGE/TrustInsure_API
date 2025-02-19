package com.example.TrustInsure.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sinistre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeSinistre; // Accident, Vol, Incendie...
    private LocalDateTime dateSinistre;
    private String description;
    private String statut; // "En attente", "En cours d'expertise", "Indemnisé"

    @ManyToOne
    @JoinColumn(name = "contrat_id", nullable = false) // ✅ Lien avec un contrat obligatoire
    private Contrat contrat;

    @OneToMany(mappedBy = "sinistre", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToOne(mappedBy = "sinistre", cascade = CascadeType.ALL)
    private Indemnisation indemnisation;

    @OneToOne(mappedBy = "sinistre", cascade = CascadeType.ALL)
    private Expertise expertise;

    public Sinistre() {}

    public Sinistre(String typeSinistre, LocalDateTime dateSinistre, String description, String statut, Contrat contrat) {
        this.typeSinistre = typeSinistre;
        this.dateSinistre = dateSinistre;
        this.description = description;
        this.statut = statut;
        this.contrat = contrat;
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

    public Contrat getContrat() { return contrat; }
    public void setContrat(Contrat contrat) { this.contrat = contrat; }

    public List<Document> getDocuments() { return documents; }
    public void setDocuments(List<Document> documents) { this.documents = documents; }

    public Indemnisation getIndemnisation() { return indemnisation; }
    public void setIndemnisation(Indemnisation indemnisation) { this.indemnisation = indemnisation; }

    public Expertise getExpertise() { return expertise; }
    public void setExpertise(Expertise expertise) { this.expertise = expertise; }
}
