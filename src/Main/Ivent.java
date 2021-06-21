package Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Ivent implements Listener {
    @EventHandler
    public void onBreak (BlockBreakEvent e){
        Player Pl = e.getPlayer();
        Pl.sendMessage("ТЫ ЧЕ ПИДРИЛА???");
    }
}
