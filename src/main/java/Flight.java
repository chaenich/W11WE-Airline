import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {
    private ArrayList<Passenger> bookedPassengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String airport;
    private String departureTime;
//    private Date departureTime;

    private ArrayList<Integer> availableSeats;

    public Flight (ArrayList<Passenger> bookedPassengers,
                   Plane plane, String flightNumber, String destination,
                   String airport, String departureTime) {
        this.bookedPassengers = bookedPassengers;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.airport = airport;
        this.departureTime = departureTime;

        // Populate available seats
        availableSeats = new ArrayList<Integer>();
        for (int i = 0; i < getPlaneCapacity(); i++) {
            this.availableSeats.add(i + 1);
        }
    }

    public ArrayList<Passenger> getBookedPassengers() {
        return this.bookedPassengers;
    }

    public int numberOfBookedPassengers() {
        return this.bookedPassengers.size();
    }

    public Plane getPlane() {
        return this.plane;
    }

    public PlaneType getPlaneType() {
        return this.plane.getPlane();
    }

    public int getPlaneCapacity() {
        return this.plane.getCapacityFromEnum();
    }

    public int getPlaneWeight() {
        return this.plane.getWeightFromEnum();
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getAirport() {
        return this.airport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public int seatsFree() {
        return getPlaneCapacity() - numberOfBookedPassengers();
    }

    public void bookInPassenger(Passenger passenger) {
        if (!bookedPassengers.contains(passenger)) {
            if (seatsFree() > 0) {
                passenger.setSeatNumber(allocateSeat());
                bookedPassengers.add(passenger);
            }
        }
    }

    public int allocateSeat() {
        int allocatedSeat;
        int allocatedSeatIndex;

        Random rand = new Random();
        allocatedSeatIndex = rand.nextInt(availableSeats.size());
        allocatedSeat = availableSeats.get(allocatedSeatIndex);
        availableSeats.remove(allocatedSeatIndex);
        return allocatedSeat;
    }

    public boolean seatIsAvailable(int seatNumber) {
        return availableSeats.contains(seatNumber);
    }
}
