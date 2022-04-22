import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TooManyRents {
        Calendar calendar = Calendar.getInstance();
        Estate estate = new Estate();
        ArrayList<Person> people = new ArrayList<>();

        Person p1 = new Person("Rinat", "Akhmetov", 12312312, "Konarskiego");
        Person p2 = new Person("Viktor", "Pinchuk", 22312313, "Konarskiego");
        Person p3 = new Person("Ihor", "Kolomoyskiy", 32312312, "Vysoka");
        Person p4 = new Person("Piotr", "Poroshenko", 42312312, "Dzielna");
        Person p5 = new Person("Nikolay", "Zlochevskiy", 52312312, "Tolstogo");
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        Rentable rt1 = null;
        Rentable rt2 = null;
        Rentable rt3 = null;
        Rentable rt4 = null;
        Rentable rt5 = null;
        Rentable pp1 = null;
        Rentable pp2 = null;
        Rentable pp3 = null;
        Rentable pp4 = null;
        Rentable pp5 = null;
        try {
            rt1 = new Appartment(1000.0, p1, calendar.getTime());
            rt2 = new Appartment(2000.0, p2, calendar.getTime());
            rt3 = new Appartment(4000.0, p2, calendar.getTime());
            rt4 = new Appartment(100, 30, 40, p3, calendar.getTime());
            rt5 = new Appartment(5000.0, p5, calendar.getTime());
            pp1 = new ParkingPlace(18.0, 8.0, 8.0, p4, calendar.getTime());
            pp2 = new ParkingPlace(12.0, 8.0,  4, p4, calendar.getTime());
            pp3 = new ParkingPlace(300, p4, calendar.getTime());
            pp4 = new ParkingPlace( 33, p4, calendar.getTime());
            pp5 = new ParkingPlace(8.0, 8.0, 8.0, p4, calendar.getTime());
        } catch (ProblematicTenantException e) {
            e.printStackTrace();
        }
        estate.addRentable(rt1);
        estate.addRentable(rt2);
        estate.addRentable(rt3);
        estate.addRentable(rt4);
        estate.addRentable(rt5);
        estate.addRentable(pp1);
        estate.addRentable(pp2);
        estate.addRentable(pp3);
        estate.addRentable(pp4);
        estate.addRentable(pp5);
        Thread estateThread = new Thread(new EstateThread(estate.getRentablevector(), calendar));
        estateThread.start();
        SwingUtilities.invokeLater(() -> new EstateFrame(estate, people));

    }
}
