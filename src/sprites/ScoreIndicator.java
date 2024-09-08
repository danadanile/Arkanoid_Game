package sprites;

import biuoop.DrawSurface;
import collision_detetion.Counter;
import game.GameLevel;
import geometry_primitives.Rectangle;

import java.awt.Color;

/**
 * class that is a sprite. follows after the score and display it.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 15-05-2022
 */
public class ScoreIndicator implements Sprite {
    private Counter countScore;
    private Rectangle rectangle;
    private Color color;
    private String name;

    /**
     * constructor.
     *
     * @param rectangle shape of indicator
     * @param countScore score game
     * @param color color of indicator
     * @param name name of level
     */
    public ScoreIndicator(Rectangle rectangle, Counter countScore, Color color, String name) {
        this.rectangle = rectangle;
        this.countScore = countScore;
        this.color = color;
        this.name = name;

    }

    /**
     * draw the score rectangle.
     *
     * @param drawSurface drawSurface
     */
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(color);
        drawSurface.fillRectangle(0, 0, 800, 20);
        drawSurface.setColor(Color.magenta);
        String scoreDisplay = String.valueOf(countScore.getValue());
        drawSurface.drawText((int) (rectangle.getUpperLeft().getX() + rectangle.getWidth() / 2 - 30),
                (int) rectangle.getUpperLeft().getY() + 15,
                "score: " + scoreDisplay + "                    Level name:" + name, 15);
    }

    /**
     * set count when there is a win.
     *
     * @param countScore
     */
    public void setWinCountScore(Counter countScore) {
        this.countScore.increase(100);
    }

    @Override
    public void timePassed() {

    }

    /**
     * add sprite to game.
     *
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
