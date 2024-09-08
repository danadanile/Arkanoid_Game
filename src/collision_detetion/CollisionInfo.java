package collision_detetion;

import geometry_primitives.Point;

/**
 * CollisionInfo class has point and collidable object.
 *
 * @author Dana Danilenko 211538863
 * @version 2
 * @since 8-04-2022
 */
public class CollisionInfo {

    private Point point;
    private Collidable collidable;

    /**
     * constructor.
     *
     * @param point      point
     * @param collidable collidable object.
     */
    public CollisionInfo(Point point, Collidable collidable) {
        this.point = point;
        this.collidable = collidable;
    }

    /**
     * return the point at which the collision occurs.
     *
     * @return point
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * return the collidable object involved in the collision.
     *
     * @return collidable object
     */
    public Collidable collisionObject() {
        return this.collidable;

    }
}