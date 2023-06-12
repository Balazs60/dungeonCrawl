package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private  int sword = 0;
    private int key = 0;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);



        if (nextCell.getType() != CellType.WALL && nextCell.getActor()==null  && nextCell.getType() !=CellType.GATE){
            if (nextCell.getType().equals(CellType.SWORD)  || nextCell.getType().equals(CellType.KEY)){
                System.out.println(nextCell.getType());

                cell.setType(CellType.FLOOR);
                if(nextCell.getType().equals(CellType.SWORD)){
                    sword++;
                }
                if(nextCell.getType().equals(CellType.KEY)){
                    key++;
                }

                cell.setActor(null);
                System.out.println(cell.getType());
                nextCell.setActor(this);
                cell = nextCell;
                System.out.println(cell.getType());
                cell.setType(CellType.FLOOR);
                //commit miatt

            }
           // System.out.println(nextCell.getType());
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }

    }

    public int getHealth() {
        return health;
    }

    public int getSword() {
        return sword;
    }

    public int getKey() {
        return key;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
