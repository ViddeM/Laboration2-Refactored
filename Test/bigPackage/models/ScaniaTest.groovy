package bigPackage.models

import bigPackage.models.AbstractModels.ACar
import bigPackage.models.AbstractModels.ATruck
import static java.lang.System.out

class ScaniaTest extends GroovyTestCase {
    void testGetFlatbed() {
        ACar s = new Scania()
        s.getFlatbed()
    }

    void testRaiseFlatbed() {
        ATruck s = new Scania()
        s.raiseFlatbed(30)
        out.println(s.getFlatbedIncline() == 30)

        s.raiseFlatbed()
        out.println(s.getFlatbedIncline() == s.getMaxIncline())
    }

    void testLowerFlatbed() {
        ATruck s = new Scania()
        s.raiseFlatbed(30)
        s.lowerFlatbed(15)
        out.println(s.getFlatbedIncline() == 15)

        s.lowerFlatbed()
        out.println(s.getFlatbedIncline() == 0)
    }

    void testSpeedFactor() {
        Scania s = new Scania()
        s.gas(0.5)
        out.println(s.getCurrentSpeed()!=0)
    }
}
