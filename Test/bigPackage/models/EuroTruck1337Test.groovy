package bigPackage.models

import bigPackage.models.AbstractModels.ACar
import bigPackage.models.AbstractModels.ATruck

import static java.lang.System.out

class EuroTruck1337Test extends GroovyTestCase {

    void testGetFlatbed() {
        ATruck f = new EuroTruck1337()
        out.println(f.getFlatbed()!=null)
    }

    void testGetRange() {
        ATruck f = new EuroTruck1337()
        out.println(f.getRange() == 20)
    }

    void testGetCapacity() {
        ATruck f = new EuroTruck1337()
        out.println(f.getCapacity() == 100)
    }

    void testRaiseFlatbed() {
        ATruck s = new EuroTruck1337()
        s.raiseFlatbed()
        out.println(s.getFlatbedIncline() == s.getMaxIncline())
    }

    void testLowerFlatbed() {
        ATruck s = new EuroTruck1337()
        s.raiseFlatbed()
        s.lowerFlatbed()
        out.println(s.getFlatbedIncline() == 0)
    }

    void testSpeedFactor() {
        ATruck s = new EuroTruck1337()
        s.gas(0.5)
        out.println(s.getCurrentSpeed() != 0)
    }

    void testLoad() {
        ATruck f = new EuroTruck1337()
        ACar s = new Saab95()
        f.load(s)
        out.println(f.getCargoHold().getCargos().contains(s))
    }

    void testUnload() {
        ATruck f = new EuroTruck1337()
        ACar s = new Saab95()
        f.load(s)
        f.unload()
        out.println(!f.getCargoHold().getCargos().contains(s))
    }

    void testMove() {
        ATruck f = new EuroTruck1337()
        ACar s = new Saab95()
        f.load(s)
        f.gas(0.5)
        f.move()
        out.println(s.getPosition()[0] + s.getPosition()[1] == f.getPosition()[0] + f.getPosition()[1])
    }
}
