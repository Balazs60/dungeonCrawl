package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Boss;
import com.codecool.dungeoncrawl.data.actors.Devil;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skull;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private Devil devil;
    private Skull skull;
    private Boss boss;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public void update(){
        devil.devilMove();
        skull.moveSkull();
        boss.moveBoss();
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setDevil(Devil devil){this.devil=devil;}
    public void setBoss(Boss boss){this.boss=boss;}


    public Player getPlayer() {
        return player;
    }
    public void setSkull(Skull skull){
        this.skull=skull;
    };

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
