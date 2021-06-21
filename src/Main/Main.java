package Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable(){
        getCommand("gm").setExecutor(new Comm());
    }
}
