package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.utils.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sk.Adin.PMenu.Main;

public class BasicLobbyCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("basicland.admin")) {
            if (args.length == 0) {
                player.sendMessage("Verze pluginu: §a" + Bukkit.getServer().getPluginManager().getPlugin("BasicLobby").getDescription().getVersion());
                if (Bukkit.getServer().getPluginManager().getPlugin("UltraMenu") != null) {
                    player.sendMessage("Verze UltraMenuAPI: §a" + Bukkit.getServer().getPluginManager().getPlugin("UltraMenu").getDescription().getVersion());
                }
                if (Bukkit.getServer().getPluginManager().getPlugin("UltraMenu") == null) {
                    player.sendMessage("Verze UltraMENUAPI: §cNENAINSTALOVANO");
                }
                if (Bukkit.getServer().getPluginManager().getPlugin("GadgetsMenu") != null) {
                    player.sendMessage("Verze GadgetsMenuAPI: §a" + Bukkit.getServer().getPluginManager().getPlugin("GadgetsMenu").getDescription().getVersion());
                }
                if (Bukkit.getServer().getPluginManager().getPlugin("GadgetsMenu") == null) {
                    player.sendMessage("Verze GadgetsMenuAPI: §cNENAINSTALOVANO");
                }
                if (Bukkit.getServer().getPluginManager().getPlugin("Coins") != null) {
                    player.sendMessage("Verze CoinsAPI: §a" + Bukkit.getServer().getPluginManager().getPlugin("Coins").getDescription().getVersion());
                }
                if (Bukkit.getServer().getPluginManager().getPlugin("Coins") == null) {
                    player.sendMessage("Verze CoinsAPI: §cNENAINSTALOVANO");
                }
                player.sendMessage("Verze TitleAPI: §a1.7.5");
                player.sendMessage("Verze HikariCP: §aLATEST");
                player.sendMessage("Reload: §a/bl <reload/reset>");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    long then = System.currentTimeMillis();
                    Core.getInstance().reloadConfig();
                    long now = System.currentTimeMillis() - then;
                    player.sendMessage("§aConfigurace reloadnuta za §f" + now + "ms§a.");
                    return true;
                } if (args[0].equalsIgnoreCase("reset")) {
                    Core.getInstance().smenarnaCooldown.remove("oncooldown");
                    player.sendMessage("§aCooldowny vymazany.");
                    return true;
                } else {
                    player.sendMessage("§cNeplatny prikaz.");
                    return true;
                }
            }
        } else {
            player.sendMessage("§cNedostatecna opravneni.");
            return true;
        }
        return true;
    }
}
