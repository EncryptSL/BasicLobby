package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.gui.Smenarna;
import cz.ignissak.bllobby.utils.TPSChecker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SmenarnaCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Core.getInstance().getConfig().getBoolean("smenarna.enabled") == false || Core.getInstance().getConfig().getBoolean("mysql.use") == false) {
            sender.sendMessage(Core.getInstance().getConfig().getString("smenarna.message"));
            return true;
        }
        if (TPSChecker.getTPS() < 13.0) {
            sender.sendMessage("Momentalne nelze pouzit smenarnu, Lobby prilis laguje.");
            return true;
        } if (Core.getInstance().smenarnaCooldown.contains("oncooldown")) {
            sender.sendMessage("§cMaximalne pred minutou nekdo uz nakupoval. Chvili jeste pockej.");
            return true;
        }
        else {
            Player player = (Player) sender;
            Smenarna smenarna = new Smenarna();
            smenarna.SmenarnaMenu(player);
            return true;
        }
    }
}
