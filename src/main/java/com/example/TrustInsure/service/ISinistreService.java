package com.example.TrustInsure.service;

import com.example.TrustInsure.dto.SinistreDTO;
import com.example.TrustInsure.model.Sinistre;

import java.util.List;

public interface ISinistreService {
    SinistreDTO creerSinistre(SinistreDTO sinistre);
    List<SinistreDTO> getSinistresParContratId(Long clientId);
    SinistreDTO getSinistreById(Long sinistreId);
    SinistreDTO modifierSinistre(Long sinistreId, String updatedSinistre);
}

