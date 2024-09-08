package geometry_primitives;

/**
 * Line class has two points, calculate line slope, middle and length.
 * check intersection of two line, and if two line equal.
 *
 * @author Dana Danilenko 211538863
 * @version 8
 * @since 8-03-2022
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * constructor of line.
     *
     * @param start point
     * @param end   point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor of line.
     *
     * @param x1 x coordinate of point
     * @param y1 y coordinate of point
     * @param x2 x coordinate of point
     * @param y2 y coordinate of point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return length of line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return middle point
     */
    public Point middle() {
        double newX = (start.getX() + end.getX()) / 2;
        double newY = (start.getY() + end.getY()) / 2;
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    /**
     * Returns the start point of the line.
     *
     * @return start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * check if line has infinity slope.
     *
     * @return true/false
     */
    public boolean infinitySlope() {
        return start.getX() == end.getX();
    }

    /**
     * calculate slope of line.
     *
     * @return slope
     */
    public double slope() {
        double slope = (start.getY() - end.getY()) / (start.getX() - end.getX());
        return slope;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other line
     * @return true/false
     */
    public boolean isIntersecting(Line other) {
        if (!this.infinitySlope() || !other.infinitySlope()) {
            if (other.slope() == this.slope()) {

                //if line with bigger x starts before line with smaller x ends
                if (Math.max((Math.min(other.start.getX(), other.end.getX())),
                        (Math.min(this.start.getX(), this.end.getX())))
                        <= Math.min((Math.max(other.start.getX(), other.end.getX())),
                        (Math.max(this.start.getX(), this.end.getX())))) {
                    return true;
                }
            }
            //infinity slope
        } else {
            if (!start.equals(start.getX(), other.start.getX())) {
                return false;
            }
            if (Math.max((Math.min(other.start.getY(), other.end.getY())),
                    (Math.min(this.start.getY(), this.end.getY())))
                    <= Math.min((Math.max(other.start.getY(), other.end.getY())),
                    (Math.max(this.start.getY(), this.end.getY())))) {
                return true;
            }
        }

        if (this.intersectionWith(other) != null) {
            return true;
        }
        return false;
    }

    /**
     * function check if x coordinate is in the domain of line points
     * coordinates. for check if intersection is only after lines end.
     *
     * @param x     coordinate x
     * @param other line
     * @return true/false
     */
    public boolean inDomain(double x, Line other) {
        if ((x > Math.max(this.start.getX(), this.end.getX()))
                || (x > Math.max(other.start.getX(), other.end.getX()))) {
            return false;
        }
        if ((x < Math.min(this.start.getX(), this.end.getX()))
                || (x < Math.min(other.start.getX(), other.end.getX()))) {
            return false;
        }
        return true;
    }

    /**
     * Returns the intersection point if the lines intersect,and null otherwise.
     *
     * @param other line
     * @return point of intersection
     */
    public Point intersectionWith(Line other) {

        //if equal, no intersection point
        if (other.equals(new Line(this.start, this.end))) {
            return null;
        }

        //in case two lines parallel to y line.
        if (this.infinitySlope() && other.infinitySlope()) {

            //a possibility for intersection only if they have same x
            if (this.start.getX() == other.start.getX()) {
                if (Math.max(Math.min(this.start.getY(), this.end.getY()),
                        Math.min(other.start.getY(), other.end.getY()))
                        == Math.min(Math.max(this.start.getY(), this.end.getY()),
                        Math.max(other.start.getY(), other.end.getY()))) {
                    return new Point(this.start.getX(),
                            Math.min(Math.max(this.start.getY(), this.end.getY()),
                                    Math.max(other.start.getY(), other.end.getY())));
                }
            }
            return null;
        }
        if (this.infinitySlope()) {
            //x=a
            if (this.start.getX() >= Math.min(other.start.getX(),
                    other.end.getX()) && this.start.getX()
                    <= Math.max(other.start.getX(), other.end.getX())) {
                double b = other.start.getY() - (other.slope() * other.start.getX());
                double y = this.start.getX() * other.slope() + b;

                if (y <= Math.max(this.start.getY(), this.end.getY())
                        && y >= Math.min(this.start.getY(), this.end.getY())) {
                    return new Point(this.start.getX(), y);
                }

                return null;
            }

            return null;
        }

        if (other.infinitySlope()) {
            if (other.start.getX() >= Math.min(this.start.getX(), this.end.getX())
                    && other.start.getX() <= Math.max(this.start.getX(),
                    this.end.getX())) {
                double b = this.start.getY() - (this.slope() * this.start.getX());
                double y = other.start.getX() * this.slope() + b;
                if (y <= Math.max(other.start.getY(), other.end.getY())
                        && y >= Math.min(other.start.getY(), other.end.getY())) {
                    return new Point(other.start.getX(), y);

                }
                return null;
            }
            return null;
        }

        double incline1 = this.slope();
        double incline2 = other.slope();

        if (this.slope() == other.slope()) {

            //in case intersection in 1 point and slope equals.
            if (Math.max((Math.min(other.start.getX(), other.end.getX())),
                    (Math.min(this.start.getX(), this.end.getX())))
                    <= Math.min((Math.max(other.start.getX(), other.end.getX())),
                    (Math.max(this.start.getX(), this.end.getX())))) {

                //if there are two points that equals
                if ((Math.min(Math.max(other.start.getX(), other.end.getX()),
                        Math.max(this.start.getX(), this.end.getX()))
                        == Math.max(Math.min(other.start.getX(),
                        other.end.getX()), Math.min(this.start.getX(),
                        this.end.getX())))
                        && (Math.min(Math.max(other.start.getY(), other.end.getY()),
                        Math.max(this.start.getY(), this.end.getY()))
                        == Math.max(Math.min(other.start.getY(),
                        other.end.getY()), Math.min(this.start.getY(),
                        this.end.getY())))) {

                    double x = Math.min(Math.max(other.start.getX(), other.end.getX()),
                            Math.max(this.start.getX(), this.end.getX()));
                    double b = start.getY() - (incline1 * start.getX());
                    double y = x * this.slope() + b;
                    return new Point(x, y);

                }
            }
            return null;
        }

        double b1 = start.getY() - (incline1 * start.getX());
        double b2 = other.start.getY() - (incline2 * other.start.getX());
        double x = (b2 - b1) / (incline1 - incline2);
        double y = incline1 * ((b2 - b1) / (incline1 - incline2)) + b1;
        if (!inDomain(x, other)) {
            return null;
        }
        return new Point(x, y);
    }

    /**
     * return true is the lines are equal, false otherwise.
     *
     * @param other line
     * @return true/false
     */
    public boolean equals(Line other) {
        if ((other.start.equals(this.start) && other.end.equals(this.end))
                || (other.start.equals(this.end) && other.end.equals(this.start))) {
            return true;
        }
        return false;
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect Rectangle
     * @return null or point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> intersection = rect.intersectionPoints(this);

        if (intersection.size() == 0) {
            return null;
        }
        //check minimum of intersection
        Point closestP = intersection.get(0);
        double min = this.start.distance(intersection.get(0));
        for (int i = 0; i < intersection.size(); i++) {
            if (this.start.distance(intersection.get(i)) < min) {
                closestP = intersection.get(i);
                min = this.start.distance(intersection.get(i));
            }
        }
        return closestP;
    }

    /**
     * check if point is on a line.
     *
     * @param point point
     * @return true if on the line false otherwise
     */
    public Boolean withIntersectionEdge(Point point) {
        //left-right edge
        if (start.equals(start.getX(), end.getX())) {
            if (point.getY() >= Math.min(start.getY(), end.getY())
                    && point.getY() <= Math.max(start.getY(), end.getY())
                    && start.equals(start.getX(), point.getX())) {
                return true;
            }
            return false;
        }
        //up-down edge
        if (start.equals(start.getY(), end.getY())) {
            if (point.getX() >= Math.min(start.getX(), end.getX())
                    && point.getX() <= Math.max(start.getX(), end.getX())
                    && start.equals(start.getY(), point.getY())) {
                return true;
            }
            return false;
        }
        return false;
    }
}