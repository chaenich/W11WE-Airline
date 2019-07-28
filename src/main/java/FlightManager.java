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

    public int sortPassengersBySeatNumber(ArrayList<Passenger> bookedPassengers) {
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
        return 1;
    }
//        void bubbleSort(int arr[])
//        {
//            int n = arr.length;
//            for (int i = 0; i < n-1; i++)
//                for (int j = 0; j < n-i-1; j++)
//                    if (arr[j] > arr[j+1])
//                    {
//                        // swap arr[j+1] and arr[i]
//                        int temp = arr[j];
//                        arr[j] = arr[j+1];
//                        arr[j+1] = temp;
//                    }
//        }

}
