package de.nextround.nextcolors;

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

import com.plotsquared.core.api.PlotAPI;
import com.plotsquared.core.plot.Plot;
import de.nextround.nextcolors.commands.NCCommand;
import de.nextround.nextcolors.listeners.OtherListeners;
import de.nextround.nextcolors.listeners.click.CustomGradientInventoryClickListeners;
import de.nextround.nextcolors.listeners.click.MainInventoryClickListeners;
import de.nextround.nextcolors.listeners.interact.DefaultInteractListener;
import de.nextround.nextcolors.utils.ColorChains;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class nextColors extends JavaPlugin {

    /* Player config version */
    public static int configVersion = 1;

    /* APIs */
    public static PlotAPI plotAPI;
    public static boolean plotSquaredEnabled;

    /* Enable */
    @Override
    public void onEnable() {

        registerListeners();
        registerCommands();

        /* Loading PlotSquaredAPI */
        if(loadPlotAPI()) {
            plotSquaredEnabled = true;
        }else{
            plotSquaredEnabled = false;
        }

        /* creates all ArrayLists for the color-chains */
        ColorChains.setBlockLists();

        /* Console enable message */
        Bukkit.broadcastMessage(getPrefix() + " §cPlease rejoin to load all features of nextColors!");

        Bukkit.getConsoleSender().sendMessage("§8[§2nextColors§8] §3The plugin is now §aEnabled");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextColors§8] §3Coded by: §enextRound");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextColors§8] §3Version: §e"+getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextColors§8] §3Thank you for downloading my plugin!");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8[§2nextColors§8] §c(c) Copyright Nicole S. 2020/21");
    }

    /* register Commands */
    public void registerCommands() {
        getCommand("nc").setExecutor(new NCCommand());
        getCommand("ncu").setExecutor(new NCCommand());
    }

    /* register all listeners */
    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new OtherListeners(), this);
        Bukkit.getPluginManager().registerEvents(new MainInventoryClickListeners(), this);
        Bukkit.getPluginManager().registerEvents(new CustomGradientInventoryClickListeners(), this);
        Bukkit.getPluginManager().registerEvents(new DefaultInteractListener(), this);
    }

    /* get the plugin massage prefix */
    public static String getPrefix() {
        return "§8[§3nextColors§8]";
    }

    /* Loads PlotAPI if PlotSquared is enabled on server */
    public boolean loadPlotAPI() {
        if((Bukkit.getPluginManager().getPlugin("PlotSquared") != null && !Bukkit.getPluginManager().getPlugin("PlotSquared").isEnabled()) || (Bukkit.getPluginManager().getPlugin("PlotSquared") == null)) {
            return false;
        }

        plotAPI = new PlotAPI();

        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(getPrefix()+" §9PlotSquared loaded successfully!");
        Bukkit.getConsoleSender().sendMessage(" ");

        return true;
    }

    /* If PlotSquared is enabled: checks if block can be placed (owner,trusted or permission) */
    public static boolean canBlockBePlaced(Player player, Location loc) {
        if(plotSquaredEnabled) {

            if((!plotAPI.getPlotSquared().hasPlotArea(loc.getWorld().getName()) &&
                    (player.hasPermission("nextcolors.coloroutside")))) {
                return true;
            }

            com.plotsquared.core.location.Location plotSquaredLocation =
                    new com.plotsquared.core.location.Location(
                            loc.getWorld().getName(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(),
                            loc.getYaw(), loc.getPitch());

            if(plotAPI.getPlotSquared().getPlotAreaAbs(plotSquaredLocation) == null) {
                return false;
            }

            Plot ownedPlot = plotAPI.getPlotSquared().getPlotAreaAbs(plotSquaredLocation).getOwnedPlot(plotSquaredLocation);
            try {
                if (plotAPI.getPlotSquared().getPlotAreaAbs(plotSquaredLocation).getOwnedPlot(plotSquaredLocation).getOwners().contains(player.getUniqueId()) || plotAPI.getPlotSquared().getPlotAreaAbs(plotSquaredLocation).getOwnedPlot(plotSquaredLocation).getTrusted().contains(player.getUniqueId())) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
