package MainPack;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
            file.delete();
            FileConfiguration basts = YamlConfiguration.loadConfiguration(file);
            for(String key : bastards.keySet()){
                basts.set(key + ".punish", format.format(bastards.get(key).getEnd().getTime()));
                basts.set(key + ".minutes", bastards.get(key).getMinute());
            }
            basts.save(file);
            System.out.println("Наказанные сохранены");
        }
        catch (Exception ex){
            System.out.println("Ошибка сохранения наказанных");
        }
    }

    public void setBastards(){
        bastards.clear();
        if(!new File(Main.plugin.getDataFolder() + File.separator + "bastards.yml").exists()){
            System.out.println("Наказанные не обнаружены");
            return;
        }

        File file = new File(Main.plugin.getDataFolder() + File.separator + "bastards.yml");
        FileConfiguration basts = YamlConfiguration.loadConfiguration(file);
        for(String key: basts.getKeys(false)){
            bastards.put(key, new Punishment(basts.getInt(key+".minute"), getCal(basts.getString(key+".punish"))));
        }
        file.delete();
    }

    private Calendar getCal(String cal){
        Calendar ret = Calendar.getInstance();
        try{
        ret.setTime(format.parse(cal));
        }
        catch (Exception e){
            return  null;
        }
        return ret;
    }
}
