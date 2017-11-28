package bigPackage.Accessories

import bigPackage.models.AbstractModels.ACar
import bigPackage.models.EuroTruck1337
import bigPackage.models.Saab95

import static java.lang.System.out
class CargoHoldTest extends GroovyTestCase {
    void testGetCargo() {
        CargoHold c = new CargoHold(true, 1, 1)
        out.println(c != null)
    }

    void testLoad() {
        EuroTruck1337 tp = new EuroTruck1337()
        ACar s = new Saab95()
        CargoHold c = new CargoHold(true, 1, 1)
        c.load(s,tp,true)
        out.println(c.getCargos().contains(s))
    }

    void testUnload() {

        EuroTruck1337 tp = new EuroTruck1337()
        ACar s = new Saab95()
        CargoHold c = new CargoHold(true, 1, 1)
        c.load(s,tp,true)
        out.println(c.getCargos().contains(s))

        out.println(c.unload(true) == s)
        out.println(!c.getCargos().contains(s))
    }
}
