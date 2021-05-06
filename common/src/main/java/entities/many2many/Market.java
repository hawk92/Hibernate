package entities.many2many;

import valueTypes.Holiday;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
public class Market {

    @Id
    @Column(name = "MKT_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "code")
    @SequenceGenerator(name = "code", sequenceName = "code_seq")
    private String marketCode;

    @Column(name = "MKT_DESC", nullable = false)
    private String marketDescription;

    //Example of collection of composite type
    @ElementCollection
    @CollectionTable(name = "MARKETWISE_HOLIDAY",
            joinColumns = @JoinColumn(name = "MH_MKT_CD", referencedColumnName = "MKT_CODE"))
    @AttributeOverrides({
            @AttributeOverride(column = @Column(name = "MH_HOL_DT"), name = "holidayDate"),
            @AttributeOverride(column = @Column(name = "MH_HOL_DESC"), name = "holidayDescription")
    })
    private List<Holiday> holidays = new ArrayList<>();

    //Example of unidirectional Many to Many mapping
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MARKETWISE_INSTRUMENTS",
            joinColumns = @JoinColumn(name = "MI_MKT_CD", referencedColumnName = "MKT_CODE"),
            inverseJoinColumns = @JoinColumn(name = "MI_INST_CD", referencedColumnName = "INST_CODE"))
    private List<Instrument> instruments = new ArrayList<>();

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketDescription() {
        return marketDescription;
    }

    public void setMarketDescription(String marketDescription) {
        this.marketDescription = marketDescription;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    @Override
    public String toString() {
        return "Market{" +
                "marketCode='" + marketCode + '\'' +
                ", marketDescription='" + marketDescription + '\'' +
                ", holidays=" + holidays +
                '}';
    }
}
