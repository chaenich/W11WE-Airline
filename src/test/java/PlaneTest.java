import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane plane1;

    @Before
    public void before() {
        plane1 = new Plane(PlaneType.AIRBUS330);
    }
    @Test
    public void canGetPlaneType() {
        assertEquals(PlaneType.AIRBUS330, plane1.getPlane());
    }
    @Test
    public void canGetCapacity() {
        assertEquals(100, plane1.getCapacityFromEnum());
    }
    @Test
    public void canGetWeight() {
        assertEquals(3000, plane1.getWeightFromEnum());
    }


}
