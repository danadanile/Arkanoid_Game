package game;

import geometry_primitives.Point;
import geometry_primitives.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.util.List;

/**
 * LevelInformation interface specifies the information required to fully
 * describe a level.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 25-05-2022
 */
public interface LevelInformation {
    /**
     * number of balls.
     *
     * @return number of balls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return velocity
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddle speed.
     *
     * @return speed
     */
    int paddleSpeed();

    /**
     * paddle width.
     *
     * @return width
     */
    int paddleWidth();

    /**
     * the level name that will be displayed at the top of the screen.
     *
     * @return string
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return sprites background.
     */
    Sprite getBackground();
    //

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return block list
     */
    List<Block> blocks();


    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return number of blocks
     */
    int numberOfBlocksToRemove();

    /**
     * return the start point of block.
     *
     * @return left upper point of block
     */
    Point coardinate();

}