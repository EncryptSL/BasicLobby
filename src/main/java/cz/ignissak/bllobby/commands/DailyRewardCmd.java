package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.gui.DailyRewards;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DailyRewardCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (Core.getInstance().getConfig().getBoolean("dailyrewards.enabled") == true) {
                Player player = (Player) sender;
                    DailyRewards dw = new DailyRewards();
                    dw.DRewards(player);
                    return true;
            } else {
                sender.sendMessage(Core.getInstance().getConfig().getString("dailyrewards.message"));
                return true;
            }
        }
        return true;
    }
}
