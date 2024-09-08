package collision_detetion;

import sprites.Ball;
import sprites.Block;

/**
 * Objects that want to be notified of hit events, should implement the
 * HitListener interface, and register themselves with a HitNotifier object
 * using its addHitListener method.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 12-05-2022
 */
public interface HitListener {


    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit object that was hit
     * @param hitter   tbe ball that make hit
     */
    void hitEvent(Block beingHit, Ball hitter);

}
