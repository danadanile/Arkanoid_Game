import biuoop.GUI;
import biuoop.KeyboardSensor;
import Animation.AnimationRunner;
import game.GameFlow;
import game.LevelInformation;
import levels.DirectHit;
import levels.WideEasy;
import levels.Green3;
import levels.FinalFour;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass6Game runs the animation and the game.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 9-04-2022
 */
public class Ass6Game {
    /**
     * runs the game.
     *
     * @param args array of strings
     */
    public static void main(String[] args) {
        GUI gui = new GUI("hakuna matata", 800, 600);
        KeyboardSensor key = gui.getKeyboardSensor();
        AnimationRunner animationRunner = new AnimationRunner(gui);
        GameFlow gameFlow = new GameFlow(animationRunner, key);

        LevelInformation level1 = new DirectHit();
        LevelInformation level2 = new WideEasy();
        LevelInformation level3 = new Green3();
        LevelInformation level4 = new FinalFour();
        List<LevelInformation> list = new ArrayList<>();


        for (String arg : args) {
            switch (arg) {
                case "1":
                    list.add(level1);
                    break;
                case "2":
                    list.add(level2);
                    break;
                case "3":
                    list.add(level3);
                    break;
                case "4":
                    list.add(level4);
                    break;
                default:
                    break;
            }
        }
        if (list.isEmpty()) {
            list.add(level1);
            list.add(level2);
            list.add(level3);
            list.add(level4);
        }
        gameFlow.runLevels(list);
    }
}
