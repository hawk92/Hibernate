package entities.one2many;

import entities.many2one.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BATCH_ID")
    private long batchId;

    @Column(name = "BATCH_TYPE", nullable = false)
    private String batchType;

    @ElementCollection()
    @JoinColumn(name="TXN_BATCH_ID",referencedColumnName = "BATCH_ID")
    private List<Transaction> transactionList = new ArrayList<>();

    public long getBatchId() {
        return batchId;
    }

    public String getBatchType() {
        return batchType;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", batchType='" + batchType + '\'' +
                ", transactionList=" + transactionList +
                '}';
    }
}
