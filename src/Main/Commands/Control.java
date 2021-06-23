package Main.Commands;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Control implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("С консоли команды не робят");
            return true;
        }

        Player p = (Player) sender;

        if(args.length == 0){
            p.sendMessage(Objects.requireNonNull(Main.locale.getString("no_file_msg")));
            return true;
        }

        if(args.length == 1){
            String arg = args[0].toLowerCase();

            //Перезагрузка плагина
            if("plugin".contains(arg)){
                Bukkit.getPluginManager().disablePlugin(Main.plugin);
                Bukkit.getPluginManager().enablePlugin(Main.plugin);
                p.sendMessage(Objects.requireNonNull(Main.locale.getString("reload_plugin")));
                return true;
            }
        }
        return false;
    }
}
