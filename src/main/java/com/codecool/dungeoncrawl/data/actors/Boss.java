package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Boss extends Actor {
    private int counter;
    Movement movement;

    public Boss(Cell cell) {
        super(cell, 30, 5);
        movement = new Movement();
    }

    public void moveBoss() {


        int movementIndex = counter % 16;

        if (movementIndex < 1) {
            moveLeftOne();
        } else if (movementIndex < 5) {
            moveUpOne();
        } else if (movementIndex < 9) {
            moveRihtOne();
        } else if (movementIndex < 13) {
            moveDownOne();
        } else if (movementIndex < 16) {
            moveLeftOne();
        }
    }


    private void moveDownOne() {
        cell = movement.moveDown(cell, this);
        counter++;
    }

    private void moveRihtOne() {
        cell = movement.moveRight(cell, this);
        counter++;
    }

    private void moveUpOne() {
        cell = movement.moveUp(cell, this);
        counter++;
    }

    private void moveLeftOne() {
        cell = movement.moveLeft(cell, this);
        counter++;
    }

    @Override
    public String getTileName() {
        return "boss";
    }
}
