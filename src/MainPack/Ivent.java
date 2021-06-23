package MainPack;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

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

    @EventHandler
    public void onEnter(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String name = p.getName();

        if(Main.playersMap.inLater(name)){
            Main.playersMap.setPunish(name, new Punishment(Main.playersMap.getLaterMap().get(name)));
            Main.playersMap.delLater(name);
            p.sendMessage("Вы были замучены");
        }
    }
}
