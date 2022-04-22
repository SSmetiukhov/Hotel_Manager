import java.util.Date;
import java.util.Vector;

public class ParkingPlace extends Rentable{

    public ParkingPlace(double volume, Person tenant, Date dateFrom) throws TooManyRents, ProblematicTenantException {
        super(volume, 2, tenant, dateFrom);
    }

    public ParkingPlace(double length, double width, double height, Person tenant, Date dateFrom) throws TooManyRents, ProblematicTenantException {
        super(length, width, height, 2, tenant, dateFrom);
    }


    @Override
    public Vector<Person> getPeople() {
        return null;
    }

    @Override
    public void checkIn(Person person) {

    }

    @Override
    public void checkOut(Person person) {

    }
}
