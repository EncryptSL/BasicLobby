package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.utils.BungeeFactory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.hasPermission("basicland.dev")) {
            //BungeeFactory.setCount(p, "surv18");
            BungeeFactory.getServerName(p);
            //sender.sendMessage("Surv 1.8 players: " + BungeeFactory.getCount("surv18"));
            sender.sendMessage("Si na serveri: " + BungeeFactory.kdeJe.get(p.getName()));
        }
        return true;
    }
}
