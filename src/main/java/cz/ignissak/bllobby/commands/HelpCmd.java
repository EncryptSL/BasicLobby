package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.gui.Help;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1) {
            if (sender.hasPermission("basicland.admin")) {
                Bukkit.dispatchCommand(sender, "bukkit:help " + args[0]);
            } else {
                Help help = new Help();
                help.menuHelp(player);
                return true;
            }
        } else {
            Help help = new Help();
            help.menuHelp(player);
            return true;
        }
        return true;
    }
}
