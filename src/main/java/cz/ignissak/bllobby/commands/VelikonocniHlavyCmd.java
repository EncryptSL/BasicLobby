package cz.ignissak.bllobby.commands;

import cz.ignissak.bllobby.utils.ItemFactory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VelikonocniHlavyCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.isOp()) {
            ItemStack vajicko = ItemFactory.createHead("vajicko", "31fbf397-0e5b-4e24-9ead-410a2cc3a06b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFlZWNhMzYxNTczNGYyZGRlNjUyYzc1YzhmYjUyMGVmZjNiYTQwNWM2NTVhNWZmM2E4N2FiYzY4Yzk4MWIyIn19fQ==",
                    "§fVajicko", "§7Velikonoce 2018");
            p.getInventory().addItem(vajicko);
        }
        return true;
    }
}
