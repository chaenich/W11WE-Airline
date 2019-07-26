import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    public Plane plane1;

    @Before
    public void before() {
        plane1 = new Plane(PlaneType.AIRBUS220);
    }

    @Test
    public void canGetPlane() {
        assertEquals(PlaneType.AIRBUS220, plane1.getPlane());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(80, plane1.getCapacityFromEnum());
    }

    @Test
    public void canGetWeight() {
        assertEquals(800, plane1.getWeightFromEnum());
    }
}
