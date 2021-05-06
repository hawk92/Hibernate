package entities.many2many;

import enumerations.CashNonCash;
import valueTypes.InstrumentEligibility;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Instrument {

    @Id
    @Column(name = "INST_CODE")
    private String instrumentCode;

    @Basic(optional = false)
    @Column(name = "INST_DESC")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INST_CRT_DATE", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "INST_MOD_DATE", insertable = false)
    private Date modifiedDate;

    //Example of composite type
    @AttributeOverrides({
            @AttributeOverride(column = @Column(name = "INST_IS_BLK"), name = "isBLK"),
            @AttributeOverride(column = @Column(name = "INST_IS_RLS"), name = "isRLS"),
            @AttributeOverride(column = @Column(name = "INST_IS_TRF"), name = "isTRF")
    })
    private InstrumentEligibility instrumentEligibility;

    //Example of enumerated type
    @Enumerated(EnumType.STRING)
    @Column(name = "INST_CASH_NONCASH")
    private CashNonCash instrumentCashNoncash;

    public String getInstrumentCode() {
        return instrumentCode;
    }

    public void setInstrumentCode(String instrumentCode) {
        this.instrumentCode = instrumentCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public InstrumentEligibility getInstrumentEligibility() {
        return instrumentEligibility;
    }

    public void setInstrumentEligibility(InstrumentEligibility instrumentEligibility) {
        this.instrumentEligibility = instrumentEligibility;
    }

    public CashNonCash getInstrumentCashNoncash() {
        return instrumentCashNoncash;
    }

    public void setInstrumentCashNoncash(CashNonCash instrumentCashNoncash) {
        this.instrumentCashNoncash = instrumentCashNoncash;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentCode='" + instrumentCode + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", instrumentEligibility=" + instrumentEligibility +
                ", instrumentCashNoncash=" + instrumentCashNoncash +
                '}';
    }
}
