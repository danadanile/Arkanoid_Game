package geometry_primitives;

/**
 * velocity class Velocity specifies the change in position on the
 * `x` and the `y` axes.
 *
 * @author Dana Danilenko 211538863
 * @version 3
 * @since 8-04-2022
 */

public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     *
     * @param dx x change
     * @param dy y change
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * calculate the speed.
     *
     * @return speed
     */
    public double getSpeed() {
        return Math.sqrt(getDx() * getDx() + getDy() * getDy());
    }

    /**
     * calculate speed an angele.
     *
     * @param angle angele of ball move
     * @param speed speed of ball
     * @return velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radAngele = Math.toRadians(angle); //convert to rad
        double dy = -speed * Math.cos(radAngele);
        double dx = speed * Math.sin(radAngele);
        return new Velocity(dx, dy);
    }


    /**
     * return dx.
     *
     * @return dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * return dy.
     *
     * @return dy
     */
    public double getDy() {
        return dy;
    }

    /**
     * set dx.
     *
     * @param dx dx
     */
    public void setDX(double dx) {
        this.dx = dx;
    }

    /**
     * set dy.
     *
     * @param dy dy
     */
    public void setDY(double dy) {
        this.dy = dy;
    }

    /**
     * Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     *
     * @param p point
     * @return new point
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }


}