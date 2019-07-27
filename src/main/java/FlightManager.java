public class FlightManager {
    Flight flight;

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
}
