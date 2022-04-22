
import java.util.Vector;

public class Person {
    private String name;
    private String surname;
    private int pesel;
    private String address;
    private Vector<TenantLetter> tenantLetters = new Vector<TenantLetter>();
    private Vector<Rentable> rents = new Vector<>();

    public Person(String name, String surname, int pesel, String address) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
    }
    public void rentNewRentable(Rentable rentable) throws TooManyRents, ProblematicTenantException{
        if (rents.size() > 5)
            throw new TooManyRents();
        else if (tenantLetters.size()>3)
            throw new ProblematicTenantException(this);
        else
            rents.add(rentable);
    }

    public void receiveTenantLetter(TenantLetter letter){
        tenantLetters.add(letter);
    }

    public Vector<TenantLetter> getTenantLetters() {
        return tenantLetters;
    }

    public Vector<Rentable> getRents() {
        return rents;
    }

    @Override
    public String toString() {
        return  name + ' ' + surname + ' '  + pesel + ' ' + address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

