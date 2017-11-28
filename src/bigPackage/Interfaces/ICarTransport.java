package bigPackage.Interfaces;

import bigPackage.Accessories.CargoHold;
import bigPackage.models.AbstractModels.ACar;

/**
 * The interface ACar transport.
 */
public interface ICarTransport {

    /**
     * Loads car onto transporter's cargo.
     *
     * @param c the c
     */
    void load(ACar c);

    /**
     * Unload car from transporter's cargo.
     *
     * @return the car unloaded
     */
    ACar unload();

    /**
     * Gets range.
     *
     * @return the range
     */
    double getRange();

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    int getCapacity();

    /**
     * Gets cargo.
     *
     * @return the Cargo
     */
    CargoHold getCargoHold();


}
