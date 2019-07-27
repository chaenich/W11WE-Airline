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
    Flight flight;

    @Before
    public void before() {
        passenger1 = new Passenger("Jim", 2);
        passenger2 = new Passenger("Helen", 3);
        passenger3 = new Passenger("Bob", 5);
        passenger4 = new Passenger("Jane", 1);
        bookedPassengers = new ArrayList<Passenger>();
        plane1 = new Plane(PlaneType.AIRBUS220);

        flight = new Flight(bookedPassengers, plane1, "GLA123",
                          "GLA", "EDI", "18:00");
    }

    @Test
    public void canCheckNoBookedPassengers() {
        assertEquals(0, flight.numberOfBookedPassengers());
    }

    @Test
    public void canCheckTwoPassengersBooked() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        assertEquals(2, flight.numberOfBookedPassengers());
    }

    @Test
    public void canGetAllBookedPassengers() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        flight.addPassenger(passenger4);
        assertEquals(this.bookedPassengers, flight.getBookedPassengers());
        assertEquals(4, flight.numberOfBookedPassengers());
    }

    @Test
    public void canGetPlaneAllocatedToThisFlight() {
        assertEquals(plane1, flight.getPlane());
    }

    @Test
    public void canGetPlaneTypeAllocatedToThisFlight() {
        assertEquals(PlaneType.AIRBUS220, flight.getPlaneType());
    }

    @Test
    public void canGetPlaneCapacityForThisFlight() {
        assertEquals(3, flight.getPlaneCapacity());
    }

    @Test
    public void canGetPlaneWeightForThisFlight() {
        assertEquals(800, flight.getPlaneWeight());
    }

    @Test
    public void canGetFlightNumber() {
        assertEquals("GLA123", flight.getFlightNumber());
    }

    @Test
    public void canGetDestination() {
        assertEquals("GLA", flight.getDestination());
    }

    @Test
    public void canGetDepartureAirport() {
        assertEquals("EDI", flight.getAirport());
    }

    @Test
    public void canGetDepartureTime() {
        assertEquals("18:00", flight.getDepartureTime());
    }

    @Test
    public void canGetNumberOfAvailableSeats() {
        assertEquals(3, flight.seatsFree());
    }

    @Test
    public void noPassengersBooked() {
        assertEquals(0, flight.numberOfBookedPassengers());
        assertEquals(3, flight.seatsFree());
    }

    @Test
    public void canBookPassenger() {
        flight.bookInPassenger(passenger1);
        assertEquals(1, flight.numberOfBookedPassengers());
        assertEquals(2, flight.seatsFree());
    }

    @Test
    public void willNotBookPassengerIfFull() {
        flight.bookInPassenger(passenger1);
        flight.bookInPassenger(passenger2);
        flight.bookInPassenger(passenger3);
        flight.bookInPassenger(passenger4);
        assertEquals(3, flight.numberOfBookedPassengers());
        assertEquals(0, flight.seatsFree());
    }
}

