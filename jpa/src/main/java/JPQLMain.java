import entities.many2one.Transaction;
import factory.JpaSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;

public class JPQLMain {

    public static void main(String args[]) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = JpaSessionFactory.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();


            Query jpqlQuery = entityManager.createQuery("from Transaction t where t.instrumentCode=?1");
            jpqlQuery.setParameter(1, "CASH");
            List<Transaction> transactionList = jpqlQuery.getResultList();
            printTransaction(transactionList);

            System.out.println("----------------------------------");

            jpqlQuery = entityManager.createQuery("from Transaction t where t.transactionAmount >:minAmount");
            jpqlQuery.setParameter("minAmount", 100.0);
            transactionList = jpqlQuery.getResultList();
            printTransaction(transactionList);

            System.out.println("----------------------------------");

            jpqlQuery = entityManager.createNamedQuery("maxTransactionAmount", Double.class);
            System.out.println(String.format("Max transaction amount %.2f", jpqlQuery.getResultList().get(0)));


        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    public static void printTransaction(List<Transaction> transactionList) {
        Consumer<Transaction> transactionConsumer =
                transaction -> System.out.println(String.format("Transaction id: %d Participant code: %s",
                        transaction.getTransactionId(), transaction.getParticipantCode()));
        transactionList.stream()
                .forEach(transactionConsumer);
    }
}
