import java.util.Calendar;
import java.util.Vector;

public class EstateThread implements Runnable{
    private Vector<Rentable> rentablevector;
    private Calendar calendar;

    public EstateThread(Vector<Rentable> rentablevector, Calendar calendar) {
        this.rentablevector = rentablevector;
        this.calendar = calendar;
    }

    @Override
    public void run() {
        boolean checkDay = false;
        while(true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            calendar.add(Calendar.DATE, 1);
            if(checkDay){
                for (int i = 0; i < rentablevector.size(); i++) {
                    try {
                        for (int j = 0; i < rentablevector.elementAt(i).getTenant().getTenantLetters().size(); j++) { // checking whether tenant letters have expired
                            if (calendar.getTime().after(rentablevector.elementAt(i).getTenant().getTenantLetters().elementAt(j).getDateOfExpire())
                                    && !(rentablevector.elementAt(i).getTenant().getTenantLetters().elementAt(j).isExpired())) {

                                rentablevector.elementAt(i).getTenant().getTenantLetters().elementAt(j).setExpired(true);
                                rentablevector.elementAt(i).cancelRent();
                            }
                        }
                        if (calendar.getTime().after(rentablevector.elementAt(i).getDateTo()) && !rentablevector.elementAt(i).isCurrentlyExpired()) { //sending tenant letters to tenants whose end date of the rent has expired
                            rentablevector.elementAt(i).sendTenantLetter(calendar.getTime());
                            rentablevector.elementAt(i).setCurrentlyExpired(true);
                        }
                    }catch (NullPointerException | ArrayIndexOutOfBoundsException ex){

                    }
                    ;
                }
            }
            checkDay = !checkDay;
            System.out.println("new day!");


        }
    }
}
