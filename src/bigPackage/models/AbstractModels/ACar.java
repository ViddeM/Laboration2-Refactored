package bigPackage.models.AbstractModels;

import java.awt.*;

/**
 * The type ACar.
 */
public abstract class ACar extends AMotorisedVehicle {

    /**
     * The number of doors of the car
     */
    private int nrDoors; // Number of doors on the car


    protected ACar( Color color, double enginePower, String modelName, int nrDoors ) {
        super( color, enginePower, modelName );
        this.nrDoors = nrDoors;
    }

    /**
     * Get nr doors int.
     *
     * @return the number of doors of the vehicle
     */
    public int getNrDoors() {
        return nrDoors;
    }


}
