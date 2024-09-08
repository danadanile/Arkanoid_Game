package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation decorator-class that will wrap an existing animation
 * and add a "waiting-for-key" behavior to it.
 *
 * @author Dana Danilenko 211538863
 * @version 3
 * @since 30-05-2022
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private Animation animation;
    private String key;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     *
     * @param sensor    sensor
     * @param key       string of key
     * @param animation animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (keyboardSensor.isPressed(key) && !isAlreadyPressed) {
            stop = true;
        }
        if (!keyboardSensor.isPressed(key)) {
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}
