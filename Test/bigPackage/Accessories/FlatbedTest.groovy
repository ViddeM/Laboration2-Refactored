package bigPackage.Accessories

import static java.lang.System.out
class FlatbedTest extends GroovyTestCase {
    void testGetFlatbedIncline() {
        Flatbed f = new Flatbed()
        out.println(f.getFlatbedIncline() == (double) 0.0)
    }

    void testGetMaxIncline() {
        Flatbed f = new Flatbed()
        out.println(f.getMaxIncline() == f.maxIncline)
    }

    void testIsFlatbedDown() {
        Flatbed f = new Flatbed()
        out.println(f.isFlatbedDown())
        f.raiseFlatbed(0)
        out.println(!f.isFlatbedDown())
        f.lowerFlatbed(0)
        out.println(f.isFlatbedDown())
    }
}
