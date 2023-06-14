package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Movement {

    public Cell moveUp(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(0, -1);
        if (actor.health > 0) {
            if (nextCell.getType() != CellType.WALL && nextCell.getActor() == null && nextCell.getType() != CellType.GATE &&
                    nextCell.getType() != CellType.WATER) {
                cell.setActor(null);
                nextCell.setActor(actor);
                return nextCell;
            }
            return cell;
        }
        return cell;
    }

    public Cell moveDown(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(0, 1);
        if (actor.health > 0) {
            if (nextCell.getType() != CellType.WALL && nextCell.getActor() == null && nextCell.getType() != CellType.GATE &&
                    nextCell.getType() != CellType.WATER) {
                cell.setActor(null);
                nextCell.setActor(actor);

                return nextCell;
            }
            return cell;
        }
        return cell;
    }

    public Cell moveLeft(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(-1, 0);
        if (actor.health > 0) {
            if (nextCell.getType() != CellType.WALL && nextCell.getActor() == null && nextCell.getType() != CellType.GATE &&
                    nextCell.getType() != CellType.WATER) {

                cell.setActor(null);
                nextCell.setActor(actor);
                return nextCell;
            }
            return cell;
        }
        return cell;

    }

    public Cell moveRight(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(1, 0);
        if (actor.health > 0) {

            if (nextCell.getType() != CellType.WALL &&
             nextCell.getType() != CellType.GATE && nextCell.getType() != CellType.WATER) {

                cell.setActor(null);
                nextCell.setActor(actor);
                return nextCell;
            }
            return cell;
        }
        return cell;
    }
}
