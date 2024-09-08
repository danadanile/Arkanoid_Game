package sprites;

import biuoop.DrawSurface;
import collision_detetion.CollisionInfo;
import game.GameLevel;
import game.GameEnvironment;
import geometry_primitives.Line;
import geometry_primitives.Velocity;
import geometry_primitives.Point;


import java.awt.Color;

/**
 * Ball class has radius,center point,color,speed,and boundaries.
 * draw ball and move step functions.
 *
 * @author Dana Danilenko 211538863
 * @version 8
 * @since 28-03-2022
 */
public class Ball implements Sprite {
    private int r;
    private Point point;
    private Color color;
    private Velocity v;
    private int leftBoundaryX;
    private int upBoundaryY;
    private int rightBoundaryX;
    private int downBoundaryY;
    private GameEnvironment game;


    /**
     * constructors, initialize ball parameters.
     *
     * @param center center point of ball.
     * @param r      radius of ball
     * @param color  color of ball
     */
    public Ball(Point center, int r, Color color) {
        this.r = r;
        this.point = center;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.game = null;
    }

    /**
     * constructors, initialize ball parameters.
     *
     * @param x     x coordinate of ball center
     * @param y     y coordinate of ball center
     * @param r     radius of ball
     * @param color color of ball
     */
    public Ball(double x, double y, int r, Color color) {
        this(new Point(x, y), r, color);
    }

    /**
     * constructor.
     *
     * @param center ball center
     * @param r      radius
     * @param color  color
     * @param v      velocity
     * @param game   game object
     */
    public Ball(Point center, int r, Color color, Velocity v, GameEnvironment game) {
        this(center, r, color, v);
        this.game = game;
    }

    /**
     * constructors, initialize ball parameters.
     *
     * @param center center point of ball.
     * @param r      radius of ball
     * @param color  color of ball
     * @param v      speed of ball
     */
    public Ball(Point center, int r, Color color, Velocity v) {
        this.r = r;
        this.point = center;
        this.color = color;
        this.v = v;
    }

    /**
     * change to x coordinate of ball center.
     *
     * @return new x
     */
    public int getX() {
        return (int) point.getX();
    }

    /**
     * change y coordinate of ball center.
     *
     * @return new y
     */
    public int getY() {
        return (int) point.getY();
    }

    /**
     * return x.
     *
     * @return radius
     */
    public int getSize() {
        return r;
    }

    /**
     * return color.
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * set the coordinates of frame.
     *
     * @param leftBoundaryX  left x coordinate of frame
     * @param leftBoundaryY  left y coordinate of frame
     * @param rightBoundaryX right x coordinate of frame
     * @param rightBoundaryY right y coordinate of frame
     */
    public void setBoundary(int leftBoundaryX, int leftBoundaryY,
                            int rightBoundaryX, int rightBoundaryY) {
        this.leftBoundaryX = leftBoundaryX;
        this.upBoundaryY = leftBoundaryY;
        this.rightBoundaryX = rightBoundaryX;
        this.downBoundaryY = rightBoundaryY;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int) point.getX(), (int) point.getY(), r);
        surface.setColor(Color.black);
        surface.drawCircle((int) point.getX(), (int) point.getY(), r);

    }

    /**
     * return center of ball.
     *
     * @return point
     */
    public Point getCenter() {
        return point;
    }

    /**
     * set gameEnvironment.
     *
     * @param gameEnvironment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.game = gameEnvironment;
    }

    /**
     * set the speed of ball.
     *
     * @param v speed of ball
     */
    public void setVelocity(Velocity v) {
        this.v = new Velocity(v.getDx(), v.getDy());
    }

    /**
     * set the speed of ball.
     *
     * @param dx param of x change for speed
     * @param dy param of y change for speed
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * return the speed.
     *
     * @return v speed of ball
     */
    public Velocity getVelocity() {
        return v;
    }

    /**
     * check the movement of ball. if ball hit boundary in his next move change
     * his speed direction
     */
    public void moveOneStep() {
        Line trajectory = new Line(point, getVelocity().applyToPoint(point));
        CollisionInfo collisionInfo = this.game.getClosestCollision(trajectory);
        if (collisionInfo == null) {
            this.point = this.getVelocity().applyToPoint(this.point);
            return;
        }
        //move ball to hit point
        this.point = new Point(collisionInfo.collisionPoint().getX()
                - getVelocity().getDx() / r,
                collisionInfo.collisionPoint().getY()
                        - getVelocity().getDy() / r);
        setVelocity(collisionInfo.collisionObject().hit(this,
                collisionInfo.collisionPoint(), getVelocity()));
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * add block to sprites list.
     *
     * @param g gama object
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * remove sprite from game.
     * @param g game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);

    }
}

