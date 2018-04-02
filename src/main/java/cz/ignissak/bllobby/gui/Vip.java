package cz.ignissak.bllobby.gui;

import cz.ignissak.bllobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Vip {

    public void VipMenu(Player p) {
        Inventory i = Bukkit.getServer().createInventory(null, 45, "§8VIP");

        ItemStack ironcz = ItemFactory.create(Material.IRON_BLOCK, (byte) 0, "§7IRON", "§cSMS pro CR", "§f", "§7Cena: §f50 kc", "§7Delka trvani: §f30 + 5 dni", "§7Cislo: §f9033350", "§7Tvar: §fcsmc s122151 " + p.getName(),
                "§f", "§7Cena: §f149 kc", "§7Delka trvani: §fPERMA", "§7Cislo: §f90333", "§7Tvar: §fcsmc 149 s122151 " + p.getName());
        i.setItem(10, ironcz);

        ItemStack ironsk = ItemFactory.create(Material.IRON_BLOCK, (byte) 0, "§7IRON", "§cSMS pro SR", "§f", "§7Cena: §f2 EUR", "§7Delka trvani: §f30 + 5 dni", "§7Cislo: §f8877", "§7Tvar: §fcsmc 2 s122151 " + p.getName(),
        "§f", "§7Cena: §f6 EUR", "§7Delka trvani: §fPERMA", "§7Cislo: §f8877", "§7Tvar: §fcsmc 6 s122151 " + p.getName());
        i.setItem(19, ironsk);

        ItemStack goldcz = ItemFactory.create(Material.GOLD_BLOCK, (byte) 0, "§6GOLD", "§cSMS pro CR", "§f", "§6Cena: §f79 kc", "§6Delka trvani: §f30 + 5 dni", "§6Cislo: §f9033379", "§6Tvar: §fcsmc s122151 " + p.getName(),
                "§f", "§6Cena: §f249 kc", "§6Delka trvani: §fPERMA", "§6Cislo: §f90333", "§6Tvar: §fcsmc 249 s122151 " + p.getName());
        i.setItem(12, goldcz);

        ItemStack goldsk = ItemFactory.create(Material.GOLD_BLOCK, (byte) 0, "§6GOLD", "§cSMS pro SR", "§f", "§6Cena: §f3 EUR", "§6Delka trvani: §f30 + 5 dni", "§6Cislo: §f8877", "§6Tvar: §fcsmc 3 s122151 " + p.getName(),
                "§f", "§6Cena: §f10 EUR ", "§6Delka trvani: §fPERMA", "§6Cislo: §f8877", "§6Tvar: §fcsmc 10 s122151 " + p.getName());
        i.setItem(21, goldsk);

        ItemStack diacz = ItemFactory.create(Material.DIAMOND_BLOCK, (byte) 0, "§bDIAMOND", "§cSMS pro CR", "§f", "§bCena: §f99 kc", "§bDelka trvani: §f30 + 5 dni", "§bCislo: §f9033399", "§bTvar: §fcsmc s122151 " + p.getName(),
                "§f", "§bCena: §f299 kc", "§bDelka trvani: §fPERMA", "§bCislo: §f90333", "§bTvar: §fcsmc 299 s122151 " + p.getName());
        i.setItem(14, diacz);

        ItemStack diask = ItemFactory.create(Material.DIAMOND_BLOCK, (byte) 0, "§bDIAMOND", "§cSMS pro SR", "§f", "§bCena: §f4 EUR", "§bDelka trvani: §f30 + 5 dni", "§bCislo: §f8877", "§bTvar: §fcsmc 4 s122151 " + p.getName(),
                "§f", "§bCena: §f12 EUR ", "§bDelka trvani: §fPERMA", "§bCislo: §f8877", "§bTvar: §fcsmc 12 s122151 " + p.getName());
        i.setItem(23, diask);

        ItemStack emecz = ItemFactory.create(Material.EMERALD_BLOCK, (byte) 0, "§2EMERALD", "§cSMS pro CR", "§f", "§2Cena: §f499 kc", "§2Delka trvani: §fPERMA", "§2Cislo: §f90333", "§2Tvar: §fcsmc 499 s122151 " + p.getName());
        i.setItem(16, emecz);

        ItemStack emesk = ItemFactory.create(Material.EMERALD_BLOCK, (byte) 0, "§2EMERALD", "§cSMS pro SR", "§f", "§2Cena: §f20 EUR", "§2Delka trvani: §fPERMA", "§2Cislo: §f8877", "§2Tvar: §fcsmc 20 s122151 " + p.getName());
        i.setItem(25, emesk);

        ItemStack ironvyhody = ItemFactory.create(Material.PAPER, (byte) 0, "§fIRON VYHODY", "§f", "§fTvoreni shopu, sleva v AShopu, rezervovany slot", "§fhat, feed, vetsi island a res,", "§fvice /sethome, kity, back, WE na creativu.", "§f",
                "§7Vsechny vyhody na strance:", "§fwww.basicland.cz/vip-vyhody");
        i.setItem(28, ironvyhody);

        ItemStack goldvyhody = ItemFactory.create(Material.PAPER, (byte) 0, "§6GOLD VYHODY", "§f", "§fVsechny IRON VIP vyhody,", "§ffly, heal, vice res, kity, zmena biomu, vice /sethome,", "§fzustavani inventare, sleva v AShopu.", "§f",
                "§6Vsechny vyhody na strance:", "§fwww.basicland.cz/vip-vyhody");
        i.setItem(30, goldvyhody);

        ItemStack diavyhody = ItemFactory.create(Material.PAPER, (byte) 0, "§bDIAMOND VYHODY", "§f", "§fVsechny GOLD VIP vyhody,","§fkit na spawner, vice res, vice /sethome,", "§ffix, sleva v AShopu, zmena pocasi a casu.", "§f",
                "§bVsechny vyhody na strance:", "§fwww.basicland.cz/vip-vyhody");
        i.setItem(32, diavyhody);

        ItemStack emevyhody = ItemFactory.create(Material.PAPER, (byte) 0, "§2EMERALD VYHODY", "§f", "§fVsechny DIAMOND VIP vyhody,", "§fsleva v AShopu, vice /sethome,", "§fvlastni kratky suffix za jmenem.", "§f",
                "§2Vsechny vyhody na strance:", "§fwww.basicland.cz/vip-vyhody");
        i.setItem(34, emevyhody);


        p.openInventory(i);
    }
}