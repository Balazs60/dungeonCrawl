package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Boss extends Actor {
    public Boss(Cell cell) {
        super(cell, 50, 20);
    }
    @Override
    public String getTileName() {
        return "boss";
    }
}
