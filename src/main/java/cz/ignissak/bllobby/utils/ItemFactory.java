package cz.ignissak.bllobby.utils;


import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

    public static ItemStack createHead(String name, String uuid, String textureData, String displayName, String... lore) {
        try {
            net.minecraft.server.v1_12_R1.ItemStack sHead = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.SKULL_ITEM, 1, (short) 3));

            NBTTagCompound tag = new NBTTagCompound();
            NBTTagCompound skullOwnerTag = new NBTTagCompound();
            NBTTagCompound displayTag = new NBTTagCompound();
            NBTTagCompound propertiesTag = new NBTTagCompound();

            NBTTagList tagList = new NBTTagList();

            NBTTagCompound valueTag = new NBTTagCompound();
            valueTag.setString("Value", textureData);

            tagList.add(valueTag);

            propertiesTag.set("textures", tagList);

            skullOwnerTag.setString("Id", uuid);
            skullOwnerTag.setString("Name", name);

            skullOwnerTag.set("Properties", propertiesTag);

            displayTag.setString("Name", name);

            tag.set("SkullOwner", skullOwnerTag);

            tag.set("display", displayTag);

            sHead.setTag(tag);

            ItemStack item = CraftItemStack.asBukkitCopy(sHead);

            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(displayName);
            if (lore != null) {
                ArrayList<String> finalLore = new ArrayList();
                for (String s : lore)
                    finalLore.add(s);
                itemMeta.setLore(finalLore);
            }
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            item.setItemMeta(itemMeta);

            return item;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ItemStack create(Material material, byte data, String displayName, String... lore) {
        try {
            ItemStack itemStack = new MaterialData(material, data).toItemStack(1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(displayName);
            if (lore != null) {
                List<String> finalLore = new ArrayList();
                for (String s : lore)
                    finalLore.add(s);
                itemMeta.setLore(finalLore);
            }
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            itemStack.setItemMeta(itemMeta);
            return itemStack;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ItemStack create(Material material, byte data, String displayName) {
        return create(material, data, displayName, null);
    }
}
