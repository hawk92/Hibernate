package factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaSessionFactory {

    private static EntityManagerFactory entityManagerFactory = buildEntityManager();

    private JpaSessionFactory() {
    }

    private static EntityManagerFactory buildEntityManager() {
        return Persistence.createEntityManagerFactory("jpa-unit");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
