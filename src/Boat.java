public class Boat extends Vehicle{
    private double displacement;

    public Boat(double height, double width, double length, String name, double enginePower, double displacement) {
        super(height, width, length, name, enginePower);
        this.displacement = displacement;
    }

    public Boat(double volume, String name, double enginePower, double displacement) {
        super(volume, name, enginePower);
        this.displacement = displacement;
    }
}
