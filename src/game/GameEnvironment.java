package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import collision_detetion.Collidable;
import collision_detetion.CollisionInfo;
import geometry_primitives.Line;
import geometry_primitives.Velocity;
import geometry_primitives.Point;
import geometry_primitives.Rectangle;
import sprites.Ball;
import sprites.Block;
import java.awt.Color;
import java.util.ArrayList;

/**
 * class GameEnvironment holds a list of Collidable.
 *
 * @author Dana Danilenko 211538863
 * @version 3
 * @since 7-04-2022
 */
public class GameEnvironment {
    private ArrayList<Collidable> array;

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.array = new ArrayList<>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.array.add(c);
    }

    /**
     * remove collidable from array.
     *
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        array.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory line
     * @return collision info or null if there is no collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point min = null;
        double minDis = trajectory.length();
        Collidable collide = null;
        //check if collision point is the closest.
        for (Collidable c : array) {
            Point closePoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            //make that ball will not stack in paddle
            if (trajectory.start().getX()
                    < c.getCollisionRectangle().getRight().start().getX()
                    && trajectory.start().getX()
                    > c.getCollisionRectangle().getLeft().start().getX()
                    && trajectory.start().getY()
                    < c.getCollisionRectangle().getDown().start().getY()
                    && trajectory.start().getY()
                    > c.getCollisionRectangle().getUp().start().getY()) {
                return null;
            }
            if (closePoint != null && closePoint.distance(trajectory.start()) <= minDis) {
                minDis = closePoint.distance(trajectory.start());
                min = closePoint;
                collide = c;
            }

        }
        if (min != null) {
            return new CollisionInfo(min, collide);
        }
        return null;
    }

}


