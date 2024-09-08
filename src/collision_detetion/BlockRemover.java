package collision_detetion;

import game.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as
 * keeping count of the number of blocks that remain.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 13-05-2022
 */


public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param gameLevel game
     * @param removedBlocks number of blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.game = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit object that was hit
     * @param hitter   tbe ball that make hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.getHitListeners().remove(this);
        beingHit.removeFromGame(game);
        remainingBlocks.decrease(1);
    }
}
