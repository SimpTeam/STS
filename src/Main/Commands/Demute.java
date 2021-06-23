package Main.Commands;

import Main.Main;
import Main.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Demute implements CommandExecutor {
    Utils utils = new Utils();
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
            String name = args[0];
            player.sendMessage(Objects.requireNonNull(Main.locale.getString("demute_finish")));

            Player bastard = utils.getBastard(name);
            if(bastard == null){
                player.sendMessage(Objects.requireNonNull(Main.locale.getString("no_player")));
                return true;
            }
            demute(bastard.getName());
            return true;
        }
        return false;
    }
    //Тут демутим
    private void demute (String player){
         Main.playersMap.delPunish(player);
    }
}
