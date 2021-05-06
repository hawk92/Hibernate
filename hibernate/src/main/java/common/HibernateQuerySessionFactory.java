package common;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateQuerySessionFactory {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateQuerySessionFactory() {
    }

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg-query.xml").build();
        Metadata metaData =
                new MetadataSources(standardRegistry).getMetadataBuilder().build();
        return metaData.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
