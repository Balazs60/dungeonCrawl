package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Movement {

    public Cell moveUp(Cell cell, Actor actor){
        Cell nextCell = cell.getNeighbor(0, -1);
        cell.setActor(null);
        nextCell.setActor(actor);
        return nextCell;
    }
    public Cell moveDown(Cell cell, Actor actor){
        Cell nextCell = cell.getNeighbor(0, 1);
        cell.setActor(null);
        nextCell.setActor(actor);
        return nextCell;
    }

    public Cell moveLeft(Cell cell, Actor actor){
        Cell nextCell = cell.getNeighbor(-1, 0);
        cell.setActor(null);
        nextCell.setActor(actor);
        return nextCell;
    }

    public Cell moveRight(Cell cell, Actor actor){
        Cell nextCell = cell.getNeighbor(1, 0);
        cell.setActor(null);
        nextCell.setActor(actor);
        return nextCell;
    }
}
