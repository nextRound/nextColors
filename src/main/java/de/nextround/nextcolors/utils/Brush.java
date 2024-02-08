package de.nextround.nextcolors.utils;

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

import de.nextround.nextcolors.nextColors;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Brush {

    private NCPlayer ncPlayer;
    private boolean rightClick;
    private BrushType brushType;
    private Location targetLocation;

    public Brush(NCPlayer ncPlayer, boolean rightClick, BrushType brushType, Location targetLocation) {
        this.ncPlayer = ncPlayer;
        this.rightClick = rightClick;
        this.brushType = brushType;
        this.targetLocation = targetLocation;
    }

    public enum BrushType {
        SPHERE,
        SPLATTER
    }

    public NCPlayer getNCPlayer() {
        return ncPlayer;
    }

    public boolean isRightClick() {
        return rightClick;
    }

    public BrushType getBrushType() {
        return brushType;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    public void brushAtLocation() {
        Player player = Bukkit.getPlayer(ncPlayer.getUuid());

        if (ncPlayer.getMode() == 0) {
            for (Block block : getBlocksLookingAt(targetLocation, ncPlayer.getSize())) {
                ItemStack item = new ItemStack(block.getType(), 1);

                if (ColorChains.allBlocks.containsKey(item)) {
                    if (ncPlayer.getMaskMode() == 0) {
                        if (nextColors.plotSquaredEnabled) {
                            if (nextColors.canBlockBePlaced(player, block.getLocation())) {
                                placeBlock(item, block);
                            }
                        } else {
                            placeBlock(item, block);
                        }
                    } else if (ncPlayer.getMaskMode() == 1) {
                        if (nextColors.plotSquaredEnabled) {
                            if (nextColors.canBlockBePlaced(player, block.getLocation())) {
                                checkForMask(item, block);
                            }
                        } else {
                            checkForMask(item, block);
                        }
                    }
                }
            }
        } else if (ncPlayer.getMode() == 1) {
            for (Block block : getBlocksLookingAt(targetLocation, ncPlayer.getSize())) {
                ItemStack item = new ItemStack(block.getType(), 1);

                if (ncPlayer.getColorGradients().getGradientList().get(ncPlayer.getColorGradients().getSelectedGradient()).contains(item.getType().toString())) {
                    if (nextColors.plotSquaredEnabled) {
                        if (nextColors.canBlockBePlaced(player, block.getLocation())) {
                            placeBlock(item, block);
                        }
                    } else {
                        placeBlock(item, block);
                    }
                }
            }
        }
    }

    public void placeBlock(ItemStack item, Block block) {
        if (ncPlayer.getMode() == 0) {
            if (ColorChains.allBlocks.get(item).indexOf(item) == 0) {
                if (rightClick) {
                    ItemStack item0 = (ItemStack) ColorChains.allBlocks.get(item).get(ColorChains.allBlocks.get(item).indexOf(item) + 1);

                    if (brushType == BrushType.SPHERE) {
                        block.setType(item0.getType());
                    } else if (brushType == BrushType.SPLATTER) {
                        double distanceToBlock = targetLocation.distance(block.getLocation());

                        int percentage = (int) (distanceToBlock / (ncPlayer.getPercentage() / 2) * 100);

                        if (new Random().nextInt(100) > percentage) {
                            block.setType(item0.getType());
                        } else if (new Random().nextInt(100) < percentage && new Random().nextInt(100) < ncPlayer.getPercentage()) {
                            block.setType(item0.getType());
                        }
                    }
                }
            } else if (ColorChains.allBlocks.get(item).indexOf(item) == ColorChains.allBlocks.get(item).size() - 1) {
                if (!rightClick) {
                    ItemStack item0 = (ItemStack) ColorChains.allBlocks.get(item).get(ColorChains.allBlocks.get(item).indexOf(item) - 1);

                    if (brushType == BrushType.SPHERE) {
                        block.setType(item0.getType());
                    } else if (brushType == BrushType.SPLATTER) {
                        double distanceToBlock = targetLocation.distance(block.getLocation());

                        int percentage = (int) (distanceToBlock / (ncPlayer.getPercentage() / 2) * 100);

                        if (new Random().nextInt(100) > percentage) {
                            block.setType(item0.getType());
                        } else if (new Random().nextInt(100) < percentage && new Random().nextInt(100) < ncPlayer.getPercentage()) {
                            block.setType(item0.getType());
                        }
                    }
                }
            } else if (ColorChains.allBlocks.get(item).indexOf(item) > 0) {
                ItemStack item0;

                if (rightClick) {
                    item0 = (ItemStack) ColorChains.allBlocks.get(item).get(ColorChains.allBlocks.get(item).indexOf(item) + 1);
                } else {
                    item0 = (ItemStack) ColorChains.allBlocks.get(item).get(ColorChains.allBlocks.get(item).indexOf(item) - 1);
                }

                if (brushType == BrushType.SPHERE) {
                    block.setType(item0.getType());
                } else if (brushType == BrushType.SPLATTER) {
                    double distanceToBlock = targetLocation.distance(block.getLocation());

                    int percentage = (int) (distanceToBlock / (ncPlayer.getPercentage() / 2) * 100);

                    if (new Random().nextInt(100) > percentage) {
                        block.setType(item0.getType());
                    } else if (new Random().nextInt(100) < percentage && new Random().nextInt(100) < ncPlayer.getPercentage()) {
                        block.setType(item0.getType());
                    }
                }
            }
        }else if (ncPlayer.getMode() == 1) {
            List<String> blockList = ncPlayer.getColorGradients().getGradientList().get(ncPlayer.getColorGradients().getSelectedGradient());

            if (blockList.indexOf(item.getType().toString()) == 0) {
                if (rightClick) {
                    ItemStack item0 = new ItemStack(Material.getMaterial(blockList.get(blockList.indexOf(item.getType().toString()) + 1)));

                    if (brushType == BrushType.SPHERE) {
                        block.setType(item0.getType());
                    } else if (brushType == BrushType.SPLATTER) {
                        double distanceToBlock = targetLocation.distance(block.getLocation());

                        int percentage = (int) (distanceToBlock / (ncPlayer.getPercentage() / 2) * 100);

                        if (new Random().nextInt(100) > percentage) {
                            block.setType(item0.getType());
                        } else if (new Random().nextInt(100) < percentage && new Random().nextInt(100) < ncPlayer.getPercentage()) {
                            block.setType(item0.getType());
                        }
                    }
                }
            } else if (blockList.indexOf(item.getType().toString()) == blockList.size() - 1) {
                if (!rightClick) {
                    ItemStack item0 = new ItemStack(Material.getMaterial(blockList.get(blockList.indexOf(item.getType().toString()) - 1)));

                    if (brushType == BrushType.SPHERE) {
                        block.setType(item0.getType());
                    } else if (brushType == BrushType.SPLATTER) {
                        double distanceToBlock = targetLocation.distance(block.getLocation());

                        int percentage = (int) (distanceToBlock / (ncPlayer.getPercentage() / 2) * 100);

                        if (new Random().nextInt(100) > percentage) {
                            block.setType(item0.getType());
                        } else if (new Random().nextInt(100) < percentage && new Random().nextInt(100) < ncPlayer.getPercentage()) {
                            block.setType(item0.getType());
                        }
                    }
                }
            } else if (blockList.indexOf(item.getType().toString()) > 0) {
                ItemStack item0;

                if (rightClick) {
                    item0 = new ItemStack(Material.getMaterial(blockList.get(blockList.indexOf(item.getType().toString()) + 1)));
                } else {
                    item0 = new ItemStack(Material.getMaterial(blockList.get(blockList.indexOf(item.getType().toString()) - 1)));
                }

                if (brushType == BrushType.SPHERE) {
                    block.setType(item0.getType());
                } else if (brushType == BrushType.SPLATTER) {
                    double distanceToBlock = targetLocation.distance(block.getLocation());

                    int percentage = (int) (distanceToBlock / (ncPlayer.getPercentage() / 2) * 100);

                    if (new Random().nextInt(100) > percentage) {
                        block.setType(item0.getType());
                    } else if (new Random().nextInt(100) < percentage && new Random().nextInt(100) < ncPlayer.getPercentage()) {
                        block.setType(item0.getType());
                    }
                }
            }
        }
    }

    public void checkForMask(ItemStack item, Block block) {
        if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.PINK_STAINED_GLASS, 1)) && ncPlayer.getMask().isRedGlass()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.WHITE_STAINED_GLASS, 1)) && ncPlayer.getMask().isGreyGlass()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.MAGENTA_STAINED_GLASS, 1)) && ncPlayer.getMask().isPurpleGlass()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.LIME_STAINED_GLASS, 1)) && ncPlayer.getMask().isGreenGlass()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1)) && ncPlayer.getMask().isBlueGlass()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.END_STONE_BRICKS, 1)) && ncPlayer.getMask().isBrown()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.HONEYCOMB_BLOCK, 1)) && ncPlayer.getMask().isOrange()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.GOLD_BLOCK, 1)) && ncPlayer.getMask().isYellow()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.EMERALD_BLOCK, 1)) && ncPlayer.getMask().isGreen()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.PACKED_ICE, 1)) && ncPlayer.getMask().isBlue()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.PURPLE_TERRACOTTA, 1)) && ncPlayer.getMask().isPurple()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.PINK_WOOL, 1)) && ncPlayer.getMask().isPink()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.BRICKS, 1)) && ncPlayer.getMask().isRed()) {
            placeBlock(item, block);
        } else if (ColorChains.allBlocks.get(item).contains(new ItemStack(Material.SNOW_BLOCK, 1)) && ncPlayer.getMask().isGrey()) {
            placeBlock(item, block);
        }
    }

    public static List<Block> getBlocksLookingAt(Location middle, double diameter) {
        List<Block> blocks = new ArrayList<Block>();

        for (double x = middle.getX() - diameter / 2; x <= middle.getX() + diameter / 2; x++) {
            for (double y = middle.getY() - diameter / 2; y <= middle.getY() + diameter / 2; y++) {
                for(double z = middle.getZ() - diameter / 2; z <= middle.getZ() + diameter / 2; z++) {

                    Location loc = new Location(middle.getWorld(), x, y, z);

                    if(loc.getBlock().getType() != Material.AIR) {
                        if(loc.distance(middle) < diameter / 2) {
                            blocks.add(loc.getBlock());
                        }
                    }

                }
            }
        }
        return blocks;
    }
}
