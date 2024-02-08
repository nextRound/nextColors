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

import de.nextround.nextcolors.utils.ColorGradients;
import de.nextround.nextcolors.utils.FileManager;
import de.nextround.nextcolors.utils.NCPlayer;
import de.nextround.nextcolors.utils.inventories.CustomGradientInventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CustomGradientInventoryClickListeners implements Listener {

    private HashMap<Player, List> currentList = new HashMap<>();

   /*
    *   Listener for the "Previous Page", "Next Page"
    *   and "NEW" Buttons
    */
    @EventHandler
    public void onButtonClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getView().getTitle().startsWith("§9Own Color Gradients") && event.getClickedInventory() != null) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().contains("NEW")) {
                    if(ncPlayer.getColorGradients().getSelectedGradient() == -1) {
                        ColorGradients colorGradients = ncPlayer.getColorGradients();
                        colorGradients.setSelectedGradient(0);
                        ncPlayer.setColorGradients(colorGradients);

                        FileManager.updatePlayerConfigFile(ncPlayer);
                    }
                    List<Material> blockList = new ArrayList<>();
                    currentList.put(player, blockList);
                    player.closeInventory();

                    CustomGradientInventory.openCreateInventory(player);
                }else if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Previous Page")) {
                    int page;

                    String[] item = event.getInventory().getItem(0).getItemMeta().getDisplayName().split(" ");
                    if (Integer.parseInt(item[item.length-1]) != 1) {
                        page = ((Integer.parseInt(item[item.length-1]) - 1) / 36) + 1;
                    } else {
                        page = 1;
                    }

                    if(page != 1) {
                        ItemStack backgroundItemStack = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
                        ItemMeta backgroundItemMeta = backgroundItemStack.getItemMeta();
                        backgroundItemMeta.setDisplayName(" ");
                        backgroundItemStack.setItemMeta(backgroundItemMeta);

                        for (int i = 0; i < 36; i++) {
                            event.getInventory().setItem(i, backgroundItemStack);
                        }

                        for (int i = 36 * (page - 2); i < ncPlayer.getColorGradients().getGradientList().size(); i++) {
                            if (i < 36 * (page - 1)) {
                                ItemStack gradientItemStack = new ItemStack(Material.getMaterial((String) ncPlayer.getColorGradients().getGradientList().get(i).get(0)), 1);
                                ItemMeta gradientItemMeta = gradientItemStack.getItemMeta();
                                List<String> gradientLore = new LinkedList<String>();
                                gradientItemMeta.setDisplayName("§9Color Gradient §8-§f§l " + (i + 1));
                                if (ncPlayer.getColorGradients().getSelectedGradient() == i) {
                                    gradientItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                                } else {
                                    gradientLore.add(" ");
                                    gradientLore.add("§l§7➥ §r§oLeftclick to");
                                    gradientLore.add("  §r§oselect Color Gradient!");
                                }
                                gradientLore.add(" ");
                                gradientLore.add("§l§7➥ §r§oRightclick to");
                                gradientLore.add("  §r§oedit Color Gradient!");
                                gradientItemMeta.setLore(gradientLore);
                                gradientItemStack.setItemMeta(gradientItemMeta);

                                event.getInventory().setItem( i - 36 * (page - 2), gradientItemStack);
                            } else {
                                i = ncPlayer.getColorGradients().getGradientList().size();
                            }
                        }

                        ItemStack scrollRightItemStack = new ItemStack(Material.PLAYER_HEAD, 1);
                        SkullMeta scrollRightItemMeta = (SkullMeta) scrollRightItemStack.getItemMeta();
                        scrollRightItemMeta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowRight"));
                        scrollRightItemMeta.setDisplayName("§f§lNext Page");
                        scrollRightItemStack.setItemMeta(scrollRightItemMeta);

                        event.getInventory().setItem(42, scrollRightItemStack);

                        if(page - 1 == 1) {
                            ItemStack secondaryBackgroundItemStack = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
                            ItemMeta secondaryBackgroundItemMeta = secondaryBackgroundItemStack.getItemMeta();
                            secondaryBackgroundItemMeta.setDisplayName(" ");
                            secondaryBackgroundItemStack.setItemMeta(secondaryBackgroundItemMeta);

                            event.getInventory().setItem(38, secondaryBackgroundItemStack);
                        }
                    }
                }else if(event.getCurrentItem().getItemMeta().getDisplayName().contains("Next Page")) {
                    int page;

                    String[] item = event.getInventory().getItem(0).getItemMeta().getDisplayName().split(" ");
                    if (Integer.parseInt(item[item.length-1]) != 1) {
                        page = ((Integer.parseInt(item[item.length-1]) - 1) / 36) + 1;
                    } else {
                        page = 1;
                    }

                    double size = ncPlayer.getColorGradients().getGradientList().size();
                    double maxPages = Math.ceil(size / 36);

                    if(page != maxPages) {
                        ItemStack backgroundItemStack = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
                        ItemMeta backgroundItemMeta = backgroundItemStack.getItemMeta();
                        backgroundItemMeta.setDisplayName(" ");
                        backgroundItemStack.setItemMeta(backgroundItemMeta);

                        for (int i = 0; i < 36; i++) {
                            event.getInventory().setItem(i, backgroundItemStack);
                        }

                        for (int i = 36 * page; i < ncPlayer.getColorGradients().getGradientList().size(); i++) {
                            if (i < 36 * (page + 1)) {
                                ItemStack gradientItemStack = new ItemStack(Material.getMaterial((String) ncPlayer.getColorGradients().getGradientList().get(i).get(0)), 1);
                                ItemMeta gradientItemMeta = gradientItemStack.getItemMeta();
                                List<String> gradientLore = new LinkedList<String>();
                                gradientItemMeta.setDisplayName("§9Color Gradient §8-§f§l " + (i + 1));
                                if (ncPlayer.getColorGradients().getSelectedGradient() == i) {
                                    gradientItemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                                } else {
                                    gradientLore.add(" ");
                                    gradientLore.add("§l§7➥ §r§oLeftclick to");
                                    gradientLore.add("  §r§oselect Color Gradient!");
                                }
                                gradientLore.add(" ");
                                gradientLore.add("§l§7➥ §r§oRightclick to");
                                gradientLore.add("  §r§oedit Color Gradient!");
                                gradientItemMeta.setLore(gradientLore);
                                gradientItemStack.setItemMeta(gradientItemMeta);

                                event.getInventory().setItem( i - 36 * page, gradientItemStack);
                            } else {
                                i = ncPlayer.getColorGradients().getGradientList().size();
                            }
                        }

                        ItemStack scrollLeftItemStack = new ItemStack(Material.PLAYER_HEAD, 1);
                        SkullMeta scrollLeftItemMeta = (SkullMeta) scrollLeftItemStack.getItemMeta();
                        scrollLeftItemMeta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowLeft"));
                        scrollLeftItemMeta.setDisplayName("§f§lPrevious Page");
                        scrollLeftItemStack.setItemMeta(scrollLeftItemMeta);

                        event.getInventory().setItem(38, scrollLeftItemStack);

                        if(page + 1 == maxPages) {
                            ItemStack secondaryBackgroundItemStack = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
                            ItemMeta secondaryBackgroundItemMeta = secondaryBackgroundItemStack.getItemMeta();
                            secondaryBackgroundItemMeta.setDisplayName(" ");
                            secondaryBackgroundItemStack.setItemMeta(secondaryBackgroundItemMeta);

                            event.getInventory().setItem(42, secondaryBackgroundItemStack);
                        }
                    }
                }else if(event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§9Color Gradient §8-§f§l")) {
                    if(event.isRightClick()) {
                        String[] item = event.getCurrentItem().getItemMeta().getDisplayName().split(" ");
                        int selectedGradient = Integer.parseInt(item[3]) - 1;

                        ColorGradients colorGradients = ncPlayer.getColorGradients();
                        colorGradients.setSelectedGradient(selectedGradient);
                        ncPlayer.setColorGradients(colorGradients);

                        FileManager.updatePlayerConfigFile(ncPlayer);
                        List<String> blockList = ncPlayer.getColorGradients().getGradientList().get(selectedGradient);
                        currentList.put(player, blockList);
                        player.closeInventory();

                        CustomGradientInventory.openEditInventory(player, blockList);
                    }else if(event.isLeftClick()) {
                        ColorGradients colorGradients = ncPlayer.getColorGradients();

                        double oldSelected = colorGradients.getSelectedGradient();
                        int slot = (int) Math.round(oldSelected - (Math.floor(oldSelected/36) * 36));

                        ItemMeta oldItemMeta = event.getInventory().getItem(slot).getItemMeta();
                        oldItemMeta.removeEnchant(Enchantment.ARROW_INFINITE);
                        event.getInventory().getItem(slot).setItemMeta(oldItemMeta);

                        ItemStack itemStack = event.getCurrentItem();
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        itemStack.setItemMeta(itemMeta);

                        colorGradients.setSelectedGradient(Integer.parseInt(itemMeta.getDisplayName().split(" ")[3])-1);
                        ncPlayer.setColorGradients(colorGradients);
                        FileManager.updatePlayerConfigFile(ncPlayer);
                    }
                }
            }
        }
    }

    /*
     *   Listener for the new color gradient UI
     */
    @EventHandler
    public void onNewColorGradientClickEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getClickedInventory() != null) {
            if (event.getView().getTitle().startsWith("§9New Color Gradient")) {
                if (event.getClickedInventory() != player.getInventory()) {
                    event.setCancelled(true);

                    if (event.getCurrentItem() != null) {
                        List<Material> blockList = currentList.get(player);

                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("SAVE")) {
                            if (blockList.size() > 1) {
                                ncPlayer.getColorGradients().addNewColorGradient(blockList);
                                FileManager.updatePlayerConfigFile(ncPlayer);

                                player.closeInventory();
                                CustomGradientInventory.openSelectInventory(player);
                            }
                        } else if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                            if (blockList.isEmpty()) {
                                if (event.getSlot() == 0) {
                                    if ((event.getCursor() != null) && (event.getCursor().getType().isBlock()) && (event.getCursor().getType().isSolid())) {
                                        ItemStack cursorItem = new ItemStack(event.getCursor().getType(), 1);
                                        event.getInventory().setItem(event.getSlot(), cursorItem);
                                        event.getInventory().setItem(event.getSlot() + 1, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));

                                        blockList.add(cursorItem.getType());
                                        currentList.put(player, blockList);
                                    }
                                }
                            } else {
                                if (event.getSlot() == blockList.size() && event.getSlot() < 36) {
                                    if ((event.getCursor() != null) && (event.getCursor().getType().isBlock()) && (event.getCursor().getType().isSolid())) {
                                        ItemStack cursorItem = new ItemStack(event.getCursor().getType(), 1);
                                        if (!blockList.contains(cursorItem.getType())) {
                                            event.getInventory().setItem(event.getSlot(), cursorItem);
                                            if (event.getSlot() + 1 != 36) {
                                                event.getInventory().setItem(event.getSlot() + 1, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
                                            }

                                            blockList.add(cursorItem.getType());
                                            currentList.put(player, blockList);
                                        }
                                    }
                                }
                            }
                        } else {
                            if (event.getCursor().getType() == Material.AIR) {
                                if (!blockList.isEmpty()) {
                                    if (event.getSlot() == (blockList.size() - 1)) {
                                        event.getInventory().setItem(event.getSlot(), new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
                                        event.getInventory().setItem(event.getSlot() + 1, new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1));

                                        blockList.remove(blockList.get(event.getSlot()));
                                        currentList.put(player, blockList);
                                    }
                                }
                            } else if ((event.getCursor() != null) && (event.getCursor().getType().isBlock()) && (event.getCursor().getType().isSolid())) {
                                if (!blockList.isEmpty()) {
                                    if (event.getSlot() <= (blockList.size() - 1)) {
                                        ItemStack cursorItem = new ItemStack(event.getCursor().getType(), 1);
                                        if (!blockList.contains(cursorItem.getType())) {
                                            event.getInventory().setItem(event.getSlot(), cursorItem);

                                            blockList.remove(blockList.get(event.getSlot()));
                                            blockList.add(cursorItem.getType());
                                            currentList.put(player, blockList);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (event.getView().getTitle().startsWith("§9Edit Color Gradient")) {
                if (event.getClickedInventory() != player.getInventory()) {
                    event.setCancelled(true);

                    if (event.getCurrentItem() != null) {
                        List<String> blockList = currentList.get(player);

                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains("SAVE")) {
                            if (blockList.size() > 1) {
                                ncPlayer.getColorGradients().setColorGradient(blockList, ncPlayer.getColorGradients().getSelectedGradient());
                                FileManager.updatePlayerConfigFile(ncPlayer);

                                player.closeInventory();
                                CustomGradientInventory.openSelectInventory(player);
                            }
                        } if(event.getCurrentItem().getItemMeta().getDisplayName().contains("DELETE")){
                            ncPlayer.getColorGradients().getGradientList().remove(ncPlayer.getColorGradients().getSelectedGradient());
                            FileManager.updatePlayerConfigFile(ncPlayer);

                            ColorGradients colorGradients = ncPlayer.getColorGradients();
                            if(ncPlayer.getColorGradients().getGradientList().isEmpty()) {
                                colorGradients.setSelectedGradient(-1);
                            }else{
                                colorGradients.setSelectedGradient(0);
                            }
                            ncPlayer.setColorGradients(colorGradients);
                            FileManager.updatePlayerConfigFile(ncPlayer);

                            player.closeInventory();
                            CustomGradientInventory.openSelectInventory(player);
                        } else if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                            if (blockList.isEmpty()) {
                                if (event.getSlot() == 0) {
                                    if ((event.getCursor() != null) && (event.getCursor().getType().isBlock()) && (event.getCursor().getType().isSolid())) {
                                        ItemStack cursorItem = new ItemStack(event.getCursor().getType(), 1);
                                        event.getInventory().setItem(event.getSlot(), cursorItem);
                                        event.getInventory().setItem(event.getSlot() + 1, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));

                                        blockList.add(cursorItem.getType().toString());
                                        currentList.put(player, blockList);
                                    }
                                }
                            } else {
                                if (event.getSlot() == blockList.size() && event.getSlot() < 36) {
                                    if ((event.getCursor() != null) && (event.getCursor().getType().isBlock()) && (event.getCursor().getType().isSolid())) {
                                        ItemStack cursorItem = new ItemStack(event.getCursor().getType(), 1);
                                        if (!blockList.contains(cursorItem.getType().toString())) {
                                            event.getInventory().setItem(event.getSlot(), cursorItem);
                                            if (event.getSlot() + 1 != 36) {
                                                event.getInventory().setItem(event.getSlot() + 1, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
                                            }

                                            blockList.add(cursorItem.getType().toString());
                                            currentList.put(player, blockList);
                                        }
                                    }
                                }
                            }
                        } else {
                            if (event.getCursor().getType() == Material.AIR) {
                                if (!blockList.isEmpty()) {
                                    if (event.getSlot() == (blockList.size() - 1)) {
                                        event.getInventory().setItem(event.getSlot(), new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
                                        event.getInventory().setItem(event.getSlot() + 1, new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1));

                                        blockList.remove(blockList.get(event.getSlot()));
                                        currentList.put(player, blockList);
                                    }
                                }
                            } else if ((event.getCursor() != null) && (event.getCursor().getType().isBlock()) && (event.getCursor().getType().isSolid())) {
                                if (!blockList.isEmpty()) {
                                    if (event.getSlot() <= (blockList.size() - 1)) {
                                        ItemStack cursorItem = new ItemStack(event.getCursor().getType(), 1);
                                        if (!blockList.contains(cursorItem.getType().toString())) {
                                            event.getInventory().setItem(event.getSlot(), cursorItem);

                                            blockList.remove(blockList.get(event.getSlot()));
                                            blockList.add(cursorItem.getType().toString());
                                            currentList.put(player, blockList);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
