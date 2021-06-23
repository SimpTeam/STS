package Main.Commands;

import Main.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command com, String s, String[] str) {
        if(!(Sender instanceof Player)){
            System.out.println("Бан сука тебе");
            return true;
        }
        Player Pl = (Player) Sender;
        if (str.length == 1){
            String word = str[0];
            if(word.equals("1")){
                Pl.setGameMode(GameMode.CREATIVE);
                Pl.sendMessage("Установлен режим 'Креатив'");
                return true;
            }
            if(word.equals("0")){
                Pl.setGameMode(GameMode.SURVIVAL);
                Pl.sendMessage("Установлен режим 'Выживание'");
                return true;
            }
            if(word.equals("2")){
                Pl.setGameMode(GameMode.SPECTATOR);
                Pl.sendMessage(" Вы Гарик Куколд Харламов");
            }
            else{
                Pl.sendMessage("Завали ебало");
            }
            return true;
        }
        return false;
    }
}
