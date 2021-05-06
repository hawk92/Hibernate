package entities.one2one.singletable;

import entities.many2one.Transaction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "COLL_TYPE", discriminatorType = DiscriminatorType.STRING)
@IdClass(value = CollateralKey.class)
public abstract class Collateral {

    @Id
    @Column(name = "COLL_PART_CD")
    private String collateralParticipant;

    @Id
    @Column(name = "COLL_INST_CD")
    private String collateralInstrument;

    @Column(name = "COLL_CREAT_DT", updatable = false)
    private Date collateralCreatedDate;

    @Column(name = "COLL_UPD_DT", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date collateralModifiedDate;

    @Column(name = "COLL_AMT")
    private double collateralAmount;

    @OneToOne()
    @JoinColumn(name = "COLL_TXN_ID", referencedColumnName = "TXN_ID")
    private Transaction collateralTransaction;

    public Transaction getCollateralTransaction() {
        return collateralTransaction;
    }

    public void setCollateralTransaction(Transaction collateralTransaction) {
        this.collateralTransaction = collateralTransaction;
    }

    public Date getCollateralCreatedDate() {
        return collateralCreatedDate;
    }

    public void setCollateralCreatedDate(Date collateralCreatedDate) {
        this.collateralCreatedDate = collateralCreatedDate;
    }

    public Date getCollateralModifiedDate() {
        return collateralModifiedDate;
    }

    public void setCollateralModifiedDate(Date collateralModifiedDate) {
        this.collateralModifiedDate = collateralModifiedDate;
    }

    public double getCollateralAmount() {
        return collateralAmount;
    }

    public void setCollateralAmount(double collateralAmount) {
        this.collateralAmount = collateralAmount;
    }

    public String getCollateralParticipant() {
        return collateralParticipant;
    }

    public void setCollateralParticipant(String collateralParticipant) {
        this.collateralParticipant = collateralParticipant;
    }

    public String getCollateralInstrument() {
        return collateralInstrument;
    }

    public void setCollateralInstrument(String collateralInstrument) {
        this.collateralInstrument = collateralInstrument;
    }

    @Override
    public String toString() {
        return "Collateral{" +
                "collateralParticipant='" + collateralParticipant + '\'' +
                ", collateralInstrument='" + collateralInstrument + '\'' +
                ", collateralCreatedDate=" + collateralCreatedDate +
                ", collateralModifiedDate=" + collateralModifiedDate +
                ", collateralAmount=" + collateralAmount +
                ", collateralTransaction=" + collateralTransaction +
                '}';
    }
}
