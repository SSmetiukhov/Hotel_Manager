public class Vehicle extends Item{
    private double enginePower;

    public Vehicle(double height, double width, double length, String name, double enginePower) {
        super(height, width, length, name);
        this.enginePower = enginePower;
    }

    public Vehicle(double volume, String name, double enginePower) {
        super(volume, name);
        this.enginePower = enginePower;
    }
}
