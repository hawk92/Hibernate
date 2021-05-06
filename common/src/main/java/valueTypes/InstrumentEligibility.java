package valueTypes;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InstrumentEligibility {

    @Column(name = "IS_BLK", nullable = false)
    boolean isBlockingEligible;

    @Column(name = "IS_RLS", nullable = false)
    boolean isReleaseEligible;

    @Column(name = "IS_TRF", nullable = false)
    boolean isTransferEligible;

    public boolean isBlockingEligible() {
        return isBlockingEligible;
    }

    public void setBlockingEligible(boolean blockingEligible) {
        isBlockingEligible = blockingEligible;
    }

    public boolean isReleaseEligible() {
        return isReleaseEligible;
    }

    public void setReleaseEligible(boolean releaseEligible) {
        isReleaseEligible = releaseEligible;
    }

    public boolean isTransferEligible() {
        return isTransferEligible;
    }

    public void setTransferEligible(boolean transferEligible) {
        isTransferEligible = transferEligible;
    }
}
