package Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Ivent implements Listener {
    Utils utils = new Utils();
    @EventHandler
    public void onChat (AsyncPlayerChatEvent e){
        Player pl = e.getPlayer();
        String message = e.getMessage();
        if(Main.playersMap.inList(pl.getName())){
            pl.sendMessage(utils.chat(Main.locale.getString("cant_write_msg")));
            e.setCancelled(true);
        }
    }
}
