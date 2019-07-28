import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    Passenger passenger1;

    @Before
    public void before() {
        passenger1 = new Passenger("Bob", 2, 22);
    }

    @Test
    public void canGetPassengerName() {
        assertEquals("Bob", passenger1.getName());
    }

    @Test
    public void canGetNumberOfBags() {
        assertEquals(2, passenger1.getNumBags());
    }

    @Test
    public void canSetSeatNumber() {
        passenger1.setSeatNumber(45);
        assertEquals(45, passenger1.getSeatNumber());
    }

    @Test
    public void canGetSeatNumber() {
        assertEquals(22, passenger1.getSeatNumber());
    }

}
