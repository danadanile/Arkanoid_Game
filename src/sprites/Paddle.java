package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collision_detetion.Collidable;
import game.GameLevel;
import geometry_primitives.Line;
import geometry_primitives.Velocity;
import geometry_primitives.Rectangle;
import geometry_primitives.Point;

import java.awt.Color;

/**
 * is the player in the game. It is a rectangle that is controlled by the arrow
 * keys, and moves according to the player key presses.
 *
 * @author Dana Danilenko 211538863
 * @version 4
 * @since 10-04-2022
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int leftEnd;
    private int rightEnd;
    private Color color;
    private int speed;
    private int width;

    /**
     * constructor.
     *
     * @param rectangle rectangle
     * @param keyboard  keyboard
     * @param leftEnd   the left border of game
     * @param rightEnd  the right border of game
     */

    public Paddle(Rectangle rectangle, KeyboardSensor keyboard,
                  int leftEnd, int rightEnd) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
    }

    /**
     * constructor.
     *
     * @param rectangle rectangle
     * @param keyboard  keyboard
     * @param leftEnd   left end of paddle
     * @param rightEnd  right end of paddle
     * @param color     color of paddle
     * @param speed     speed of paddle
     * @param width     width of paddle
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard,
                  int leftEnd, int rightEnd, Color color, int speed, int width) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
        this.color = color;
        this.speed = speed;
        this.width = width;
    }


    /**
     * moving the paddle to left.
     */
    public void moveLeft() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            double x = rectangle.getUpperLeft().getX();
            double y = rectangle.getUpperLeft().getY();
            if (x - speed < leftEnd) {
                this.rectangle = new Rectangle(new Point(leftEnd, y),
                        rectangle.getWidth(), rectangle.getHeight());
            } else {
                this.rectangle = new Rectangle(new Point(x - speed, y),
                        rectangle.getWidth(), rectangle.getHeight());
            }
        }
    }

    /**
     * moving the paddle to right.
     */
    public void moveRight() {
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            double x = rectangle.getUpperLeft().getX();
            double y = rectangle.getUpperLeft().getY();
            if (x + rectangle.getWidth() + speed > rightEnd) {
                this.rectangle = new Rectangle(new Point(rightEnd
                        - rectangle.getWidth(), y),
                        rectangle.getWidth(), rectangle.getHeight());
            } else {
                this.rectangle = new Rectangle(new Point(x + speed, y),
                        rectangle.getWidth(), rectangle.getHeight());
            }
        }
    }

    /**
     * moving the paddle left and right.
     */
    public void timePassed() {
        moveRight();
        moveLeft();
    }

    /**
     * draw the paddle.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        int x = (int) rectangle.getUpperLeft().getX();
        int y = (int) rectangle.getUpperLeft().getY();
        int height = (int) rectangle.getHeight();
        int width = (int) rectangle.getWidth();
        d.fillRectangle(x, y, width, height);
        d.setColor(Color.gray);
        d.drawRectangle(x, y, width, height);
    }

    /**
     * return rectangle.
     *
     * @return rectangle
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }


    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us.
     * if ball hit left/right sides of paddle while paddle is moving: make the
     * ball pass trow the paddle, so it will not stack in paddle.
     *
     * @param collisionPoint  collision point
     * @param currentVelocity velocity
     * @param hitter          the ball that hit
     * @return velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        Line l1 = new Line(rectangle.getUpperLeft().getX(),
                rectangle.getUpperLeft().getY(),
                rectangle.getUpperLeft().getX() + width / 5,
                rectangle.getUpperLeft().getY());

        Line l2 = new Line(rectangle.getUpperLeft().getX() + width / 5,
                rectangle.getUpperLeft().getY(),
                rectangle.getUpperLeft().getX() + width / 5 * 2,
                rectangle.getUpperLeft().getY());

        Line l3 = new Line(rectangle.getUpperLeft().getX() + width / 5 * 2,
                rectangle.getUpperLeft().getY(),
                rectangle.getUpperLeft().getX() + width / 5 * 3,
                rectangle.getUpperLeft().getY());

        Line l4 = new Line(rectangle.getUpperLeft().getX() + width / 5 * 3,
                rectangle.getUpperLeft().getY(),
                rectangle.getUpperLeft().getX() + width / 5 * 4,
                rectangle.getUpperLeft().getY());

        Line l5 = new Line(rectangle.getUpperLeft().getX() + width / 5 * 4,
                rectangle.getUpperLeft().getY(),
                rectangle.getUpperLeft().getX() + width,
                rectangle.getUpperLeft().getY());

        if (l1.withIntersectionEdge(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        }
        if (l2.withIntersectionEdge(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
        }
        if (l4.withIntersectionEdge(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        }
        if (l5.withIntersectionEdge(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }

        if ((this.rectangle.getUp().withIntersectionEdge(collisionPoint))
                || this.rectangle.getDown().withIntersectionEdge(collisionPoint)) {
            currentVelocity.setDY(-1 * currentVelocity.getDy());
        }

        if ((this.rectangle.getLeft().withIntersectionEdge(collisionPoint))
                || this.rectangle.getRight().withIntersectionEdge(collisionPoint)) {
            currentVelocity.setDX(-1 * currentVelocity.getDx());

        }
        return currentVelocity;
    }


    /**
     * Add this paddle to the game.
     *
     * @param g game object
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}