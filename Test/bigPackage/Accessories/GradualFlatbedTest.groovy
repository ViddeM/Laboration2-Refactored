package bigPackage.Accessories

import static java.lang.System.out

class GradualFlatbedTest extends GroovyTestCase {
    void testRaiseFlatbed() {
        GradualFlatbed f = new GradualFlatbed(90)
        out.println(f.isFlatbedDown())
        f.raiseFlatbed(0,10)
        out.println(f.getFlatbedIncline() == 10)
    }

    void testLowerFlatbed() {
        GradualFlatbed f = new GradualFlatbed(90)
        out.println(f.isFlatbedDown())
        f.raiseFlatbed(0,10)
        f.lowerFlatbed(0,3)
        out.println(f.getFlatbedIncline() == 7)
    }
}
