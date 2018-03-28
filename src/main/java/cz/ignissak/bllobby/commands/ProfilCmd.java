package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.gui.Profil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProfilCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Core.getInstance().getConfig().getBoolean("mysql.use") == false) {
            sender.sendMessage("Profil neni mozne nacist, protoze neni spravne zapojena databaze.");
        }
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        Profil p = new Profil();
        p.Profil(player);
        return true;

    }
}
