package bigPackage.Accessories;

/**
 * The type Gradual flatbed.
 */
public class GradualFlatbed extends Flatbed {

    /**
     * Instantiates a new Gradual flatbed.
     *
     * @param maxIncline the max incline
     */
    public GradualFlatbed( double maxIncline ) {
        super( maxIncline );
    }

    /**
     * Raises the flatbed by a specified amount, up to a max of <i>maxIncline</i> degrees
     *
     * @param currentSpeed the current speed of the transporter
     * @param value        of degrees you want the flatbed to be raised
     */
    public void raiseFlatbed( double currentSpeed, double value ) {
        if ( currentSpeed == 0 ) {
            setFlatbedIncline( Math.min( getFlatbedIncline() + value, getMaxIncline() ) );
            setFlatbedDown( getFlatbedIncline() == 0.0 );
        } else {
            throw new IllegalStateException( "Can not lower flatbed while moving" );
        }
    }

    /**
     * Lowers the flatbed by a specified amount, down to a minimum of 0 degrees
     *
     * @param currentSpeed the current speed of the transporter
     * @param value        of degrees you want the flatbed to be lowered
     */
    public void lowerFlatbed( double currentSpeed, double value ) {
        if ( currentSpeed == 0 ) {
            setFlatbedIncline( Math.max( getFlatbedIncline() - value, 0.0 ) );
            setFlatbedDown( getFlatbedIncline() == 0.0 );
        } else {
            throw new IllegalStateException( "Can not lower flatbed while moving" );
        }
    }
}
