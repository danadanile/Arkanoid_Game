package collision_detetion;

import game.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * a BallRemover is in charge of removing balls from the game, as well as
 * keeping count of the number of balls that remain.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 13-05-2022
 */


public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game         game
     * @param removedBalls cont number of balls
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * Balls that hit the death zone should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param deathBlock object that was hit
     * @param hitter     the ball that make hit
     */
    public void hitEvent(Block deathBlock, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);

    }
}

