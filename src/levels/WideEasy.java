package levels;

import biuoop.DrawSurface;
import game.LevelInformation;
import geometry_primitives.Point;
import geometry_primitives.Rectangle;
import geometry_primitives.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level 2 class saves all the information about level 2 of the game.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 26-05-2022
 */
public class WideEasy implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel = new ArrayList<>();
        Velocity v = new Velocity(0, 0);

        vel.add(v.fromAngleAndSpeed(10, 5));
        vel.add(v.fromAngleAndSpeed(20, 5));
        vel.add(v.fromAngleAndSpeed(30, 5));
        vel.add(v.fromAngleAndSpeed(40, 5));
        vel.add(v.fromAngleAndSpeed(50, 5));
        vel.add(v.fromAngleAndSpeed(-10, 5));
        vel.add(v.fromAngleAndSpeed(-20, 5));
        vel.add(v.fromAngleAndSpeed(-30, 5));
        vel.add(v.fromAngleAndSpeed(-40, 5));
        vel.add(v.fromAngleAndSpeed(-50, 5));

        return vel;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 650;
    }

    @Override
    public String levelName() {
        String name = "Wide Easy";
        return name;
    }

    @Override
    public Sprite getBackground() {
        Sprite draw = new Sprite() {
            public void drawOn(DrawSurface d) {
                d.setColor(Color.WHITE);
                d.fillRectangle(0, 0, 800, 600);
                Color lightYellow = new Color(243, 243, 138);
                Color yellow = new Color(236, 223, 33);
                Color darkYellow = new Color(252, 236, 11);
                d.setColor(lightYellow);
                for (int i = 0; i <= 100; i++) {
                    d.drawLine(140, 140, 750 / 100 * i, 250);
                }
                d.setColor(lightYellow);
                d.fillCircle(130, 140, 60);
                d.setColor(yellow);
                d.fillCircle(130, 140, 50);
                d.setColor(darkYellow);
                d.fillCircle(130, 140, 40);

            }

            @Override
            public void timePassed() {
            }
        };
        return draw;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int j;
        for (int i = 0; i < 2; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 250),
                    52, 25), Color.red);
            blocks.add(block);
        }
        for (int i = 2; i < 4; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 250),
                    52, 25), Color.orange);
            blocks.add(block);
        }
        for (int i = 4; i < 6; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 250),
                    52, 25), Color.yellow);
            blocks.add(block);
        }
        for (int i = 6; i < 9; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 250),
                    52, 25), Color.green);
            blocks.add(block);
        }
        for (int i = 9; i < 11; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 250),
                    52, 25), Color.blue);
            blocks.add(block);
        }
        for (int i = 11; i < 13; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 250),
                    52, 25), Color.pink);
            blocks.add(block);
        }
        for (int i = 13; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 250),
                    52, 25), Color.cyan);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

    @Override
    public Point coardinate() {
        return new Point(65, 560);
    }

}
