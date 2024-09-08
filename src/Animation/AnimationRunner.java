package Animation;

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * AnimationRunner takes an animation object and runs it.
 *
 * @author Dana Danilenko 211538863
 * @version 3
 * @since 25-05-2022
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;

    /**
     * constructor.
     *
     * @param gui gui
     */
    public AnimationRunner(GUI gui) {
        this.framesPerSecond = 60;
        this.gui = gui;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * return gui.
     *
     * @return gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Run the game -- start the animation loop.
     *
     * @param animation animation object
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
