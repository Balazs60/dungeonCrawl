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
        int circleCount = counter / 16; // Calculate the number of completed circles

        if (circleCount < 50) {
            int movementIndex = counter % 16; // Calculate the current movement within the circle

            if (movementIndex < 1) {
                cell = movement.moveLeft(cell, this);
                counter++;
            } else if (movementIndex < 5) {
                cell = movement.moveUp(cell, this);
                counter++;
            } else if (movementIndex < 9) {
                cell = movement.moveRight(cell, this);
                counter++;
            } else if (movementIndex < 13) {
                cell = movement.moveDown(cell, this);
                counter++;
            } else if (movementIndex < 16) {
                cell = movement.moveLeft(cell, this);
                counter++;
            }
        } else {
            // The desired number of circles (50) have been completed, you can add any desired code here.
        }
    }

    @Override
    public String getTileName() {
        return "boss";
    }
}
