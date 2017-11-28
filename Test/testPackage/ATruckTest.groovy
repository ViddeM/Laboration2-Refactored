package testPackage

import bigPackage.models.Scania

import static java.lang.System.out;
import org.testng.annotations.Test

class ATruckTest extends GroovyTestCase {



    @Test
    void testRaiseFlatbed() {
        Scania s = new Scania()
        s.raiseFlatbed(45)
        out.println(s.getFlatbedIncline() == 45)

        s.raiseFlatbed(45)
        out.println(s.getFlatbedIncline() == 70)

    }

    @Test
    void testLowerFlatbed() {
        Scania s = new Scania()
        s.raiseFlatbed(45)
        s.lowerFlatbed(35)
        out.println(s.getFlatbedIncline() == 10)

        s.lowerFlatbed(35)
        out.println(s.getFlatbedIncline() == 0)

    }

    @Test
    void testIncrementSpeed() {
        Scania v = new Scania()
        double a1 = v.getCurrentSpeed()
        v.incrementSpeed(0.2)
        out.println(a1 != v.getCurrentSpeed())

        boolean b = false
        try{
            v.raiseFlatbed(50)
        } catch(IllegalStateException e) {
            b = true
        }
        out.println(b)
    }
}
