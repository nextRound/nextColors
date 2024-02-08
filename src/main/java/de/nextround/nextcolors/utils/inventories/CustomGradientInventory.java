package de.nextround.nextcolors.utils.inventories;

/*
 *
 *
 *    █▀▀▄ █▀▀ █ █ ▀▀█▀▀ ░█▀▀█ █▀▀█ █   █▀▀█ █▀▀█ █▀▀
 *    █  █ █▀▀ ▄▀▄   █   ░█    █  █ █   █  █ █▄▄▀ ▀▀█
 *    ▀  ▀ ▀▀▀ ▀ ▀   ▀   ░█▄▄█ ▀▀▀▀ ▀▀▀ ▀▀▀▀ ▀ ▀▀ ▀▀▀
 *
 *    Project: nextColors
 *    Author: Nicole Scheitler (nextRound)
 *    Copyright - GNU GPLv3 (C) Nicole Scheitler
 *
 *
 */

import de.nextround.nextcolors.utils.NCPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.LinkedList;
import java.util.List;

public class CustomGradientInventory {

    public static void openSelectInventory(Player player) {
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        Inventory inv = Bukkit.createInventory(null, 45, "§9Own Color Gradients");

        /*
         *   Creates the Background for the Inventory
         */

        ItemStack backgroundItemStack = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
        ItemMeta backgroundItemMeta = backgroundItemStack.getItemMeta();
        backgroundItemMeta.setDisplayName(" ");
        backgroundItemStack.setItemMeta(backgroundItemMeta);

        for (int i = 0; i <= 44; i++) {
            inv.setItem(i, backgroundItemStack);
        }

        ItemStack secondaryBackgroundItemStack = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta secondaryBackgroundItemMeta = secondaryBackgroundItemStack.getItemMeta();
        secondaryBackgroundItemMeta.setDisplayName(" ");
        secondaryBackgroundItemStack.setItemMeta(secondaryBackgroundItemMeta);

        for (int i = 36; i <= 44; i++) {
            inv.setItem(i, secondaryBackgroundItemStack);
        }

        if (!ncPlayer.getColorGradients().getGradientList().isEmpty()) {
            for(int i = 0; i < ncPlayer.getColorGradients().getGradientList().size(); i++) {
                if(i < 36) {
                    ItemStack gradientItemStack = new ItemStack(Material.getMaterial((String) ncPlayer.getColorGradients().getGradientList().get(i).get(0)), 1);
                    ItemMeta gradientItemMeta = gradientItemStack.getItemMeta();
                    List<String> gradientLore = new LinkedList<String>();
                    gradientItemMeta.setDisplayName("§9Color Gradient §8-§f§l " + (i+1));
                    if(ncPlayer.getColorGradients().getSelectedGradient() == i) {
                        gradientItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    }
                    gradientLore.add(" ");
                    gradientLore.add("§l§7➥ §r§oLeftclick to");
                    gradientLore.add("  §r§oselect Color Gradient!");
                    gradientLore.add(" ");
                    gradientLore.add("§l§7➥ §r§oRightclick to");
                    gradientLore.add("  §r§oedit Color Gradient!");
                    gradientItemMeta.setLore(gradientLore);
                    gradientItemStack.setItemMeta(gradientItemMeta);

                    inv.setItem(i, gradientItemStack);
                }else{
                    i = ncPlayer.getColorGradients().getGradientList().size();
                }
            }
        }

        if(ncPlayer.getColorGradients().getNumberOfGradients() > 36) {
            ItemStack scrollRightItemStack = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta scrollRightItemMeta = (SkullMeta) scrollRightItemStack.getItemMeta();
            scrollRightItemMeta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowRight"));
            scrollRightItemMeta.setDisplayName("§f§lNext Page");
            scrollRightItemStack.setItemMeta(scrollRightItemMeta);

            inv.setItem(42, scrollRightItemStack);
        }

        ItemStack createNewItemStack = new ItemStack(Material.LIME_DYE, 1);
        ItemMeta createNewItemMeta = createNewItemStack.getItemMeta();
        createNewItemMeta.setDisplayName("§f§lNEW§r §8- §9Color Gradient");
        List<String> createNewLore = new LinkedList<String>();
        createNewLore.add(" ");
        createNewLore.add("§l§7➥ §r§oLeftclick to");
        createNewLore.add("  §r§ocreate own Color Gradient!");
        createNewItemMeta.setLore(createNewLore);
        createNewItemStack.setItemMeta(createNewItemMeta);

        inv.setItem(40, createNewItemStack);

        player.openInventory(inv);
    }

    public static void openCreateInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 45, "§9New Color Gradient");

        /*
         *   Creates the Background for the Inventory
         */

        ItemStack placeholderItemStack = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta placeholderItemMeta = placeholderItemStack.getItemMeta();
        placeholderItemMeta.setDisplayName(" ");
        placeholderItemStack.setItemMeta(placeholderItemMeta);

        inv.setItem(0, placeholderItemStack);

        ItemStack backgroundItemStack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta backgroundItemMeta = backgroundItemStack.getItemMeta();
        backgroundItemMeta.setDisplayName(" ");
        backgroundItemStack.setItemMeta(backgroundItemMeta);

        for (int i = 1; i <= 44; i++) {
            inv.setItem(i, backgroundItemStack);
        }

        ItemStack secondaryBackgroundItemStack = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta secondaryBackgroundItemMeta = secondaryBackgroundItemStack.getItemMeta();
        secondaryBackgroundItemMeta.setDisplayName(" ");
        secondaryBackgroundItemStack.setItemMeta(secondaryBackgroundItemMeta);

        for (int i = 36; i <= 44; i++) {
            inv.setItem(i, secondaryBackgroundItemStack);
        }

        ItemStack saveGradientItemStack = new ItemStack(Material.EMERALD, 1);
        ItemMeta saveGradientItemMeta = saveGradientItemStack.getItemMeta();
        saveGradientItemMeta.setDisplayName("§f§lSAVE§r §8- §9Color Gradient");
        List<String> saveGradientLore = new LinkedList<String>();
        saveGradientLore.add(" ");
        saveGradientLore.add("§l§7➥ §r§oLeftclick to");
        saveGradientLore.add("  §r§oSAVE your Color Gradient!");
        saveGradientItemMeta.setLore(saveGradientLore);
        saveGradientItemStack.setItemMeta(saveGradientItemMeta);

        inv.setItem(40, saveGradientItemStack);

        player.openInventory(inv);
    }

    public static void openEditInventory(Player player, List<String> blockList) {
        Inventory inv = Bukkit.createInventory(null, 45, "§9Edit Color Gradient");

        /*
         *   Creates the Background for the Inventory
         */

        ItemStack placeholderItemStack = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta placeholderItemMeta = placeholderItemStack.getItemMeta();
        placeholderItemMeta.setDisplayName(" ");
        placeholderItemStack.setItemMeta(placeholderItemMeta);

        inv.setItem(0, placeholderItemStack);

        ItemStack backgroundItemStack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta backgroundItemMeta = backgroundItemStack.getItemMeta();
        backgroundItemMeta.setDisplayName(" ");
        backgroundItemStack.setItemMeta(backgroundItemMeta);

        for (int i = 1; i <= 44; i++) {
            inv.setItem(i, backgroundItemStack);
        }

        ItemStack secondaryBackgroundItemStack = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta secondaryBackgroundItemMeta = secondaryBackgroundItemStack.getItemMeta();
        secondaryBackgroundItemMeta.setDisplayName(" ");
        secondaryBackgroundItemStack.setItemMeta(secondaryBackgroundItemMeta);

        for (int i = 36; i <= 44; i++) {
            inv.setItem(i, secondaryBackgroundItemStack);
        }

        for(int i = 0; i < blockList.size(); i++) {
            ItemStack cursorItem = new ItemStack(Material.getMaterial(blockList.get(i)), 1);
            inv.setItem(i, cursorItem);
            inv.setItem(i + 1, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
        }

        ItemStack saveGradientItemStack = new ItemStack(Material.EMERALD, 1);
        ItemMeta saveGradientItemMeta = saveGradientItemStack.getItemMeta();
        saveGradientItemMeta.setDisplayName("§f§lSAVE§r §8- §9Color Gradient");
        List<String> saveGradientLore = new LinkedList<String>();
        saveGradientLore.add(" ");
        saveGradientLore.add("§l§7➥ §r§oLeftclick to");
        saveGradientLore.add("  §r§oSAVE your Color Gradient!");
        saveGradientItemMeta.setLore(saveGradientLore);
        saveGradientItemStack.setItemMeta(saveGradientItemMeta);

        inv.setItem(40, saveGradientItemStack);

        ItemStack deleteGradientItemStack = new ItemStack(Material.RED_DYE, 1);
        ItemMeta deleteGradientItemMeta = saveGradientItemStack.getItemMeta();
        deleteGradientItemMeta.setDisplayName("§4§lDELETE§r §8- §9Color Gradient");
        List<String> deleteGradientLore = new LinkedList<String>();
        deleteGradientLore.add(" ");
        deleteGradientLore.add("§l§7➥ §r§oLeftclick to");
        deleteGradientLore.add("  §r§oDELETE your Color Gradient!");
        deleteGradientItemMeta.setLore(deleteGradientLore);
        deleteGradientItemStack.setItemMeta(deleteGradientItemMeta);

        inv.setItem(44, deleteGradientItemStack);

        player.openInventory(inv);
    }
}
