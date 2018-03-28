package cz.ignissak.bllobby.listeners;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.SQLManager;
import cz.ignissak.bllobby.utils.TitleAPI;
import net.nifheim.beelzebu.coins.CoinsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.inventivetalent.particle.ParticleEffect;

public class InventoryClick implements Listener {

    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        SQLManager sql = new SQLManager();
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("§8Tvuj profil")) {
            e.setCancelled(true);
        } if (e.getInventory().getTitle().equals("§8Odmeny")) {
            e.setCancelled(true);
            if (e.getSlot() == 12) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§aDenni odmena")) {
                    sql.setDWPrvaCooldown(p);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "token give " + e.getWhoClicked().getName() + " 50");
                    e.getWhoClicked().sendMessage("§aDenni odmena byla vyzdvihnuta.");
                    p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                    ParticleEffect.VILLAGER_HAPPY.send(Bukkit.getOnlinePlayers(), e.getWhoClicked().getLocation(), 1, 1, 1, 10, 30);
                    e.getWhoClicked().closeInventory();
                    return;
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cDenni odmena")){
                    p.playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
            } else if (e.getSlot() == 13) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§aDenni odmena (GOLD)")) {
                    sql.setDWDruhaCooldown(p);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "token give " + e.getWhoClicked().getName() + " 150");
                    e.getWhoClicked().sendMessage("§aDenni odmena (GOLD) byla vyzdvihnuta.");
                    p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                    ParticleEffect.VILLAGER_HAPPY.send(Bukkit.getOnlinePlayers(), e.getWhoClicked().getLocation(), 1, 1, 1, 10, 30);
                    e.getWhoClicked().closeInventory();
                    return;
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cDenni odmena (GOLD)")){
                    p.playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
            }else if (e.getSlot() == 14) {
                    p.playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
        } if (e.getInventory().getTitle().equals("§8Smenarna")) {
            e.setCancelled(true);
            if (e.getSlot() == 20) { //1
                if (sql.getCoins(p.getUniqueId()) >= 300) {
                    TitleAPI.sendPlayerTitle(p, 10, 30, 10, "§a§lPLATBA USPESNA", "§fNakup byl ukoncen.");
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gmysteryboxes give " + p.getName() + " 1 1");
                    CoinsAPI.takeCoins(p.getUniqueId(), 300);
                    p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                    Core.getInstance().smenarnaCooldown.add("oncooldown");
                    sql.addSmenarnaPenize(300);
                    sql.addSmenarnaTransakce(1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Core.getInstance().smenarnaCooldown.remove("oncooldown");
                        }
                    }.runTaskLater(Core.getPlugin(Core.class), Core.getInstance().getConfig().getInt("smenarna.cooldown") * 20);
                    p.closeInventory();
                } else {
                    Bukkit.getPlayer(e.getWhoClicked().getName()).getWorld().playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
            } if (e.getSlot() == 21) { //2
                if (sql.getCoins(p.getUniqueId()) >= 500) {
                    TitleAPI.sendPlayerTitle(p, 10, 30, 10, "§a§lPLATBA USPESNA", "§fNakup byl ukoncen.");
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gmysteryboxes give " + p.getName() + " 1 2");
                    CoinsAPI.takeCoins(p.getUniqueId(), 500);
                    p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                    Core.getInstance().smenarnaCooldown.add("oncooldown");
                    sql.addSmenarnaPenize(500);
                    sql.addSmenarnaTransakce(1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Core.getInstance().smenarnaCooldown.remove("oncooldown");
                        }
                    }.runTaskLater(Core.getPlugin(Core.class), Core.getInstance().getConfig().getInt("smenarna.cooldown") * 20);
                    p.closeInventory();
                } else {
                    Bukkit.getPlayer(e.getWhoClicked().getName()).getWorld().playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
            } if (e.getSlot() == 22) { //3
                if (sql.getCoins(p.getUniqueId()) >= 750) {
                    TitleAPI.sendPlayerTitle(p, 10, 30, 10, "§a§lPLATBA USPESNA", "§fNakup byl ukoncen.");
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gmysteryboxes give " + p.getName() + " 1 3");
                    CoinsAPI.takeCoins(p.getUniqueId(), 750);
                    p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                    Core.getInstance().smenarnaCooldown.add("oncooldown");
                    sql.addSmenarnaPenize(750);
                    sql.addSmenarnaTransakce(1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Core.getInstance().smenarnaCooldown.remove("oncooldown");
                        }
                    }.runTaskLater(Core.getPlugin(Core.class), Core.getInstance().getConfig().getInt("smenarna.cooldown") * 20);
                    p.closeInventory();
                } else {
                    Bukkit.getPlayer(e.getWhoClicked().getName()).getWorld().playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
            } if (e.getSlot() == 23) { //4
                if (sql.getCoins(p.getUniqueId()) >= 1000) {
                    TitleAPI.sendPlayerTitle(p, 10, 30, 10, "§a§lPLATBA USPESNA", "§fNakup byl ukoncen.");
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gmysteryboxes give " + p.getName() + " 1 4");
                    CoinsAPI.takeCoins(p.getUniqueId(), 1000);
                    p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                    Core.getInstance().smenarnaCooldown.add("oncooldown");
                    sql.addSmenarnaPenize(1000);
                    sql.addSmenarnaTransakce(1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Core.getInstance().smenarnaCooldown.remove("oncooldown");
                        }
                    }.runTaskLater(Core.getPlugin(Core.class), Core.getInstance().getConfig().getInt("smenarna.cooldown") * 20);
                    p.closeInventory();
                } else {
                    Bukkit.getPlayer(e.getWhoClicked().getName()).getWorld().playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
            } if (e.getSlot() == 24) { //5
                if (sql.getCoins(p.getUniqueId()) >= 1250) {
                    TitleAPI.sendPlayerTitle(p, 10, 30, 10, "§a§lPLATBA USPESNA", "§fNakup byl ukoncen.");
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gmysteryboxes give " + p.getName() + " 1 5");
                    CoinsAPI.takeCoins(p.getUniqueId(), 1250);
                    p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                    sql.addSmenarnaPenize(1250);
                    sql.addSmenarnaTransakce(1);
                    Core.getInstance().smenarnaCooldown.add("oncooldown");
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Core.getInstance().smenarnaCooldown.remove("oncooldown");
                        }
                    }.runTaskLater(Core.getPlugin(Core.class), Core.getInstance().getConfig().getInt("smenarna.cooldown") * 20);
                    p.closeInventory();
                } else {
                    Bukkit.getPlayer(e.getWhoClicked().getName()).getWorld().playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 0);
                    return;
                }
            }
        } if (e.getInventory().getTitle().equals("§8Zakoupeni tokenu")) {
            e.setCancelled(true);
            if (e.getSlot() == 12) { //cz 15k
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage("§7TVAR SMS: §fcsmc s144178 " + p.getName());
                p.sendMessage("§7CISLO: §f9033320");
                p.sendMessage("§7CENA SMS: §f20 korun ceskych");
                p.sendMessage("");
            } if (e.getSlot() == 13) { //cz 40k
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage("§eTVAR SMS: §fcsmc s144178 " + p.getName());
                p.sendMessage("§eCISLO: §f9033350");
                p.sendMessage("§eCENA SMS: §f50 korun ceskych");
                p.sendMessage("");
            } if (e.getSlot() == 14) { //cz 100k
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage("§aTVAR SMS: §fcsmc s144178 " + p.getName());
                p.sendMessage("§aCISLO: §f9033399");
                p.sendMessage("§aCENA SMS: §f100 korun ceskych");
                p.sendMessage("");
            } if (e.getSlot() == 22) { //sk 40k
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage("§aTVAR SMS: §fcsmc 2 s144178 " + p.getName());
                p.sendMessage("§aCISLO: §f8877");
                p.sendMessage("§aCENA SMS: §f2 eura");
                p.sendMessage("");
            } if (e.getSlot() == 23) { //sk 100k
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage("§aTVAR SMS: §fcsmc 4 s144178 " + p.getName());
                p.sendMessage("§aCISLO: §f8877");
                p.sendMessage("§aCENA SMS: §f4 eura");
                p.sendMessage("");
            }
        } if (e.getInventory().getTitle().equals("§8VIP")) {
            e.setCancelled(true);
        }
    }
}
