package entities.many2one;

import javax.persistence.*;
import java.util.Date;

@NamedQueries(@NamedQuery(name = "maxTransactionAmount", query = "select max(t.transactionAmount) from Transaction t"))
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TXN_ID")
    private long transactionId;

    @Column(name = "TXN_PART_CD", nullable = false)
    private String participantCode;

    @Column(name = "TXN_INST_CD", nullable = false)
    private String instrumentCode;

    @Column(name = "TXN_AMT", nullable = false)
    private double transactionAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TXN_CREATE_DT", updatable = false, nullable = false)
    private Date transactionCreateDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TXN_UPD_DT", insertable = false)
    private Date transactionUpdateDate;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getParticipantCode() {
        return participantCode;
    }

    public void setParticipantCode(String participantCode) {
        this.participantCode = participantCode;
    }

    public String getInstrumentCode() {
        return instrumentCode;
    }

    public void setInstrumentCode(String instrumentCode) {
        this.instrumentCode = instrumentCode;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionCreateDate() {
        return transactionCreateDate;
    }

    public void setTransactionCreateDate(Date transactionCreateDate) {
        this.transactionCreateDate = transactionCreateDate;
    }

    public Date getTransactionUpdateDate() {
        return transactionUpdateDate;
    }

    public void setTransactionUpdateDate(Date transactionUpdateDate) {
        this.transactionUpdateDate = transactionUpdateDate;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", participantCode='" + participantCode + '\'' +
                ", instrumentCode='" + instrumentCode + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionCreateDate=" + transactionCreateDate +
                ", transactionUpdateDate=" + transactionUpdateDate +
                '}';
    }
}
