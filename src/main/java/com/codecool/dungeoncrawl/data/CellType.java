package com.codecool.dungeoncrawl.data;

public enum CellType {
    KEY("key"),
    GATE("gate"),
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    OPENGATE("opengate"),
    DEVIL("devil"),

    SWORD("sword"),
    Health("health"),
    Boss("boss");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
