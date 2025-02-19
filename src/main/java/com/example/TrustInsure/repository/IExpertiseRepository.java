package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Expertise;

import java.util.List;

public interface IExpertiseRepository {
    Expertise save(Expertise expertise);
    Expertise findById(Long id);
    List<Expertise> findByExpertId(Long expertId);
    List<Expertise> findBySinistreId(Long sinistreId);
}

