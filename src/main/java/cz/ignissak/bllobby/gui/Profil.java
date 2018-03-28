package cz.ignissak.bllobby.gui;

import cz.ignissak.bllobby.SQLManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Profil {
    public int swStats(Player p) {
        SQLManager sql = new SQLManager();
        sql.getSWStats(p);
        return 0;
    }

    public void Profil(Player p) {
        SQLManager sql = new SQLManager();
        Inventory i = Bukkit.createInventory(null, 54, "§8Tvuj profil");

        SkullMeta headItemMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        headItemMeta.setOwner(p.getName());
        headItemMeta.setDisplayName("§bZakladni statistiky");
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ArrayList<String> headLore = new ArrayList<String>();
        headLore.add("");
        headLore.add("§7Zakladni statistiky, ktere si nikam");
        headLore.add("§7jinam zatim nehodi.");
        headLore.add("");
        headLore.add("§fTvoje Auth ID: §b#" + sql.getAuthId(p));
        headLore.add("§fPocet tokenu: §b" + NumberFormat.getNumberInstance(Locale.US).format(sql.getCoins(p.getUniqueId())));
        headLore.add("§fPocet hlasu (celkem): §b" + sql.getTotalVotes(p.getUniqueId()));
        headLore.add("§fPocet hlasu (mesic): §b" + sql.getMonthlyVotes(p.getUniqueId()));
        headLore.add("§fPocet hlasu (tyden): §b" + sql.getWeeklyVotes(p.getUniqueId()));
        headItemMeta.setLore(headLore);
        headItem.setItemMeta(headItemMeta);
        i.setItem(13, headItem);

        ItemStack murder = new ItemStack(Material.IRON_SWORD);
        ItemMeta murdermeta = murder.getItemMeta();
        murdermeta.setDisplayName("§eMurder Mystery");
        ArrayList<String> murderLore = new ArrayList<String>();
        murderLore.add("");
        murderLore.add("§fScore: §e" + sql.getMurderScore(p));
        murderLore.add("§fPocet vyher: §e" + sql.getMurderWins(p));
        murderLore.add("§fPocet proher: §e" + sql.getMurderLoses(p));
        murderLore.add("§fPocet killu: §e" + sql.getMurderKills(p));
        murderLore.add("§fPocet smrti: §e" + sql.getMurderDeaths(p));
        murdermeta.setLore(murderLore);
        murder.setItemMeta(murdermeta);
        i.setItem(30, murder);

        ItemStack getdown = new ItemStack(Material.SEA_LANTERN);
        ItemMeta getdownmeta = getdown.getItemMeta();
        getdownmeta.setDisplayName("§dGetDown");
        ArrayList<String> getdownLore = new ArrayList<String>();
        getdownLore.add("");
        getdownLore.add("§fPocet zhozeni: §d" + sql.getGTKills(p.getUniqueId()));
        getdownLore.add("§fPocet spadnuti: §d" + sql.getGTDeaths(p.getUniqueId()));
        getdownLore.add("§fPocet vyher: §d" + sql.getGTWins(p.getUniqueId()));
        getdownLore.add("§fPocet killu: §d" + sql.getGTPvpkills(p.getUniqueId()));
        getdownLore.add("§fPocet smrti: §d" + sql.getGTPvpdeaths(p.getUniqueId()));
        getdownLore.add("§fPocet vyher v pvp: §d" + sql.getGTPvpwins(p.getUniqueId()));
        getdownLore.add("§fPocet odhranych her: §d" + sql.getGTPlayed(p.getUniqueId()));
        getdownLore.add("§fNejvice coinu za hru: §d" + sql.getGTMostcoins(p.getUniqueId()));
        getdownmeta.setLore(getdownLore);
        getdown.setItemMeta(getdownmeta);
        i.setItem(31, getdown);

        ItemStack kitpvp = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta kitpvpmeta = kitpvp.getItemMeta();
        kitpvpmeta.setDisplayName("§3KitPvP");
        ArrayList<String> kitpvpLore = new ArrayList<String>();
        kitpvpLore.add("");
        kitpvpLore.add("§fPocet coinu: §3" + sql.getKBCoins(p));
        kitpvpLore.add("§fPocet killu: §3" + sql.getKBKills(p));
        kitpvpLore.add("§fPocet smrti: §3" + sql.getKBDeaths(p));
        kitpvpLore.add("§fPocet exp: §3" + sql.getKBExp(p));
        kitpvpLore.add("§fPocet kit-unlockeru: §3" + sql.getKBKitunlockers(p));
        kitpvpmeta.setLore(kitpvpLore);
        kitpvp.setItemMeta(kitpvpmeta);
        i.setItem(32, kitpvp);

        ItemStack speedbuilders = new ItemStack(Material.BRICK);
        ItemMeta sbmeta = speedbuilders.getItemMeta();
        sbmeta.setDisplayName("§2SpeedBuilders");
        ArrayList<String> sbLore = new ArrayList<String>();
        sbLore.add("");
        sbLore.add("§fPocet vyher: §2" + sql.getSBWins(p));
        sbLore.add("§fPocet proher: §2" + sql.getSBLosses(p));
        sbLore.add("§fPocet 100% staveb: §2" + sql.getSBPbuilds(p));
        sbmeta.setLore(sbLore);
        speedbuilders.setItemMeta(sbmeta);
        i.setItem(39, speedbuilders);

        ItemStack uhc = new ItemStack(Material.APPLE);
        ItemMeta uhcmeta = uhc.getItemMeta();
        uhcmeta.setDisplayName("§cUHC");
        ArrayList<String> uhcLore = new ArrayList<String>();
        uhcLore.add("");
        uhcLore.add("§7Tato minihrahra uz");
        uhcLore.add("§7je zrusena.");
        uhcLore.add("");
        uhcLore.add("§fPocet vyher: §c" + sql.getUHCWins(p.getUniqueId()));
        uhcLore.add("§fPocet proher: §c" + sql.getUHCLosses(p.getUniqueId()));
        uhcLore.add("§fPocet smrti: §c" + sql.getUHCDeaths(p.getUniqueId()));
        uhcLore.add("§fPocet killu: §c" + sql.getUHCKills(p.getUniqueId()));
        uhcLore.add("§fPocet odehranych her: §c" + sql.getUHCGameplayed(p.getUniqueId()));
        uhcmeta.setLore(uhcLore);
        uhc.setItemMeta(uhcmeta);
        //i.setItem(40, uhc);

        ItemStack sw = new ItemStack(Material.BOW);
        String[] parts = sql.getSWStats(p).split(":");
        String[] inv = sql.getSWKits(p).split(":");
        ItemMeta swmeta = sw.getItemMeta();
        swmeta.setDisplayName("§9SkyWars");
        ArrayList<String> swLore = new ArrayList<String>();
        if (sql.getSWStats(p) != "0") {
            swLore.add("");
            swLore.add("§fPocet killu: §9" + parts[0]);
            swLore.add("§fPocet smrti: §9" + parts[2]);
            swLore.add("§fPocet vyher: §9" + parts[3]);
            swLore.add("§fPocet coinu: §9" + parts[1]);
            swLore.add("§fPocet veci v inventari: §9" + inv.length);
            swLore.add("§f");
        } else {
            swLore.add("");
            swLore.add("§7Nastal problem s databazi,");
            swLore.add("§7vypadato, ze jsi nikdy nehral");
            swLore.add("§7SkyWars hehe :D");
        }
        swmeta.setLore(swLore);
        sw.setItemMeta(swmeta);
        i.setItem(40, sw);


        p.openInventory(i);

    }
}
