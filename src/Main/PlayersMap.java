package Main;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayersMap {
    private Map<String, Punishment> bastards = new HashMap<>();

    public Map<String, Punishment> getBastards(){
        return bastards;
    }
    public void setPunish(String p, Punishment punishment){bastards.put(p, punishment);}
    public void delPunish(String p) {bastards.remove(p);}
    public boolean inList(String p) {return bastards.containsKey(p);}
}
