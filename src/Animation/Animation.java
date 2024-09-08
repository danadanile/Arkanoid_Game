package Animation;

import biuoop.DrawSurface;

/**
 * Animation handle with the game-specific logic and stopping conditions.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 25-05-2022
 */

public interface Animation {
    /**
     * make another frame in the game.
     *
     * @param d DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * inform if game should stop or not.
     *
     * @return true if game should to stop false otherwise
     */
    boolean shouldStop();
}

