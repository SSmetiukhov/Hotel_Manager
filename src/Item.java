public class Item {
    private String name;
    private double volume;

    public Item(double height, double width, double length, String name) {
        this.volume = height * width * length;
        this.name = name;
    }
    public Item(double volume, String name){
        this.volume = volume;
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "                 " + name + " " + volume + '\n';
    }
}
