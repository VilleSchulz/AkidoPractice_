import java.time.LocalDate;
import java.util.Date;


public class PracticeSession {
    Date date;
    int duration;



    public PracticeSession(Date date, int duration){
        this.date = date;
        this.duration = duration;

    }



    public Date getDate(){
        return date;
    }


}
