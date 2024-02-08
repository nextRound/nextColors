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

public class Mask {

    private boolean red;
    private boolean orange;
    private boolean yellow;
    private boolean green;
    private boolean blue;
    private boolean pink;
    private boolean purple;
    private boolean grey;
    private boolean brown;

    private boolean redGlass;
    private boolean greenGlass;
    private boolean blueGlass;
    private boolean purpleGlass;
    private boolean greyGlass;

    public Mask(boolean red, boolean orange, boolean yellow, boolean green,
                boolean blue, boolean pink, boolean purple, boolean grey,
                boolean brown, boolean redGlass, boolean greenGlass,
                boolean blueGlass, boolean purpleGlass, boolean greyGlass) {

        this.red = red;
        this.orange = orange;
        this.yellow = yellow;
        this.green = green;
        this.blue = blue;
        this.pink = pink;
        this.purple = purple;
        this.grey = grey;
        this.brown = brown;
        this.redGlass = redGlass;
        this.greenGlass = greenGlass;
        this.blueGlass = blueGlass;
        this.purpleGlass = purpleGlass;
        this.greyGlass = greyGlass;
    }

    public boolean isRed() {
        return red;
    }

    public boolean isOrange() {
        return orange;
    }

    public boolean isYellow() {
        return yellow;
    }

    public boolean isGreen() {
        return green;
    }

    public boolean isBlue() {
        return blue;
    }

    public boolean isPink() {
        return pink;
    }

    public boolean isPurple() {
        return purple;
    }

    public boolean isGrey() {
        return grey;
    }

    public boolean isBrown() {
        return brown;
    }

    public boolean isRedGlass() {
        return redGlass;
    }

    public boolean isGreenGlass() {
        return greenGlass;
    }

    public boolean isBlueGlass() {
        return blueGlass;
    }

    public boolean isPurpleGlass() {
        return purpleGlass;
    }

    public boolean isGreyGlass() {
        return greyGlass;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void setOrange(boolean orange) {
        this.orange = orange;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public void setPink(boolean pink) {
        this.pink = pink;
    }

    public void setPurple(boolean purple) {
        this.purple = purple;
    }

    public void setGrey(boolean grey) {
        this.grey = grey;
    }

    public void setBrown(boolean brown) {
        this.brown = brown;
    }

    public void setRedGlass(boolean redGlass) {
        this.redGlass = redGlass;
    }

    public void setGreenGlass(boolean greenGlass) {
        this.greenGlass = greenGlass;
    }

    public void setBlueGlass(boolean blueGlass) {
        this.blueGlass = blueGlass;
    }

    public void setPurpleGlass(boolean purpleGlass) {
        this.purpleGlass = purpleGlass;
    }

    public void setGreyGlass(boolean greyGlass) {
        this.greyGlass = greyGlass;
    }
}
