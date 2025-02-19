package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Document;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DocumentRepositoryImpl implements IDocumentRepository {

    private  SessionFactory sessionFactory;

    public DocumentRepositoryImpl() {
        sessionFactory =HibernateUtils.getSessionFactory();

    }

    @Override
    public Document save(Document document) {
        sessionFactory.inTransaction(session -> {
            session.persist(document);
            session.flush();
            session.refresh(document);
        });
        return document;
    }

    @Override
    public List<Document> saveAll(List<Document> documents) {
        sessionFactory.inTransaction(session -> {
            for (Document doc : documents) {
                session.persist(doc);
            }
        });
        return documents;
    }

    @Override
    public Document findById(Long documentId) {
        return sessionFactory.fromTransaction(session -> session.get(Document.class, documentId));
    }

    @Override
    public List<Document> findBySinistreId(Long sinistreId) {
        return sessionFactory.fromTransaction(session ->
                session.createQuery("FROM Document WHERE sinistre.id = :sinistreId", Document.class)
                        .setParameter("sinistreId", sinistreId)
                        .list()
        );
    }
}

