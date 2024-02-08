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

import com.google.gson.Gson;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.UUID;

public class FileManager {

    public static void createDefaultPlayerConfigFile(UUID uuid) {
        NCPlayer ncPlayer = NCPlayer.getDefaultNCPlayer(uuid);

        Gson gson = new Gson();
        String userJson = gson.toJson(ncPlayer);

        File file = new File("plugins/nextColors/players", uuid.toString()+".json");

        try {
            if(!file.getParentFile().exists()) {
                if(file.getParentFile().mkdirs()) {
                    Bukkit.getConsoleSender().sendMessage("§8[§2nextColors§8] §3Plugin directory has been created!");
                }
            }

            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write(userJson);
                fileWriter.close();

                Bukkit.getConsoleSender().sendMessage("§8[§2nextColors§8] §3Config-File for user §e"+uuid.toString()+"§3 has been created!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlayerConfigFile(NCPlayer ncPlayer) {
        Gson gson = new Gson();
        String userJson = gson.toJson(ncPlayer);

        File file = new File("plugins/nextColors/players", ncPlayer.getUuid().toString()+".json");

        try {
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(userJson);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void resetPlayerConfigFile(UUID uuid) {
        NCPlayer ncPlayer = NCPlayer.getDefaultNCPlayer(uuid);

        Gson gson = new Gson();
        String userJson = gson.toJson(ncPlayer);

        File file = new File("plugins/nextColors/players", uuid.toString()+".json");

        try {
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(userJson);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
