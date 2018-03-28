package cz.ignissak.bllobby.listeners;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.SQLManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerJoin implements Listener {

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        List<String> motd = Core.getInstance().getConfig().getStringList("motd");
        motd.forEach((s) -> {
            e.getPlayer().sendMessage(s);
        });
        SQLManager sql = new SQLManager();
        if (sql.hasDWdata(e.getPlayer()) == false) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[DB] Hrac " + e.getPlayer().getName() + " zapsan do database!");
            sql.instertDWdata(e.getPlayer());
        }
    }
}
