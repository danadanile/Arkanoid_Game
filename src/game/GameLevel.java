package game;

import Animation.Animation;
import Animation.AnimationRunner;
import Animation.CountdownAnimation;
import Animation.KeyPressStoppableAnimation;
import Animation.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import collision_detetion.Counter;
import collision_detetion.BallRemover;
import collision_detetion.BlockRemover;
import collision_detetion.ScoreTrackingListener;
import collision_detetion.Collidable;
import geometry_primitives.Rectangle;
import geometry_primitives.Point;
import sprites.Block;
import sprites.Ball;
import sprites.Sprite;
import sprites.ScoreIndicator;
import sprites.SpriteCollection;
import sprites.Paddle;

import java.awt.Color;
import java.util.List;


/**
 * class Game hold the sprites and the collidables, and will be in charge
 * of the animation.
 *
 * @author Dana Danilenko 211538863
 * @version 8
 * @since 26-05-2022
 */

public class GameLevel implements Animation {
    private GUI gui;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter countBlocks;
    private Counter countBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * constructor.
     *
     * @param levelInfo       level information
     * @param keyboardSensor  keyboard sensor
     * @param animationRunner animation runner
     * @param score           score
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = animationRunner.getGui();
        this.countBlocks = new Counter(0);
        this.countBalls = new Counter(0);
        this.score = score;
        this.runner = new AnimationRunner(gui);
        this.running = false;
        this.keyboard = keyboardSensor;
        this.levelInformation = levelInfo;
    }

    /**
     * return level information.
     *
     * @return levelInformation
     */
    public LevelInformation getLeveInfo() {
        return this.levelInformation;
    }

    /**
     * return number of blocks.
     *
     * @return number of blocks
     */
    public Counter getCountBlocks() {
        return this.countBlocks;
    }

    /**
     * return number of balls.
     *
     * @return number of balls
     */
    public Counter getCountBalls() {
        return this.countBalls;
    }

    /**
     * add a collidable object to environment.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add sprite object to sprites collection.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        BlockRemover blockRemover = new BlockRemover(this, countBlocks);
        BallRemover ballRemover = new BallRemover(this, countBalls);
        ScoreTrackingListener scoreTrackingListener =
                new ScoreTrackingListener(score);

        addSprite(levelInformation.getBackground());
        Block b1 = new Block(new Rectangle(new Point(0, 20),
                800, 10), Color.gray);
        b1.addToGame(this);


        Block b2 = new Block(new Rectangle(new Point(0, 0),
                10, 600), Color.gray);
        b2.addToGame(this);

        Block b3 = new Block(new Rectangle(new Point(0, 590),
                800, 10), Color.gray);
        b3.addToGame(this);
        b3.getHitListeners().add(ballRemover);


        Block b4 = new Block(new Rectangle(new Point(790, 0),
                10, 600), Color.gray);
        b4.addToGame(this);

        ScoreIndicator b5 = new ScoreIndicator(new Rectangle(new Point(0, 0),
                800, 20), score, Color.WHITE, levelInformation.levelName());
        b5.addToGame(this);

        Paddle paddle = new Paddle(new Rectangle(levelInformation.coardinate(),
                levelInformation.paddleWidth(), 12), keyboard, 10,
                790, Color.orange, levelInformation.paddleSpeed(),
                levelInformation.paddleWidth());
        paddle.addToGame(this);

        List<Block> list = levelInformation.blocks();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).addToGame(this);
            countBlocks.increase(1);
            list.get(i).addHitListener(blockRemover);
            list.get(i).addHitListener(scoreTrackingListener);
        }
        countBalls.increase(levelInformation.numberOfBalls());

    }

    private void createBallsOnTopOfPaddle() {
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball1 = new Ball(new Point(398, 558), 5, Color.white,
                    levelInformation.initialBallVelocities().get(i), environment);
            ball1.addToGame(this);
        }
    }

    /**
     * remove collidable.
     *
     * @param c collidable object
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * remove sprite.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {

        sprites.removeSprite(s);
    }

    /**
     * run the game.
     */
    public void run() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.running = true;
        this.runner.run(new CountdownAnimation(2,
                3, sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.keyboard.isPressed("p")) {
            KeyPressStoppableAnimation keyPressStoppableAnimation =
                    new KeyPressStoppableAnimation(gui.getKeyboardSensor(),
                            "space", new PauseScreen(this.keyboard));
            runner.run(keyPressStoppableAnimation);
        }

        if (countBlocks.getValue() == 0) {
            score.increase(100);
            this.sprites.drawAllOn(d);
            this.running = false;
        }
        if (countBalls.getValue() == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

}