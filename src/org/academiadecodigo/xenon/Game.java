package org.academiadecodigo.xenon;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.xenon.Handler;
import org.academiadecodigo.xenon.KeyboardListener;
import org.academiadecodigo.xenon.world.*;
import org.academiadecodigo.xenon.world.gameobjects.*;
import org.academiadecodigo.xenon.world.gameobjects.EnemyShipFactory;
import org.academiadecodigo.xenon.world.gameobjects.projectiles.ProjectileFactory;
import org.academiadecodigo.xenon.world.gameobjects.EnemyShip;
import org.academiadecodigo.xenon.world.gameobjects.PlayerShip;

import javax.sound.sampled.Clip;

public class Game implements Handler {

    private PlayerShip player;
    private World world;
    private LivesScore livesScore;
    private static Sound sound;
    private KeyboardListener listener;

    public Game(KeyboardListener listener) {
        new GameMap();
        this.world = new World();
        this.player = new PlayerShip(10, GameMap.HEIGHT / 2 - 30, world);
        this.world.setPlayer(this.player);
        this.livesScore = new LivesScore(GameMap.PADDING, GameMap.PADDING, "Score: 0");
        this.listener = listener;
    }

    public void init() {
        Game.sound = new Sound("/sound/backgroundmusic.wav");
        Clip clip = Game.sound.getClip();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        this.world.add(this.player);
        listener.setHandler(this);
        this.player.show();
    }

    public void run() {
        init();

        while (this.isRunning()) {
            if (this.world.isDefeated()) {
                break;
            }

            this.tick();

            this.livesScore.setScore(this.player.score());

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        if (this.world.isDefeated()) {
            this.showGameWon();
        } else {
            this.showGameOver();
        }
    }

    public void showGameOver() {
        Text text = new Text(225, 250, "You lose! Press q to quit.");
        Game.sound.stop();
        text.setColor(Color.WHITE);
        text.draw();
    }

    public void showGameWon() {
        Text text = new Text(225, 250, "You won! Press q to quit.");
        text.setColor(Color.WHITE);
        text.draw();
    }

    public boolean isRunning() {
        return !this.player.isDestroyed();
    }

    public void tick() {
        this.world.tick();
    }

    @Override
    public void handlePressed(KeyboardEvent key) {
        switch (key.getKey()) {
            case KeyboardEvent.KEY_UP:
                this.player.setDirection(Direction.NORTH);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.player.setDirection(Direction.SOUTH);
                break;
            case KeyboardEvent.KEY_SPACE:
                if (player.isControllable()) {
                    this.player.setShooting(true);
                }
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void handleReleased(KeyboardEvent keyEvent) {
        if (!this.player.isControllable()) {
            return;
        }
        switch (keyEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                this.player.setDirection(null);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.player.setDirection(null);
                break;
        }
    }
}
