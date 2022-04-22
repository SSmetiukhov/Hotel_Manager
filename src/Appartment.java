
import java.util.Date;
import java.util.Vector;

public class Appartment extends Rentable{
    private Vector<Person> people = new Vector<>();

    public Appartment(double volume, Person rentalFeesPerson, Date dateFrom) throws TooManyRents, ProblematicTenantException {
        super(volume, 1, rentalFeesPerson, dateFrom);
    }

    public Appartment(double length, double width, double height, Person rentalFeesPerson, Date dateFrom) throws TooManyRents, ProblematicTenantException {
        super(length, width, height, 1, rentalFeesPerson, dateFrom);
        checkIn(new Person("Vasya", "Pupkin", 412412, "jerak"));
    }

    @Override
    public void checkIn(Person person){
        people.add(person);
    }
    @Override
    public void checkOut(Person person){
        people.remove(person);
    }
    public void evictAll(){
        people.clear();
    }

    @Override
    public void addItem(Item item) throws TooManyThingsException {
        if (!(item instanceof Vehicle))
            super.addItem(item);
        else
            throw new IllegalArgumentException("You cannot store Vehicle in the apartment");
    }

    @Override
    public void cancelRent() {
        super.cancelRent();
        evictAll();
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getVolume() + " " +
                "\n\tTenant: " + this.getTenant().toString() + people.toString() + '\n' + this.getStorage().toString();
    }

    @Override
    public Vector<Person> getPeople() {
        return people;
    }
}
