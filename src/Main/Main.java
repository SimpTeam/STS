package Main;

import Main.Commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable(){
        plugin = this;
        registerCommands();
        loadFiles();
        Bukkit.getPluginManager().registerEvents(new Ivent(),this);
    }
}
