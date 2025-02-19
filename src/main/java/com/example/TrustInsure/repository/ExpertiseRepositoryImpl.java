package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Expertise;
import org.hibernate.SessionFactory;
import java.util.List;

public class ExpertiseRepositoryImpl implements IExpertiseRepository {

    private final SessionFactory sessionFactory;

    public ExpertiseRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Expertise save(Expertise expertise) {
        sessionFactory.inTransaction(session -> {
            session.persist(expertise);
            session.flush();
            session.refresh(expertise);
        });
        return expertise;
    }

    @Override
    public Expertise findById(Long id) {
        return sessionFactory.fromTransaction(session -> session.get(Expertise.class, id));
    }

    @Override
    public List<Expertise> findByExpertId(Long expertId) {
        return sessionFactory.fromTransaction(session ->
                session.createQuery("FROM Expertise WHERE expert.id = :expertId", Expertise.class)
                        .setParameter("expertId", expertId)
                        .list()
        );
    }

    @Override
    public List<Expertise> findBySinistreId(Long sinistreId) {
        return sessionFactory.fromTransaction(session ->
                session.createQuery("FROM Expertise WHERE sinistre.id = :sinistreId", Expertise.class)
                        .setParameter("sinistreId", sinistreId)
                        .list()
        );
    }
}
