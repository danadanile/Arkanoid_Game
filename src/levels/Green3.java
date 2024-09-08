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
 * @version 2
 * @since 30-05-2022
 */
public class Green3 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel = new ArrayList<>();
        vel.add(new Velocity(2, 4));
        vel.add(new Velocity(-2, 4));
        return vel;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        String name = "Green 3";
        return name;
    }

    @Override
    public Sprite getBackground() {
        Sprite draw = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                Color darkGreen = new Color(0, 153, 0);
                Color veryDarkGreen = new Color(51, 51, 51);

                d.setColor(darkGreen);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.black);
                d.fillRectangle(50, 420, 120, 180);
                int j;
                d.setColor(Color.white);
                for (int i = 0; i < 5; i++) {
                    j = 60 + (i * 22);
                    d.fillRectangle(j, 430, 13, 27);
                }
                for (int i = 0; i < 5; i++) {
                    j = 60 + (i * 22);
                    d.fillRectangle(j, 465, 13, 27);
                }
                for (int i = 0; i < 5; i++) {
                    j = 60 + (i * 22);
                    d.fillRectangle(j, 500, 13, 27);
                }
                for (int i = 0; i < 5; i++) {
                    j = 60 + (i * 22);
                    d.fillRectangle(j, 535, 13, 27);
                }
                for (int i = 0; i < 5; i++) {
                    j = 60 + (i * 22);
                    d.fillRectangle(j, 570, 13, 27);
                }
                d.setColor(veryDarkGreen);
                d.fillRectangle(95, 360, 30, 60);
                d.setColor(Color.DARK_GRAY);
                d.fillRectangle(103, 200, 15, 160);
                d.setColor(Color.ORANGE);
                d.fillCircle(110, 190, 12);
                d.setColor(Color.RED);
                d.fillCircle(110, 190, 8);
                d.setColor(Color.WHITE);
                d.fillCircle(110, 190, 4);


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
        for (int i = 0; i < 10; i++) {
            j = 240 + (i * 55);
            Block block = new Block(new Rectangle(new Point(j, 110),
                    55, 25), Color.gray);
            blocks.add(block);

        }
        for (int i = 0; i < 9; i++) {
            j = 295 + (i * 55);
            Block block = new Block(new Rectangle(new Point(j, 135),
                    55, 25), Color.red);
            blocks.add(block);
        }
        for (int i = 0; i < 8; i++) {
            j = 350 + (i * 55);
            Block block = new Block(new Rectangle(new Point(j, 160),
                    55, 25), Color.yellow);
            blocks.add(block);
        }
        for (int i = 0; i < 7; i++) {
            j = 405 + (i * 55);
            Block block = new Block(new Rectangle(new Point(j, 185),
                    55, 25), Color.blue);
            blocks.add(block);
        }
        for (int i = 0; i < 6; i++) {
            j = 460 + (i * 55);
            Block block = new Block(new Rectangle(new Point(j, 210),
                    55, 25), Color.white);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }

    @Override
    public Point coardinate() {
        return new Point(350, 560);
    }

}
