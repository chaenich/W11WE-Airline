import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    Passenger passenger1;

    @Before
    public void before() {
        passenger1 = new Passenger("Bob", 2);
    }

    @Test
    public void canGetPassengerName() {
        assertEquals("Bob", passenger1.getName());
    }

    @Test
    public void canGetNumberOfBags() {
        assertEquals(2, passenger1.getNumBags());
    }
}
