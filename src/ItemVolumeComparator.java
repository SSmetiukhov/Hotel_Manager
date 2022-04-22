import java.util.Comparator;

public class ItemVolumeComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2){
        return Double.compare(o1.getVolume(), o2.getVolume());
    }
}
