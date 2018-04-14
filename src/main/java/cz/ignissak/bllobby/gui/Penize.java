package cz.ignissak.bllobby.gui;

import cz.ignissak.bllobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Penize {

    public void PenizeMenu(Player p) {
        Inventory i = Bukkit.createInventory(null, 36, "§8Zakoupeni tokenu");

        ItemStack acz = ItemFactory.create(Material.IRON_BLOCK, (byte) 0, "§c[CZ] §715,000 tokenu (20kc)", "§f", "§fKlikni pro zobrazeni SMS formatu", "§fpro Ceskou republiku.");
        i.setItem(12, acz);

        ItemStack ask = ItemFactory.create(Material.BARRIER, (byte) 0, "§9[SK] §715,000 tokenu", "§f", "§fTento obnos tokenu neni mozne", "§fpro SK zakoupit.");
        i.setItem(21, ask);

        ItemStack bcz = ItemFactory.create(Material.GOLD_BLOCK, (byte) 0, "§c[CZ] §740,000 tokenu (50kc)", "§f", "§fKlikni pro zobrazeni SMS formatu", "§fpro Ceskou republiku.");
        i.setItem(13, bcz);

        ItemStack bsk = ItemFactory.create(Material.GOLD_BLOCK, (byte) 0, "§9[SK] §740,000 tokenu (2e)", "§f", "§fKlikni pro zobrazeni SMS formatu", "§fpro Slovenskou republiku.");
        i.setItem(22, bsk);

        ItemStack ccz = ItemFactory.create(Material.EMERALD_BLOCK, (byte) 0, "§c[CZ] §7100,000 tokenu (99kc)", "§f", "§fKlikni pro zobrazeni SMS formatu", "§fpro Ceskou republiku.");
        i.setItem(14, ccz);

        ItemStack csk = ItemFactory.create(Material.EMERALD_BLOCK, (byte) 0, "§9[SK] §7100,000 tokenu (4e)", "§f", "§fKlikni pro zobrazeni SMS formatu", "§fpro Slovenskou republiku.");
        i.setItem(23, csk);

        p.openInventory(i);
    }
}
