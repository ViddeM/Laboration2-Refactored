package bigPackage.Interfaces;

/**
 * The interface Movable.
 */
public interface IMovable {
    /**
     * Changes the vehicle's current position according to it's speed and direction
     */
    void move();

    /**
     * Changes the car's direction by one quarter of a revolution to the left
     */
    void turnLeft();

    /**
     * Changes the car's direction by one quarter of a revolution to the right
     */
    void turnRight();
}
