package de.nextround.nextcolors.listeners.click;

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
import de.nextround.nextcolors.utils.FileManager;
import de.nextround.nextcolors.utils.Mask;
import de.nextround.nextcolors.utils.NCPlayer;
import de.nextround.nextcolors.utils.inventories.CustomGradientInventory;
import de.nextround.nextcolors.utils.inventories.MainInventory;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;

public class MainInventoryClickListeners implements Listener {

   /*
    *   Listener to switch between the "Default Mode" and
    *   "Own Color Gradient Mode"
    */
    @EventHandler
    public void onSwitchModeClickListener(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getView().getTitle().startsWith("§9nextColors") && event.getClickedInventory() != null) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Mode §8- ")) {
                if (ncPlayer.getMode() == 0) {

                    ncPlayer.setMode(1);

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

                    event.getClickedInventory().setItem(22, toggleModeItemStack);

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

                    event.getClickedInventory().setItem(40, createColorGradientItemStack);

                    player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);

                    FileManager.updatePlayerConfigFile(ncPlayer);

                } else if (ncPlayer.getMode() == 1) {

                    ncPlayer.setMode(0);

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

                    event.getClickedInventory().setItem(22, toggleModeItemStack);

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

                        event.getClickedInventory().setItem(40, maskEnabledItemStack);
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

                        event.getClickedInventory().setItem(40, maskEnabledItemStack);
                    }

                    player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);

                    FileManager.updatePlayerConfigFile(ncPlayer);
                }
            }
        }
    }

   /*
    *   Listener to toggle the mask on and off
    *   as well as to open the mask inventory
    *   (MainInventory -> openMaskInventory(Player player))
    */

    @EventHandler
    public void onMaskListener(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getView().getTitle().startsWith("§9nextColors") && event.getClickedInventory() != null) {
            event.setCancelled(true);

            /* LeftClick to toggle the mask on and off */
            if(event.getClick().isLeftClick()) {
                if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Mask §8- ")) {
                    if (ncPlayer.getMaskMode() == 0) {
                        ncPlayer.setMaskMode(1);

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

                        event.getClickedInventory().setItem(40, maskEnabledItemStack);
                        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                    } else if (ncPlayer.getMaskMode() == 1) {
                        ncPlayer.setMaskMode(0);

                        ItemStack maskEnabledItemStack = new ItemStack(Material.SKELETON_SKULL, 1);
                        ItemMeta maskEnabledItemMeta = maskEnabledItemStack.getItemMeta();
                        maskEnabledItemMeta.setDisplayName("§9Mask §8- §4§lDisabled");
                        List<String> maskEnabledLore = new LinkedList<String>();
                        maskEnabledLore.add(" ");
                        maskEnabledLore.add("§l§7➥ §r§oLeftclick to");
                        maskEnabledLore.add("  §r§otoggle!");
                        maskEnabledItemMeta.setLore(maskEnabledLore);
                        maskEnabledItemStack.setItemMeta(maskEnabledItemMeta);

                        event.getClickedInventory().setItem(40, maskEnabledItemStack);
                        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);

                        FileManager.updatePlayerConfigFile(ncPlayer);
                    }
                }

            /* RightClick to open the mask inventory */
            }else if(event.getClick().isRightClick()) {
                if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta().getDisplayName().equals("§9Mask §8- §f§lColor Gradient")) {
                    player.closeInventory();

                    MainInventory.openMaskInventory(player);
                }
            }
        }
    }

   /*
    *   Listener to switch between the different
    *   brush types (Normal & Splatter)
    */

    @EventHandler
    public void onBrushTypeEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getView().getTitle().startsWith("§9nextColors") && event.getClickedInventory() != null) {
            event.setCancelled(true);

            if(event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Brush §8-")) {
                    if (ncPlayer.getBrushType() == Brush.BrushType.SPHERE) {

                        ItemStack splatterBrushItemStack = new ItemStack(Material.MELON_SEEDS, 1);
                        ItemMeta splatterBrushItemMeta = splatterBrushItemStack.getItemMeta();
                        splatterBrushItemMeta.setDisplayName("§9Brush §8- §f§lSplatter Brush");
                        List<String> splatterBrushLore = new LinkedList<String>();
                        splatterBrushLore.add(" ");
                        splatterBrushLore.add("§l§7➥ §r§oLeftclick to");
                        splatterBrushLore.add("  §r§oselect your brush-type!");
                        splatterBrushItemMeta.setLore(splatterBrushLore);
                        splatterBrushItemStack.setItemMeta(splatterBrushItemMeta);

                        event.getClickedInventory().setItem(4, splatterBrushItemStack);

                        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
                        ncPlayer.setBrushType(Brush.BrushType.SPLATTER);

                        FileManager.updatePlayerConfigFile(ncPlayer);
                    } else if (ncPlayer.getBrushType() == Brush.BrushType.SPLATTER) {

                        ItemStack normalBrushItemStack = new ItemStack(Material.FIREWORK_STAR, 1);
                        ItemMeta normalBrushItemMeta = normalBrushItemStack.getItemMeta();
                        normalBrushItemMeta.setDisplayName("§9Brush §8- §f§lNormal Brush");
                        List<String> normalBrushLore = new LinkedList<String>();
                        normalBrushLore.add(" ");
                        normalBrushLore.add("§l§7➥ §r§oLeftclick to");
                        normalBrushLore.add("  §r§oselect your brush-type!");
                        normalBrushItemMeta.setLore(normalBrushLore);
                        normalBrushItemStack.setItemMeta(normalBrushItemMeta);

                        event.getClickedInventory().setItem(4, normalBrushItemStack);
                        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);

                        ncPlayer.setBrushType(Brush.BrushType.SPHERE);

                        FileManager.updatePlayerConfigFile(ncPlayer);
                    }
                }
            }
        }
    }

   /*
    *   Listener to increase or decrease the size and chance
    *   of a brush. A "LeftClick" increases by 1 and a "RightClick"
    *   decreases by 1. With "Shift" combined it adds or removes
    *   10 when combined.
    */

    @EventHandler
    public void onClickListener(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getView().getTitle().startsWith("§9nextColors") && event.getClickedInventory() != null) {
            event.setCancelled(true);

            if(event.getCurrentItem() != null) {
                /* Open inventory for own color gradient selection */
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§9Create own §f§lColor Gradient")) {
                    player.closeInventory();
                    CustomGradientInventory.openSelectInventory(player);
                } else if (event.getClick() == ClickType.RIGHT) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Size §8-")) {
                        if (ncPlayer.getSize() != 1) {
                            changeBrushSize(ncPlayer, event.getClickedInventory(), -1);
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Brush chance §8-")) {
                        if (ncPlayer.getPercentage() != 1) {
                            changeBrushPercentage(ncPlayer, event.getClickedInventory(), -1);
                        }
                    }
                } else if (event.getClick() == ClickType.LEFT) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Size §8-")) {
                        if (ncPlayer.getSize() != 100) {
                            changeBrushSize(ncPlayer, event.getClickedInventory(), 1);
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Brush chance §8-")) {
                        if (ncPlayer.getPercentage() != 100) {
                            changeBrushPercentage(ncPlayer, event.getClickedInventory(), 1);
                        }
                    }
                } else if (event.getClick() == ClickType.SHIFT_LEFT) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Size §8-")) {
                        if (ncPlayer.getSize() >= 90 && ncPlayer.getSize() <= 100) {
                            ncPlayer.setSize(100);

                            FileManager.updatePlayerConfigFile(ncPlayer);

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

                            event.getClickedInventory().setItem(24, brushSizeItemStack);
                        } else {
                            changeBrushSize(ncPlayer, event.getClickedInventory(), 10);
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Brush chance §8-")) {
                        if (ncPlayer.getPercentage() >= 90 && ncPlayer.getPercentage() <= 100) {
                            ncPlayer.setPercentage(100);

                            FileManager.updatePlayerConfigFile(ncPlayer);

                            /*
                             *   Sets the brush chance item in the inventory
                             */
                            ItemStack brushChanceItemStack = new ItemStack(Material.GOLD_BLOCK, 1);
                            ItemMeta brushChanceItemMeta = brushChanceItemStack.getItemMeta();
                            brushChanceItemMeta.setDisplayName("§9Brush chance §8- §f§l" + ncPlayer.getPercentage() + "%");
                            List<String> brushChanceLore = new LinkedList<String>();
                            brushChanceLore.add(" ");
                            brushChanceLore.add("§l§7➥ §r§oLeftclick to add!");
                            brushChanceLore.add(" ");
                            brushChanceLore.add("§l§7➥ §r§oRightclick to remove!");
                            brushChanceItemMeta.setLore(brushChanceLore);
                            brushChanceItemStack.setItemMeta(brushChanceItemMeta);

                            event.getClickedInventory().setItem(20, brushChanceItemStack);
                        } else {
                            changeBrushPercentage(ncPlayer, event.getClickedInventory(), 10);
                        }
                    }
                } else if (event.getClick() == ClickType.SHIFT_RIGHT) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Size §8-")) {
                        if (ncPlayer.getSize() <= 10 && ncPlayer.getSize() >= 1) {
                            ncPlayer.setSize(1);

                            FileManager.updatePlayerConfigFile(ncPlayer);

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

                            event.getClickedInventory().setItem(24, brushSizeItemStack);
                        } else {
                            changeBrushSize(ncPlayer, event.getClickedInventory(), -10);
                        }
                    } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Brush chance §8-")) {
                        if (ncPlayer.getPercentage() <= 10 && ncPlayer.getPercentage() >= 1) {
                            ncPlayer.setPercentage(1);

                            FileManager.updatePlayerConfigFile(ncPlayer);

                            /*
                             *   Sets the brush chance item in the inventory
                             */
                            ItemStack brushChanceItemStack = new ItemStack(Material.GOLD_BLOCK, 1);
                            ItemMeta brushChanceItemMeta = brushChanceItemStack.getItemMeta();
                            brushChanceItemMeta.setDisplayName("§9Brush chance §8- §f§l" + ncPlayer.getPercentage() + "%");
                            List<String> brushChanceLore = new LinkedList<String>();
                            brushChanceLore.add(" ");
                            brushChanceLore.add("§l§7➥ §r§oLeftclick to add!");
                            brushChanceLore.add(" ");
                            brushChanceLore.add("§l§7➥ §r§oRightclick to remove!");
                            brushChanceItemMeta.setLore(brushChanceLore);
                            brushChanceItemStack.setItemMeta(brushChanceItemMeta);

                            event.getClickedInventory().setItem(20, brushChanceItemStack);
                        } else {
                            changeBrushPercentage(ncPlayer, event.getClickedInventory(), -10);
                        }
                    }
                }
            }
        }
    }

   /*
    *   Method to change the brush size and update the
    *   name of the item
    */
    public void changeBrushSize(NCPlayer ncPlayer, Inventory inv, int amount) {
        ncPlayer.setSize(ncPlayer.getSize() + amount);

        FileManager.updatePlayerConfigFile(ncPlayer);

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
    }

   /*
    *   Method to change the brush percentage and update the
    *   name of the item
    */
    public void changeBrushPercentage(NCPlayer ncPlayer, Inventory inv, int amount) {
        ncPlayer.setPercentage(ncPlayer.getPercentage() + amount);

        FileManager.updatePlayerConfigFile(ncPlayer);

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
    }

    /*
     *   Listener to select the different masks
     *   in the mask inventory
     */
    @EventHandler
    public void onSelectMaskEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getView().getTitle().startsWith("§9Mask") && event.getClickedInventory() != null) {
            event.setCancelled(true);

            if (event.getCurrentItem().getItemMeta().getDisplayName().contains("BACK")) {
                System.out.println("start");
                player.closeInventory();
                System.out.println("middle");
                MainInventory.openInventory(player);
                System.out.println("finish");
            }
            if(event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§c§lRed Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isRed()) {
                        mask.setRed(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack redMaskItemStack = new ItemStack(Material.RED_WOOL, 1);
                        ItemMeta redMaskItemMeta = redMaskItemStack.getItemMeta();
                        redMaskItemMeta.setDisplayName("§c§lRed Gradient §8- §4§lDisabled");
                        List<String> redMaskLore = new LinkedList<String>();
                        redMaskLore.add(" ");
                        redMaskLore.add("§l§7➥ §r§oLeftclick to");
                        redMaskLore.add("  §r§otoggle the mask for the");
                        redMaskLore.add("  §r§ored gradient on and off.");
                        redMaskItemMeta.setLore(redMaskLore);
                        redMaskItemStack.setItemMeta(redMaskItemMeta);

                        event.getClickedInventory().setItem(0, redMaskItemStack);
                    } else {
                        mask.setRed(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack redMaskItemStack = new ItemStack(Material.RED_WOOL, 1);
                        ItemMeta redMaskItemMeta = redMaskItemStack.getItemMeta();
                        redMaskItemMeta.setDisplayName("§c§lRed Gradient §8- §f§lEnabled");
                        redMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> redMaskLore = new LinkedList<String>();
                        redMaskLore.add(" ");
                        redMaskLore.add("§l§7➥ §r§oLeftclick to");
                        redMaskLore.add("  §r§otoggle the mask for the");
                        redMaskLore.add("  §r§ored gradient on and off.");
                        redMaskItemMeta.setLore(redMaskLore);
                        redMaskItemStack.setItemMeta(redMaskItemMeta);

                        event.getClickedInventory().setItem(0, redMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§6§lOrange Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isOrange()) {
                        mask.setOrange(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack orangeMaskItemStack = new ItemStack(Material.ORANGE_WOOL, 1);
                        ItemMeta orangeMaskItemMeta = orangeMaskItemStack.getItemMeta();
                        orangeMaskItemMeta.setDisplayName("§6§lOrange Gradient §8- §4§lDisabled");
                        List<String> orangeMaskLore = new LinkedList<String>();
                        orangeMaskLore.add(" ");
                        orangeMaskLore.add("§l§7➥ §r§oLeftclick to");
                        orangeMaskLore.add("  §r§otoggle the mask for the");
                        orangeMaskLore.add("  §r§oorange gradient on and off.");
                        orangeMaskItemMeta.setLore(orangeMaskLore);
                        orangeMaskItemStack.setItemMeta(orangeMaskItemMeta);

                        event.getClickedInventory().setItem(1, orangeMaskItemStack);
                    } else {
                        mask.setOrange(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack orangeMaskItemStack = new ItemStack(Material.ORANGE_WOOL, 1);
                        ItemMeta orangeMaskItemMeta = orangeMaskItemStack.getItemMeta();
                        orangeMaskItemMeta.setDisplayName("§6§lOrange Gradient §8- §f§lEnabled");
                        orangeMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> orangeMaskLore = new LinkedList<String>();
                        orangeMaskLore.add(" ");
                        orangeMaskLore.add("§l§7➥ §r§oLeftclick to");
                        orangeMaskLore.add("  §r§otoggle the mask for the");
                        orangeMaskLore.add("  §r§oorange gradient on and off.");
                        orangeMaskItemMeta.setLore(orangeMaskLore);
                        orangeMaskItemStack.setItemMeta(orangeMaskItemMeta);

                        event.getClickedInventory().setItem(1, orangeMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§e§lYellow Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isYellow()) {
                        mask.setYellow(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack yellowMaskItemStack = new ItemStack(Material.YELLOW_WOOL, 1);
                        ItemMeta yellowMaskItemMeta = yellowMaskItemStack.getItemMeta();
                        yellowMaskItemMeta.setDisplayName("§e§lYellow Gradient §8- §4§lDisabled");
                        List<String> yellowMaskLore = new LinkedList<String>();
                        yellowMaskLore.add(" ");
                        yellowMaskLore.add("§l§7➥ §r§oLeftclick to");
                        yellowMaskLore.add("  §r§otoggle the mask for the");
                        yellowMaskLore.add("  §r§oyellow gradient on and off.");
                        yellowMaskItemMeta.setLore(yellowMaskLore);
                        yellowMaskItemStack.setItemMeta(yellowMaskItemMeta);

                        event.getClickedInventory().setItem(2, yellowMaskItemStack);
                    } else {
                        mask.setYellow(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack yellowMaskItemStack = new ItemStack(Material.YELLOW_WOOL, 1);
                        ItemMeta yellowMaskItemMeta = yellowMaskItemStack.getItemMeta();
                        yellowMaskItemMeta.setDisplayName("§e§lYellow Gradient §8- §f§lEnabled");
                        yellowMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> yellowMaskLore = new LinkedList<String>();
                        yellowMaskLore.add(" ");
                        yellowMaskLore.add("§l§7➥ §r§oLeftclick to");
                        yellowMaskLore.add("  §r§otoggle the mask for the");
                        yellowMaskLore.add("  §r§oyellow gradient on and off.");
                        yellowMaskItemMeta.setLore(yellowMaskLore);
                        yellowMaskItemStack.setItemMeta(yellowMaskItemMeta);

                        event.getClickedInventory().setItem(2, yellowMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§a§lGreen Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isGreen()) {
                        mask.setGreen(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greenMaskItemStack = new ItemStack(Material.LIME_WOOL, 1);
                        ItemMeta greenMaskItemMeta = greenMaskItemStack.getItemMeta();
                        greenMaskItemMeta.setDisplayName("§a§lGreen Gradient §8- §4§lDisabled");
                        List<String> greenMaskLore = new LinkedList<String>();
                        greenMaskLore.add(" ");
                        greenMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greenMaskLore.add("  §r§otoggle the mask for the");
                        greenMaskLore.add("  §r§ogreen gradient on and off.");
                        greenMaskItemMeta.setLore(greenMaskLore);
                        greenMaskItemStack.setItemMeta(greenMaskItemMeta);

                        event.getClickedInventory().setItem(3, greenMaskItemStack);
                    } else {
                        mask.setGreen(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greenMaskItemStack = new ItemStack(Material.LIME_WOOL, 1);
                        ItemMeta greenMaskItemMeta = greenMaskItemStack.getItemMeta();
                        greenMaskItemMeta.setDisplayName("§a§lGreen Gradient §8- §f§lEnabled");
                        greenMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> greenMaskLore = new LinkedList<String>();
                        greenMaskLore.add(" ");
                        greenMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greenMaskLore.add("  §r§otoggle the mask for the");
                        greenMaskLore.add("  §r§ogreen gradient on and off.");
                        greenMaskItemMeta.setLore(greenMaskLore);
                        greenMaskItemStack.setItemMeta(greenMaskItemMeta);

                        event.getClickedInventory().setItem(3, greenMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§b§lBlue Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isBlue()) {
                        mask.setBlue(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack blueMaskItemStack = new ItemStack(Material.LIGHT_BLUE_WOOL, 1);
                        ItemMeta blueMaskItemMeta = blueMaskItemStack.getItemMeta();
                        blueMaskItemMeta.setDisplayName("§b§lBlue Gradient §8- §4§lDisabled");
                        List<String> blueMaskLore = new LinkedList<String>();
                        blueMaskLore.add(" ");
                        blueMaskLore.add("§l§7➥ §r§oLeftclick to");
                        blueMaskLore.add("  §r§otoggle the mask for the");
                        blueMaskLore.add("  §r§oblue gradient on and off.");
                        blueMaskItemMeta.setLore(blueMaskLore);
                        blueMaskItemStack.setItemMeta(blueMaskItemMeta);

                        event.getClickedInventory().setItem(4, blueMaskItemStack);
                    } else {
                        mask.setBlue(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack blueMaskItemStack = new ItemStack(Material.LIGHT_BLUE_WOOL, 1);
                        ItemMeta blueMaskItemMeta = blueMaskItemStack.getItemMeta();
                        blueMaskItemMeta.setDisplayName("§b§lBlue Gradient §8- §f§lEnabled");
                        blueMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> blueMaskLore = new LinkedList<String>();
                        blueMaskLore.add(" ");
                        blueMaskLore.add("§l§7➥ §r§oLeftclick to");
                        blueMaskLore.add("  §r§otoggle the mask for the");
                        blueMaskLore.add("  §r§oblue gradient on and off.");
                        blueMaskItemMeta.setLore(blueMaskLore);
                        blueMaskItemStack.setItemMeta(blueMaskItemMeta);

                        event.getClickedInventory().setItem(4, blueMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§d§lPink Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isPink()) {
                        mask.setPink(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack pinkMaskItemStack = new ItemStack(Material.PINK_WOOL, 1);
                        ItemMeta pinkMaskItemMeta = pinkMaskItemStack.getItemMeta();
                        pinkMaskItemMeta.setDisplayName("§d§lPink Gradient §8- §4§lDisabled");
                        List<String> pinkMaskLore = new LinkedList<String>();
                        pinkMaskLore.add(" ");
                        pinkMaskLore.add("§l§7➥ §r§oLeftclick to");
                        pinkMaskLore.add("  §r§otoggle the mask for the");
                        pinkMaskLore.add("  §r§opink gradient on and off.");
                        pinkMaskItemMeta.setLore(pinkMaskLore);
                        pinkMaskItemStack.setItemMeta(pinkMaskItemMeta);

                        event.getClickedInventory().setItem(5, pinkMaskItemStack);
                    } else {
                        mask.setPink(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack pinkMaskItemStack = new ItemStack(Material.PINK_WOOL, 1);
                        ItemMeta pinkMaskItemMeta = pinkMaskItemStack.getItemMeta();
                        pinkMaskItemMeta.setDisplayName("§d§lPink Gradient §8- §f§lEnabled");
                        pinkMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> pinkMaskLore = new LinkedList<String>();
                        pinkMaskLore.add(" ");
                        pinkMaskLore.add("§l§7➥ §r§oLeftclick to");
                        pinkMaskLore.add("  §r§otoggle the mask for the");
                        pinkMaskLore.add("  §r§opink gradient on and off.");
                        pinkMaskItemMeta.setLore(pinkMaskLore);
                        pinkMaskItemStack.setItemMeta(pinkMaskItemMeta);

                        event.getClickedInventory().setItem(5, pinkMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§5§lPurple Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isPurple()) {
                        mask.setPurple(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack purpleMaskItemStack = new ItemStack(Material.PURPLE_WOOL, 1);
                        ItemMeta purpleMaskItemMeta = purpleMaskItemStack.getItemMeta();
                        purpleMaskItemMeta.setDisplayName("§5§lPurple Gradient §8- §4§lDisabled");
                        List<String> purpleMaskLore = new LinkedList<String>();
                        purpleMaskLore.add(" ");
                        purpleMaskLore.add("§l§7➥ §r§oLeftclick to");
                        purpleMaskLore.add("  §r§otoggle the mask for the");
                        purpleMaskLore.add("  §r§opurple gradient on and off.");
                        purpleMaskItemMeta.setLore(purpleMaskLore);
                        purpleMaskItemStack.setItemMeta(purpleMaskItemMeta);

                        event.getClickedInventory().setItem(6, purpleMaskItemStack);
                    } else {
                        mask.setPurple(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack purpleMaskItemStack = new ItemStack(Material.PURPLE_WOOL, 1);
                        ItemMeta purpleMaskItemMeta = purpleMaskItemStack.getItemMeta();
                        purpleMaskItemMeta.setDisplayName("§5§lPurple Gradient §8- §f§lEnabled");
                        purpleMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> purpleMaskLore = new LinkedList<String>();
                        purpleMaskLore.add(" ");
                        purpleMaskLore.add("§l§7➥ §r§oLeftclick to");
                        purpleMaskLore.add("  §r§otoggle the mask for the");
                        purpleMaskLore.add("  §r§opurple gradient on and off.");
                        purpleMaskItemMeta.setLore(purpleMaskLore);
                        purpleMaskItemStack.setItemMeta(purpleMaskItemMeta);

                        event.getClickedInventory().setItem(6, purpleMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§7§lGrey Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isGrey()) {
                        mask.setGrey(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greyMaskItemStack = new ItemStack(Material.LIGHT_GRAY_WOOL, 1);
                        ItemMeta greyMaskItemMeta = greyMaskItemStack.getItemMeta();
                        greyMaskItemMeta.setDisplayName("§7§lGrey Gradient §8- §4§lDisabled");
                        List<String> greyMaskLore = new LinkedList<String>();
                        greyMaskLore.add(" ");
                        greyMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greyMaskLore.add("  §r§otoggle the mask for the");
                        greyMaskLore.add("  §r§ogrey gradient on and off.");
                        greyMaskItemMeta.setLore(greyMaskLore);
                        greyMaskItemStack.setItemMeta(greyMaskItemMeta);

                        event.getClickedInventory().setItem(7, greyMaskItemStack);
                    } else {
                        mask.setGrey(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greyMaskItemStack = new ItemStack(Material.LIGHT_GRAY_WOOL, 1);
                        ItemMeta greyMaskItemMeta = greyMaskItemStack.getItemMeta();
                        greyMaskItemMeta.setDisplayName("§7§lGrey Gradient §8- §f§lEnabled");
                        greyMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> greyMaskLore = new LinkedList<String>();
                        greyMaskLore.add(" ");
                        greyMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greyMaskLore.add("  §r§otoggle the mask for the");
                        greyMaskLore.add("  §r§ogrey gradient on and off.");
                        greyMaskItemMeta.setLore(greyMaskLore);
                        greyMaskItemStack.setItemMeta(greyMaskItemMeta);

                        event.getClickedInventory().setItem(7, greyMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§8§lBrown Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isBrown()) {
                        mask.setBrown(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack brownMaskItemStack = new ItemStack(Material.BROWN_WOOL, 1);
                        ItemMeta brownMaskItemMeta = brownMaskItemStack.getItemMeta();
                        brownMaskItemMeta.setDisplayName("§8§lBrown Gradient §8- §4§lDisabled");
                        List<String> brownMaskLore = new LinkedList<String>();
                        brownMaskLore.add(" ");
                        brownMaskLore.add("§l§7➥ §r§oLeftclick to");
                        brownMaskLore.add("  §r§otoggle the mask for the");
                        brownMaskLore.add("  §r§obrown gradient on and off.");
                        brownMaskItemMeta.setLore(brownMaskLore);
                        brownMaskItemStack.setItemMeta(brownMaskItemMeta);

                        event.getClickedInventory().setItem(8, brownMaskItemStack);
                    } else {
                        mask.setBrown(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack brownMaskItemStack = new ItemStack(Material.BROWN_WOOL, 1);
                        ItemMeta brownMaskItemMeta = brownMaskItemStack.getItemMeta();
                        brownMaskItemMeta.setDisplayName("§8§lBrown Gradient §8- §f§lEnabled");
                        brownMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> brownMaskLore = new LinkedList<String>();
                        brownMaskLore.add(" ");
                        brownMaskLore.add("§l§7➥ §r§oLeftclick to");
                        brownMaskLore.add("  §r§otoggle the mask for the");
                        brownMaskLore.add("  §r§obrown gradient on and off.");
                        brownMaskItemMeta.setLore(brownMaskLore);
                        brownMaskItemStack.setItemMeta(brownMaskItemMeta);

                        event.getClickedInventory().setItem(8, brownMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§c§lRed Glass Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isRedGlass()) {
                        mask.setRedGlass(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack redGlassMaskItemStack = new ItemStack(Material.RED_STAINED_GLASS, 1);
                        ItemMeta redGlassMaskItemMeta = redGlassMaskItemStack.getItemMeta();
                        redGlassMaskItemMeta.setDisplayName("§c§lRed Glass Gradient §8- §4§lDisabled");
                        List<String> redGlassMaskLore = new LinkedList<String>();
                        redGlassMaskLore.add(" ");
                        redGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        redGlassMaskLore.add("  §r§otoggle the mask for the");
                        redGlassMaskLore.add("  §r§ored glass gradient on and off.");
                        redGlassMaskItemMeta.setLore(redGlassMaskLore);
                        redGlassMaskItemStack.setItemMeta(redGlassMaskItemMeta);

                        event.getClickedInventory().setItem(9, redGlassMaskItemStack);
                    } else {
                        mask.setRedGlass(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack redGlassMaskItemStack = new ItemStack(Material.RED_STAINED_GLASS, 1);
                        ItemMeta redGlassMaskItemMeta = redGlassMaskItemStack.getItemMeta();
                        redGlassMaskItemMeta.setDisplayName("§c§lRed Glass Gradient §8- §f§lEnabled");
                        redGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> redGlassMaskLore = new LinkedList<String>();
                        redGlassMaskLore.add(" ");
                        redGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        redGlassMaskLore.add("  §r§otoggle the mask for the");
                        redGlassMaskLore.add("  §r§ored glass gradient on and off.");
                        redGlassMaskItemMeta.setLore(redGlassMaskLore);
                        redGlassMaskItemStack.setItemMeta(redGlassMaskItemMeta);

                        event.getClickedInventory().setItem(9, redGlassMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§a§lGreen Glass Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isGreenGlass()) {
                        mask.setGreenGlass(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greenGlassMaskItemStack = new ItemStack(Material.LIME_STAINED_GLASS, 1);
                        ItemMeta greenGlassMaskItemMeta = greenGlassMaskItemStack.getItemMeta();
                        greenGlassMaskItemMeta.setDisplayName("§a§lGreen Glass Gradient §8- §4§lDisabled");
                        List<String> greenGlassMaskLore = new LinkedList<String>();
                        greenGlassMaskLore.add(" ");
                        greenGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greenGlassMaskLore.add("  §r§otoggle the mask for the");
                        greenGlassMaskLore.add("  §r§ogreen glass gradient on and off.");
                        greenGlassMaskItemMeta.setLore(greenGlassMaskLore);
                        greenGlassMaskItemStack.setItemMeta(greenGlassMaskItemMeta);

                        event.getClickedInventory().setItem(12, greenGlassMaskItemStack);
                    } else {
                        mask.setGreenGlass(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greenGlassMaskItemStack = new ItemStack(Material.LIME_STAINED_GLASS, 1);
                        ItemMeta greenGlassMaskItemMeta = greenGlassMaskItemStack.getItemMeta();
                        greenGlassMaskItemMeta.setDisplayName("§a§lGreen Glass Gradient §8- §f§lEnabled");
                        greenGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> greenGlassMaskLore = new LinkedList<String>();
                        greenGlassMaskLore.add(" ");
                        greenGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greenGlassMaskLore.add("  §r§otoggle the mask for the");
                        greenGlassMaskLore.add("  §r§ogreen glass gradient on and off.");
                        greenGlassMaskItemMeta.setLore(greenGlassMaskLore);
                        greenGlassMaskItemStack.setItemMeta(greenGlassMaskItemMeta);

                        event.getClickedInventory().setItem(12, greenGlassMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§b§lBlue Glass Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isBlueGlass()) {
                        mask.setBlueGlass(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack blueGlassMaskItemStack = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1);
                        ItemMeta blueGlassMaskItemMeta = blueGlassMaskItemStack.getItemMeta();
                        blueGlassMaskItemMeta.setDisplayName("§b§lBlue Glass Gradient §8- §4§lDisabled");
                        List<String> blueGlassMaskLore = new LinkedList<String>();
                        blueGlassMaskLore.add(" ");
                        blueGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        blueGlassMaskLore.add("  §r§otoggle the mask for the");
                        blueGlassMaskLore.add("  §r§oblue glass gradient on and off.");
                        blueGlassMaskItemMeta.setLore(blueGlassMaskLore);
                        blueGlassMaskItemStack.setItemMeta(blueGlassMaskItemMeta);

                        event.getClickedInventory().setItem(13, blueGlassMaskItemStack);
                    } else {
                        mask.setBlueGlass(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack blueGlassMaskItemStack = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1);
                        ItemMeta blueGlassMaskItemMeta = blueGlassMaskItemStack.getItemMeta();
                        blueGlassMaskItemMeta.setDisplayName("§b§lBlue Glass Gradient §8- §f§lEnabled");
                        blueGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> blueGlassMaskLore = new LinkedList<String>();
                        blueGlassMaskLore.add(" ");
                        blueGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        blueGlassMaskLore.add("  §r§otoggle the mask for the");
                        blueGlassMaskLore.add("  §r§oblue glass gradient on and off.");
                        blueGlassMaskItemMeta.setLore(blueGlassMaskLore);
                        blueGlassMaskItemStack.setItemMeta(blueGlassMaskItemMeta);

                        event.getClickedInventory().setItem(13, blueGlassMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§5§lPurple Glass Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isPurpleGlass()) {
                        mask.setPurpleGlass(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack purpleGlassMaskItemStack = new ItemStack(Material.PURPLE_STAINED_GLASS, 1);
                        ItemMeta purpleGlassMaskItemMeta = purpleGlassMaskItemStack.getItemMeta();
                        purpleGlassMaskItemMeta.setDisplayName("§5§lPurple Glass Gradient §8- §4§lDisabled");
                        List<String> purpleGlassMaskLore = new LinkedList<String>();
                        purpleGlassMaskLore.add(" ");
                        purpleGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        purpleGlassMaskLore.add("  §r§otoggle the mask for the");
                        purpleGlassMaskLore.add("  §r§opurple glass gradient on and off.");
                        purpleGlassMaskItemMeta.setLore(purpleGlassMaskLore);
                        purpleGlassMaskItemStack.setItemMeta(purpleGlassMaskItemMeta);

                        event.getClickedInventory().setItem(15, purpleGlassMaskItemStack);
                    } else {
                        mask.setPurpleGlass(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack purpleGlassMaskItemStack = new ItemStack(Material.PURPLE_STAINED_GLASS, 1);
                        ItemMeta purpleGlassMaskItemMeta = purpleGlassMaskItemStack.getItemMeta();
                        purpleGlassMaskItemMeta.setDisplayName("§5§lPurple Glass Gradient §8- §f§lEnabled");
                        purpleGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> purpleGlassMaskLore = new LinkedList<String>();
                        purpleGlassMaskLore.add(" ");
                        purpleGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        purpleGlassMaskLore.add("  §r§otoggle the mask for the");
                        purpleGlassMaskLore.add("  §r§opurple glass gradient on and off.");
                        purpleGlassMaskItemMeta.setLore(purpleGlassMaskLore);
                        purpleGlassMaskItemStack.setItemMeta(purpleGlassMaskItemMeta);

                        event.getClickedInventory().setItem(15, purpleGlassMaskItemStack);
                    }
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§7§lGrey Glass Gradient §8-")) {
                    Mask mask = ncPlayer.getMask();

                    if(ncPlayer.getMask().isGreyGlass()) {
                        mask.setGreyGlass(false);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greyGlassMaskItemStack = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 1);
                        ItemMeta greyGlassMaskItemMeta = greyGlassMaskItemStack.getItemMeta();
                        greyGlassMaskItemMeta.setDisplayName("§7§lGrey Glass Gradient §8- §4§lDisabled");
                        List<String> greyGlassMaskLore = new LinkedList<String>();
                        greyGlassMaskLore.add(" ");
                        greyGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greyGlassMaskLore.add("  §r§otoggle the mask for the");
                        greyGlassMaskLore.add("  §r§ogrey glass gradient on and off.");
                        greyGlassMaskItemMeta.setLore(greyGlassMaskLore);
                        greyGlassMaskItemStack.setItemMeta(greyGlassMaskItemMeta);

                        event.getClickedInventory().setItem(16, greyGlassMaskItemStack);
                    } else {
                        mask.setGreyGlass(true);
                        ncPlayer.setMask(mask);

                        FileManager.updatePlayerConfigFile(ncPlayer);

                        ItemStack greyGlassMaskItemStack = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 1);
                        ItemMeta greyGlassMaskItemMeta = greyGlassMaskItemStack.getItemMeta();
                        greyGlassMaskItemMeta.setDisplayName("§7§lGrey Glass Gradient §8- §f§lEnabled");
                        greyGlassMaskItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        List<String> greyGlassMaskLore = new LinkedList<String>();
                        greyGlassMaskLore.add(" ");
                        greyGlassMaskLore.add("§l§7➥ §r§oLeftclick to");
                        greyGlassMaskLore.add("  §r§otoggle the mask for the");
                        greyGlassMaskLore.add("  §r§ogrey glass gradient on and off.");
                        greyGlassMaskItemMeta.setLore(greyGlassMaskLore);
                        greyGlassMaskItemStack.setItemMeta(greyGlassMaskItemMeta);

                        event.getClickedInventory().setItem(16, greyGlassMaskItemStack);
                    }
                }
            }
        }
    }
}
