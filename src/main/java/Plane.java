public class Plane {
    private PlaneType plane;

    public Plane(PlaneType plane) {
        this.plane = plane;
    }

    public PlaneType getPlane() {
        return this.plane;
    }

    public int getCapacityFromEnum() {
        return this.plane.getCapacity();
    }

    public int getWeightFromEnum() {
        return this.plane.getWeight();
    }

//    Think these should be here (capacity / weight are fixed) but spec says calculate these in FlightManager so...
//    public int getReservedBaggageWeight() {
//        return getWeightFromEnum() / 2;
//    }
//    public int getWeightPerBag() {
//        return getReservedBaggageWeight() / getCapacityFromEnum();
//    }
//    public int getBaggageAllowancePerPassenger() {
//        return getReservedBaggageWeight() / getCapacityFromEnum();
//    }
}
