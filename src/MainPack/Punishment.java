package MainPack;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Punishment {
    Calendar start;
    Calendar end;
    int min;

    String min1 = "234";
    String min2 = "567890";


    public Punishment(int min){
        this.min = min;

        start = Calendar.getInstance();
        end = (Calendar) start.clone();
        end.add(Calendar.MINUTE, this.min);
    }

    public Punishment(int min, Calendar end){
        this.min = min;
        this.end = end;
        start = (Calendar) end.clone();
        start.add(Calendar.MINUTE, -min);
    }

    public int getMinute(){
        return this.min;
    }

    public String checkMute(){
        Calendar now = Calendar.getInstance();
        long difference = (int) (end.getTimeInMillis() - now.getTimeInMillis())/1000;
        if(difference<60){
            return difference + getSec((int) difference);
        }
        if(difference%60 == 0){
            return difference/60 + getMin((int) difference);
        }
        else {
            return (int) difference/60 + getMin((int) difference/60) + " " + (int) difference%60 + getSec((int)difference%60);
        }
    }

    private String getMin(int m){
        String end = Integer.toString(m);
        String ending = end.substring(end.length()-1);
        if(min1.contains(ending)) {
            if(end.length() >= 2){
                if(!Character.toString(end.charAt(end.length()-2)).equals("1")) return " минуты";
                else {
                    return " минут";}
            }
            else return " минуты";
        }

        if(min2.contains(ending)) return " минут";

        return " минуту";
    }

    private String getSec(int s){
        String end = Integer.toString(s);
        String ending = end.substring(end.length()-1);
        if(min1.contains(ending)) {
            if(end.length() >= 2){
                if(!Character.toString(end.charAt(end.length()-2)).equals("1")) return " секунды";
                else return " секунд";
            }
            else return " секунды";
        }

        if(min2.contains(ending)) return " секунд";

        return " секунду";
    }
}
