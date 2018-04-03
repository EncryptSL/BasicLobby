package cz.ignissak.bllobby.gui;

import cz.ignissak.bllobby.SQLManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Smenarna {

    public void SmenarnaMenu(Player p) {
        SQLManager sql = new SQLManager();
        Inventory i = Bukkit.createInventory(null, 45, "§8Smenarna");

        ItemStack info = new ItemStack(Material.PAPER, 1);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName("§9Statistiky");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add("");
        infoLore.add("§7Pocet tvych tokenu: §9" + NumberFormat.getNumberInstance(Locale.US).format(sql.getCoins(p.getUniqueId())));
        infoLore.add("§7Minute penize: §9" + NumberFormat.getNumberInstance(Locale.US).format(sql.getSmenarnaPenize()));
        infoLore.add("§7Pocet transakci: §9" + NumberFormat.getNumberInstance(Locale.US).format(sql.getSmenarnaTransakce()));
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);

        ItemStack one = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta oneMeta = one.getItemMeta();
        oneMeta.setDisplayName("§9Zakladni mystery box");
        ArrayList<String> oneLore = new ArrayList<>();
        oneLore.add("§e✰§f✰✰✰✰");
        oneLore.add("");
        oneLore.add("§7Velika sance dostat common");
        oneLore.add("§7doplnky a mala sance ziskat");
        oneLore.add("§7vzacne doplnky.");
        oneLore.add("§7Cena: §9300 tokenu");
        oneMeta.setLore(oneLore);
        one.setItemMeta(oneMeta);

        ItemStack two = new ItemStack(Material.ENDER_CHEST, 2);
        ItemMeta twoMeta = two.getItemMeta();
        twoMeta.setDisplayName("§9Pokrocily mystery box");
        ArrayList<String> twoLore = new ArrayList<>();
        twoLore.add("§e✰✰§f✰✰✰");
        twoLore.add("");
        twoLore.add("§7Velka sance dostat common");
        twoLore.add("§7doplnky a vetsi sance ziskat");
        twoLore.add("§7rare nebo epic doplnky.");
        twoLore.add("§7Cena: §9500 tokenu");
        twoMeta.setLore(twoLore);
        two.setItemMeta(twoMeta);

        ItemStack three = new ItemStack(Material.ENDER_CHEST, 3);
        ItemMeta threeMeta = three.getItemMeta();
        threeMeta.setDisplayName("§9Mystery box pro narocne");
        ArrayList<String> threeLore = new ArrayList<>();
        threeLore.add("§e✰✰✰§f✰✰");
        threeLore.add("");
        threeLore.add("§7Mensi sance dostat common");
        threeLore.add("§7doplnky a velka sance ziskat");
        threeLore.add("§7rare nebo epic doplnky.");
        threeLore.add("§7Cena: §9750 tokenu");
        threeMeta.setLore(threeLore);
        three.setItemMeta(threeMeta);

        ItemStack four = new ItemStack(Material.ENDER_CHEST, 4);
        ItemMeta fourMeta = four.getItemMeta();
        fourMeta.setDisplayName("§9Profesionalni mystery box");
        ArrayList<String> fourLore = new ArrayList<>();
        fourLore.add("§e✰✰✰✰§f✰");
        fourLore.add("");
        fourLore.add("§7Mensi sance dostat common");
        fourLore.add("§7doplnky a velka sance ziskat");
        fourLore.add("§7rare nebo epic doplnky.");
        fourLore.add("§7Cena: §91000 tokenu");
        fourMeta.setLore(fourLore);
        four.setItemMeta(fourMeta);

        ItemStack five = new ItemStack(Material.ENDER_CHEST, 5);
        ItemMeta fiveMeta = five.getItemMeta();
        fiveMeta.setDisplayName("§9Specialni mystery box");
        ArrayList<String> fiveLore = new ArrayList<>();
        fiveLore.add("§e✰✰✰✰✰");
        fiveLore.add("");
        fiveLore.add("§7Mala sance dostat common");
        fiveLore.add("§7doplnky a velika sance ziskat");
        fiveLore.add("§7rare, epic nebo legendarni doplnky.");
        fiveLore.add("§7Cena: §91250 tokenu");
        fiveMeta.setLore(fiveLore);
        five.setItemMeta(fiveMeta);

        i.setItem(13, info);
        i.setItem(20, one);
        i.setItem(21, two);
        i.setItem(22, three);
        i.setItem(23, four);
        i.setItem(24, five);

        p.openInventory(i);
    }
}
