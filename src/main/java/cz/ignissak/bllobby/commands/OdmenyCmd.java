package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.gui.DailyRewards;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OdmenyCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (Core.getInstance().getConfig().getBoolean("dailyrewards.enabled")) {
            DailyRewards dw = new DailyRewards();
            dw.DRewards(p);
            return true;
        } else {
            p.sendMessage(Core.getInstance().getConfig().getString("dailyrewards.message"));
            return true;
        }
    }
}
