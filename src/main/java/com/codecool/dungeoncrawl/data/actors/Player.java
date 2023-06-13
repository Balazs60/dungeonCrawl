package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import javax.print.attribute.HashPrintServiceAttributeSet;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public int getPlayerHealt() {
        return playerHealt;
    }

    public void setPlayerHealt(int playerHealt) {
        this.playerHealt = playerHealt;
    }

    public int getGetPlayerAtk() {
        return getPlayerAtk;
    }

    public void setGetPlayerAtk(int getPlayerAtk) {
        this.getPlayerAtk = getPlayerAtk;
    }

    int playerHealt=10;
    int getPlayerAtk=5;

    public String getTileName() {
        return "player";
    }
}
