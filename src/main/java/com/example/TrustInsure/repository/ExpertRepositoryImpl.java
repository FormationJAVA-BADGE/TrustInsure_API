package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Expert;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpertRepositoryImpl implements IExpertRepository {

    private  SessionFactory sessionFactory;

    public ExpertRepositoryImpl() {
        sessionFactory =HibernateUtils.getSessionFactory();

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

