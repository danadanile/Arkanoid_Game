package game;

import Animation.AnimationRunner;
import Animation.GameOver;
import Animation.KeyPressStoppableAnimation;
import Animation.Win;
import biuoop.KeyboardSensor;
import collision_detetion.Counter;

import java.util.List;

/**
 * This class will be in charge of creating the different levels,
 * and moving from one level to the next.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 26-05-2022
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;
    private boolean gamaOver;


    /**
     * constructor.
     *
     * @param ar AnimationRunner
     * @param ks KeyboardSensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter(0);
        this.gamaOver = false;
    }

    /**
     * runs all the levels.
     *
     * @param levels array of all the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, score);

            level.initialize();
            while (level.getCountBlocks().getValue() > 0 && level.getCountBalls().getValue() > 0) {
                level.run();
            }

            if (level.getCountBalls().getValue() == 0) {
                this.gamaOver = true;
                break;
            }
        }

        KeyPressStoppableAnimation stoppableAnimation;
        if (this.gamaOver) {
            stoppableAnimation = new KeyPressStoppableAnimation(keyboardSensor, "space", new GameOver(this.score));
        } else {
            stoppableAnimation = new KeyPressStoppableAnimation(keyboardSensor, "space", new Win(this.score));
        }
        animationRunner.run(stoppableAnimation);
        animationRunner.getGui().close();
    }
}
