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

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColorChains {

    public static HashMap<ItemStack, List> allBlocks = new HashMap<ItemStack, List>();

    public static List<ItemStack> brown = new ArrayList<ItemStack>();
    public static List<ItemStack> orange = new ArrayList<ItemStack>();
    public static List<ItemStack> yellow = new ArrayList<ItemStack>();
    public static List<ItemStack> green = new ArrayList<ItemStack>();
    public static List<ItemStack> blue = new ArrayList<ItemStack>();
    public static List<ItemStack> purple = new ArrayList<ItemStack>();
    public static List<ItemStack> pink = new ArrayList<ItemStack>();
    public static List<ItemStack> red = new ArrayList<ItemStack>();
    public static List<ItemStack> grey = new ArrayList<ItemStack>();
    public static List<ItemStack> blueGlass = new ArrayList<ItemStack>();
    public static List<ItemStack> greenGlass = new ArrayList<ItemStack>();
    public static List<ItemStack> purpleGlass = new ArrayList<ItemStack>();
    public static List<ItemStack> greyGlass = new ArrayList<ItemStack>();
    public static List<ItemStack> redGlass = new ArrayList<ItemStack>();

    public static void setBlockLists() {

       /*
        *   Red glass gradient
        */
        allBlocks.put(new ItemStack(Material.PINK_STAINED_GLASS, 1), redGlass);
        allBlocks.put(new ItemStack(Material.RED_STAINED_GLASS, 1), redGlass);

        redGlass.add(new ItemStack(Material.PINK_STAINED_GLASS, 1));
        redGlass.add(new ItemStack(Material.RED_STAINED_GLASS, 1));

       /*
        *   Black to white glass gradient
        */
        allBlocks.put(new ItemStack(Material.WHITE_STAINED_GLASS, 1), greyGlass);
        allBlocks.put(new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 1), greyGlass);
        allBlocks.put(new ItemStack(Material.GRAY_STAINED_GLASS, 1), greyGlass);
        allBlocks.put(new ItemStack(Material.BLACK_STAINED_GLASS, 1), greyGlass);

        greyGlass.add(new ItemStack(Material.WHITE_STAINED_GLASS, 1));
        greyGlass.add(new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 1));
        greyGlass.add(new ItemStack(Material.GRAY_STAINED_GLASS, 1));
        greyGlass.add(new ItemStack(Material.BLACK_STAINED_GLASS, 1));

       /*
        *   Purple glass gradient
        */
        allBlocks.put(new ItemStack(Material.MAGENTA_STAINED_GLASS, 1), purpleGlass);
        allBlocks.put(new ItemStack(Material.PURPLE_STAINED_GLASS, 1), purpleGlass);

        purpleGlass.add(new ItemStack(Material.MAGENTA_STAINED_GLASS, 1));
        purpleGlass.add(new ItemStack(Material.PURPLE_STAINED_GLASS, 1));

       /*
        *   Green glass gradient
        */
        allBlocks.put(new ItemStack(Material.LIME_STAINED_GLASS, 1), greenGlass);
        allBlocks.put(new ItemStack(Material.GREEN_STAINED_GLASS, 1), greenGlass);

        greenGlass.add(new ItemStack(Material.LIME_STAINED_GLASS, 1));
        greenGlass.add(new ItemStack(Material.GREEN_STAINED_GLASS, 1));

       /*
        *   Blue glass gradient
        */
        allBlocks.put(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1), blueGlass);
        allBlocks.put(new ItemStack(Material.CYAN_STAINED_GLASS, 1), blueGlass);
        allBlocks.put(new ItemStack(Material.BLUE_STAINED_GLASS, 1), blueGlass);

        blueGlass.add(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 1));
        blueGlass.add(new ItemStack(Material.CYAN_STAINED_GLASS, 1));
        blueGlass.add(new ItemStack(Material.BLUE_STAINED_GLASS, 1));

       /*
        *   Brown gradient
        */
        allBlocks.put(new ItemStack(Material.END_STONE_BRICKS, 1), brown);
        allBlocks.put(new ItemStack(Material.END_STONE, 1), brown);
        allBlocks.put(new ItemStack(Material.SMOOTH_SANDSTONE, 1), brown);
        allBlocks.put(new ItemStack(Material.SANDSTONE, 1), brown);
        allBlocks.put(new ItemStack(Material.BIRCH_PLANKS, 1), brown);
        allBlocks.put(new ItemStack(Material.STRIPPED_BIRCH_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.STRIPPED_JUNGLE_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.STRIPPED_OAK_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.OAK_PLANKS, 1), brown);
        allBlocks.put(new ItemStack(Material.DIRT, 1), brown);
        allBlocks.put(new ItemStack(Material.COARSE_DIRT, 1), brown);
        allBlocks.put(new ItemStack(Material.BROWN_MUSHROOM_BLOCK, 1), brown);
        allBlocks.put(new ItemStack(Material.OAK_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.STRIPPED_SPRUCE_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.SPRUCE_PLANKS, 1), brown);
        allBlocks.put(new ItemStack(Material.STRIPPED_DARK_OAK_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.JUNGLE_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.BROWN_WOOL, 1), brown);
        allBlocks.put(new ItemStack(Material.BROWN_CONCRETE, 1), brown);
        allBlocks.put(new ItemStack(Material.NOTE_BLOCK, 1), brown);
        allBlocks.put(new ItemStack(Material.SOUL_SAND, 1), brown);
        allBlocks.put(new ItemStack(Material.BROWN_TERRACOTTA, 1), brown);
        allBlocks.put(new ItemStack(Material.GRAY_TERRACOTTA, 1), brown);
        allBlocks.put(new ItemStack(Material.DARK_OAK_PLANKS, 1), brown);
        allBlocks.put(new ItemStack(Material.DARK_OAK_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.SPRUCE_WOOD, 1), brown);
        allBlocks.put(new ItemStack(Material.BLACK_TERRACOTTA, 1), brown);

        brown.add(new ItemStack(Material.END_STONE_BRICKS, 1));
        brown.add(new ItemStack(Material.END_STONE, 1));
        brown.add(new ItemStack(Material.SMOOTH_SANDSTONE, 1));
        brown.add(new ItemStack(Material.SANDSTONE, 1));
        brown.add(new ItemStack(Material.BIRCH_PLANKS, 1));
        brown.add(new ItemStack(Material.STRIPPED_BIRCH_WOOD, 1));
        brown.add(new ItemStack(Material.STRIPPED_JUNGLE_WOOD, 1));
        brown.add(new ItemStack(Material.STRIPPED_OAK_WOOD, 1));
        brown.add(new ItemStack(Material.OAK_PLANKS, 1));
        brown.add(new ItemStack(Material.DIRT, 1));
        brown.add(new ItemStack(Material.COARSE_DIRT, 1));
        brown.add(new ItemStack(Material.BROWN_MUSHROOM_BLOCK, 1));
        brown.add(new ItemStack(Material.OAK_WOOD, 1));
        brown.add(new ItemStack(Material.STRIPPED_SPRUCE_WOOD, 1));
        brown.add(new ItemStack(Material.SPRUCE_PLANKS, 1));
        brown.add(new ItemStack(Material.STRIPPED_DARK_OAK_WOOD, 1));
        brown.add(new ItemStack(Material.JUNGLE_WOOD, 1));
        brown.add(new ItemStack(Material.BROWN_WOOL, 1));
        brown.add(new ItemStack(Material.BROWN_CONCRETE, 1));
        brown.add(new ItemStack(Material.NOTE_BLOCK, 1));
        brown.add(new ItemStack(Material.SOUL_SAND, 1));
        brown.add(new ItemStack(Material.BROWN_TERRACOTTA, 1));
        brown.add(new ItemStack(Material.GRAY_TERRACOTTA, 1));
        brown.add(new ItemStack(Material.DARK_OAK_PLANKS, 1));
        brown.add(new ItemStack(Material.DARK_OAK_WOOD, 1));
        brown.add(new ItemStack(Material.SPRUCE_WOOD, 1));
        brown.add(new ItemStack(Material.BLACK_TERRACOTTA, 1));

       /*
        *  Orange gradient
        */
        allBlocks.put(new ItemStack(Material.HONEYCOMB_BLOCK, 1), orange);
        allBlocks.put(new ItemStack(Material.PUMPKIN, 1), orange);
        allBlocks.put(new ItemStack(Material.ORANGE_WOOL, 1), orange);
        allBlocks.put(new ItemStack(Material.ORANGE_CONCRETE, 1), orange);
        allBlocks.put(new ItemStack(Material.ACACIA_PLANKS, 1), orange);
        allBlocks.put(new ItemStack(Material.SMOOTH_RED_SANDSTONE, 1), orange);
        allBlocks.put(new ItemStack(Material.ORANGE_TERRACOTTA, 1), orange);
        allBlocks.put(new ItemStack(Material.STRIPPED_ACACIA_WOOD, 1), orange);
        allBlocks.put(new ItemStack(Material.TERRACOTTA, 1), orange);

        orange.add(new ItemStack(Material.HONEYCOMB_BLOCK, 1));
        orange.add(new ItemStack(Material.PUMPKIN, 1));
        orange.add(new ItemStack(Material.ORANGE_WOOL, 1));
        orange.add(new ItemStack(Material.ORANGE_CONCRETE, 1));
        orange.add(new ItemStack(Material.ACACIA_PLANKS, 1));
        orange.add(new ItemStack(Material.SMOOTH_RED_SANDSTONE, 1));
        orange.add(new ItemStack(Material.ORANGE_TERRACOTTA, 1));
        orange.add(new ItemStack(Material.STRIPPED_ACACIA_WOOD, 1));
        orange.add(new ItemStack(Material.TERRACOTTA, 1));

       /*
        *   Yellow gradient
        */
        allBlocks.put(new ItemStack(Material.GOLD_BLOCK, 1), yellow);
        allBlocks.put(new ItemStack(Material.YELLOW_WOOL, 1), yellow);
        allBlocks.put(new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA, 1), yellow);
        allBlocks.put(new ItemStack(Material.YELLOW_CONCRETE, 1), yellow);
        allBlocks.put(new ItemStack(Material.HAY_BLOCK, 1), yellow);
        allBlocks.put(new ItemStack(Material.YELLOW_TERRACOTTA, 1), yellow);

        yellow.add(new ItemStack(Material.GOLD_BLOCK, 1));
        yellow.add(new ItemStack(Material.YELLOW_WOOL, 1));
        yellow.add(new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA, 1));
        yellow.add(new ItemStack(Material.YELLOW_CONCRETE, 1));
        yellow.add(new ItemStack(Material.HAY_BLOCK, 1));
        yellow.add(new ItemStack(Material.YELLOW_TERRACOTTA, 1));

       /*
        *   Green gradient
        */
        allBlocks.put(new ItemStack(Material.EMERALD_BLOCK, 1), green);
        allBlocks.put(new ItemStack(Material.SLIME_BLOCK, 1), green);
        allBlocks.put(new ItemStack(Material.LIME_WOOL, 1), green);
        allBlocks.put(new ItemStack(Material.LIME_CONCRETE, 1), green);
        allBlocks.put(new ItemStack(Material.MELON, 1), green);
        allBlocks.put(new ItemStack(Material.LIME_TERRACOTTA, 1), green);
        allBlocks.put(new ItemStack(Material.GREEN_WOOL, 1), green);
        allBlocks.put(new ItemStack(Material.GREEN_CONCRETE, 1), green);
        allBlocks.put(new ItemStack(Material.GREEN_TERRACOTTA, 1), green);
        allBlocks.put(new ItemStack(Material.DARK_PRISMARINE, 1), green);

        green.add(new ItemStack(Material.EMERALD_BLOCK, 1));
        green.add(new ItemStack(Material.SLIME_BLOCK, 1));
        green.add(new ItemStack(Material.LIME_WOOL, 1));
        green.add(new ItemStack(Material.LIME_CONCRETE, 1));
        green.add(new ItemStack(Material.MELON, 1));
        green.add(new ItemStack(Material.LIME_TERRACOTTA, 1));
        green.add(new ItemStack(Material.GREEN_WOOL, 1));
        green.add(new ItemStack(Material.GREEN_CONCRETE, 1));
        green.add(new ItemStack(Material.GREEN_TERRACOTTA, 1));
        green.add(new ItemStack(Material.DARK_PRISMARINE, 1));

       /*
        *   Blue gradient
        */
        allBlocks.put(new ItemStack(Material.PACKED_ICE, 1), blue);
        allBlocks.put(new ItemStack(Material.DIAMOND_BLOCK, 1), blue);
        allBlocks.put(new ItemStack(Material.LIGHT_BLUE_WOOL, 1), blue);
        allBlocks.put(new ItemStack(Material.BLUE_ICE, 1), blue);
        allBlocks.put(new ItemStack(Material.LIGHT_BLUE_CONCRETE, 1), blue);
        allBlocks.put(new ItemStack(Material.CYAN_WOOL, 1), blue);
        allBlocks.put(new ItemStack(Material.PRISMARINE_BRICKS, 1), blue);
        allBlocks.put(new ItemStack(Material.PRISMARINE, 1), blue);
        allBlocks.put(new ItemStack(Material.CYAN_CONCRETE, 1), blue);
        allBlocks.put(new ItemStack(Material.LIGHT_BLUE_TERRACOTTA, 1), blue);
        allBlocks.put(new ItemStack(Material.BLUE_WOOL, 1), blue);
        allBlocks.put(new ItemStack(Material.BLUE_CONCRETE, 1), blue);
        allBlocks.put(new ItemStack(Material.LAPIS_BLOCK, 1), blue);
        allBlocks.put(new ItemStack(Material.BLUE_GLAZED_TERRACOTTA, 1), blue);

        blue.add(new ItemStack(Material.PACKED_ICE, 1));
        blue.add(new ItemStack(Material.DIAMOND_BLOCK, 1));
        blue.add(new ItemStack(Material.LIGHT_BLUE_WOOL, 1));
        blue.add(new ItemStack(Material.BLUE_ICE, 1));
        blue.add(new ItemStack(Material.LIGHT_BLUE_CONCRETE, 1));
        blue.add(new ItemStack(Material.CYAN_WOOL, 1));
        blue.add(new ItemStack(Material.PRISMARINE_BRICKS, 1));
        blue.add(new ItemStack(Material.PRISMARINE, 1));
        blue.add(new ItemStack(Material.CYAN_CONCRETE, 1));
        blue.add(new ItemStack(Material.LIGHT_BLUE_TERRACOTTA, 1));
        blue.add(new ItemStack(Material.BLUE_WOOL, 1));
        blue.add(new ItemStack(Material.BLUE_CONCRETE, 1));
        blue.add(new ItemStack(Material.LAPIS_BLOCK, 1));
        blue.add(new ItemStack(Material.BLUE_GLAZED_TERRACOTTA, 1));

       /*
        *   Purple gradient
        */
        allBlocks.put(new ItemStack(Material.PURPLE_TERRACOTTA, 1), purple);
        allBlocks.put(new ItemStack(Material.PURPLE_WOOL, 1), purple);
        allBlocks.put(new ItemStack(Material.PURPLE_CONCRETE, 1), purple);
        allBlocks.put(new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA, 1), purple);
        allBlocks.put(new ItemStack(Material.BLUE_TERRACOTTA, 1), purple);

        purple.add(new ItemStack(Material.PURPLE_TERRACOTTA, 1));
        purple.add(new ItemStack(Material.PURPLE_WOOL, 1));
        purple.add(new ItemStack(Material.PURPLE_CONCRETE, 1));
        purple.add(new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA, 1));
        purple.add(new ItemStack(Material.BLUE_TERRACOTTA, 1));

       /*
        *   Pink gradient
        */
        allBlocks.put(new ItemStack(Material.PINK_WOOL, 1), pink);
        allBlocks.put(new ItemStack(Material.PINK_CONCRETE, 1), pink);
        allBlocks.put(new ItemStack(Material.MAGENTA_WOOL, 1), pink);
        allBlocks.put(new ItemStack(Material.MAGENTA_CONCRETE, 1), pink);
        allBlocks.put(new ItemStack(Material.PURPUR_BLOCK, 1), pink);
        allBlocks.put(new ItemStack(Material.PURPUR_PILLAR, 1), pink);
        allBlocks.put(new ItemStack(Material.MAGENTA_TERRACOTTA, 1), pink);
        allBlocks.put(new ItemStack(Material.POLISHED_GRANITE, 1), pink);
        allBlocks.put(new ItemStack(Material.GRANITE, 1), pink);
        allBlocks.put(new ItemStack(Material.JUNGLE_PLANKS, 1), pink);
        allBlocks.put(new ItemStack(Material.LIGHT_GRAY_TERRACOTTA, 1), pink);

        pink.add(new ItemStack(Material.PINK_WOOL, 1));
        pink.add(new ItemStack(Material.PINK_CONCRETE, 1));
        pink.add(new ItemStack(Material.MAGENTA_WOOL, 1));
        pink.add(new ItemStack(Material.MAGENTA_CONCRETE, 1));
        pink.add(new ItemStack(Material.PURPUR_BLOCK, 1));
        pink.add(new ItemStack(Material.PURPUR_PILLAR, 1));
        pink.add(new ItemStack(Material.MAGENTA_TERRACOTTA, 1));
        pink.add(new ItemStack(Material.POLISHED_GRANITE, 1));
        pink.add(new ItemStack(Material.GRANITE, 1));
        pink.add(new ItemStack(Material.JUNGLE_PLANKS, 1));
        pink.add(new ItemStack(Material.LIGHT_GRAY_TERRACOTTA, 1));

       /*
        *   Red gradient
        */
        allBlocks.put(new ItemStack(Material.BRICKS, 1), red);
        allBlocks.put(new ItemStack(Material.PINK_TERRACOTTA, 1), red);
        allBlocks.put(new ItemStack(Material.RED_TERRACOTTA, 1), red);
        allBlocks.put(new ItemStack(Material.RED_GLAZED_TERRACOTTA, 1), red);
        allBlocks.put(new ItemStack(Material.RED_WOOL, 1), red);
        allBlocks.put(new ItemStack(Material.RED_CONCRETE, 1), red);
        allBlocks.put(new ItemStack(Material.NETHERRACK, 1), red);
        allBlocks.put(new ItemStack(Material.NETHER_WART_BLOCK, 1), red);
        allBlocks.put(new ItemStack(Material.RED_NETHER_BRICKS, 1), red);
        allBlocks.put(new ItemStack(Material.BLACK_GLAZED_TERRACOTTA, 1), red);
        allBlocks.put(new ItemStack(Material.NETHER_BRICKS, 1), red);

        red.add(new ItemStack(Material.BRICKS, 1));
        red.add(new ItemStack(Material.PINK_TERRACOTTA, 1));
        red.add(new ItemStack(Material.RED_TERRACOTTA, 1));
        red.add(new ItemStack(Material.RED_GLAZED_TERRACOTTA, 1));
        red.add(new ItemStack(Material.RED_WOOL, 1));
        red.add(new ItemStack(Material.RED_CONCRETE, 1));
        red.add(new ItemStack(Material.NETHERRACK, 1));
        red.add(new ItemStack(Material.NETHER_WART_BLOCK, 1));
        red.add(new ItemStack(Material.RED_NETHER_BRICKS, 1));
        red.add(new ItemStack(Material.BLACK_GLAZED_TERRACOTTA, 1));
        red.add(new ItemStack(Material.NETHER_BRICKS, 1));

       /*
        *   Color gradient from white to black
        */
        allBlocks.put(new ItemStack(Material.SNOW_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.WHITE_WOOL, 1), grey);
        allBlocks.put(new ItemStack(Material.QUARTZ_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.CHISELED_QUARTZ_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.IRON_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.WHITE_CONCRETE, 1), grey);
        allBlocks.put(new ItemStack(Material.BIRCH_WOOD, 1), grey);
        allBlocks.put(new ItemStack(Material.POLISHED_DIORITE, 1), grey);
        allBlocks.put(new ItemStack(Material.DIORITE, 1), grey);
        allBlocks.put(new ItemStack(Material.BONE_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.CLAY, 1), grey);
        allBlocks.put(new ItemStack(Material.SMOOTH_STONE, 1), grey);
        allBlocks.put(new ItemStack(Material.LIGHT_GRAY_WOOL, 1), grey);
        allBlocks.put(new ItemStack(Material.LIGHT_GRAY_CONCRETE, 1), grey);
        allBlocks.put(new ItemStack(Material.ACACIA_WOOD, 1), grey);
        allBlocks.put(new ItemStack(Material.DEAD_BUBBLE_CORAL_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.DEAD_FIRE_CORAL_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.IRON_ORE, 1), grey);
        allBlocks.put(new ItemStack(Material.ANDESITE, 1), grey);
        allBlocks.put(new ItemStack(Material.POLISHED_ANDESITE, 1), grey);
        allBlocks.put(new ItemStack(Material.STONE, 1), grey);
        allBlocks.put(new ItemStack(Material.STONE_BRICKS, 1), grey);
        allBlocks.put(new ItemStack(Material.COBBLESTONE, 1), grey);
        allBlocks.put(new ItemStack(Material.COAL_ORE, 1), grey);
        allBlocks.put(new ItemStack(Material.CYAN_TERRACOTTA, 1), grey);
        allBlocks.put(new ItemStack(Material.GRAY_WOOL, 1), grey);
        allBlocks.put(new ItemStack(Material.GRAY_CONCRETE, 1), grey);
        allBlocks.put(new ItemStack(Material.BLACK_WOOL, 1), grey);
        allBlocks.put(new ItemStack(Material.COAL_BLOCK, 1), grey);
        allBlocks.put(new ItemStack(Material.OBSIDIAN, 1), grey);
        allBlocks.put(new ItemStack(Material.BLACK_CONCRETE, 1), grey);

        grey.add(new ItemStack(Material.SNOW_BLOCK, 1));
        grey.add(new ItemStack(Material.WHITE_WOOL, 1));
        grey.add(new ItemStack(Material.QUARTZ_BLOCK, 1));
        grey.add(new ItemStack(Material.CHISELED_QUARTZ_BLOCK, 1));
        grey.add(new ItemStack(Material.IRON_BLOCK, 1));
        grey.add(new ItemStack(Material.WHITE_CONCRETE, 1));
        grey.add(new ItemStack(Material.BIRCH_WOOD, 1));
        grey.add(new ItemStack(Material.POLISHED_DIORITE, 1));
        grey.add(new ItemStack(Material.DIORITE, 1));
        grey.add(new ItemStack(Material.BONE_BLOCK, 1));
        grey.add(new ItemStack(Material.CLAY, 1));
        grey.add(new ItemStack(Material.SMOOTH_STONE, 1));
        grey.add(new ItemStack(Material.LIGHT_GRAY_WOOL, 1));
        grey.add(new ItemStack(Material.LIGHT_GRAY_CONCRETE, 1));
        grey.add(new ItemStack(Material.ACACIA_WOOD, 1));
        grey.add(new ItemStack(Material.DEAD_BUBBLE_CORAL_BLOCK, 1));
        grey.add(new ItemStack(Material.DEAD_FIRE_CORAL_BLOCK, 1));
        grey.add(new ItemStack(Material.IRON_ORE, 1));
        grey.add(new ItemStack(Material.ANDESITE, 1));
        grey.add(new ItemStack(Material.POLISHED_ANDESITE, 1));
        grey.add(new ItemStack(Material.STONE, 1));
        grey.add(new ItemStack(Material.STONE_BRICKS, 1));
        grey.add(new ItemStack(Material.COBBLESTONE, 1));
        grey.add(new ItemStack(Material.COAL_ORE, 1));
        grey.add(new ItemStack(Material.CYAN_TERRACOTTA, 1));
        grey.add(new ItemStack(Material.GRAY_WOOL, 1));
        grey.add(new ItemStack(Material.GRAY_CONCRETE, 1));
        grey.add(new ItemStack(Material.BLACK_WOOL, 1));
        grey.add(new ItemStack(Material.COAL_BLOCK, 1));
        grey.add(new ItemStack(Material.OBSIDIAN, 1));
        grey.add(new ItemStack(Material.BLACK_CONCRETE, 1));

    }
}
