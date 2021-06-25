package MainPack;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class PlayersMap {
    private Map<String, Punishment> bastards = new HashMap<>();
    private Map<String, Integer> laterMap = new HashMap<>();
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy H:m:s");

    public Map<String, Punishment> getBastards(){
        return bastards;
    }
    public void setPunish(String p, Punishment punishment){bastards.put(p, punishment);}
    public void delPunish(String p) {bastards.remove(p);}
    public boolean inList(String p) {return bastards.containsKey(p);}
    public Punishment getPunish(String p){return bastards.get(p);}

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

    public void saveBastards(){
        try {
            if(bastards.isEmpty()){
                return;
            }

            File file = new File(Main.plugin.getDataFolder() + File.separator + "bastards.yml");
            System.out.println("0");
            file.delete();
            System.out.println("1");
            FileConfiguration basts = YamlConfiguration.loadConfiguration(file);
            System.out.println("2");
            for(String name: bastards.keySet()){
                String s = format.format(bastards.get(name));
                System.out.println(s);
                basts.set(name + ".punish", s);
                System.out.println("3");
                basts.set(name + ".minutes", bastards.get(name).getMinute());
                System.out.println("4");
            }
            basts.save(file);
            System.out.println("Наказанные сохранены");
        }
        catch (Exception ex){
            System.out.println("Ошибка сохранения наказанных");
        }
    }
}
