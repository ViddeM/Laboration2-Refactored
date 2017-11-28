package bigPackage.Accessories;


import bigPackage.models.AbstractModels.ACar;
import bigPackage.models.AbstractModels.AMotorisedVehicle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The type Cargo hold.
 */
public class CargoHold {

    /**
     * The reaching capability for the CargoHold in arbitrary units
     */
    private double range;
    /**
     * The max capacity the CargoHold can carry
     */
    private int capacity;
    /**
     * The order of unloading (first-in-last-out)
     */
    private boolean filo;
    /**
     * The list for the cargos
     */
    private Deque<ACar> cargos;


    /**
     * Instantiates a new Cargo hold.
     *
     * @param filo     the order of unloading (first-in-last-out)
     * @param range    the range
     * @param capacity the capacity
     */
    public CargoHold( boolean filo, double range, int capacity ) {
        this.range = range;
        this.capacity = capacity;
        this.filo = filo;
        cargos = new ArrayDeque<>( capacity );
    }

    /**
     * Gets cargos.
     *
     * @return the cargos
     */
    public Deque<ACar> getCargos() {
        return cargos;
    }

    /**
     * Uses Pythagoras Theorem to check if the <i>vehicle</i> is within range
     *
     * @param c  the vehicle to check
     * @param tp the transporter
     * @return True if the vehicle is in range of the current object
     */
    private boolean isWithinRange( ACar c, AMotorisedVehicle tp ) {
        return Math.sqrt( Math.pow( c.getPosition()[0] - tp.getPosition()[0], 2 ) +
                ( Math.pow( c.getPosition()[1] - tp.getPosition()[1], 2 ) ) ) <= range;
    }

    /**
     * Load boolean.
     *
     * @param c   the car to load
     * @param tp  the transporter
     * @param iFD if the flatbed is down
     */
    public void load( ACar c, AMotorisedVehicle tp, boolean iFD ) {
        if ( isWithinRange( c, tp )
                && !c.isOnTransport()
                && capacity >= cargos.size()
                && iFD
                && c != tp ) {
            addToCargo( c, tp );
        }
    }

    /**
     * Help method
     *
     * @param c  ACar to load
     * @param tp Transporter to load onto
     */
    private void addToCargo( ACar c, AMotorisedVehicle tp ) {
        syncState( c, tp );
        c.stopEngine();
        c.setOnTransport( true );
        cargos.add( c );
    }

    /**
     * Unload car.
     *
     * @param iFD if the flatbed is down
     * @return the unloaded car
     */
    public ACar unload( boolean iFD ) {
        if ( !iFD ) {
            return null;
        }
        ACar c;
        if ( filo ) {
            c = cargos.pollLast();
        } else {
            c = cargos.pollFirst();
        }
        c.setOnTransport( false );
        return c;
    }

    /**
     * Sync state.
     *
     * @param c  the car
     * @param tp the transporter
     */
    public void syncState( ACar c, AMotorisedVehicle tp ) {
        c.setPosition( tp.getPosition().clone() );
        c.setDirection( tp.getDirection() );
    }
}
