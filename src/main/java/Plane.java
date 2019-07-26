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
}
