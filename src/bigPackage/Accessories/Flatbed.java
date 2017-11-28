package bigPackage.Accessories;

/**
 * The type Flatbed.
 */
public class Flatbed {

    /**
     * The Flatbeds state.
     */
    private boolean flatbedDown = true;

    /**
     * The Flatbed incline.
     */
    private double flatbedIncline = 0.0;

    /**
     * The Max flatbedIncline.
     */
    private double maxIncline = 90.0;

    /**
     * Instantiates a new Flatbed.
     */
    public Flatbed() {
    }

    protected Flatbed( Double maxIncline ) {
        this.maxIncline = maxIncline;
    }

    /**
     * Get flatbed incline.
     *
     * @return the double flatbedIncline
     */
    public double getFlatbedIncline() {
        return flatbedIncline;
    }

    protected void setFlatbedDown( boolean flatbedDown ) {
        this.flatbedDown = flatbedDown;
    }

    protected void setFlatbedIncline( double flatbedIncline ) {
        this.flatbedIncline = flatbedIncline;
    }

    /**
     * Gets max incline.
     *
     * @return the max incline
     */
    public double getMaxIncline() {
        return maxIncline;
    }

    /**
     * Is flatbed down boolean.
     *
     * @return the boolean flatbedDown
     */
    public boolean isFlatbedDown() {
        return flatbedDown;
    }

    /**
     * Raises the flatbed
     *
     * @param currentSpeed the transporter's current speed
     */
    public void raiseFlatbed( double currentSpeed ) {
        if ( currentSpeed == 0.0 ) {
            flatbedDown = false;
            flatbedIncline = maxIncline;
        } else {
            throw new IllegalStateException( "Can not raise flatbed while moving" );
        }
    }

    /**
     * Lowers the flatbed
     *
     * @param currentSpeed the transporter's current speed
     */
    public void lowerFlatbed( double currentSpeed ) {
        if ( currentSpeed == 0.0 ) {
            flatbedDown = true;
            flatbedIncline = 0.0;
        } else {
            throw new IllegalStateException( "Can not lower flatbed while moving" );
        }
    }
}
