package Main.Commands;

import Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Mute implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command comm, String lbl, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Кыш консоль");
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage(Objects.requireNonNull(Main.locale.getString("no_args_msg")));
            return true;
        }
        if (args.length == 1){
            player.sendMessage(Objects.requireNonNull(Main.locale.getString("no_time_msg")));
            return true;
        }
        if (args.length == 2){
            player.sendMessage("Игрок в муте");
        }
        return false;
    }
    //Тут матим
    private void mute (){

    }

    //Тут получаем игрока
    private Player getBastard(String name){
        return  null;
    }
}
