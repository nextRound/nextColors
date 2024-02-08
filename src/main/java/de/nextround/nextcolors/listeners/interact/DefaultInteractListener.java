package de.nextround.nextcolors.listeners.interact;/*
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
import de.nextround.nextcolors.utils.Undo;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Set;

public class DefaultInteractListener implements Listener {

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        NCPlayer ncPlayer = NCPlayer.getNCPlayer(player.getUniqueId());

        if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR) {
            if (player.getItemInHand().getType() == Material.CLAY_BALL) {
                if (player.hasPermission("nextcolors.interact.use")) {
                    event.setCancelled(true);

                    if (ncPlayer.getBrushType() == Brush.BrushType.SPHERE) {
                        Location targetLocation = player.getTargetBlock((Set<Material>) null, 150).getLocation();

                        Undo undo = new Undo(Brush.getBlocksLookingAt(targetLocation, ncPlayer.getSize()), player);
                        undo.addNewUndo(undo);

                        Brush brush = new Brush(ncPlayer, false, Brush.BrushType.SPHERE, targetLocation);
                        brush.brushAtLocation();
                    } else if (ncPlayer.getBrushType() == Brush.BrushType.SPLATTER) {
                        Location targetLocation = player.getTargetBlock((Set<Material>) null, 150).getLocation();

                        Undo undo = new Undo(Brush.getBlocksLookingAt(targetLocation, ncPlayer.getSize()), player);
                        undo.addNewUndo(undo);

                        Brush brush = new Brush(ncPlayer, false, Brush.BrushType.SPLATTER, targetLocation);
                        brush.brushAtLocation();
                    }
                }
            }
        } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (player.getItemInHand().getType() == Material.CLAY_BALL) {
                if (player.hasPermission("nextcolors.interact.use")) {
                    event.setCancelled(true);

                    if (ncPlayer.getBrushType() == Brush.BrushType.SPHERE) {
                        Location targetLocation = player.getTargetBlock((Set<Material>) null, 150).getLocation();

                        Undo undo = new Undo(Brush.getBlocksLookingAt(targetLocation, ncPlayer.getSize()), player);
                        undo.addNewUndo(undo);

                        Brush brush = new Brush(ncPlayer, true, Brush.BrushType.SPHERE, targetLocation);
                        brush.brushAtLocation();
                    } else if (ncPlayer.getBrushType() == Brush.BrushType.SPLATTER) {
                        Location targetLocation = player.getTargetBlock((Set<Material>) null, 150).getLocation();

                        Undo undo = new Undo(Brush.getBlocksLookingAt(targetLocation, ncPlayer.getSize()), player);
                        undo.addNewUndo(undo);

                        Brush brush = new Brush(ncPlayer, true, Brush.BrushType.SPLATTER, targetLocation);
                        brush.brushAtLocation();
                    }
                }
            }
        }
    }
}
