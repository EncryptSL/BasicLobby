package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.gui.Vip;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VipCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Vip vip = new Vip();
        Player player = (Player) sender;
        vip.VipMenu(player);
        return true;
    }
}
