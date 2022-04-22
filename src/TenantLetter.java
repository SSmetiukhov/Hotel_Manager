import java.util.Calendar;
import java.util.Date;

public class TenantLetter {
    private Date dateOfExpire;
    private boolean isExpired;
    private int indx;
    public TenantLetter(Date date, int indx){
        dateOfExpire = date;
        isExpired = false;
        this.indx=indx;
    }

    public Date getDateOfExpire() {
        return dateOfExpire;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Override
    public String toString() {
        return  "dateOfExpire=" + dateOfExpire +
                ", status =" + isExpired +
                ", id of rent=" + indx ;
    }

    public int getIndx() {
        return indx;
    }
}
