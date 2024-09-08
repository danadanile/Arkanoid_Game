package geometry_primitives;

/**
 * point class has function that calculate distance between two point,check if
 * two point equals.
 *
 * @author Dana Danilenko 211538863
 * @version 4
 * @since 28-03-2022
 */
public class Point {
    static final double EPSILON = Math.pow(10, -10);
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the distance of this point to the other point.
     *
     * @param other point
     * @return distance
     */
    public double distance(Point other) {
        return Math.sqrt((other.y - this.y) * (other.y - this.y)
                + (other.x - this.x) * (other.x - this.x));
    }

    /**
     * check if one double values bigger from other.
     *
     * @param x1 first x
     * @param x2 second x
     * @return true is bigger false otherwise.
     */
    public boolean bigger(double x1, double x2) {
        return (x1 - x2) >= EPSILON;
    }

    /**
     * check if one double values smaller from other.
     *
     * @param x1 first x
     * @param x2 second x
     * @return true is smaller false otherwise.
     */
    public boolean smaller(double x1, double x2) {
        return (x2 - x1) >= EPSILON;
    }

    /**
     * check if two double values equals.
     *
     * @param x1 first x
     * @param x2 second x
     * @return true is equals false otherwise.
     */
    public boolean equals(double x1, double x2) {
        return Math.abs(x1 - x2) <= EPSILON;
    }

    /**
     * return true is the points are equal, false otherwise.
     *
     * @param other point
     * @return true/false
     */
    public boolean equals(Point other) {
        if (equals(other.x, this.x) && equals(this.y, other.y)) {
            return true;
        }
        return false;
    }

    /**
     * set x.
     *
     * @param x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * set y.
     *
     * @param y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * return x value.
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * return y value.
     *
     * @return y
     */
    public double getY() {
        return y;
    }
}
