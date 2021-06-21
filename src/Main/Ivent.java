package Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Ivent implements Listener {
    @EventHandler
    public void onChat (AsyncPlayerChatEvent e){
        Player pl = e.getPlayer();
        String message = e.getMessage();
        if(message.contains("сука")){
            pl.sendMessage("Хули материшься?");
            e.setCancelled(true);
        }
    }
}
