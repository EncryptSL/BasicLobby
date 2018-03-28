package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.gui.Penize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PenizeCmd implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Penize penize = new Penize();
        penize.PenizeMenu(player);
        return true;
    }
}
