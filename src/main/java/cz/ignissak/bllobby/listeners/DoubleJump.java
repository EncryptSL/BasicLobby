package cz.ignissak.bllobby.listeners;

import cz.ignissak.bllobby.Core;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.particle.ParticleEffect;

public class DoubleJump implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().isOnGround()) {
            if (Core.getInstance().getConfig().getStringList("doublejump.enabled-in").contains(e.getPlayer().getWorld().getName())) {
                e.getPlayer().setAllowFlight(true);
            } else {
                return;
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDoubleJump(PlayerToggleFlightEvent e) {
        Player player = (Player) e.getPlayer();
        if (Core.getInstance().getConfig().getStringList("doublejump.enabled-in").contains(player.getWorld().getName())) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                e.setCancelled(true);
                player.setFlying(false);
                player.setAllowFlight(false);
                player.setFallDistance(-256);
                player.setVelocity(player.getLocation().getDirection().multiply(1.2).setY(0.8));
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, 2, 1);
                ParticleEffect.SNOW_SHOVEL.send(Bukkit.getOnlinePlayers(), player.getLocation(), 0.1, 0.1, 0.1, 0.2, 50);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (player.isOnGround()) {
                            this.cancel();
                        }
                        if (!(Bukkit.getServer().getOnlinePlayers().contains(player))) {
                            this.cancel();
                        }
                        Location location = player.getLocation();
                        ParticleEffect.SNOW_SHOVEL.send(Bukkit.getOnlinePlayers(), location, 0.1, 0.1, 0.1, 0.1, 2);

                    }
                }.runTaskTimerAsynchronously(Core.getInstance(), 0, 0);
            }
        } else {
            return;
        }
    }
}
