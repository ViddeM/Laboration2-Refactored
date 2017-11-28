package bigPackage.models;

import bigPackage.Accessories.CargoHold;
import bigPackage.Accessories.Flatbed;
import bigPackage.Interfaces.ICarTransport;
import bigPackage.Interfaces.IHasFlatbed;
import bigPackage.models.AbstractModels.ACar;
import bigPackage.models.AbstractModels.AMotorisedVehicle;

import java.awt.*;

/**
 * The type Ferry master 420.
 */
public class FerryMaster420 extends AMotorisedVehicle implements ICarTransport, IHasFlatbed {

    private final double trimFactor = 25;
    private final double range = 20;
    private final int capacity = 100;
    private Flatbed flatbed;
    private CargoHold cargoHold;

    /**
     * Instantiates a new Ferry master 420.
     */
    public FerryMaster420() {
        super( Color.green, 420, "Ferry NoobLord 420" );
        flatbed = new Flatbed();
        cargoHold = new CargoHold( false, range, capacity );
        stopEngine();
    }

    public Flatbed getFlatbed() {
        return flatbed;
    }

    public double getRange() {
        return range;
    }

    public int getCapacity() {
        return capacity;
    }

    public CargoHold getCargoHold() {
        return cargoHold;
    }

    public double getFlatbedIncline() {
        return flatbed.getFlatbedIncline();
    }

    public double getMaxIncline() {
        return flatbed.getMaxIncline();
    }

    public boolean isFlatbedDown() {
        return flatbed.isFlatbedDown();
    }

    public void raiseFlatbed() {
        flatbed.raiseFlatbed( getCurrentSpeed() );
    }

    public void lowerFlatbed() {
        flatbed.lowerFlatbed( getCurrentSpeed() );
    }

    public void load( ACar c ) { cargoHold.load( c, this, isFlatbedDown() );
    }

    public ACar unload() {
        return cargoHold.unload( isFlatbedDown() );
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected void incrementSpeed( double amount ) {
        if ( isFlatbedDown() ) {
            super.incrementSpeed( amount );
        } else {
            throw new IllegalArgumentException( "Can't move when flatbed is not lowered" );
        }
    }

    @Override
    public void move() {
        super.move();
        for ( ACar c : cargoHold.getCargos() ) {
            cargoHold.syncState( c, this );
        }
    }

}
