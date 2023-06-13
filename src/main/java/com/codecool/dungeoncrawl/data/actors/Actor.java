package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;


    public void setHealth(int health) {
        this.health = health;
    }
    Player player;

    private int health = 10;
    private int sword = 0;
    private int key = 0;
public Skeleton skeleton;
    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        wallCheck(nextCell);
        checkSkeleton(nextCell);





    }

    private void attack(int enemyHp , int enemyAtk ,int playerHealth ,int playerAtk, Cell nextCell) {
        while (playerHealth>=0 || enemyHp >=0){
            enemyHp-=playerAtk;


               playerHealth-=enemyAtk;



        }
        nextCell.setActor(null);




    }


    private void checkSkeleton(Cell nextCell) {
        String skeletoncheck = nextCell.getActor().toString();
        if (skeletoncheck.contains("Skeleton")) {
            int enemyHp=10;
            System.out.println(enemyHp);
            int enemyAtk=2;
            System.out.println(enemyAtk);
            int playerHp=10;
            int playerAtk= sword>0?7:5;


            attack(enemyHp,enemyAtk,playerHp, playerAtk ,nextCell);
             nextCell.setActor(null);
        }


      

    }

    

    private void wallCheck(Cell nextCell) {
        if (nextCell.getType() != CellType.WALL && nextCell.getActor()==null  && nextCell.getType() !=CellType.GATE){

            collectIventory(nextCell);

            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    private void collectIventory(Cell nextCell) {

        if (nextCell.getType().equals(CellType.SWORD) || nextCell.getType().equals(CellType.KEY)) {
            System.out.println(nextCell.getType());

            cell.setType(CellType.FLOOR);
            if (nextCell.getType().equals(CellType.SWORD)) {
                sword++;
            }
            if (nextCell.getType().equals(CellType.KEY)) {

                key++;
            }

            cell.setActor(null);
            System.out.println(cell.getType());
            nextCell.setActor(this);
            cell = nextCell;
            System.out.println(cell.getType());
            cell.setType(CellType.FLOOR);


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