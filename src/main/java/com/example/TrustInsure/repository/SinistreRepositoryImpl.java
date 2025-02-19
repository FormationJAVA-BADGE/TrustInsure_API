package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Sinistre;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class SinistreRepositoryImpl implements ISinistreRepository {

    private final SessionFactory sessionFactory;

    public SinistreRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Sinistre save(Sinistre sinistre) {
        sessionFactory.inTransaction(session -> {
            session.persist(sinistre);
        });
        return sinistre;
    }

    @Override
    public Sinistre findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Sinistre.class, id);
        }
    }

    @Override
    public List<Sinistre> findByClientId(Long clientId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Sinistre WHERE client.id = :clientId", Sinistre.class)
                    .setParameter("clientId", clientId)
                    .list();
        }
    }

    @Override
    public Sinistre update(Sinistre sinistre) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(sinistre);
            transaction.commit();
            return sinistre;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erreur lors de la mise à jour du sinistre", e);
        }
    }

    @Override
    public List<Sinistre> findByContratId(Long contratId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Sinistre s WHERE s.contrat.id = :contratId", Sinistre.class)
                    .setParameter("contratId", contratId)
                    .list();
        }
    }
}

