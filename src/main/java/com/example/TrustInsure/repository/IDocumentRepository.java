package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Contrat;
import com.example.TrustInsure.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDocumentRepository extends JpaRepository<Document, Long>  {
    List<Document> findBySinistreId(Long sinistreId);
}

