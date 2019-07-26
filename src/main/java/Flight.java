import java.util.ArrayList;

public class Flight {
    private ArrayList<Passenger> bookedPassengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String airport;
    private String departureTime;

    public Flight (ArrayList<Passenger> bookedPassengers,
                   Plane plane, String flightNumber, String destination,
                   String airport, String departureTime) {
        this.bookedPassengers = bookedPassengers;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.airport = airport;
        this.departureTime = departureTime;

    }

    public int numberOfBookedPassengers() {
        return this.bookedPassengers.size();
    }

    public void addPassenger(Passenger passenger) {
        this.bookedPassengers.add(passenger);
    }

    public Plane getPlane() {
        return this.plane;
    }

    public PlaneType getPlaneType() {
        return this.plane.getPlane();
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
}
