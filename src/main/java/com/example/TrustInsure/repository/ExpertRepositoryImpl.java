package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Expert;
import org.hibernate.SessionFactory;
import java.util.List;

public class ExpertRepositoryImpl implements IExpertRepository {

    private final SessionFactory sessionFactory;

    public ExpertRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Expert findById(Long id) {
        return sessionFactory.fromTransaction(session -> session.get(Expert.class, id));
    }

    @Override
    public List<Expert> findAll() {
        return sessionFactory.fromTransaction(session ->
                session.createQuery("FROM Expert", Expert.class).list()
        );
    }
}

