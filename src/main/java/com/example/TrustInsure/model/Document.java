package com.example.TrustInsure.model;

import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // "Photo", "Rapport"
    private String url;

    @ManyToOne
    private Sinistre sinistre;

    public Document( String type, String url, Sinistre sinistre) {

        this.type = type;
        this.url = url;
        this.sinistre = sinistre;
    }

    public Document() {
    }

    // Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Sinistre getSinistre() {
        return sinistre;
    }

    public void setSinistre(Sinistre sinistre) {
        this.sinistre = sinistre;
    }
}
