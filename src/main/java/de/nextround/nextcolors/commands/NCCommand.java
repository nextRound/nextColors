package de.nextround.nextcolors.commands;

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
import de.nextround.nextcolors.utils.Undo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NCCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("nc")) {
            if(!player.hasPermission("nextcolors.command.nc")) {
                player.sendMessage(nextColors.getPrefix() + " §cYou do not have permission to perform this command!");
                return false;
            }

            if(args.length==0) {
                player.sendMessage(nextColors.getPrefix() + " §9Usage§8: §f/nc §7<§fundo§7>");
            }else if(args.length==1) {
                if (args[0].equalsIgnoreCase("undo")) {
                    if (Undo.undoPlayers.containsKey(player)) {
                        if (Undo.undoPlayers.get(player).isEmpty()) {
                            player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                            return false;
                        }

                        Undo undo = (Undo) Undo.undoPlayers.get(player).get(Undo.undoPlayers.get(player).size() - 1);

                        undo.performUndo();

                        Undo.undoPlayers.get(player).remove(Undo.undoPlayers.get(player).size() - 1);

                        player.sendMessage(nextColors.getPrefix() + " §9Undo!");
                    } else {
                        player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                        return false;
                    }
                }
            }else if(args.length == 2) {
                if (args[0].equalsIgnoreCase("undo")) {
                    int undoInt = Integer.parseInt(args[1]);

                    if (undoInt > 100 || undoInt < 1) {
                        player.sendMessage(nextColors.getPrefix() + " §9Usage§8: §f/nc undo §7<§f1§8-§f100§7>");
                        return false;
                    }
                    if (Undo.undoPlayers.get(player).isEmpty()) {
                        player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                        return false;
                    }

                    if (Undo.undoPlayers.containsKey(player)) {
                        player.sendMessage(nextColors.getPrefix() + " §9" + undoInt + "x Undo");
                        for (int i = 0; i < undoInt; i++) {
                            if (Undo.undoPlayers.containsKey(player)) {
                                if (Undo.undoPlayers.get(player).isEmpty()) {
                                    player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                                    return false;
                                }

                                Undo undo = (Undo) Undo.undoPlayers.get(player).get(Undo.undoPlayers.get(player).size() - 1);

                                undo.performUndo();

                                Undo.undoPlayers.get(player).remove(Undo.undoPlayers.get(player).size() - 1);
                            }
                        }
                    } else {
                        player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                        return false;
                    }
                }
            }
        }else if(command.getName().equalsIgnoreCase("ncu")) {
            if(!player.hasPermission("nextcolors.command.nc")) {
                player.sendMessage(nextColors.getPrefix() + " §cYou do not have permission to perform this command!");
                return false;
            }

            if(args.length==0) {
                if (Undo.undoPlayers.containsKey(player)) {
                    if (Undo.undoPlayers.get(player).isEmpty()) {
                        player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                        return false;
                    }

                    Undo undo = (Undo) Undo.undoPlayers.get(player).get(Undo.undoPlayers.get(player).size() - 1);

                    undo.performUndo();

                    Undo.undoPlayers.get(player).remove(Undo.undoPlayers.get(player).size() - 1);

                    player.sendMessage(nextColors.getPrefix() + " §9Undo!");
                } else {
                    player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                    return false;
                }
            }else if(args.length == 1) {
                int undoInt = Integer.parseInt(args[0]);

                if (undoInt > 100 || undoInt < 1) {
                    player.sendMessage(nextColors.getPrefix() + " §9Usage§8: §f/ncu §7<§f1§8-§f100§7>");
                    return false;
                }
                if (Undo.undoPlayers.get(player).isEmpty()) {
                    player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                    return false;
                }

                if (Undo.undoPlayers.containsKey(player)) {
                    player.sendMessage(nextColors.getPrefix() + " §9" + undoInt + "x Undo");
                    for (int i = 0; i < undoInt; i++) {
                        if (Undo.undoPlayers.containsKey(player)) {
                            if (Undo.undoPlayers.get(player).isEmpty()) {
                                player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                                return false;
                            }

                            Undo undo = (Undo) Undo.undoPlayers.get(player).get(Undo.undoPlayers.get(player).size() - 1);

                            undo.performUndo();

                            Undo.undoPlayers.get(player).remove(Undo.undoPlayers.get(player).size() - 1);
                        }
                    }
                } else {
                    player.sendMessage(nextColors.getPrefix() + " §cThere is nothing left to undo!");
                    return false;
                }
            }
        }
        return false;
    }
}
