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

import de.nextround.nextcolors.utils.Brush;
import de.nextround.nextcolors.utils.NCPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;

public class MainInventory {

    public static void openInventory(Player player) {

        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        Inventory inv = Bukkit.createInventory(null, 45, "§9nextColors");

       /*
        *   Creates the Background for all Inventories
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

        inv.setItem(3, secondaryBackgroundItemStack);
        inv.setItem(5, secondaryBackgroundItemStack);

        inv.setItem(11, secondaryBackgroundItemStack);
        inv.setItem(15, secondaryBackgroundItemStack);

        inv.setItem(29, secondaryBackgroundItemStack);
        inv.setItem(33, secondaryBackgroundItemStack);

        inv.setItem(39, secondaryBackgroundItemStack);
        inv.setItem(41, secondaryBackgroundItemStack);

       /*
        *   Sets the brush items (Normal & Splatter)
        */
        if (ncPlayer.getBrushType() == Brush.BrushType.SPHERE) {
            ItemStack normalBrushItemStack = new ItemStack(Material.FIREWORK_STAR, 1);
            ItemMeta normalBrushItemMeta = normalBrushItemStack.getItemMeta();
            normalBrushItemMeta.setDisplayName("§9Brush §8- §f§lNormal Brush");
            List<String> normalBrushLore = new LinkedList<String>();
            normalBrushLore.add(" ");
            normalBrushLore.add("§l§7➥ §r§oLeftclick to");
            normalBrushLore.add("  §r§oselect your brush-type!");
            normalBrushItemMeta.setLore(normalBrushLore);
            normalBrushItemStack.setItemMeta(normalBrushItemMeta);

            inv.setItem(4, normalBrushItemStack);
        } else if (ncPlayer.getBrushType() == Brush.BrushType.SPLATTER) {
            ItemStack splatterBrushItemStack = new ItemStack(Material.MELON_SEEDS, 1);
            ItemMeta splatterBrushItemMeta = splatterBrushItemStack.getItemMeta();
            splatterBrushItemMeta.setDisplayName("§9Brush §8- §f§lSplatter Brush");
            List<String> splatterBrushLore = new LinkedList<String>();
            splatterBrushLore.add(" ");
            splatterBrushLore.add("§l§7➥ §r§oLeftclick to");
            splatterBrushLore.add("  §r§oselect your brush-type!");
            splatterBrushItemMeta.setLore(splatterBrushLore);
            splatterBrushItemStack.setItemMeta(splatterBrushItemMeta);

            inv.setItem(4, splatterBrushItemStack);
        }

       /*
        *   Sets the brush chance item in the inventory
        */
        ItemStack brushChanceItemStack = new ItemStack(Material.GOLD_BLOCK, 1);
        ItemMeta brushChanceItemMeta = brushChanceItemStack.getItemMeta();
        brushChanceItemMeta.setDisplayName("§9Brush chance §8- §f§l"+ncPlayer.getPercentage()+"%");
        List<String> brushChanceLore = new LinkedList<String>();
        brushChanceLore.add(" ");
        brushChanceLore.add("§l§7➥ §r§oLeftclick to add!");
        brushChanceLore.add(" ");
        brushChanceLore.add("§l§7➥ §r§oRightclick to remove!");
        brushChanceItemMeta.setLore(brushChanceLore);
        brushChanceItemStack.setItemMeta(brushChanceItemMeta);

        inv.setItem(20, brushChanceItemStack);

       /*
        *   Sets the brush size item in the inventory
        */
        ItemStack brushSizeItemStack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta brushSizeItemMeta = brushSizeItemStack.getItemMeta();
        brushSizeItemMeta.setDisplayName("§9Size §8- §f§l" + ncPlayer.getSize());
        List<String> brushSizeLore = new LinkedList<String>();
        brushSizeLore.add(" ");
        brushSizeLore.add("§l§7➥ §r§oLeftclick to add!");
        brushSizeLore.add(" ");
        brushSizeLore.add("§l§7➥ §r§oRightclick to remove!");
        brushSizeItemMeta.setLore(brushSizeLore);
        brushSizeItemStack.setItemMeta(brushSizeItemMeta);

        inv.setItem(24, brushSizeItemStack);

       /*
        *   Checks which mode is active to open the right Inventory
        */
        if(ncPlayer.getMode() == 0) {

           /*
            *   Sets mask item in the inventory
            */
            if (ncPlayer.getMaskMode() == 0) {
                ItemStack maskEnabledItemStack = new ItemStack(Material.SKELETON_SKULL, 1);
                ItemMeta maskEnabledItemMeta = maskEnabledItemStack.getItemMeta();
                maskEnabledItemMeta.setDisplayName("§9Mask §8- §4§lDisabled");
                List<String> maskEnabledLore = new LinkedList<String>();
                maskEnabledLore.add(" ");
                maskEnabledLore.add("§l§7➥ §r§oLeftclick to");
                maskEnabledLore.add("  §r§otoggle!");
                maskEnabledItemMeta.setLore(maskEnabledLore);
                maskEnabledItemStack.setItemMeta(maskEnabledItemMeta);

                inv.setItem(40, maskEnabledItemStack);
            } else if (ncPlayer.getMaskMode() == 1) {
                ItemStack maskEnabledItemStack = new ItemStack(Material.CARVED_PUMPKIN, 1);
                ItemMeta maskEnabledItemMeta = maskEnabledItemStack.getItemMeta();
                maskEnabledItemMeta.setDisplayName("§9Mask §8- §f§lColor Gradient");
                List<String> maskEnabledLore = new LinkedList<String>();
                maskEnabledLore.add(" ");
                maskEnabledLore.add("§l§7➥ §r§oLeftclick to");
                maskEnabledLore.add("  §r§otoggle!");
                maskEnabledLore.add(" ");
                maskEnabledLore.add("§l§7➥ §r§oRightclick to");
                maskEnabledLore.add("  §r§oedit mask!");
                maskEnabledItemMeta.setLore(maskEnabledLore);
                maskEnabledItemStack.setItemMeta(maskEnabledItemMeta);

                inv.setItem(40, maskEnabledItemStack);
            }

           /*
            *   Sets the mode item in the inventory for "Default"
            */
            ItemStack toggleModeItemStack = new ItemStack(Material.NOTE_BLOCK, 1);
            ItemMeta toggleModeItemMeta = toggleModeItemStack.getItemMeta();
            toggleModeItemMeta.setDisplayName("§9Mode §8- §f§lDefault");
            List<String> toggleModeLore = new LinkedList<String>();
            toggleModeLore.add(" ");
            toggleModeLore.add("§l§7➥ §r§oLeftclick to");
            toggleModeLore.add("  §r§oselect your mode!");
            toggleModeLore.add(" ");
            toggleModeLore.add("  §r§l» §3§lDefault");
            toggleModeLore.add("  §r« §3Own Color Gradient");
            toggleModeItemMeta.setLore(toggleModeLore);
            toggleModeItemStack.setItemMeta(toggleModeItemMeta);

            inv.setItem(22, toggleModeItemStack);


        }else if(ncPlayer.getMode() == 1) {

           /*
            *   Sets the mode item in the inventory for "Own Color Gradient"
            */
            ItemStack toggleModeItemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
            ItemMeta toggleModeItemMeta = toggleModeItemStack.getItemMeta();
            toggleModeItemMeta.setDisplayName("§9Mode §8- §f§lOwn Color Gradient");
            List<String> toggleModeLore = new LinkedList<String>();
            toggleModeLore.add(" ");
            toggleModeLore.add("§l§7➥ §r§oLeftclick to");
            toggleModeLore.add("  §r§oselect your mode!");
            toggleModeLore.add(" ");
            toggleModeLore.add("  §r« §3Default");
            toggleModeLore.add("  §r§l» §3§lOwn Color Gradient");
            toggleModeItemMeta.setLore(toggleModeLore);
            toggleModeItemStack.setItemMeta(toggleModeItemMeta);

            inv.setItem(22, toggleModeItemStack);

           /*
            *   Sets own color gradient item in the inventory
            */
            ItemStack createColorGradientItemStack = new ItemStack(Material.MUSIC_DISC_WAIT, 1);
            ItemMeta createColorGradientItemMeta = createColorGradientItemStack.getItemMeta();
            createColorGradientItemMeta.setDisplayName("§9Create own §f§lColor Gradient");
            List<String> createColorGradientLore = new LinkedList<String>();
            createColorGradientLore.add(" ");
            createColorGradientLore.add("§l§7➥ §r§oLeftclick to");
            createColorGradientLore.add("  §r§ocreate your own Color Gradient!");
            createColorGradientItemMeta.setLore(createColorGradientLore);
            createColorGradientItemStack.setItemMeta(createColorGradientItemMeta);

            inv.setItem(40, createColorGradientItemStack);
        }

        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);

        player.openInventory(inv);
    }

    public static void openMaskInventory(Player player) {
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());
        Inventory inv = Bukkit.createInventory(null, 36, "§9Mask");

        /*
         *   Creates the Background for the Inventory
         */

        ItemStack secondaryBackgroundItemStack = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta secondaryBackgroundItemMeta = secondaryBackgroundItemStack.getItemMeta();
        secondaryBackgroundItemMeta.setDisplayName(" ");
        secondaryBackgroundItemStack.setItemMeta(secondaryBackgroundItemMeta);

        for (int i = 27; i <= 35; i++) {
            inv.setItem(i, secondaryBackgroundItemStack);
        }

        ItemStack backItemStack = new ItemStack(Material.EMERALD, 1);
        ItemMeta backItemMeta = backItemStack.getItemMeta();
        backItemMeta.setDisplayName("§f§lBACK");
        List<String> backLore = new LinkedList<String>();
        backLore.add(" ");
        backLore.add("§l§7➥ §r§oLeftclick to");
        backLore.add("  §r§ogo back!");
        backItemMeta.setLore(backLore);
        backItemStack.setItemMeta(backItemMeta);

        inv.setItem(31, backItemStack);

        ItemStack redMaskItemStack = new ItemStack(Material.RED_WOOL, 1);
        ItemMeta redMaskItemMeta = redMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isRed()) {
            redMaskItemMeta.setDisplayName("§c§lRed Gradient §8- §f§lEnabled");
            redMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            redMaskItemMeta.setDisplayName("§c§lRed Gradient §8- §4§lDisabled");
        }
        List<String> redMaskLore = new LinkedList<String>();
        redMaskLore.add(" ");
        redMaskLore.add("§l§7➥ §r§oLeftclick to");
        redMaskLore.add("  §r§otoggle the mask for the");
        redMaskLore.add("  §r§ored gradient on and off.");
        redMaskItemMeta.setLore(redMaskLore);
        redMaskItemStack.setItemMeta(redMaskItemMeta);

        inv.setItem(0, redMaskItemStack);

        ItemStack orangeMaskItemStack = new ItemStack(Material.ORANGE_WOOL, 1);
        ItemMeta orangeMaskItemMeta = orangeMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isOrange()) {
            orangeMaskItemMeta.setDisplayName("§6§lOrange Gradient §8- §f§lEnabled");
            orangeMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            orangeMaskItemMeta.setDisplayName("§6§lOrange Gradient §8- §4§lDisabled");
        }
        List<String> orangeMaskLore = new LinkedList<String>();
        orangeMaskLore.add(" ");
        orangeMaskLore.add("§l§7➥ §r§oLeftclick to");
        orangeMaskLore.add("  §r§otoggle the mask for the");
        orangeMaskLore.add("  §r§oorange gradient on and off.");
        orangeMaskItemMeta.setLore(orangeMaskLore);
        orangeMaskItemStack.setItemMeta(orangeMaskItemMeta);

        inv.setItem(1, orangeMaskItemStack);

        ItemStack yellowMaskItemStack = new ItemStack(Material.YELLOW_WOOL, 1);
        ItemMeta yellowMaskItemMeta = yellowMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isYellow()) {
            yellowMaskItemMeta.setDisplayName("§e§lYellow Gradient §8- §f§lEnabled");
            yellowMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            yellowMaskItemMeta.setDisplayName("§e§lYellow Gradient §8- §4§lDisabled");
        }
        List<String> yellowMaskLore = new LinkedList<String>();
        yellowMaskLore.add(" ");
        yellowMaskLore.add("§l§7➥ §r§oLeftclick to");
        yellowMaskLore.add("  §r§otoggle the mask for the");
        yellowMaskLore.add("  §r§oyellow gradient on and off.");
        yellowMaskItemMeta.setLore(yellowMaskLore);
        yellowMaskItemStack.setItemMeta(yellowMaskItemMeta);

        inv.setItem(2, yellowMaskItemStack);

        ItemStack greenMaskItemStack = new ItemStack(Material.LIME_WOOL, 1);
        ItemMeta greenMaskItemMeta = greenMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isGreen()) {
            greenMaskItemMeta.setDisplayName("§a§lGreen Gradient §8- §f§lEnabled");
            greenMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            greenMaskItemMeta.setDisplayName("§a§lGreen Gradient §8- §4§lDisabled");
        }
        List<String> greenMaskLore = new LinkedList<String>();
        greenMaskLore.add(" ");
        greenMaskLore.add("§l§7➥ §r§oLeftclick to");
        greenMaskLore.add("  §r§otoggle the mask for the");
        greenMaskLore.add("  §r§ogreen gradient on and off.");
        greenMaskItemMeta.setLore(greenMaskLore);
        greenMaskItemStack.setItemMeta(greenMaskItemMeta);

        inv.setItem(3, greenMaskItemStack);

        ItemStack blueMaskItemStack = new ItemStack(Material.LIGHT_BLUE_WOOL, 1);
        ItemMeta blueMaskItemMeta = blueMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isBlue()) {
            blueMaskItemMeta.setDisplayName("§b§lBlue Gradient §8- §f§lEnabled");
            blueMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            blueMaskItemMeta.setDisplayName("§b§lBlue Gradient §8- §4§lDisabled");
        }
        List<String> blueMaskLore = new LinkedList<String>();
        blueMaskLore.add(" ");
        blueMaskLore.add("§l§7➥ §r§oLeftclick to");
        blueMaskLore.add("  §r§otoggle the mask for the");
        blueMaskLore.add("  §r§oblue gradient on and off.");
        blueMaskItemMeta.setLore(blueMaskLore);
        blueMaskItemStack.setItemMeta(blueMaskItemMeta);

        inv.setItem(4, blueMaskItemStack);

        ItemStack pinkMaskItemStack = new ItemStack(Material.PINK_WOOL, 1);
        ItemMeta pinkMaskItemMeta = pinkMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isPink()) {
            pinkMaskItemMeta.setDisplayName("§d§lPink Gradient §8- §f§lEnabled");
            pinkMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            pinkMaskItemMeta.setDisplayName("§d§lPink Gradient §8- §4§lDisabled");
        }
        List<String> pinkMaskLore = new LinkedList<String>();
        pinkMaskLore.add(" ");
        pinkMaskLore.add("§l§7➥ §r§oLeftclick to");
        pinkMaskLore.add("  §r§otoggle the mask for the");
        pinkMaskLore.add("  §r§opink gradient on and off.");
        pinkMaskItemMeta.setLore(pinkMaskLore);
        pinkMaskItemStack.setItemMeta(pinkMaskItemMeta);

        inv.setItem(5, pinkMaskItemStack);

        ItemStack purpleMaskItemStack = new ItemStack(Material.PURPLE_WOOL, 1);
        ItemMeta purpleMaskItemMeta = purpleMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isPurple()) {
            purpleMaskItemMeta.setDisplayName("§5§lPurple Gradient §8- §f§lEnabled");
            purpleMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            purpleMaskItemMeta.setDisplayName("§5§lPurple Gradient §8- §4§lDisabled");
        }
        List<String> purpleMaskLore = new LinkedList<String>();
        purpleMaskLore.add(" ");
        purpleMaskLore.add("§l§7➥ §r§oLeftclick to");
        purpleMaskLore.add("  §r§otoggle the mask for the");
        purpleMaskLore.add("  §r§opurple gradient on and off.");
        purpleMaskItemMeta.setLore(purpleMaskLore);
        purpleMaskItemStack.setItemMeta(purpleMaskItemMeta);

        inv.setItem(6, purpleMaskItemStack);

        ItemStack greyMaskItemStack = new ItemStack(Material.LIGHT_GRAY_WOOL, 1);
        ItemMeta greyMaskItemMeta = greyMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isGrey()) {
            greyMaskItemMeta.setDisplayName("§7§lGrey Gradient §8- §f§lEnabled");
            greyMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            greyMaskItemMeta.setDisplayName("§7§lGrey Gradient §8- §4§lDisabled");
        }
        List<String> greyMaskLore = new LinkedList<String>();
        greyMaskLore.add(" ");
        greyMaskLore.add("§l§7➥ §r§oLeftclick to");
        greyMaskLore.add("  §r§otoggle the mask for the");
        greyMaskLore.add("  §r§ogrey gradient on and off.");
        greyMaskItemMeta.setLore(greyMaskLore);
        greyMaskItemStack.setItemMeta(greyMaskItemMeta);

        inv.setItem(7, greyMaskItemStack);

        ItemStack brownMaskItemStack = new ItemStack(Material.BROWN_WOOL, 1);
        ItemMeta brownMaskItemMeta = brownMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isBrown()) {
            brownMaskItemMeta.setDisplayName("§8§lBrown Gradient §8- §f§lEnabled");
            brownMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            brownMaskItemMeta.setDisplayName("§8§lBrown Gradient §8- §4§lDisabled");
        }
        List<String> brownMaskLore = new LinkedList<String>();
        brownMaskLore.add(" ");
        brownMaskLore.add("§l§7➥ §r§oLeftclick to");
        brownMaskLore.add("  §r§otoggle the mask for the");
        brownMaskLore.add("  §r§obrown gradient on and off.");
        brownMaskItemMeta.setLore(brownMaskLore);
        brownMaskItemStack.setItemMeta(brownMaskItemMeta);

        inv.setItem(8, brownMaskItemStack);

        ItemStack redGlassMaskItemStack = new ItemStack(Material.RED_STAINED_GLASS, 1);
        ItemMeta redGlassMaskItemMeta = redGlassMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isRedGlass()) {
            redGlassMaskItemMeta.setDisplayName("§c§lRed Glass Gradient §8- §f§lEnabled");
            redGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            redGlassMaskItemMeta.setDisplayName("§c§lRed Glass Gradient §8- §4§lDisabled");
        }
        List<String> redGlassMaskLore = new LinkedList<String>();
        redGlassMaskLore.add(" ");
        redGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
        redGlassMaskLore.add("  §r§otoggle the mask for the");
        redGlassMaskLore.add("  §r§ored glass gradient on and off.");
        redGlassMaskItemMeta.setLore(redGlassMaskLore);
        redGlassMaskItemStack.setItemMeta(redGlassMaskItemMeta);

        inv.setItem(9, redGlassMaskItemStack);

        ItemStack greenGlassMaskItemStack = new ItemStack(Material.LIME_STAINED_GLASS, 1);
        ItemMeta greenGlassMaskItemMeta = greenGlassMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isGreenGlass()) {
            greenGlassMaskItemMeta.setDisplayName("§a§lGreen Glass Gradient §8- §f§lEnabled");
            greenGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            greenGlassMaskItemMeta.setDisplayName("§a§lGreen Glass Gradient §8- §4§lDisabled");
        }
        List<String> greenGlassMaskLore = new LinkedList<String>();
        greenGlassMaskLore.add(" ");
        greenGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
        greenGlassMaskLore.add("  §r§otoggle the mask for the");
        greenGlassMaskLore.add("  §r§ogreen glass gradient on and off.");
        greenGlassMaskItemMeta.setLore(greenGlassMaskLore);
        greenGlassMaskItemStack.setItemMeta(greenGlassMaskItemMeta);

        inv.setItem(12, greenGlassMaskItemStack);

        ItemStack blueGlassMaskItemStack = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1);
        ItemMeta blueGlassMaskItemMeta = blueGlassMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isBlueGlass()) {
            blueGlassMaskItemMeta.setDisplayName("§b§lBlue Glass Gradient §8- §f§lEnabled");
            blueGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            blueGlassMaskItemMeta.setDisplayName("§b§lBlue Glass Gradient §8- §4§lDisabled");
        }
        List<String> blueGlassMaskLore = new LinkedList<String>();
        blueGlassMaskLore.add(" ");
        blueGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
        blueGlassMaskLore.add("  §r§otoggle the mask for the");
        blueGlassMaskLore.add("  §r§oblue glass gradient on and off.");
        blueGlassMaskItemMeta.setLore(blueGlassMaskLore);
        blueGlassMaskItemStack.setItemMeta(blueGlassMaskItemMeta);

        inv.setItem(13, blueGlassMaskItemStack);

        ItemStack purpleGlassMaskItemStack = new ItemStack(Material.PURPLE_STAINED_GLASS, 1);
        ItemMeta purpleGlassMaskItemMeta = purpleGlassMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isPurpleGlass()) {
            purpleGlassMaskItemMeta.setDisplayName("§5§lPurple Glass Gradient §8- §f§lEnabled");
            purpleGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            purpleGlassMaskItemMeta.setDisplayName("§5§lPurple Glass Gradient §8- §4§lDisabled");
        }
        List<String> purpleGlassMaskLore = new LinkedList<String>();
        purpleGlassMaskLore.add(" ");
        purpleGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
        purpleGlassMaskLore.add("  §r§otoggle the mask for the");
        purpleGlassMaskLore.add("  §r§opurple glass gradient on and off.");
        purpleGlassMaskItemMeta.setLore(purpleGlassMaskLore);
        purpleGlassMaskItemStack.setItemMeta(purpleGlassMaskItemMeta);

        inv.setItem(15, purpleGlassMaskItemStack);

        ItemStack greyGlassMaskItemStack = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 1);
        ItemMeta greyGlassMaskItemMeta = greyGlassMaskItemStack.getItemMeta();
        if(ncPlayer.getMask().isGreyGlass()) {
            greyGlassMaskItemMeta.setDisplayName("§7§lGrey Glass Gradient §8- §f§lEnabled");
            greyGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        }else{
            greyGlassMaskItemMeta.setDisplayName("§7§lGrey Glass Gradient §8- §4§lDisabled");
        }
        List<String> greyGlassMaskLore = new LinkedList<String>();
        greyGlassMaskLore.add(" ");
        greyGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
        greyGlassMaskLore.add("  §r§otoggle the mask for the");
        greyGlassMaskLore.add("  §r§ogrey glass gradient on and off.");
        greyGlassMaskItemMeta.setLore(greyGlassMaskLore);
        greyGlassMaskItemStack.setItemMeta(greyGlassMaskItemMeta);

        inv.setItem(16, greyGlassMaskItemStack);

        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);

        player.openInventory(inv);
    }
}
