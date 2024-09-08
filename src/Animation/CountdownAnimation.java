package Animation;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import sprites.SpriteCollection;

import java.awt.Color;

/**
 * CountdownAnimation handle with the countdown.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 25-05-2022
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;

    /**
     * constructor.
     *
     * @param numOfSeconds time for every num show
     * @param countFrom    numbers that count
     * @param gameScreen   game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
    }

    /**
     * runs the countdown frame.
     *
     * @param d DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        if (countFrom > -1) {
            gameScreen.drawAllOn(d);
            d.setColor(Color.red);
            d.fillCircle(400, 300, 30);
            d.setColor(Color.white);
            d.drawText(390, 310, "" + countFrom, 30);
            countFrom = countFrom - 1;
            if (countFrom < 2) {
                sleeper.sleepFor(666);
            }
        } else {
            stop = true;
        }
    }

    /**
     * indicate if game should stop.
     *
     * @return stop
     */
    public boolean shouldStop() {
        return stop;
    }
}
