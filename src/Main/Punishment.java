package Main;

import java.util.Calendar;

public class Punishment {
    int sec;
    Calendar start;
    Calendar end;
    int min;

    public Punishment(int min){
        this.min = min;

        sec = this.min*60;
        start = Calendar.getInstance();
        end = (Calendar) start.clone();
        end.add(Calendar.MINUTE, this.min);
    }
}
