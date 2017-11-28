package bigPackage.models.AbstractModels;

import bigPackage.Interfaces.IMovable;

import java.awt.*;

/**
 * The type Motorised vehicle.
 */
public abstract class AMotorisedVehicle implements IMovable {

    /**
     * Current speed of the vehicle
     * Calculated with an arbitrary unit
     */
    private double currentSpeed; // The current speed of the car

    /**
     * The vehicle's current color
     */
    private Color color; // Color of the car

    /**
     * The vehicle's model name
     */
    private String modelName;

    /**
     * The position of the vehicle in the universe
     * <i>position</i> = [X,Y]
     */
    private double[] position = new double[]{0, 0};

    /**
     * The direction the vehicle is facing, in radians
     * The direction is calculated according to the unit circle
     */
    private double direction = Math.PI / 2;


    /**
     * Current engine power of the car
     * Calculated with an arbitrary unit
     */
    private double enginePower; // Engine power of the car

    /**
     * True if the vehicle is currently loaded on a transport
     */
    private boolean onTransport = false;

    protected AMotorisedVehicle( Color color, double enginePower, String modelName ) {
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Gets model name.
     *
     * @return the model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Get current speed.
     *
     * @return current speed in arbitrary units
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Get position double [ ].
     *
     * @return The double [ ] position in the universe
     */
    public double[] getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition( double[] position ) {
        this.position = position;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * Sets direction.
     *
     * @param direction the direction
     */
    public void setDirection( double direction ) {
        this.direction = direction;
    }

    /**
     * Get engine power.
     *
     * @return Motorised Vehicle's engine power in arbitrary form
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Get color.
     *
     * @return color of the vehicle
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set color.
     *
     * @param clr the color to set
     */
    public void setColor( Color clr ) {
        color = clr;
    }

    /**
     * Is on transport boolean.
     *
     * @return the boolean
     */
    public boolean isOnTransport() {
        return onTransport;
    }

    /**
     * Sets on transport.
     *
     * @param onTransport the on transport
     */
    public void setOnTransport( boolean onTransport ) {
        this.onTransport = onTransport;
    }

    /**
     * Stop engine.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Start engine.
     */
    public void startEngine() {
        if (currentSpeed == 0) {
            gas(0.1);
        }
    }

    /**
     * Changes the vehicle's direction by one quarter of a revolution to the left
     */
    @Override
    public void turnLeft() {
        direction += Math.PI / 2;
        direction = direction % ( Math.PI * 2 );
    }

    /**
     * Changes the vehicle's direction by one quarter of a revolution to the right
     */
    @Override
    public void turnRight() {
        direction -= Math.PI / 2;
        direction = ( direction + Math.PI * 2 ) % ( Math.PI * 2 );
    }

    /**
     * Changes the vehicle's current position according to it's speed and direction
     * The amount is calculated via simple trigonometry
     */
    @Override
    public void move() {
        position[0] += Math.cos( direction ) * currentSpeed;
        position[1] += Math.sin( direction ) * currentSpeed;
    }

    /**
     * Calculates the acceleration rate of the car
     * The calculated value depends on turbo's state and engine power
     *
     * @return the calculated acceleration rate
     */
    protected abstract double speedFactor();

    /**
     * Abstract method that increments speed depending on amount and model type
     *
     * @param amount a value between 0 and 1, more increments more
     */
    protected void incrementSpeed( double amount ) {
        currentSpeed = Math.min( getCurrentSpeed() + speedFactor() * amount, enginePower );
    }

    /**
     * Decreases the speed depending on amount and speed factor
     * The new speed can not be lowered below 0
     *
     * @param amount a value between 0 and 1, more decrements more
     */
    protected void decrementSpeed( double amount ) {
        currentSpeed = Math.max( getCurrentSpeed() - speedFactor() * amount, 0 );
    }

    /**
     * Calls the incrementSpeed() method from the subclass, depending on model name
     *
     * @param amount is the value you want to increase your speed with
     */
    public void gas( double amount ) {
        if ( onTransport ) {
            throw new IllegalStateException( "Can not drive while on a transport" );
        } else if ( amount >= 0 && amount <= 1 ) {
            incrementSpeed( amount );
        } else {
            throw new IllegalArgumentException( "Gas only accepts values from 0-1" );
        }
    }

    /**
     * Calls the decrementSpeed() method from the subclass, depending on model name
     *
     * @param amount is the value you want to increase your speed with
     */
    public void brake( double amount ) {
        if ( amount > 0 && amount <= 1 ) {
            decrementSpeed( amount );
        } else {
            throw new IllegalArgumentException( "Break only accepts values from 0-1" );
        }
    }

}
