package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Document;

import java.util.List;

public interface IDocumentRepository {
    Document save(Document document);
    List<Document> saveAll(List<Document> documents);
    Document findById(Long documentId);
    List<Document> findBySinistreId(Long sinistreId);
}

