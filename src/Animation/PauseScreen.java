package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * PauseScreen creates option to pause the game when pressing the p key.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 25-05-2022
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     *
     * @param k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * creates the pause frame.
     *
     * @param d DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.pink);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * indicate if game should stop.
     *
     * @return stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

