package sprites;

import biuoop.DrawSurface;
import collision_detetion.Collidable;
import collision_detetion.HitListener;
import collision_detetion.HitNotifier;
import game.GameLevel;
import geometry_primitives.Velocity;
import geometry_primitives.Rectangle;
import geometry_primitives.Point;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * Block implements from Collidable and Sprites. has rectangle.
 * class has hit func that check if there is an object that collide into block
 * and change the velocity accordingly. has drawn func that draw block
 *
 * @author Dana Danilenko 211538863
 * @version 4
 * @since 14-05-2022
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle rectangle;
    private Color color;

    /**
     * constructor.
     *
     * @param rectangle rectangle
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * constructor.
     *
     * @param rectangle rectangle
     * @param color color of block
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * set rectangle.
     *
     * @param rectangle rectangle
     */
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * set rectangle.
     *
     * @param upperLeft up left point of rectangle
     * @param width     width of rectangle
     * @param height    height of rectangle
     */
    public void setRectangle(Point upperLeft, double width, double height) {
        this.rectangle = new Rectangle(upperLeft, height, width);
    }

    /**
     * return listener list.
     * @return hitListeners
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
    }

    /**
     * get the collision rectangle.
     *
     * @return rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  point of collision
     * @param currentVelocity velocity
     * @return new velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        if (this.rectangle.getUp().withIntersectionEdge(collisionPoint)
                || this.rectangle.getDown().withIntersectionEdge(collisionPoint)) {
            this.notifyHit(hitter);
            currentVelocity.setDY(-1 * currentVelocity.getDy());
        }

        if (this.rectangle.getLeft().withIntersectionEdge(collisionPoint)
                || this.rectangle.getRight().withIntersectionEdge(collisionPoint)) {
            this.notifyHit(hitter);
            currentVelocity.setDX(-1 * currentVelocity.getDx());

        }

        return currentVelocity;
    }

    /**
     * draw the block.
     *
     * @param surface surface
     */
    public void drawOn(DrawSurface surface) {

        surface.setColor(color);
        int x = (int) rectangle.getUpperLeft().getX();
        int y = (int) rectangle.getUpperLeft().getY();
        int height = (int) rectangle.getHeight();
        int width = (int) rectangle.getWidth();
        surface.fillRectangle(x, y, width, height);
        surface.setColor(Color.black);
        surface.drawRectangle(x, y, width, height);
    }

    /**
     * move block(not in use).
     */
    @Override
    public void timePassed() {

    }

    /**
     * add block to sprites list and to collidable list.
     *
     * @param g gama object
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove block from sprites list and from collidable list.
     *
     * @param game game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);

    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }

    }
}

