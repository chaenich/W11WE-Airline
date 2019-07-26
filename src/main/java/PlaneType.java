public enum PlaneType {
    BOEING737(150, 1000),
    BOEING747(175, 1100),
    BOEING767(200, 1200),
    BOEING777(225, 1300),
    AIRBUS220(3, 800),
    AIRBUS330(100, 900),
    AIRBUS350(120, 950),
    AIRBUS380(250, 1500);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getWeight() {
        return this.weight;
    }
}
