package com.codecool.dungeoncrawl.data;

public enum CellType {
    KEY("key"),
    GATE("gate"),
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    TRESURE("tresure"),
    POTION("potion"),
    OPENGATE("opengate"),
    DEVIL("devil"),
    SKULL("skull"),

    WATER("water"),

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
