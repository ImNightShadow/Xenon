package org.academiadecodigo.xenon.world.gameobjects;

import org.academiadecodigo.xenon.world.GameMap;
import org.academiadecodigo.xenon.world.Direction;

public class Projectile extends GameObject {

    public Projectile(int x, int y, GameMap gameMap) {
        super(x, y, 30, 29, gameMap, "res/star.png");
    }

    public Projectile(int x, int y, GameMap gameMap, String pathname) {
        super(x, y, 22, 22, gameMap,  pathname);
    }

    public int getSpeed() {
        return 12;
    }
}


