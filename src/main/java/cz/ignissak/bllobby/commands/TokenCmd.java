package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.gui.Smenarna;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokenCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length == 1 ) {
                if (args[0].equalsIgnoreCase("shop")) {
                    Player player = (Player) sender;
                    Smenarna smenarna = new Smenarna();
                    smenarna.SmenarnaMenu(player);
                    return true;
                }
            }
        return true;
    }
}
