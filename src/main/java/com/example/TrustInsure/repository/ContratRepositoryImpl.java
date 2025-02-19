package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Contrat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class ContratRepositoryImpl implements IContratRepository {

    private final SessionFactory sessionFactory;

    public ContratRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Contrat findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Contrat.class, id);
        }
    }

    @Override
    public List<Contrat> findByClientId(Long clientId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Contrat WHERE client.id = :clientId", Contrat.class)
                    .setParameter("clientId", clientId)
                    .list();
        }
    }

    @Override
    public Contrat save(Contrat contrat) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(contrat);
            transaction.commit();
            return contrat;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erreur lors de la sauvegarde du contrat", e);
        }
    }

    @Override
    public void update(Contrat contrat) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(contrat);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erreur lors de la mise à jour du contrat", e);
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Contrat contrat = session.find(Contrat.class, id);
            if (contrat != null) {
                session.remove(contrat);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Erreur lors de la suppression du contrat", e);
        }
    }
}
