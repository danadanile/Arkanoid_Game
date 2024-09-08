package collision_detetion;

import geometry_primitives.Point;
import geometry_primitives.Rectangle;
import geometry_primitives.Velocity;
import sprites.Ball;

/**
 * interface Collidable. will be used by things that can be collided with.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 7-04-2022
 */
public interface Collidable {

    /**
     * Return the "collision shape" of the object.
     *
     * @return rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  point
     * @param currentVelocity velocity
     * @param hitter          the ball that hit
     * @return velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
