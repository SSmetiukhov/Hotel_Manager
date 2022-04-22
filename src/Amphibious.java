public class Amphibious extends Vehicle{
    private double onGroundSpeed;
    private double onWaterSpeed;

    public Amphibious(double height, double width, double length, String name, double enginePower, double onGroundSpeed, double onWaterSpeed) {
        super(height, width, length, name, enginePower);
        this.onGroundSpeed = onGroundSpeed;
        this.onWaterSpeed = onWaterSpeed;
    }

    public Amphibious(double volume, String name, double enginePower, double onGroundSpeed, double onWaterSpeed) {
        super(volume, name, enginePower);
        this.onGroundSpeed = onGroundSpeed;
        this.onWaterSpeed = onWaterSpeed;
    }
}
