package bigPackage.models;

import bigPackage.models.AbstractModels.ACar;
import bigPackage.Interfaces.ITurbo;

import java.awt.*;

/**
 * The type Saab 95.
 */
public class Saab95 extends ACar implements ITurbo {

    private boolean turboOn;

    /**
     * Constructor with hardcoded values
     */
    public Saab95() {
        super( Color.red, 120, "Saab95", 2 );
        turboOn = false;
        stopEngine();
    }

    /**
     * Is turbo on boolean.
     *
     * @return the boolean
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Turns on turbo
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turns off turbo
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Calculates the acceleration rate of the car
     * The calculated value depends on turbo's state and engine power
     *
     * @return the calculated acceleration rate
     */
    protected double speedFactor() {
        double turbo = 1;
        if ( turboOn ) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}