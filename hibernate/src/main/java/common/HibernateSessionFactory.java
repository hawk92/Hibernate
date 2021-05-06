package common;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateSessionFactory {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateSessionFactory() {
    }

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metaData =
                new MetadataSources(standardRegistry).getMetadataBuilder().build();
        return metaData.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
