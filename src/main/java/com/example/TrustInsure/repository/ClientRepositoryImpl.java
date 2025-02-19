package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Client;
import com.example.TrustInsure.model.Sinistre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements IClientRepository {

    private  SessionFactory sessionFactory;

    public ClientRepositoryImpl() {
        sessionFactory =HibernateUtils.getSessionFactory();

    }

    @Override
    public Client findById(Long id) {

        return sessionFactory.openSession().find(Client.class, id);
    }

    @Override
    public List<Client> findALl() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Client", Client.class).list();
        }

    }

    @Override
    public Client save(Client client) {
        sessionFactory.inTransaction((session -> session.persist(client)));
        return client;
    }
}
