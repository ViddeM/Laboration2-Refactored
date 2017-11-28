package bigPackage.models.AbstractModels;

import bigPackage.Interfaces.IHasFlatbed;

import java.awt.*;

/**
 * The type ATruck.
 */
public abstract class ATruck extends ACar implements IHasFlatbed {

    protected ATruck( Color color, double enginePower, String modelName, int nrDoors ) {
        super( color, enginePower, modelName, nrDoors );
    }

    public double getFlatbedIncline() {
        return getFlatbed().getFlatbedIncline();
    }

    public double getMaxIncline() {
        return getFlatbed().getMaxIncline();
    }

    public boolean isFlatbedDown() {
        return getFlatbed().isFlatbedDown();
    }

    public void raiseFlatbed() {
        getFlatbed().raiseFlatbed( getCurrentSpeed() );
    }

    public void lowerFlatbed() {
        getFlatbed().lowerFlatbed( getCurrentSpeed() );
    }

    /**
     * Increases the speed depending on amount and speed factor
     * The new speed can not be increased above the engine power
     *
     * @param amount a value between 0 and 1, more increments more
     */
    @Override
    protected void incrementSpeed( double amount ) {
        if ( isFlatbedDown() ) {
            super.incrementSpeed( amount );
        } else {
            throw new IllegalStateException( "Can't move when flatbed is not lowered" );
        }
    }

}
