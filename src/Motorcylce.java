public class Motorcylce extends Vehicle{
    public enum Transmission{
        MANUAL, AUTOMATIC, SEMIAUTOMATIC, CLUTCH;
    }
    private Transmission transmission;

    public Motorcylce(double height, double width, double length, String name, double enginePower, Transmission transmission) {
        super(height, width, length, name, enginePower);
        this.transmission = transmission;
    }

    public Motorcylce(double volume, String name, double enginePower, Transmission transmission) {
        super(volume, name, enginePower);
        this.transmission = transmission;
    }
}
