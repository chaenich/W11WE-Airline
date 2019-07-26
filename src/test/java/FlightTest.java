import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    ArrayList<Passenger> bookedPassengers;
    Plane plane1;
    Flight flight1;

    @Before
    public void before() {
        passenger1 = new Passenger("Jim", 2);
        passenger2 = new Passenger("Helen", 3);
        bookedPassengers = new ArrayList<Passenger>();
        plane1 = new Plane(PlaneType.AIRBUS220);

        flight1 = new Flight(bookedPassengers, plane1, "GLA123",
                          "GLA", "EDI", "18:00");
    }

    @Test
    public void canCheckNoBookedPassengers() {
        assertEquals(0, flight1.numberOfBookedPassengers());
    }

    @Test
    public void canAddOnePassenger() {
        flight1.addPassenger(passenger1);
        assertEquals(1, flight1.numberOfBookedPassengers());
    }

    @Test
    public void canCheckTwoPassengersBooked() {
        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        assertEquals(2, flight1.numberOfBookedPassengers());
    }

    @Test
    public void canGetPlaneAllocatedToThisFlight() {
        assertEquals(plane1, flight1.getPlane());
    }

    @Test
    public void canGetPlaneTypeAllocatedToThisFlight() {
        assertEquals(PlaneType.AIRBUS220, flight1.getPlaneType());
    }

    @Test
    public void canGetFlightNumber() {
        assertEquals("GLA123", flight1.getFlightNumber());
    }

    @Test
    public void canGetDestination() {
        assertEquals("GLA", flight1.getDestination());
    }

    @Test
    public void canGetDepartureAirport() {
        assertEquals("EDI", flight1.getAirport());
    }

    @Test
    public void canGetDepartureTime() {
        assertEquals("18:00", flight1.getDepartureTime());
    }

    @Test
    public void canGetNumberOfAvailableSeats() {
        assertEquals(3, flight1.seatsFree());
    }

    @Test
    public void noPassengersBooked() {
        assertEquals(0, flight1.numberOfBookedPassengers());
        assertEquals(3, flight1.seatsFree());
    }

    @Test
    public void canBookPassenger() {
        flight1.bookInPassenger(passenger1);
        assertEquals(1, flight1.numberOfBookedPassengers());
        assertEquals(2, flight1.seatsFree());
    }

    @Test
    public void willNotBookPassengerIfFull() {
        flight1.bookInPassenger(passenger1);
        flight1.bookInPassenger(passenger2);
        flight1.bookInPassenger(passenger3);
        flight1.bookInPassenger(passenger4);
        assertEquals(3, flight1.numberOfBookedPassengers());
        assertEquals(0, flight1.seatsFree());
    }
}

