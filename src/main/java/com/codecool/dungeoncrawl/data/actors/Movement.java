package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Movement {

    public Cell moveUp(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(0, -1);
        return stepNextCell(actor, wallcheck(nextCell), cell, nextCell);
    }

    public Cell moveDown(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(0, 1);
        return stepNextCell(actor, wallcheck(nextCell), cell, nextCell);
    }

    public Cell moveLeft(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(-1, 0);
        return stepNextCell(actor, wallcheck(nextCell), cell, nextCell);

    }

    private static Cell stepNextCell(Actor actor, boolean nextCell, Cell cell, Cell nextCell1) {
        if (isActorAlive(actor)) {
            if (nextCell) {

                return step(cell, actor, nextCell1);
            }
            return cell;
        }
        return cell;
    }

    private static boolean isActorAlive(Actor actor) {
        return actor.health > 0;
    }

    private static Cell step(Cell cell, Actor actor, Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(actor);
        return nextCell;
    }

    private static boolean wallcheck(Cell nextCell) {
        return nextCell.getType() != CellType.WALL && nextCell.getActor() == null && nextCell.getType() != CellType.GATE &&
                nextCell.getType() != CellType.WATER;
    }

    public Cell moveRight(Cell cell, Actor actor) {
        Cell nextCell = cell.getNeighbor(1, 0);
        return stepNextCell(actor, nextCell.getType() != CellType.WALL &&
                nextCell.getType() != CellType.GATE && nextCell.getType() != CellType.WATER, cell, nextCell);
    }
}
