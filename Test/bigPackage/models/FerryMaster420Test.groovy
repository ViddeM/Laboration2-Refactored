package bigPackage.models

import bigPackage.models.AbstractModels.ACar

import static java.lang.System.out

class FerryMaster420Test extends GroovyTestCase {
    void testGetFlatbed() {
        FerryMaster420 f = new FerryMaster420()
        out.println(f.getFlatbed()!=null)
    }

    void testGetRange() {
        FerryMaster420 f = new FerryMaster420()
        out.println(f.getRange() == 20)
    }

    void testGetCapacity() {
        FerryMaster420 f = new FerryMaster420()
        out.println(f.getCapacity() == 100)
    }

    void testRaiseFlatbed() {
        FerryMaster420 s = new FerryMaster420()
        s.raiseFlatbed()
        out.println(s.getFlatbedIncline() == s.getMaxIncline())
    }

    void testLowerFlatbed() {
        FerryMaster420 s = new FerryMaster420()
        s.raiseFlatbed()
        s.lowerFlatbed()
        out.println(s.getFlatbedIncline() == 0)
    }

    void testSpeedFactor() {
        FerryMaster420 s = new FerryMaster420()
        s.gas(0.5)
        out.println(s.getCurrentSpeed() != 0)
    }

    void testLoad() {
        FerryMaster420 f = new FerryMaster420()
        ACar s = new Saab95()
        f.load(s)
        out.println(f.getCargoHold().getCargos().contains(s))
    }

    void testUnload() {
        FerryMaster420 f = new FerryMaster420()
        ACar s = new Saab95()
        f.load(s)
        f.unload()
        out.println(!f.getCargoHold().getCargos().contains(s))
    }

    void testMove() {
        FerryMaster420 f = new FerryMaster420()
        ACar s = new Saab95()
        f.load(s)
        f.gas(0.5)
        f.move()
        out.println(s.getPosition()[0] + s.getPosition()[1] == f.getPosition()[0] + f.getPosition()[1])
    }
}
