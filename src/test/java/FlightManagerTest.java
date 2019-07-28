import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    ArrayList<Passenger> bookedPassengers;
    Plane plane1;
    Flight flight1;
    FlightManager flightManager;

    @Before
    public void before() {
        passenger1 = new Passenger("Jim", 1, 0);
        passenger2 = new Passenger("Helen", 2, 0);
        passenger3 = new Passenger("Bob", 3, 0);
        passenger4 = new Passenger("Jane", 2, 0);
        bookedPassengers = new ArrayList<Passenger>();
        plane1 = new Plane(PlaneType.AIRBUS330);
        flight1 = new Flight(bookedPassengers, plane1, "GLA123",
                "GLA", "EDI", "18:00");
        flightManager = new FlightManager(flight1);
    }

    @Test
    public void canGetTotalReservedBaggageWeight() {
        assertEquals(1500, flightManager.getReservedBaggageWeight());
    }

    //Next two tests are same thing per spec but different meanings if multiple bags
    @Test
    public void canGetWeightPerBag() {
        assertEquals(15, flightManager.getWeightPerBag());
    }

    @Test
    public void canGetBaggageAllowancePerPassenger() {
        assertEquals(15, flightManager.getBaggageAllowancePerPassenger());
    }

    @Test
    public void canCalculateBaggageWeightForAllBookedCustomers() {
        flight1.bookInPassenger(passenger1);
        flight1.bookInPassenger(passenger2);
        flight1.bookInPassenger(passenger3);
        flight1.bookInPassenger(passenger4);
        assertEquals(120, flightManager.baggageWeightForAllBookedCustomers());
    }

    @Test
    public void canCalculateRemainingBaggageWeightReservation() {
        flight1.bookInPassenger(passenger1);
        flight1.bookInPassenger(passenger2);
        flight1.bookInPassenger(passenger3);
        flight1.bookInPassenger(passenger4);
        assertEquals(1380, flightManager.remainingBaggageWeightReservation());
    }

}
