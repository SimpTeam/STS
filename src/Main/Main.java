package Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable(){
        getCommand("gm").setExecutor(new Comm());
        Bukkit.getPluginManager().registerEvents(new Ivent(),this);
    }
}
