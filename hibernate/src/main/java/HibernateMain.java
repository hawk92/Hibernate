import common.HibernateSessionFactory;
import entities.many2many.Instrument;
import entities.many2many.Market;
import entities.many2one.Transaction;
import entities.one2many.Batch;
import entities.one2one.singletable.CashCollateral;
import entities.one2one.singletable.SecurityCollateral;
import enumerations.CashNonCash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import valueTypes.Holiday;
import valueTypes.InstrumentEligibility;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class HibernateMain {

    private static int staticOne = 1;
    private int instanceOne = 1;

    public void instanceMethod() {
        int instanceOne = 2;
        int staticOne = 2;
        System.out.println("Static" + this.staticOne);
        System.out.println("Local static " + staticOne);
        System.out.println("Local instance " + instanceOne);
        System.out.println("Instance " + this.instanceOne);
    }

    public static void checkFinal(HibernateMain hibernateMain) {
        hibernateMain = new HibernateMain();
        hibernateMain.instanceOne = 100;
    }

    static String isValid(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            countMap.merge(s.charAt(i), 1, (a, b) -> ++a);
        }

        Integer[] indexCount = countMap.values().toArray(new Integer[countMap.size()]);
        System.out.println(countMap);
        boolean isRemoved = false;
        int prev = indexCount[0];
        for (int i = 1; i < indexCount.length; i++) {
            if (Math.abs(prev - indexCount[i]) > 0 && !isRemoved) {
                if (prev - 1 == 0) {
                    isRemoved = true;
                    prev--;
                } else if (indexCount[i] - 1 == 0) {
                    isRemoved = true;
                    indexCount[i]--;
                } else if (prev - 1 == indexCount[i]) {
                    isRemoved = true;
                    prev--;
                } else if (indexCount[i] - 1 == prev) {
                    isRemoved = true;
                    indexCount[i]--;
                } else {
                    return "NO";
                }
            } else if (prev - indexCount[i] == 0) {
                continue;
            } else {
                return "NO";
            }
            prev = indexCount[i];
        }
        return "YES";
    }


    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        Map<Character, Integer> h = new HashMap<>();
        Map<Character, Integer> h1 = new HashMap<>();
        char[] a_array = a.toCharArray();
        char[] b_array = b.toCharArray();

        for (char i : a_array) {
            h.merge(i, 1, (p, q) -> ++p);
        }

        for (char i : b_array) {
            h1.merge(i, 1, (p, q) -> ++p);
        }
        System.out.println(h);
        System.out.println(h1);

        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);


        List<Integer> ab = new ArrayList<>(1);

        int remove = 0;
        for (int i = 0; i < sb1.length(); i++) {
            String check = String.valueOf(sb1.charAt(i));
            if (sb2.indexOf(check) == -1) {
                ++remove;
            } else {
                int sb1Prev = sb1.indexOf(check) + 1;
                int sb2Prev = sb2.indexOf(check) + 1;

                while (sb1.indexOf(check, sb1Prev) != -1) {
                    if (sb2.indexOf(check, sb2Prev) == -1) {
                        sb1Prev = sb1.indexOf(check, sb1Prev);
                        sb1 = sb1.deleteCharAt(sb1Prev);
                        sb1Prev++;
                        ++remove;
                    } else {
                        sb1Prev = sb1.indexOf(check, sb1Prev) + 1;
                        sb2Prev = sb2.indexOf(check, sb2Prev) + 1;
                    }
                }
            }
        }

        for (int i = 0; i < sb2.length(); i++) {
            String check = String.valueOf(sb2.charAt(i));
            if (sb1.indexOf(check) == -1) {
                ++remove;
            } else {
                int sb1Prev = sb1.indexOf(check) + 1;
                int sb2Prev = sb2.indexOf(check) + 1;

                while (sb2.indexOf(check, sb2Prev) != -1) {
                    if (sb1.indexOf(check, sb1Prev) == -1) {
                        sb2Prev = sb2.indexOf(check, sb2Prev);
                        sb2 = sb2.deleteCharAt(sb2.indexOf(check, sb2Prev));
                        sb2Prev++;
                        ++remove;
                    } else {
                        sb1Prev = sb1.indexOf(check, sb1Prev) + 1;
                        sb2Prev = sb2.indexOf(check, sb2Prev) + 1;
                    }
                }
            }
        }


        return remove;

    }

    public static long subStrings(String s) {

        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (subStr.length() == 1) {
                    count++;
                    continue;
                } else {
                    char[] values = subStr.toCharArray();
                    char prev = values[0];
                    int mid = values.length / 2;
                    boolean isMid = values.length % 2 != 0, special = true;
                    for (int k = 1; k < values.length; k++) {
                        if (isMid && k == mid && values[k] != prev) {
                            continue;
                        } else if (prev != values[k]) {
                            special = false;
                            break;
                        }
                    }
                    if (special) {
                        count++;
                    }
                }

            }
        }
        return count;
    }


    public static void main(String args[]) {

/*
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Special " + subStrings(s));
        //System.out.println(isValid(s));
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
        int instanceOne = 2;
        int staticOne = 2;
        HibernateMain hibernateMain = new HibernateMain();
        System.out.println("Static " + hibernateMain.staticOne);
        System.out.println("Local static " + staticOne);
        System.out.println("Local instance " + instanceOne);
        System.out.println("Instance " + hibernateMain.instanceOne);

        final HibernateMain finalObj = new HibernateMain();
        checkFinal(finalObj);

        System.out.println("Calling instance method");
        hibernateMain.instanceMethod();

        double a = 10.0;
        float b = 2 / 3f;
        Integer i = Integer.valueOf("10");
        System.out.println(a + " " + b);

        int plan = 1;
        System.out.println(plan++ + --plan);
        if (plan == 1) {
            System.out.print("Plan A");
        } else if (plan == 2) {
            System.out.print("Plan B");
        } else System.out.print("Plan C");

        int[] array[] = new int[][]{{1, 2}, {3}, {5, 6, 7}};
        Object[] array2 = array;

*/

            LinkedList<String> l=null;


        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = HibernateSessionFactory.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();


            Criteria cr=session.createCriteria(Holiday.class);
            //cr.add(Restrictions.and(Restrictions.eq()).)
            cr.setProjection(Projections.count(""));

            Holiday bankHoliday = new Holiday();
            bankHoliday.setHolidayDate(new Date());
            bankHoliday.setHolidayDescription("Bank holiday");

            Holiday weeklyHoliday = new Holiday();
            weeklyHoliday.setHolidayDate(new Date());
            weeklyHoliday.setHolidayDescription("Weekly holiday");

            Market cashMarket = new Market();
            cashMarket.setMarketCode("CM");
            cashMarket.setMarketDescription("Equity market");
            cashMarket.getHolidays().add(bankHoliday);
            cashMarket.getHolidays().add(weeklyHoliday);

            Market fnoMarket = new Market();
            fnoMarket.setMarketCode("FO");
            fnoMarket.setMarketDescription("Futures & Options market");
            fnoMarket.getHolidays().add(bankHoliday);
            fnoMarket.getHolidays().add(weeklyHoliday);

            InstrumentEligibility cashEligibility = new InstrumentEligibility();
            cashEligibility.setBlockingEligible(true);
            cashEligibility.setReleaseEligible(true);
            cashEligibility.setTransferEligible(true);

            Instrument cashInstrument = new Instrument();
            cashInstrument.setInstrumentCode("CASH");
            cashInstrument.setDescription("Cash");
            cashInstrument.setCreatedDate(new Date());
            cashInstrument.setInstrumentEligibility(cashEligibility);
            cashInstrument.setInstrumentCashNoncash(CashNonCash.CASH);

            Instrument securityInstrument = new Instrument();
            securityInstrument.setInstrumentCode("STOCK");
            securityInstrument.setDescription("Equities");
            securityInstrument.setCreatedDate(new Date());
            securityInstrument.setInstrumentEligibility(cashEligibility);
            securityInstrument.setInstrumentCashNoncash(CashNonCash.CASH);

            Transaction cashTransaction = new Transaction();
            cashTransaction.setInstrumentCode(cashInstrument.getInstrumentCode());
            cashTransaction.setParticipantCode("PARTY-1");
            cashTransaction.setTransactionAmount(100);
            cashTransaction.setTransactionCreateDate(new Date());

            Transaction cashTransaction1 = new Transaction();
            cashTransaction1.setInstrumentCode(cashInstrument.getInstrumentCode());
            cashTransaction1.setParticipantCode("PARTY-2");
            cashTransaction1.setTransactionAmount(200);
            cashTransaction1.setTransactionCreateDate(new Date());

            Batch depositBatch = new Batch();
            depositBatch.setBatchType("Deposit");
            depositBatch.getTransactionList().add(cashTransaction);
            depositBatch.getTransactionList().add(cashTransaction1);

            cashMarket.getInstruments().add(cashInstrument);
            cashMarket.getInstruments().add(cashInstrument);
            fnoMarket.getInstruments().add(securityInstrument);

            CashCollateral cashCollateral = new CashCollateral();
            cashCollateral.setCollateralParticipant("PARTY-1");
            cashCollateral.setCollateralInstrument(cashInstrument.getInstrumentCode());
            cashCollateral.setCollateralCreatedDate(new Date());
            cashCollateral.setCollateralAmount(100);
            cashCollateral.setCollateralTransaction(cashTransaction);
            cashCollateral.setCurrency("INR");

            SecurityCollateral securityCollateral = new SecurityCollateral();
            securityCollateral.setCollateralParticipant("PARTY-2");
            securityCollateral.setCollateralInstrument(cashInstrument.getInstrumentCode());
            securityCollateral.setCollateralCreatedDate(new Date());
            securityCollateral.setCollateralAmount(200);
            securityCollateral.setCollateralTransaction(cashTransaction1);
            securityCollateral.setIsin("INF110101");

            session.save(cashMarket);
            session.save(fnoMarket);
            session.save(depositBatch);
            session.save(cashTransaction);
            session.save(cashTransaction1);
            session.save(cashCollateral);
            session.save(securityCollateral);
            session.getTransaction().commit();


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
