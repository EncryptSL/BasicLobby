package cz.ignissak.bllobby.gui;

import cz.ignissak.bllobby.SQLManager;
import cz.ignissak.bllobby.utils.BungeeFactory;
import cz.ignissak.bllobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DailyRewards {


    public void DRewards(Player p) {
        long zostavacas;
        long hodky;
        long minutky;
        long dny;
        Inventory i = Bukkit.getServer().createInventory(null, 45, "§8Odmeny");
        SQLManager sql = new SQLManager();
        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        empty.getItemMeta().setDisplayName("§f");
        empty.setItemMeta(empty.getItemMeta());

        ItemStack dailyy = new ItemStack(Material.CHEST);
        ItemMeta dailyyMeta = dailyy.getItemMeta();
        dailyyMeta.setDisplayName("§aDenni odmena");
        ArrayList<String> dailyyLore = new ArrayList<String>();
        dailyyLore.add("");
        dailyyLore.add("§7Tuto odmenu si muzes vyzvednout");
        dailyyLore.add("§7kazdy den a ziskat 50 tokenu.");
        dailyyLore.add("");
        dailyyLore.add("§aKlikni pro vyzdvihnuti.");
        dailyyMeta.setLore(dailyyLore);
        dailyy.setItemMeta(dailyyMeta);

        zostavacas = sql.getDWPrvaCooldown(p) - System.currentTimeMillis();
        hodky = TimeUnit.MILLISECONDS.toHours(zostavacas);
        minutky = TimeUnit.MILLISECONDS.toMinutes(zostavacas) % 60;
        ItemStack dailyn = new ItemStack(Material.CHEST);
        ItemMeta dailynMeta = dailyn.getItemMeta();
        dailynMeta.setDisplayName("§cDenni odmena");
        ArrayList<String> dailynLore = new ArrayList<String>();
        dailynLore.add("");
        dailynLore.add("§7Tuto odmenu si muzes vyzvednout");
        dailynLore.add("§7kazdy den a ziskat 50 tokenu.");
        dailynLore.add("");
        dailynLore.add("§cPockej jeste " + hodky + "h a " + minutky + "m" + " §cpred vyzdvihnutim.");
        dailynMeta.setLore(dailynLore);
        dailyn.setItemMeta(dailynMeta);

        ItemStack dailygoldy = new ItemStack(Material.ENDER_CHEST);
        ItemMeta goldMetay = dailygoldy.getItemMeta();
        goldMetay.setDisplayName("§aDenni odmena (GOLD)");
        ArrayList<String> dailygoldyLore = new ArrayList<String>();
        dailygoldyLore.add("");
        dailygoldyLore.add("§7Tuto odmenu si muzes vyzvednout");
        dailygoldyLore.add("§7kazdy den pokud mas GOLD VIP a vys");
        dailygoldyLore.add("§7a ziskat 150 tokenu.");
        dailygoldyLore.add("");
        dailygoldyLore.add("§aKlikni pro vyzdvihnuti.");
        goldMetay.setLore(dailygoldyLore);
        dailygoldy.setItemMeta(goldMetay);

        zostavacas = sql.getDWDruhaCooldown(p) - System.currentTimeMillis();
        hodky = TimeUnit.MILLISECONDS.toHours(zostavacas);
        minutky = TimeUnit.MILLISECONDS.toMinutes(zostavacas) % 60;
        ItemStack dailygoldn = new ItemStack(Material.ENDER_CHEST);
        ItemMeta goldMetan = dailygoldn.getItemMeta();
        goldMetan.setDisplayName("§cDenni odmena (GOLD)");
        ArrayList<String> dailygoldnLore = new ArrayList<String>();
        dailygoldnLore.add("");
        dailygoldnLore.add("§7Tuto odmenu si muzes vyzvednout");
        dailygoldnLore.add("§7kazdy den pokud mas GOLD VIP a vys");
        dailygoldnLore.add("§7a ziskat 150 tokenu.");
        dailygoldnLore.add("");
        dailygoldnLore.add("§cPockej jeste " + hodky + "h a " + minutky + "m" + " §cpred vyzdvihnutim.");
        goldMetan.setLore(dailygoldnLore);
        dailygoldn.setItemMeta(goldMetan);

        ItemStack dailygoldv = new ItemStack(Material.ENDER_CHEST);
        ItemMeta goldMetav = dailygoldn.getItemMeta();
        goldMetav.setDisplayName("§cDenni odmena (GOLD)");
        ArrayList<String> dailygoldvLore = new ArrayList<String>();
        dailygoldvLore.add("");
        dailygoldvLore.add("§7Tuto odmenu si muzes vyzvednout");
        dailygoldvLore.add("§7kazdy den pokud mas GOLD VIP a vys");
        dailygoldvLore.add("§7a ziskat 150 tokenu.");
        dailygoldvLore.add("");
        dailygoldvLore.add("§cMusis mit GOLD VIP.");
        goldMetav.setLore(dailygoldvLore);
        dailygoldv.setItemMeta(goldMetav);

        ItemStack weeklyy = new ItemStack(Material.NETHER_STAR);
        ItemMeta weeklyyMeta = weeklyy.getItemMeta();
        weeklyyMeta.setDisplayName("§aTydenni odmena (IRON)");
        ArrayList<String> weeklyyLore = new ArrayList<String>();
        weeklyyLore.add("");
        weeklyyLore.add("§7Tuto odmenu si muzes vyzvednout");
        weeklyyLore.add("§7kazdy den pokud mas IRON VIP a vys");
        weeklyyLore.add("§7a ziskat 2x coins booster na minihry.");
        weeklyyLore.add("");
        weeklyyLore.add("§aKlikni pro vyzdvihnuti.");
        weeklyyMeta.setLore(weeklyyLore);
        weeklyy.setItemMeta(weeklyyMeta); //y

        zostavacas = sql.getDWTrretiCooldown(p) - System.currentTimeMillis();
        minutky = TimeUnit.MILLISECONDS.toMinutes(zostavacas) % 60;
        dny = TimeUnit.MILLISECONDS.toDays(zostavacas);
        hodky = TimeUnit.MILLISECONDS.toHours(zostavacas) % 24;
        ItemStack weeklyn = new ItemStack(Material.NETHER_STAR);
        ItemMeta weeklynMeta = weeklyn.getItemMeta();
        weeklynMeta.setDisplayName("§cTydenni odmena (IRON)");
        ArrayList<String> weeklynLore = new ArrayList<String>();
        weeklynLore.add("");
        weeklynLore.add("§7Tuto odmenu si muzes vyzvednout");
        weeklynLore.add("§7kazdy den pokud mas IRON VIP a vys");
        weeklynLore.add("§7a ziskat 2x coins booster na minihry.");
        weeklynLore.add("");
        weeklynLore.add("§cPockej jeste " + dny + "d, " + hodky + "h a " + minutky + "m" + " §cpred vyzdvihnutim.");
        weeklynMeta.setLore(weeklynLore);
        weeklyn.setItemMeta(weeklynMeta); //y

        ItemStack weeklyv = new ItemStack(Material.NETHER_STAR);
        ItemMeta weeklyvMeta = weeklyv.getItemMeta();
        weeklyvMeta.setDisplayName("§cTydenni odmena (IRON)");
        ArrayList<String> weeklyvLore = new ArrayList<String>();
        weeklyvLore.add("");
        weeklyvLore.add("§7Tuto odmenu si muzes vyzvednout");
        weeklyvLore.add("§7kazdy den pokud mas IRON VIP a vys");
        weeklyvLore.add("§7a ziskat 2x coins booster na minihry.");
        weeklyvLore.add("");
        weeklyvLore.add("§cMusis mit IRON VIP.");
        weeklyvMeta.setLore(weeklyvLore);
        weeklyv.setItemMeta(weeklyvMeta); //y

        ItemStack comingsoon = new ItemStack(Material.BARRIER);
        ItemMeta csMeta = comingsoon.getItemMeta();
        csMeta.setDisplayName("§8Pripravujeme..");
        ArrayList<String> csLore = new ArrayList<String>();
        csLore.add("");
        csLore.add("§7Na novych odmenach prave");
        csLore.add("§7usilovne pracujeme.");
        csMeta.setLore(csLore);
        comingsoon.setItemMeta(csMeta);


        if (sql.getDWPrvaCooldown(p) < System.currentTimeMillis() || sql.getDWPrvaCooldown(p) == 0) {
            i.setItem(21, dailyy);
        }

        else if (sql.getDWPrvaCooldown(p) > System.currentTimeMillis()) {
            i.setItem(21, dailyn);
        }

        if (!(p.hasPermission("basicland.gold"))) {
            i.setItem(23, dailygoldv);
        }

        else if (p.hasPermission("basicland.gold") || p.hasPermission("*")){

            if (sql.getDWDruhaCooldown(p) < System.currentTimeMillis() || sql.getDWDruhaCooldown(p) == 0) {
                i.setItem(23, dailygoldy);
            }

            else if (sql.getDWDruhaCooldown(p) > System.currentTimeMillis()) {
                i.setItem(23, dailygoldn);
            }
        }

        if (!(p.hasPermission("basicland.iron"))) {
            i.setItem(22, weeklyv);
        }

        if (p.hasPermission("basicland.iron") || p.hasPermission("*")) {

            if (sql.getDWTrretiCooldown(p) < System.currentTimeMillis() || sql.getDWTrretiCooldown(p) == 0) {
                i.setItem(22, weeklyy);
            }

            else if (sql.getDWTrretiCooldown(p) > System.currentTimeMillis()) {
                i.setItem(22, weeklyn);
            }
        }
        //i.setItem(14 + 9, comingsoon);
        i.setItem(0, empty);
        i.setItem(1, empty);
        i.setItem(2, empty);
        i.setItem(3, empty);
        i.setItem(4, empty);
        i.setItem(5, empty);
        i.setItem(6, empty);
        i.setItem(7, empty);
        i.setItem(8, empty); //1 riadok
        i.setItem(9, empty);
        i.setItem(17, empty); //2 riadok
        i.setItem(18, empty);
        i.setItem(26, empty); //3 riadok
        i.setItem(27, empty);
        i.setItem(35, empty); //4 riadok
        i.setItem(36, empty);
        i.setItem(37, empty);
        i.setItem(38, empty);
        i.setItem(39, empty);
        i.setItem(40, empty);
        i.setItem(41, empty);
        i.setItem(42, empty);
        i.setItem(43, empty);
        i.setItem(44, empty);





        p.openInventory(i);
    }
}
