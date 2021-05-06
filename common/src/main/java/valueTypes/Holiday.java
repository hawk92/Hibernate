package valueTypes;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class Holiday {

    @Column(name = "HOL_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date holidayDate;

    @Column(name = "HOL_DESC", nullable = false)
    private String holidayDescription;

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayDescription() {
        return holidayDescription;
    }

    public void setHolidayDescription(String holidayDescription) {
        this.holidayDescription = holidayDescription;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "holidayDate=" + holidayDate +
                ", holidayDescription='" + holidayDescription + '\'' +
                '}';
    }
}
