package MainPack;

import java.util.HashMap;
import java.util.Map;

public class PlayersMap {
    private Map<String, Punishment> bastards = new HashMap<>();
    private Map<String, Integer> laterMap = new HashMap<>();

    public Map<String, Punishment> getBastards(){
        return bastards;
    }
    public void setPunish(String p, Punishment punishment){bastards.put(p, punishment);}
    public void delPunish(String p) {bastards.remove(p);}
    public boolean inList(String p) {return bastards.containsKey(p);}

    //Для laterMap

    public Map<String, Integer> getLaterMap() {
        return laterMap;
    }

    public void setLater(String name, int time){
        laterMap.put(name, time);
    }

    public void delLater(String name){
        laterMap.remove(name);
    }

    public boolean inLater(String name){
        return laterMap.containsKey(name);
    }
}
