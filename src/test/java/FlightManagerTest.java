import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Passenger passenger6;
    Passenger passenger7;
    Passenger passenger8;
    Passenger passenger9;
    Passenger passenger10;
    ArrayList<Passenger> bookedPassengers;
    Plane plane1;
    Flight flight1;
    FlightManager flightManager;

    @Before
    public void before() {
        passenger1 = new Passenger("Jim", 1, 0);
        passenger2 = new Passenger("Helen", 2, 0);
        passenger3 = new Passenger("Bob", 3, 0);
        passenger4 = new Passenger("Janine", 2, 0);
        passenger5 = new Passenger("Bill", 1, 0);
        passenger6 = new Passenger("Harry", 2, 0);
        passenger7 = new Passenger("John", 4, 0);
        passenger8 = new Passenger("Gayle", 2, 0);
        passenger9 = new Passenger("Ginny", 3, 0);
        passenger10 = new Passenger("Thomas", 1, 0);
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

    @Test
    public void canSortPassengersBySeatNumber() {
        flight1.bookInPassenger(passenger1);
        flight1.bookInPassenger(passenger2);
        flight1.bookInPassenger(passenger3);
        flight1.bookInPassenger(passenger4);
        flight1.bookInPassenger(passenger5);
        flight1.bookInPassenger(passenger6);
        flight1.bookInPassenger(passenger7);
        flight1.bookInPassenger(passenger8);
        flight1.bookInPassenger(passenger9);
        flight1.bookInPassenger(passenger10);
        assertEquals(true, flightManager.sortPassengersBySeatNumber(flight1.getBookedPassengers()));
    }

    @Test
    public void CanFindPassengerNameBySeatNumber() {
        flight1.bookInPassenger(passenger1);
        flight1.bookInPassenger(passenger2);
        flight1.bookInPassenger(passenger3);
        flight1.bookInPassenger(passenger4);
        flight1.bookInPassenger(passenger5);
        flight1.bookInPassenger(passenger6);
        flight1.bookInPassenger(passenger7);
        flight1.bookInPassenger(passenger8);

        flightManager.sortPassengersBySeatNumber(flight1.getBookedPassengers());
        ArrayList<Passenger> passengers = flight1.getBookedPassengers();
        // Look for whatever passenger is at index 2
        String name = passengers.get(6).getName().toString();
        int seat = passengers.get(6).getSeatNumber();

        assertEquals(name, flightManager.findPassengerBySeatNumber(passengers, seat));

    }
}
