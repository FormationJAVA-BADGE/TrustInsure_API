package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Sinistre;

import java.util.List;

public interface ISinistreRepository {
    Sinistre save(Sinistre sinistre);
    Sinistre findById(Long id);
    Sinistre update(Sinistre sinistre);
    List<Sinistre> findByContratId(Long contratId);
}
