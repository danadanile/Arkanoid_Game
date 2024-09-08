package collision_detetion;

import sprites.Ball;
import sprites.Block;

/**
 * Class follow after hit and add point when there is a hit.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 14-05-2022
 */

public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter count the score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * add 5 points if there was a hit of block.
     *
     * @param beingHit object that was hit
     * @param hitter   tbe ball that make hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);

    }
}