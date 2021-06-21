package Main.Commands;

import Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Demute implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command comm, String lbl, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Иди нахуй консоль");
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage(Objects.requireNonNull(Main.locale.getString("demute_noname_msg")));
            return true;
        }
        if(args.length == 1){
            player.sendMessage("Игрок размучен");
            return true;
        }

        return false;
    }
}
