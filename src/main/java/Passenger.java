public class Passenger {
    private String name;
    private int numBags;
    private int seatNumber;


    public Passenger(String name, int numBags, int seatNumber) {
        this.name = name;
        this.numBags = numBags;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getNumBags() {
        return this.numBags;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
