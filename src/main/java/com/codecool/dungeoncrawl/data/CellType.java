package com.codecool.dungeoncrawl.data;

public enum CellType {
    KEY("key"),
    GATE("gate"),
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    TRESURE("tresure"),
    POTION("potion"),
    NOPOTION("noPotion"),
    OPENGATE("opengate"),
    DEVIL("devil"),
    SKULL("skull"),

    WATER("water"),

    SWORD("sword"),
    Health("health"),
    Boss("boss"),
    Bridge("bridge");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
