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

    public int getReservedBaggageWeight() {
        return getWeightFromEnum() / 2;
    }
    public int getWeightPerBag() {
        return getReservedBaggageWeight() / getCapacityFromEnum();
    }

    // This is same as getWeightPerBag() but creating as getWeightPerBag() doesn't really allow
    // for multiple bags and this makes more sense
    public int getBaggageAllowancePerPassenger() {
        return getReservedBaggageWeight() / getCapacityFromEnum();
    }
}
