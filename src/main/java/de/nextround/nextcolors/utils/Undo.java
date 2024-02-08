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
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Undo {

    List<Block> blocks;
    List<Material> materials;

    Player player;
    public List<Undo> undoList;
    public static HashMap<Player, List> undoPlayers = new HashMap<Player, List>();

    public Undo(List<Block> blocks, Player player){
        if(!undoPlayers.containsKey(player)) {
            undoPlayers.put(player, new ArrayList());
        }

        this.blocks = blocks;
        this.player = player;
        this.undoList = undoPlayers.get(player);
        this.materials = new ArrayList();

        for(Block b : this.blocks) {
            materials.add(b.getType());
        }
    }

    public void addNewUndo(Undo u) {
        if(undoList.size() == 100) {
            undoList.add(u);
            undoList.remove(0);
            undoPlayers.put(player, undoList);
        }else if(undoList.size() < 100) {
            undoList.add(u);
            undoPlayers.put(player, undoList);
        }
    }

    public void performUndo() {
        for(Block b : blocks) {
            b.getLocation().getBlock().setType(materials.get(blocks.indexOf(b)));
        }
    }
}
