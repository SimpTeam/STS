package MainPack;

import MainPack.Commands.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    public static FileConfiguration config;
    public static FileConfiguration locale;
    public static File configFile;
    public static File localeFile;

    public static Plugin plugin;
    public static PlayersMap playersMap;

    public void onEnable(){
        plugin = this;
        registerCommands();
        loadFiles();
        Bukkit.getPluginManager().registerEvents(new Ivent(),this);
        playersMap = new PlayersMap();
    }

    //Метод загрузки конфигурационных файлов (locale и config)
    private void loadFiles(){
        if(!new File(getDataFolder() + File.separator + "config.yml").exists()){
            saveResource("config.yml", false);
        }
        configFile = new File(getDataFolder() + File.separator + "config.yml");
        config = YamlConfiguration.loadConfiguration(new File(getDataFolder() + File.separator + "config.yml"));

        if(!new File(getDataFolder() + File.separator + "locale.yml").exists()){
            saveResource("locale.yml", false);
        }
        localeFile = new File(getDataFolder() + File.separator + "locale.yml");
        locale = YamlConfiguration.loadConfiguration(new File(getDataFolder() + File.separator + "locale.yml"));
    }

    //Регистрация команд
    private void registerCommands(){
        getCommand("gm").setExecutor(new gm());
        getCommand("mute").setExecutor(new Mute());
        getCommand("demute").setExecutor(new Demute());
        getCommand("stsreload").setExecutor(new Control());
    }
}
