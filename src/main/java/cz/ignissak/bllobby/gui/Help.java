package cz.ignissak.bllobby.gui;

import cz.ignissak.bllobby.Core;
import cz.ignissak.bllobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import sk.Adin.PMenu.API.UltraMenuAPI;


import java.util.ArrayList;


public class Help implements Listener {

    public void menuHelp(Player p) {
        Inventory inv = Bukkit.getServer().createInventory(null, 54, "§8Basicland.cz");

        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta profilMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        profilMeta.setOwner(p.getName());
        profilMeta.setDisplayName("§dTvuj profil");
        ArrayList<String> profilLore = new ArrayList<String>();
        profilLore.add("");
        profilLore.add("§7Klikni zde pro presmerovani");
        profilLore.add("§7na tvuj profil.");
        profilMeta.setLore(profilLore);
        headItem.setItemMeta(profilMeta);
        inv.setItem(12, headItem);

        ItemStack dolary = ItemFactory.create(Material.DIAMOND, (byte) 0, "§5Dolary", "§f",
                "§7Kup si herni menu na", "§7servery a financne podpor", "§7vyvoj a provoz serveru.");
        inv.setItem(13, dolary);

        ItemStack feedback = ItemFactory.create(Material.BOOK_AND_QUILL, (byte) 0, "§aFeedback", "§f",
                "§7Nasel jsi bug nebo mas", "§7napad jak vylepsit server?", "§7Klikni sem a zdel ho nam.");
        inv.setItem(14, feedback);

        ItemStack servers = ItemFactory.create(Material.COMPASS, (byte) 0, "§3Vyber serveru", "§f",
                "§7Vyber si z velike sklay serveru", "§7zda jsou to minihry nebo survival,", "§7kazdy si zde prijde na svoje.");
        inv.setItem(20, servers);

        ItemStack vote = ItemFactory.create(Material.PAPER, (byte) 0, "§6Hlasovani pro server", "§f",
                "§7Podpor server tvym hlasovanim", "§7a ziskej hlasovaci klice na serverech", "§7a zadalsi milniky moznost vyhrat", "§7VIP ranky na 3 dny.");
        inv.setItem(21, vote);

        ItemStack vip = ItemFactory.create(Material.GOLD_INGOT, (byte) 0, "§eVIP ranky", "§f",
                "§7Ziskej specialni vip rank,", "§7ktery poskytuje specialni vyhody", "§7a financne tim podporis", "§7vyvoj a provoz serveru.");
        inv.setItem(22, vip);

        ItemStack smenarna = ItemFactory.create(Material.ENDER_CHEST, (byte) 0, "§bSmenarna pro tokeny", "§f",
                "§7Vymen tokeny z miniher za", "§7boxy a ziskej specialni", "§7doplnky na Lobby!");
        inv.setItem(23, smenarna);

        ItemStack pravidla = ItemFactory.create(Material.FERMENTED_SPIDER_EYE, (byte) 0, "§cPravidla serveru", "§f",
                "§7Pro hrani na nasem serveru", "§7si musis nejdrive precist", "§7pravidla a dodrzovat je.");
        inv.setItem(24, pravidla);

        ItemStack discord = cz.ignissak.bllobby.utils.ItemFactory.createHead("Discord", "e431cd1-ae1d-49f6-9339-a96daeacc32b",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19",
                "§9Discord server", "§7", "§7Klikni pro zobrazeni invite", "§7linku na nas discord server.");
        inv.setItem(39, discord);

        ItemStack facebook = cz.ignissak.bllobby.utils.ItemFactory.createHead("Facebook",
                "804954f3-c401-4d50-a348-c4d2cb0503fe",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0=",
                "§9Facebook", "§f", "§7Klikni pro zobrazeni linku", "§7na nasi facebook stranku.");
        inv.setItem(40, facebook);

        ItemStack web = cz.ignissak.bllobby.utils.ItemFactory.createHead("Web", "c424243d-0421-4774-8aeb-2ddea957ed57",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5MzZkNGYwZDFiOTNmZWY3NzViMWZiZDE5MjgxYjcwYzZmODg0NzViYjVhNDFiZjM3MmMxMmYxZjhhMjIifX19",
                "§9Web", "§f", "§7Klikni pro zobrazeni linku", "§7na nasi webovou stranku.");
        inv.setItem(41, web);

        ItemStack ts3 = ItemFactory.createHead("TS3", "19bcd707-8caa-4f87-ae68-9cc5988f3293",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q5ZjNjYzdkNmJiYjYzYWM1ZDM4ZjM2NWU3NTM3ZTM3YjU4NjU3M2RjODc4ZWUxZWU2OGM2YThmYjkzZjIifX19",
                "§9TeamSpeak 3", "§f", "§7Klikni pro zobrazeni IP", "§7adresy na nas TeamSpeak server.");
        inv.setItem(38, ts3);

        ItemStack faq = ItemFactory.createHead("FAQ", "4800431a-9635-4316-8820-d5ed1cb15590",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDIzZWFlZmJkNTgxMTU5Mzg0Mjc0Y2RiYmQ1NzZjZWQ4MmViNzI0MjNmMmVhODg3MTI0ZjllZDMzYTY4NzJjIn19fQ==",
                "§9FAQ", "§f", "§7Klimni pro zobrazeni linku", "§7na stranku s FAQ.");
        inv.setItem(42, faq);

        p.openInventory(inv);
    }
    @EventHandler
    public void InventoryInteract(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("§8Basicland.cz")) {
            e.setCancelled(true);
            if (e.getSlot() == 12) {
                p.closeInventory();
                p.performCommand("profil");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 13) {
                p.closeInventory();
                p.performCommand("penize");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 14) {
                p.closeInventory();
                p.performCommand("feedback");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 20) {
                p.closeInventory();
                UltraMenuAPI.openNormalMenu(p, "servers.yml");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 21) {
                p.closeInventory();
                Core.getInstance().sendToServer(p, "vote");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 22) {
                p.closeInventory();
                p.performCommand("vip");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 23) {
                p.closeInventory();
                p.performCommand("warp smenarna");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 24) {
                p.closeInventory();
                p.performCommand("pravidla");
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
            } else if (e.getSlot() == 39) {
                p.closeInventory();
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                p.sendMessage("");
                p.sendMessage("§7Odkaz na nas Discord server:");
                p.sendMessage("§ehttps://discord.gg/jmYZpb6");
                p.sendMessage("");
            } else if (e.getSlot() == 40) {
                p.closeInventory();
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                p.sendMessage("");
                p.sendMessage("§7Odkaz na nasi Facebook stranku:");
                p.sendMessage("§ehttps://www.facebook.com/basicland.cz");
                p.sendMessage("");
            } else if (e.getSlot() == 41) {
                p.closeInventory();
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                p.sendMessage("");
                p.sendMessage("§7Odkaz na nasi stranku:");
                p.sendMessage("§ehttps://basicland.cz/");
                p.sendMessage("");
            } else if (e.getSlot() == 38) {
                p.closeInventory();
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                p.sendMessage("");
                p.sendMessage("§7IP adresa na TeamSpeak server:");
                p.sendMessage("§ets3.basicland.cz");
                p.sendMessage("");
            } else if (e.getSlot() == 42) {
                p.closeInventory();
                p.playSound(e.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                p.sendMessage("");
                p.sendMessage("§7Odkaz na stranku s FAQ:");
                p.sendMessage("§ehttps://basicland.cz/faq");
                p.sendMessage("");
            }
        }
    }
}
