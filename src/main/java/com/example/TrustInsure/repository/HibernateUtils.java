package com.example.TrustInsure.repository;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            final StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .build();
            try {
                MetadataSources metadataSources = new MetadataSources(registry);

                // 📌 Ajout manuel de toutes les entités du projet INSURE
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Sinistre.class);
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Client.class);
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Contrat.class);
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Expert.class);
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Expertise.class);
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Document.class);
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Indemnisation.class);
                metadataSources.addAnnotatedClass(com.example.TrustInsure.model.Recours.class);

                sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(registry);
                throw new RuntimeException("Erreur lors de la création de la SessionFactory", e);
            }
        }
        return sessionFactory;
    }
}
