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
           cell = movement.moveUp(cell, this);
           counter++;
       } else if (counter >= 8 && counter < 16) {
           cell = movement.moveDown(cell, this);
           counter++;
       } else {
           counter = 0; // Reset the counter if it exceeds 16
       }
   }
    @Override
    public String getTileName() {
        return "skull";
    }
}
