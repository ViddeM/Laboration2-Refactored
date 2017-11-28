package bigPackage.models;

import bigPackage.Accessories.GradualFlatbed;
import bigPackage.Interfaces.IHasFlatbed;
import bigPackage.models.AbstractModels.ATruck;

import java.awt.*;

/**
 * The type Scania.
 */
public class Scania extends ATruck implements IHasFlatbed {

    /**
     * A fixed factor which affects your acceleration
     */
    private final double trimFactor = 1.25;

    private GradualFlatbed flatbed;

    /**
     * Instantiates a new Scania.
     */
    public Scania() {
        super( Color.red, 730, "Scania R 730", 4 );
        flatbed = new GradualFlatbed( 70.0 );
        stopEngine();
    }

    public GradualFlatbed getFlatbed() {
        return flatbed;
    }

    /**
     * Raises the flatbed by a specified amount, up to a max of <i>maxIncline</i> degrees
     *
     * @param value of degrees you want the flatbed to be raised
     */
    public void raiseFlatbed( double value ) {
        flatbed.raiseFlatbed( getCurrentSpeed(), value );
    }

    /**
     * Lowers the flatbed by a specified amount, down to a minimum of 0 degrees
     *
     * @param value of degrees you want the flatbed to be lowered
     */
    public void lowerFlatbed( double value ) {
        flatbed.lowerFlatbed( getCurrentSpeed(), value );
    }

    /**
     * Calculates the acceleration rate of the car
     * The calculated value depends on trim factor and engine power
     *
     * @return the calculated acceleration rate
     */
    protected double speedFactor() {
        return ( getEnginePower() * 0.01 * trimFactor );
    }
}
