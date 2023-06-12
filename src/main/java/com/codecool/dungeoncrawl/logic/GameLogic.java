package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public String setup(Skeleton skeleton, Actor actor) {
        while (actor.getHealth() >= 0 || skeleton.getHealth() >= 0) {
            int skeletonHealth = skeleton.getHealth();
            skeleton.health = skeleton.health -5;
            int playerHealth = actor.getHealth();
            actor.setHealth(-2);
        }
        String winner;
        if (actor.getHealth() > skeleton.getHealth()) {
            winner = "Player won!";
        } else {
            winner = "Skeleton won!";

        }
        return winner;
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerSword() {
        return Integer.toString(map.getPlayer().getSword());
    }

    public String getPlayerKey() {
        return Integer.toString(map.getPlayer().getKey());
    }


    public GameMap getMap() {
        return map;
    }
}
