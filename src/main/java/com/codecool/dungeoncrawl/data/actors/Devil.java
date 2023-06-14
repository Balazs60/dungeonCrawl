package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import java.util.Random;

public class Devil extends Actor {
    public Devil(Cell cell) {
        super(cell, 30, 5);
    }

    public void devilMove() {
        Random random = new Random();
        int x = this.cell.getX();
        int y = this.cell.getY();
        int numberX = random.nextInt(3) - 1;
        int numberY = random.nextInt(3) - 1;
        int newX = x + numberX;
        int newY = y + numberY;
        Cell nextCell = cell.getNeighbor(newX, newY);
        if (nextCell != null && nextCell.getType().equals(CellType.WALL)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void moveDevil() {
        devilMove();
    }

    @Override
    public String getTileName() {
        return "devil";
    }
}
