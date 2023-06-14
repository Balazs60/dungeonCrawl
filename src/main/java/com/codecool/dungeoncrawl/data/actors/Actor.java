package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;

    Player player;

    protected int health;
    protected int attack;
    private int sword = 0;
    private int key = 0;
    public Skeleton skeleton;



    public Actor(Cell cell, int health, int attack) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.attack = attack;
    }


    public void move(int dx, int dy) {



        if (isAlive()){
            Cell nextCell = cell.getNeighbor(dx, dy);
           // System.out.println(nextCell.getActor());
            setGate(nextCell);
            wallCheck(nextCell);
            checkMonster(nextCell);





        }


    }

    private boolean isAlive() {
        return health > 0;
    }

    private void attack( Cell nextCell) {



        while (health >= 0 || nextCell.getActor().getHealth() >= 0) {
            nextCell.getActor().setHealth(nextCell.getActor().getHealth() - attack);
            System.out.println("enemy hp " + nextCell.getActor().getHealth());
            System.out.println("enemy attack " + nextCell.getActor().getAttack());
            if (health<= 0) {
                cell.setActor(null);
                break;
            }
            cell.getActor().setHealth(cell.getActor().getHealth() - nextCell.getActor().getAttack());
            System.out.println("my hp " + health);

            if (nextCell.getActor().getHealth() <= 0) {
                nextCell.setActor(null);
                break;
            }
        }
    }


    private void checkMonster(Cell nextCell) {
        if (nextCell.getActor()!=null) {
            String monsterheck = nextCell.getActor().toString();

            if (monsterheck.contains("Skeleton") || monsterheck.contains("Devil") || monsterheck.contains("Boss")) {

                attack( nextCell);
                nextCell.setActor(null);
            }
        }

    }
    private void setGate(Cell nextCell){
        if (nextCell.getType().equals(CellType.GATE) && key>0){
            nextCell.setType(CellType.OPENGATE);

        }
    }


    protected void wallCheck(Cell nextCell) {
        if (nextCell.getType() != CellType.WALL && nextCell.getActor() == null && nextCell.getType() != CellType.GATE) {

            collectIventory(nextCell);
            pickUpHealth(nextCell);

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

    private void pickUpHealth(Cell nextCell){
        if(nextCell.getType().equals(CellType.Health)){
            cell.setType(CellType.FLOOR);
            health+= 35;
            cell.setActor(null);
            System.out.println(cell.getType());
            nextCell.setActor(this);
            cell = nextCell;
            System.out.println(cell.getType());
            cell.setType(CellType.FLOOR);
        }
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
    public int getHealth(){
        return health;
    };

    public void setHealth(int health) {
        this.health = health;
    }
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


}