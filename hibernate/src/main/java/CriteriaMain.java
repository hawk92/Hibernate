import common.HibernateQuerySessionFactory;
import common.HibernateSessionFactory;
import entities.many2one.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaMain {

    public static void main(String args[]) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = HibernateQuerySessionFactory.getSessionFactory();
            session = sessionFactory.openSession();
            Criterion criterion = Restrictions.ge("transactionAmount", 0.0);
            List<Transaction> transactions = session.createCriteria(Transaction.class)
                    .add(criterion).addOrder(Order.desc("transactionAmount"))
                    .list();

            transactions.stream()
                    .forEach(transaction -> System.out.println(transaction.getTransactionId() + " " + transaction.getTransactionAmount()));

        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
