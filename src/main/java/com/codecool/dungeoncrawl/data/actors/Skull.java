package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skull extends Actor {
    private int counter = 0;
    private Movement movement;

    public Skull(Cell cell) {
        super(cell, 1000, 1000);
        movement = new Movement();
    }

   public void moveSkull() {
       if (counter < 8) {
           moveUp();
       } else if (counter >= 8 && counter < 16) {
           moveDown();
       } else {
           counter = 0;
       }
   }

    private void moveDown() {
        cell = movement.moveDown(cell, this);
        counter++;
    }

    private void moveUp() {
        cell = movement.moveUp(cell, this);
        counter++;
    }

    @Override
    public String getTileName() {
        return "skull";
    }
}
