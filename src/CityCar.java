public class CityCar extends Vehicle{
    public enum EmissionStandart{
        Euro1, Euro2, Euro3, Euro4, Euro5, Euro6, Euro7;
    }
    private EmissionStandart emissionStandart;

    public CityCar(double height, double width, double length, String name, double enginePower, EmissionStandart emissionStandart) {
        super(height, width, length, name, enginePower);
        this.emissionStandart = emissionStandart;
    }

    public CityCar(double volume, String name, double enginePower, EmissionStandart emissionStandart) {
        super(volume, name, enginePower);
        this.emissionStandart = emissionStandart;
    }
}
