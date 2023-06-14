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
    private int potion = 0;
    private int tresure = 0;

    private boolean bossIsAlive = true;


    public Actor(Cell cell, int health, int attack) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.attack = attack;
    }


    public void move(int dx, int dy) {
        if (isAlive()) {
            Cell nextCell = cell.getNeighbor(dx, dy);
            setGate(nextCell);
            wallCheck(nextCell);
            setBridge(nextCell);
            checkMonster(nextCell);
        }
    }



    private void battle(Cell nextCell) {
        Actor enemy=nextCell.getActor();
        while (areFightersAlive(enemy)) {
            playerAttack(enemy);
            if (isPlayerAlive()) {
                killPlayer();
                break;
            }
            enemyAttack(nextCell);
            if (isEnemyAlive(enemy)) {
                killEnemy(nextCell);
                break;
            }
        }
    }

    private boolean isPlayerAlive() {
        return health <= 0;
    }

    private static boolean isEnemyAlive(Actor enemy) {
        return enemy.getHealth() <= 0;
    }

    private boolean areFightersAlive(Actor enemy) {
        return health >= 0 || enemy.getHealth() >= 0;
    }

    private static void killEnemy(Cell nextCell) {
        nextCell.setActor(null);
    }

    private void killPlayer() {
        cell.setActor(null);

    }

    private void enemyAttack(Cell nextCell) {
        cell.getActor().setHealth(cell.getActor().getHealth() - nextCell.getActor().getAttack());
    }

    private void playerAttack(Actor enemy) {
        enemy.setHealth(enemy.getHealth() - attack);
        System.out.println("enemy hp after my attack"+enemy.getHealth());
    }


    protected void checkMonster(Cell nextCell) {
        if (nextCell.getActor() != null) {
            String monsterheck = nextCell.getActor().toString();
            if (isBoss(monsterheck)) {
                bossFight(nextCell);
            }
            if (isSkeleton(monsterheck) || isDevil(monsterheck) || isSkull(monsterheck)) {
                monsterFight(nextCell);
            }
        }
    }

    private boolean isSkull(String monsterheck) {
        return monsterheck.contains("Skull");
    }

    private void monsterFight(Cell nextCell) {
        battle(nextCell);
        nextCell.setActor(null);
    }

    private static boolean isDevil(String monsterheck) {
        return monsterheck.contains("Devil");
    }

    private static boolean isSkeleton(String monsterheck) {
        return monsterheck.contains("Skeleton");
    }

    private void bossFight(Cell nextCell) {
        monsterFight(nextCell);
        bossIsAlive = false;
    }


    private static boolean isBoss(String monsterheck) {
        return monsterheck.contains("Boss");
    } private boolean isAlive() {
        return health > 0;
    }


    private void setGate(Cell nextCell) {
        if (nextCell.getType().equals(CellType.GATE) && key > 0) {
            nextCell.setType(CellType.OPENGATE);

        }
    }

    private void setBridge(Cell nextCell) {
        if (nextCell.getType().equals(CellType.WATER) && bossIsAlive == false) {
            nextCell.setType(CellType.Bridge);
        }
    }


    protected void wallCheck(Cell nextCell) {
        if (potion > 0) {

            {
                if(nextCell.getType().equals(CellType.NOPOTION)){
                    potion--;
                    nextCell.setType(CellType.FLOOR);
                }
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }


        } else if (nextCell.getType() != CellType.WALL && nextCell.getActor() == null && nextCell.getType() != CellType.GATE &&
                nextCell.getType() != CellType.WATER) {

            collectIventory(nextCell);
            pickUpHealth(nextCell);

            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;

        }
    }

    private void collectIventory(Cell nextCell) {

        if (nextCell.getType().equals(CellType.SWORD) || nextCell.getType().equals(CellType.KEY) ||
                nextCell.getType().equals(CellType.POTION) || nextCell.getType().equals(CellType.TRESURE)) {
            System.out.println(nextCell.getType());

            cell.setType(CellType.FLOOR);
            if (nextCell.getType().equals(CellType.SWORD)) {
                sword++;
            }
            if (nextCell.getType().equals(CellType.KEY)) {

                key++;

            }
            if (nextCell.getType().equals(CellType.POTION)) {

                potion++;
            }
            if (nextCell.getType().equals(CellType.TRESURE)) {
                tresure++;
            }

            cell.setActor(null);
            System.out.println(cell.getType());
            nextCell.setActor(this);
            cell = nextCell;
            System.out.println(cell.getType());
            cell.setType(CellType.FLOOR);


        }
    }

    private void pickUpHealth(Cell nextCell) {
        if (nextCell.getType().equals(CellType.Health)) {
            cell.setType(CellType.FLOOR);
            health += 35;
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

    public int getTresure() {
        return tresure;
    }

    public int getPotion() {
        return potion;
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

    public int getHealth() {
        return health;
    }

    ;

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