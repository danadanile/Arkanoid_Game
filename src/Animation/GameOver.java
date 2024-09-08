package Animation;

import biuoop.DrawSurface;
import collision_detetion.Counter;

import java.awt.Color;

/**
 * GameOver animation of the game over screen.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 25-05-2022
 */
public class GameOver implements Animation {
    private Counter score;

    /**
     * constructor.
     *
     * @param score game score.
     */
    public GameOver(Counter score) {
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.red);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(50, 80, "Game Over!", 50);
        d.drawText(540, 320, "Your score is: " + score.getValue(), 30);
        d.drawText(270, 560, "To continue press space", 30);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
