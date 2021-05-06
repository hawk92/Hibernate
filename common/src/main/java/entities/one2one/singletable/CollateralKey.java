package entities.one2one.singletable;

import java.io.Serializable;

public class CollateralKey implements Serializable {

    private String collateralParticipant;

    private String collateralInstrument;

    public CollateralKey() {
    }

    public CollateralKey(String collateralParticipant, String collateralInstrument) {
        this.collateralParticipant = collateralParticipant;
        this.collateralInstrument = collateralInstrument;
    }
}
