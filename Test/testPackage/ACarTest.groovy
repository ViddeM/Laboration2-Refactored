package testPackage

import bigPackage.models.AbstractModels.ACar
import bigPackage.models.Saab95
import bigPackage.models.Scania
import bigPackage.models.Volvo240

import java.awt.*
import org.testng.annotations.Test

import static java.lang.System.out

class ACarTest extends GroovyTestCase {

    @Test
    void testScania(){
        ACar s = new Scania()
        out.println(s != null)
    }

    @Test
    void testRaiseFlatbed() {
        Scania s = new Scania()
        s.raiseFlatbed(45)
        out.println(s.getFlatbedIncline() == 45)

        s.raiseFlatbed(45)
        out.println(s.getFlatbedIncline() == 70)

    }

    @Test
    void testSaab95() {
        ACar s = new Saab95()
        System.out.println(s != null)
    }

    @Test
    void testGetNrDoors() {
        ACar c = new Saab95()
        System.out.println(c.getNrDoors() == 2)
    }

    @Test
    void testGetEnginePower() {
        ACar c = new Saab95()
        System.out.println(c.getEnginePower() == 125)
    }

    @Test
    void testGetModelName() {
        ACar c = new Saab95()
        System.out.println(c.getModelName() == "Saab95")
    }

    @Test
    void testGetCurrentSpeed() {
        ACar c = new Volvo240()
        System.out.println(c.getCurrentSpeed() == (double)0)
    }

    @Test
    void testGetColor() {
        ACar c = new Saab95()
        System.out.println(c.getColor() != (Color.black))
        System.out.println(c.getColor() == (Color.red))
    }

    @Test
    void testSetColor() {
        ACar c = new Saab95()
        c.setColor(Color.blue)
        System.out.println(c.getColor() == Color.blue)
    }

    @Test
    void testStartEngine() {
        ACar c = new Volvo240()
        c.startEngine()
        System.out.println(c.getCurrentSpeed() == (double)0.1)
    }

    @Test
    void testStopEngine() {
        ACar c = new Saab95()
        c.startEngine()
        c.stopEngine()
        System.out.println(c.getCurrentSpeed() == (double)0)
    }

    @Test
    void testTurnLeft() {
        ACar c = new Volvo240()
        c.turnLeft()
        System.out.println(c.getDirection() == Math.PI)
        c.turnLeft()
        System.out.println(c.getDirection() == 3*Math.PI/2)
        c.turnLeft()
        c.turnLeft()
        c.turnLeft()
        System.out.println(c.getDirection() == Math.PI)
    }

    @Test
    void testTurnRight() {
        ACar c = new Volvo240()
        c.turnRight()
        System.out.println(c.getDirection() == 0)
        c.turnRight()
        System.out.println(c.getDirection() == 3*Math.PI/2)
        c.turnRight()
        c.turnRight()
        c.turnRight()
        System.out.println(c.getDirection() == 0)
    }

    @Test
    void testMove() {
        ACar c = new Saab95()
        double a = c.getPosition()[0]
        double b = c.getPosition()[1]
        c.gas(0.3)
        c.move()
        double x = c.getPosition()[0]
        double y = c.getPosition()[1]

        System.out.println( a != x || b != y)
    }

    void testSetTurboOn() {
        ACar c1 = new Saab95()
        ACar c2 = new Saab95()
        c1.gas(0.5)
        c2.setTurboOn()
        System.out.println(c2.isTurboOn())
        c2.gas(0.5)
        System.out.println(c1.currentSpeed != c2.currentSpeed)
    }

    void testSetTurboOff() {
        ACar c1 = new Saab95()
        ACar c2 = new Saab95()
        c1.gas(0.5)
        c2.setTurboOn()
        c2.setTurboOff()
        c2.gas(0.5)
        System.out.println(c1.currentSpeed == c2.currentSpeed)
    }

    @Test
    void testGas() {
        ACar c = new Volvo240()
        double a = c.getCurrentSpeed()
        c.gas(0.5)
        System.out.println(c.getCurrentSpeed() != a)

        ACar c2 = new Saab95()
        c2.setTurboOn()
        c2.gas(0.5)
        double a2 = c2.getCurrentSpeed()
        System.out.println(c.getCurrentSpeed() != a2)

    }

    @Test
    void testIncrementSpeed() {
        ACar v = new Volvo240()
        double a1 = v.getCurrentSpeed()
        v.incrementSpeed(0.2)
        System.out.println(a1 != v.getCurrentSpeed())

        ACar s = new Saab95()
        double b1 = s.getCurrentSpeed()
        s.incrementSpeed(0.3)
        System.out.println(b1 != s.getCurrentSpeed())
    }

    @Test
    void testBrake() {
        ACar c = new Volvo240()
        c.gas(0.5)
        double a = c.getCurrentSpeed()
        c.brake(0.8)
        System.out.println(c.getCurrentSpeed() != a)

        ACar c1 = new Saab95()
        c1.gas(0.4)
        double a1 = c1.getCurrentSpeed()
        c1.brake(0.8)
        System.out.println(c1.getCurrentSpeed() != a1)
    }

    @Test
    void testDecrementSpeed() {
        ACar v = new Volvo240()
        v.incrementSpeed(0.6)
        double a1 = v.getCurrentSpeed()
        v.decrementSpeed(0.4)
        System.out.println(a1 != v.getCurrentSpeed())


        ACar s = new Saab95()
        s.incrementSpeed(0.8)
        double b1 = s.getCurrentSpeed()
        s.decrementSpeed(0.3)
        System.out.println(b1 != s.getCurrentSpeed())


    }


}
