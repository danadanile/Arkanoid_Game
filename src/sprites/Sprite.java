package sprites;

import biuoop.DrawSurface;

/**
 * interface Sprite. game object that can be drawn to the screen.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 8-04-2022
 */


public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d draw surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}