import java.io.*;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Vector;

public class Estate {
    private Vector<Rentable> rentablevector = new Vector<>();
    private static int reportIndx;



    public void addRentable(Rentable rentable){
        rentablevector.add(rentable);
    }

    public Vector<Rentable> getRentablevector() {
        return rentablevector;
    }
    //    public void checkDay(){
//        for (int i = 0; i < rentablevector.size(); i++) {
//            for (int j = 0; i < rentablevector.elementAt(i).getTenant().getTenantLetters().size(); j++){ // checking whether tenant letters have expired
//                if(calendar.getTime().after(rentablevector.elementAt(i).getTenant().getTenantLetters().elementAt(j).getDateOfExpire())
//                && !(rentablevector.elementAt(i).getTenant().getTenantLetters().elementAt(j).isExpired())) {
//
//                    rentablevector.elementAt(i).getTenant().getTenantLetters().elementAt(j).setExpired(true);
//                    rentablevector.elementAt(i).cancelRent();
//                }
//            }
//            if (calendar.getTime().after(rentablevector.elementAt(i).getDateTo())) //sending tenant letters to tenants whose end date of the rent has expired
//                rentablevector.elementAt(i).sendTenantLetter(calendar.getTime());
//        }
//        nextDay();
//    }
//
//    public void nextDay(){
//        calendar.add(Calendar.DATE, 1);
//    }

    public void createReport(){
        String source ="report number " + String.valueOf(reportIndx++) + ".txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(source))){
            Comparator<Rentable> comp = new Comparator<Rentable>() {
                @Override
                public int compare(Rentable o1, Rentable o2) {
                    return (int)(100*(o1.getVolume() - o2.getVolume()));
                }
            };
            rentablevector.sort(comp);
            for(Rentable e : rentablevector){
                bw.write(e.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
