package geometry_primitives;

import java.util.ArrayList;

/**
 * Rectangle has 4 edges,point,height and width. has function that check if line
 * intersecting a rectangle
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 8-04-2022
 */
public class Rectangle {
    private Line up;
    private Line down;
    private Line left;
    private Line right;
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft point
     * @param width     width of rectangle.
     * @param height    height of rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.up = new Line(upperLeft, new Point(upperLeft.getX() + width,
                upperLeft.getY()));
        this.left = new Line(upperLeft, new Point(upperLeft.getX(),
                upperLeft.getY() + height));
        this.right = new Line(new Point(upperLeft.getX() + width,
                upperLeft.getY()),
                new Point(upperLeft.getX() + width,
                        upperLeft.getY() + height));
        this.down = new Line(new Point(upperLeft.getX(),
                upperLeft.getY() + height),
                new Point(upperLeft.getX() + width,
                        upperLeft.getY() + height));
    }

    /**
     * constructor.
     *
     * @param upperLeft point
     * @param width     width of rectangle
     * @param height    height of rectangle
     * @param up        edge
     * @param down      edge
     * @param left      edge
     * @param right     edge
     */
    public Rectangle(Point upperLeft, double width, double height, Line up,
                     Line down, Line left, Line right) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
        this.up = up;
        this.left = left;
        this.right = right;
        this.down = down;
    }

    /**
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line line
     * @return list of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> intersection = new ArrayList<Point>();
        ArrayList<Line> edges = new ArrayList<Line>();
        edges.add(this.getUp());
        edges.add(this.getDown());
        edges.add(this.getLeft());
        edges.add(this.getRight());

        if (!line.isIntersecting(edges.get(0))
                && !line.isIntersecting(edges.get(1))
                && !line.isIntersecting(edges.get(2))
                && !line.isIntersecting(edges.get(3))) {
            return intersection;
        }
        for (int i = 0; i < edges.size(); i++) {
            Point intersect = line.intersectionWith(edges.get(i));
            if (intersect != null) {
                intersection.add(intersect);
            }
        }
        return intersection;
    }


    /**
     * return width.
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * return height.
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return upperLeft
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Returns the down line of the rectangle.
     *
     * @return down line
     */
    public Line getDown() {
        return down;
    }

    /**
     * Returns the up line of the rectangle.
     *
     * @return up line
     */
    public Line getUp() {
        return up;
    }

    /**
     * Returns the left line of the rectangle.
     *
     * @return left line
     */
    public Line getLeft() {
        return left;
    }

    /**
     * Returns the right line of the rectangle.
     *
     * @return right line
     */
    public Line getRight() {
        return right;
    }
}
