package sprites;

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * SpriteCollection hold a collection of sprites.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 8-04-2022
 */
public class SpriteCollection {

    private ArrayList<Sprite> array;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.array = new ArrayList<Sprite>();
    }

    /**
     * add sprites to list.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        array.add(s);
    }

    /**
     * remove sprites from list.
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        array.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        ArrayList<Sprite> sprites = new ArrayList<>(array);
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : array) {
            s.drawOn(d);
        }
    }
}