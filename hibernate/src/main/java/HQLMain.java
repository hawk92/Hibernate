import common.HibernateQuerySessionFactory;
import common.HibernateSessionFactory;
import entities.one2many.Batch;
import entities.one2one.singletable.Collateral;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class HQLMain {

    public static void main(String args[]) {

        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = HibernateQuerySessionFactory.getSessionFactory();
            session = sessionFactory.openSession();

            //Many To Many
            Query hqlQuery = session.createQuery("select m.marketCode,m.marketDescription from Market m");
            List<Object[]> markets = hqlQuery.getResultList();
            markets.stream()
                    .forEach(market -> {
                                System.out.println(market[0] + " " + market[1]);
                            }
                    );

            //One To Many
            hqlQuery = session.createQuery("from Batch b");
            List<Batch> batches = hqlQuery.getResultList();
            batches.stream().
                    forEach(batch -> {
                        System.out.println("Batch name :" + batch.getBatchType());
                        batch.getTransactionList().stream()
                                .forEach(transaction -> System.out.println(transaction.getTransactionId()));
                    });

            //One to One
            hqlQuery = session.createQuery("select c.collateralParticipant,c.collateralInstrument,c.collateralAmount from " +
                    "Collateral c join Transaction t " +
                    "on c.collateralTransaction.transactionId=t.transactionId");

            List<Object[]> collaterals = hqlQuery.getResultList();
            collaterals.stream()
                    .forEach(collateral -> {
                                System.out.println(collateral[0] + " " + collateral[1] + " " + collateral[2]);
                            }
                    );

            hqlQuery = session.createQuery("from Collateral");

            List<Collateral> collateralList = hqlQuery.getResultList();
            collateralList.stream()
                    .forEach(collateral ->
                            System.out.println(collateral.getCollateralParticipant() + " " + collateral.getCollateralInstrument()
                                    + " " + collateral.getCollateralAmount() + " " + collateral.getCollateralTransaction().getTransactionId())
                    );


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