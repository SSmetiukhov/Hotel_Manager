import java.util.*;


public abstract class Rentable{
    private final double volume;
    private final int id; // 100001 - where 1 is type id and 00001 is static counter
    private static int number=0;
    private Person tenant;
    private Date dateStart;
    private Date dateTo;
    private TreeSet<Item> storage;
    private double currentVolume;
    private boolean isCurrentlyExpired = false;


    public Rentable(double volume, int type, Person tenant, Date dateFrom) throws TooManyRents, ProblematicTenantException { // type = 1 for room, type = 2 for parking space
        this.volume = volume;
        this.tenant = tenant;
        if (number < 10000)
            this.id = type*10000 + number++;
        else
            throw new TooManyRents();
        dateStart = dateFrom;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFrom);
        calendar.add(Calendar.DATE, 30);
        this.dateTo = calendar.getTime();
        Comparator<Item> itemComparator = new ItemVolumeComparator().thenComparing(new ItemNameComparator());
        storage = new TreeSet<>(itemComparator);
        currentVolume = 0;
        try {
            addItem(new Item(10,"Starting item"));
            addItem(new Item(20,"Starting item2"));
        } catch (TooManyThingsException e) {
            e.printStackTrace();
        }
        tenant.rentNewRentable(this);
    }
    public Rentable(double length, double width, double height, int type, Person tenant, Date dateFrom) throws TooManyRents, ProblematicTenantException {
        this.tenant = tenant;
        this.volume = length * width * height;
        if (number < 10000)
            this.id = type*10000 + number++;
        else
            throw new TooManyRents();
        dateStart = dateFrom;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFrom);
        calendar.add(Calendar.DATE, 30);
        Comparator<Item> itemComparator = new ItemVolumeComparator().thenComparing(new ItemNameComparator());
        storage = new TreeSet<>(itemComparator);
        this.dateTo = calendar.getTime();
        tenant.rentNewRentable(this);
    }

    public void sendTenantLetter(Date date){

        tenant.receiveTenantLetter(new TenantLetter(date, id));

    }

    public Person getTenant() {
        return tenant;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Date getDateStart() { return dateStart; }

    public double getVolume() {
        return volume;
    }

    public int getId() { return id; }

    public double getCurrentVolume() { return currentVolume; }

    public boolean isCurrentlyExpired() {
        return isCurrentlyExpired;
    }

    public void setCurrentlyExpired(boolean currentlyExpired) {
        isCurrentlyExpired = currentlyExpired;
    }

    public TreeSet<Item> getStorage() {
        return storage;
    }

    public void addItem(Item item) throws TooManyThingsException{
        if(currentVolume + item.getVolume() < this.getVolume()) {
            storage.add(item);
            currentVolume+= item.getVolume();
        }
        else
            throw new TooManyThingsException();
    }
    public Item takeOutItem(Item item){
        Item tmp = item;
        storage.remove(item);
        currentVolume-= tmp.getVolume();
        return tmp;
    }

    public void takeOutAllItems(){
        storage.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(id + " " + volume + " " +
                "\n\tTenant: " + tenant.toString());
        if (!storage.isEmpty()) {
            for (Item i : storage) {
                sb.append(i.toString() + " ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void renewRent() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTo);
        calendar.add(Calendar.DATE, 30);
        dateTo = calendar.getTime();
    }

    public void cancelRent(){
        tenant = null;
        dateStart = null;
        dateTo = null;
        takeOutAllItems();
    }



    public String getItemsReport(){
        String res = "";
        for(Item i: storage){
            res+=i.toString() + "\n";
        }
        return res;
    }

    public abstract Vector<Person> getPeople() ;

    public abstract void checkIn(Person person);

    public abstract void checkOut(Person person);

    //TODO public void Тащитьговно(Storable item)
}
