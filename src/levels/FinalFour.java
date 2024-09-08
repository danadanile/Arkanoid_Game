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
 * Level 4 class saves all the information about level 4 of the game.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 26-05-2022
 */
public class FinalFour implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel = new ArrayList<>();
        Velocity v = new Velocity(0, 0);
        vel.add(v.fromAngleAndSpeed(20, 5));
        vel.add(v.fromAngleAndSpeed(-20, 5));
        vel.add(v.fromAngleAndSpeed(0, 6));
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
        String name = "Final Four";
        return name;
    }

    @Override
    public Sprite getBackground() {
        Sprite draw = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {

                Color lightBlue = new Color(51, 153, 255);
                d.setColor(lightBlue);
                d.fillRectangle(0, 0, 800, 600);

                d.setColor(Color.LIGHT_GRAY);
                for (int i = 0; i < 35; i++) {
                    d.drawLine(70 - i, 440 + (5 * i), 70 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(80 - i, 440 + (5 * i), 80 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(90 - i, 440 + (5 * i), 90 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(100 - i, 440 + (5 * i), 100 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(110 - i, 440 + (5 * i), 110 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(120 - i, 440 + (5 * i), 120 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(130 - i, 440 + (5 * i), 130 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(140 - i, 440 + (5 * i), 140 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(150 - i, 440 + (5 * i), 150 - i, 445 + (5 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(160 - i, 440 + (5 * i), 160 - i, 445 + (5 * i));
                }

                d.setColor(Color.LIGHT_GRAY);
                d.fillCircle(80, 430, 20);
                d.setColor(Color.LIGHT_GRAY);
                d.fillCircle(100, 450, 25);
                d.setColor(Color.GRAY);
                d.fillCircle(115, 425, 25);
                d.setColor(Color.DARK_GRAY);
                d.fillCircle(132, 452, 20);
                d.setColor(Color.DARK_GRAY);
                d.fillCircle(145, 432, 25);

                d.setColor(Color.LIGHT_GRAY);

                for (int i = 0; i < 35; i++) {
                    d.drawLine(635 - i, 530 + (2 * i), 635 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(645 - i, 530 + (2 * i), 645 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(655 - i, 530 + (2 * i), 655 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(665 - i, 530 + (2 * i), 665 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(675 - i, 530 + (2 * i), 675 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(685 - i, 530 + (2 * i), 685 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(695 - i, 530 + (2 * i), 695 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(705 - i, 530 + (2 * i), 705 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(715 - i, 530 + (2 * i), 715 - i, 532 + (2 * i));
                }
                for (int i = 0; i < 35; i++) {
                    d.drawLine(725 - i, 530 + (2 * i), 725 - i, 532 + (2 * i));
                }


                d.setColor(Color.LIGHT_GRAY);
                d.fillCircle(640, 515, 20);
                d.setColor(Color.LIGHT_GRAY);
                d.fillCircle(668, 535, 25);
                d.setColor(Color.GRAY);
                d.fillCircle(680, 505, 25);
                d.setColor(Color.DARK_GRAY);
                d.fillCircle(697, 532, 20);
                d.setColor(Color.DARK_GRAY);
                d.fillCircle(710, 512, 25);
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
        for (int i = 0; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 85),
                    52, 25), Color.gray);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 110),
                    52, 25), Color.red);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 135),
                    52, 25), Color.yellow);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 160),
                    52, 25), Color.green);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 185),
                    52, 25), Color.white);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 210),
                    52, 25), Color.pink);
            blocks.add(block);
        }
        for (int i = 0; i < 15; i++) {
            j = 10 + (i * 52);
            Block block = new Block(new Rectangle(new Point(j, 235),
                    52, 25), Color.cyan);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }

    @Override
    public Point coardinate() {
        return new Point(350, 560);
    }

}
