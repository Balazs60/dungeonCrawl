package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Devil extends Actor{
    public Devil(Cell cell){super(cell, 30, 5);}

    @Override
    public String getTileName() {
        return "devil";
    }
}

