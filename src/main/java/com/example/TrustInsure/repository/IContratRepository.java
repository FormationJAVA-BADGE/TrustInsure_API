package com.example.TrustInsure.repository;


import com.example.TrustInsure.model.Contrat;
import java.util.List;

public interface IContratRepository {
    Contrat findById(Long id);
    List<Contrat> findByClientId(Long clientId);
    Contrat save(Contrat contrat);
    void update(Contrat contrat);
    void delete(Long id);
}

