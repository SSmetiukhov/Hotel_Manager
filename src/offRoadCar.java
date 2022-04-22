public class offRoadCar extends Vehicle{
    private int amountOfWheels;

    public offRoadCar(double height, double width, double length, String name, double enginePower, int amountOfWheels) {
        super(height, width, length, name, enginePower);
        this.amountOfWheels = amountOfWheels;
    }

    public offRoadCar(double volume, String name, double enginePower, int amountOfWheels) {
        super(volume, name, enginePower);
        this.amountOfWheels = amountOfWheels;
    }
}
