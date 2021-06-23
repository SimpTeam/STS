package Main.Commands;

import Main.Main;
import Main.Utils;
import Main.Punishment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Mute implements CommandExecutor {
    Utils utils = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command comm, String lbl, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Кыш консоль");
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage(Objects.requireNonNull(utils.chat(Main.locale.getString("no_args_msg"))));
            return true;
        }
        if (args.length == 1){
            player.sendMessage(Objects.requireNonNull(utils.chat(Main.locale.getString("no_time_msg"))));
            return true;
        }
        if (args.length == 2){
            String name = args[0];
            int min;
            //Получаем время мута
            try {
                min = Integer.parseInt(args[1]);
            }
            catch (Exception exception){ //если нельзя преобразовать в int
                player.sendMessage();
                return true;
            }

            Player bastard = utils.getBastard(name);
            if(bastard == null){
                player.sendMessage(Objects.requireNonNull(Main.locale.getString("no_player")));
                return true;
            }

            mute(bastard.getName(), min);
            player.sendMessage(utils.chat(Main.locale.getString("mute_finish")));
            return true;
        }
        return false;
    }
    //Тут матим
    private void mute (String player, int time){
        Main.playersMap.setPunish(player, new Punishment(time));
    }
}
