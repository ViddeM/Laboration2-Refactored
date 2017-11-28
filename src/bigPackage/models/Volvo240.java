package bigPackage.models;

import bigPackage.models.AbstractModels.ACar;

import java.awt.*;

/**
 * The type Volvo 240.
 */
public class Volvo240 extends ACar {

    /**
     * A fixed factor which affects your acceleration
     */
    private final static double trimFactor = 1.25;


    /**
     * Constructor with hardcoded values
     */
    public Volvo240() {
        super( Color.black, 100, "Volvo 240", 4 );
        stopEngine();
    }

    /**
     * Calculates the acceleration rate of the car
     * The calculated value depends on trim factor and engine power
     *
     * @return the calculated acceleration rate
     */
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}