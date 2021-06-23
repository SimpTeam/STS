package MainPack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {
    public String chat(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    //Тут получаем игрока
    public Player getBastard(String name){
        try {
            return Bukkit.getPlayer(name);
        }
        catch (Exception exception){
            return null;
        }
    }
}
