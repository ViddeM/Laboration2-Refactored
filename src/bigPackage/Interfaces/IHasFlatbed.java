package bigPackage.Interfaces;

import bigPackage.Accessories.Flatbed;

/**
 * The interface Has flatbed.
 */
public interface IHasFlatbed {

    /**
     * Raise flatbed.
     */
    void raiseFlatbed();

    /**
     * Lower flatbed.
     */
    void lowerFlatbed();

    /**
     * Is flatbed down boolean.
     *
     * @return True if flatbed is down
     */
    boolean isFlatbedDown();

    /**
     * Gets flatbed.
     *
     * @return the flatbed
     */
    <T extends Flatbed> T getFlatbed();

    /**
     * Gets max incline.
     *
     * @return the max incline
     */
    double getMaxIncline();

    /**
     * Gets flatbed incline.
     *
     * @return the flatbed incline
     */
    double getFlatbedIncline();

}
