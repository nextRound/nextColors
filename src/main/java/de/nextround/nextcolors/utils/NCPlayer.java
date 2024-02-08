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
import de.nextround.nextcolors.nextColors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class NCPlayer {

    private UUID uuid;
    private int maskMode;
    private Brush.BrushType brushType;
    private int size;
    private int percentage;
    private int mode;
    private Mask mask;
    private ColorGradients colorGradients;
    private final int configVersion;

    public NCPlayer(UUID uuid, int maskMode, Brush.BrushType brushType, int size, int percentage, int mode, Mask mask, ColorGradients colorGradients) {
        this.uuid = uuid;
        this.maskMode = maskMode;
        this.brushType = brushType;
        this.size = size;
        this.percentage = percentage;
        this.mode = mode;
        this.mask = mask;
        this.colorGradients = colorGradients;
        this.configVersion = nextColors.configVersion;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getMaskMode() {
        return maskMode;
    }

    public Brush.BrushType getBrushType() {
        return brushType;
    }

    public int getSize() {
        return size;
    }

    public int getPercentage() {
        return percentage;
    }

    public int getMode() {
        return mode;
    }

    public Mask getMask() {
        return mask;
    }

    public ColorGradients getColorGradients() {
        return colorGradients;
    }

    public int getConfigVersion() {
        return configVersion;
    }

    public void setMaskMode(int maskMode) {
        this.maskMode = maskMode;
    }

    public void setBrushType(Brush.BrushType brushType) {
        this.brushType = brushType;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }

    public void setColorGradients(ColorGradients colorGradients) {
        this.colorGradients = colorGradients;
    }

    public static NCPlayer getNCPlayer(UUID uuid) {
        File file = new File("plugins/nextColors/players", uuid.toString()+".json");

        try {
            String userConfig = new String(Files.readAllBytes(Paths.get(file.getPath())));

            Gson gson = new Gson();

            return gson.fromJson(userConfig, NCPlayer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static NCPlayer getDefaultNCPlayer(UUID uuid) {
        return new NCPlayer(uuid, 0, Brush.BrushType.SPHERE, 8, 40, 0,
                new Mask(false, false, false, false, false, false,
                        false, false, false, false, false,
                        false, false, false), new ColorGradients());
    }
}
