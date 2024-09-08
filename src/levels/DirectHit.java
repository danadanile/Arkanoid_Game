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
 * Level 1 class saves all the information about level 1 of the game.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 26-05-2022
 */
public class DirectHit implements LevelInformation {


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel = new ArrayList<>();
        vel.add(new Velocity(0, 4));
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
        String name = "Direct Hit";
        return name;
    }

    @Override
    public Sprite getBackground() {

        Sprite draw = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.black);
                d.fillRectangle(0, 0, 800, 600);
                int r = 50;
                d.setColor(Color.blue);
                for (int i = 0; i < 3; i++) {
                    d.drawCircle(400, 130, r);
                    r = r + 20;
                }
                d.drawLine(400, 20, 400, 230);
                d.drawLine(300, 130, 500, 130);
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
        Block block = new Block(new Rectangle(new Point(385, 115),
                30, 30), Color.red);
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public Point coardinate() {
        return new Point(350, 560);
    }
}
