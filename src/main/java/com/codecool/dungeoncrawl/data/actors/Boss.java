package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Boss extends Actor {
    public Boss(Cell cell) {
        super(cell, 30, 5);
    }
    @Override
    public String getTileName() {
        return "boss";
    }
}
