import java.util.ArrayList;

public class FlightManager {
    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public int getReservedBaggageWeight() {
        return this.flight.getPlaneWeight() / 2;
    }

    public int getWeightPerBag() {
        return getReservedBaggageWeight() / this.flight.getPlaneCapacity();
    }

    public int getBaggageAllowancePerPassenger() {
        return getReservedBaggageWeight() / this.flight.getPlaneCapacity();
    }

    public int baggageWeightForAllBookedCustomers() {
        int totalWeight = 0;
        for (Passenger cust : this.flight.getBookedPassengers()) {
            totalWeight += cust.getNumBags() * getBaggageAllowancePerPassenger();
        }
        return totalWeight;
    }

    public int remainingBaggageWeightReservation() {
        return getReservedBaggageWeight() - baggageWeightForAllBookedCustomers();
    }

    public boolean sortPassengersBySeatNumber(ArrayList<Passenger> bookedPassengers) {
        int numPassengers = bookedPassengers.size();

        for (int i = 1; i < numPassengers - 1; i++) {
            for (int j = 0; j < numPassengers - i; j++) {
                Passenger passenger1 = bookedPassengers.get(j);
                Passenger passenger2 = bookedPassengers.get(j + 1);
                if (passenger1.getSeatNumber() > passenger2.getSeatNumber()) {
                    Passenger temp = bookedPassengers.get(j);
                    bookedPassengers.set(j, bookedPassengers.get(j + 1));
                    bookedPassengers.set(j + 1, temp);
                }
            }
        }
        return true;
    }

    public String findPassengerBySeatNumber(ArrayList<Passenger> passengers, int seatNumber) {

        if (passengers.size() == 0){
            return "No Passengers";
        }
        int midIndex = 0;
        if (passengers.size() >1) {
            midIndex = (int) Math.ceil((double) passengers.size() / 2);
        }
        int midPoint = passengers.get(midIndex).getSeatNumber();
        if (seatNumber == midPoint) {
            return passengers.get(midIndex).getName();
        }
        ArrayList<Passenger> newSearchArea;
        if (seatNumber < midPoint){
            newSearchArea = new ArrayList<Passenger>(passengers.subList(0, midIndex));
        } else {
            newSearchArea = new ArrayList<Passenger>(passengers.subList(midIndex + 1, passengers.size()));
        }
        return findPassengerBySeatNumber(newSearchArea, seatNumber);
    }
}
