package bigPackage.models;

import bigPackage.Accessories.Flatbed;
import bigPackage.models.AbstractModels.ACar;
import bigPackage.Accessories.CargoHold;
import bigPackage.Interfaces.ICarTransport;
import bigPackage.models.AbstractModels.ATruck;

import java.awt.*;

/**
 * The type Euro truck 1337.
 */
public class EuroTruck1337 extends ATruck implements ICarTransport {

    /**
     * A fixed factor which affects your acceleration
     */
    private final double trimFactor = 1.25;
    private final double range = 5;
    private final int capacity = 10;
    /**
     * The truck's Flatbed
     */
    private Flatbed flatbed;
    /**
     * The truck's CargoHold
     */
    private CargoHold cargoHold;

    /**
     * Instantiates a new Euro truck 1337.
     */
    public EuroTruck1337() {
        super( Color.red, 1337, "Euro Truck 1337", 2 );
        flatbed = new Flatbed();
        cargoHold = new CargoHold( true, range, capacity );
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

    public void load( ACar c ) {
        cargoHold.load( c, this, isFlatbedDown() );
    }

    public ACar unload() {
        return cargoHold.unload( isFlatbedDown() );
    }

    /**
     * Syncs state for all cars in cargoHold when truck moves
     */
    @Override
    public void move() {
        super.move();
        for ( ACar c : cargoHold.getCargos() ) {
            cargoHold.syncState( c, this );
        }
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}
