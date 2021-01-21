import java.awt.*;

public abstract class BreakoutConstants {
    /**
     * Dimensions of the canvas, in pixels
     * These should be used when setting up the initial size of the game,
     * but in later calculations you should use getWidth() and getHeight()
     * rather than these constants for accurate size information.
     */
    public static final int CANVAS_WIDTH = 420;
    public static final int CANVAS_HEIGHT = 600;

    // Stage 1: Set up the Bricks

    /**
     * Number of bricks in each row
     */
    public static final int NBRICK_COLUMNS = 10;

    /**
     * Number of rows of bricks
     */
    public static final int NBRICK_ROWS = 10;

    public static final int TOTAL_AMOUNT_OF_BRICKS = 100;
    public static final int ROW_ZERO_INDEX = 0;
    /**
     * Separation between neighboring bricks, in pixels
     */
    public static final double BRICK_SEP = 4;

    /**
     * Width of each brick, in pixels
     */
    public static final double BRICK_WIDTH = Math.floor(
            (CANVAS_WIDTH - (NBRICK_COLUMNS + 1.0) * BRICK_SEP) / NBRICK_COLUMNS);

    /**
     * Height of each brick, in pixels
     */
    public static final double BRICK_HEIGHT = 8;

    /**
     * Offset of the top brick row from the top, in pixels
     */
    public static final double BRICK_Y_OFFSET = 70;
    public static final double BRICK_BORDER_TOP_OFFSET = BRICK_Y_OFFSET - 1;

    //Boolean for setting the bricks
    public static boolean LINE_COUNTER_BOOL(int x){
        if(x == 10){
            return true;
        }
        if(x == 20){
            return true;
        }
        if(x == 30){
            return true;
        }
        if(x == 40){
            return true;
        }
        if(x == 50){
            return true;
        }
        if(x == 60){
            return true;
        }
        if(x == 70){
            return true;
        }
        if(x == 80){
            return true;
        }
        if(x == 90){
            return true;
        }
        else {return false;}
    }


    public static boolean TOP_BORDER_BOOL(int x){
        if(x == 10){
            return true;
        }
        else if(x == 20){
            return true;
        }
        else if(x == 30){
            return true;
        }
        else if(x == 40){
            return true;
        }
        else if(x == 50){
            return true;
        }
        else if(x == 60){
            return true;
        }
        else  if(x == 70){
            return true;
        }
        else if(x == 80){
            return true;
        }
        else if(x == 90){
            return true;
        }
        else {return false;}
    }

    public static boolean LEFT_BORDER_BOOL(int x){
        if(x == 10){
            return true;
        }
        else if(x == 20){
            return true;
        }
        else if(x == 30){
            return true;
        }
        else if(x == 40){
            return true;
        }
        else if(x == 50){
            return true;
        }
        else if(x == 60){
            return true;
        }
        else  if(x == 70){
            return true;
        }
        else if(x == 80){
            return true;
        }
        else if(x == 90){
            return true;
        }
        else {return false;}
    }

    public static boolean RIGHT_BORDER_BOOL(int x){
        if(x == 10){
            return true;
        }
        else if(x == 20){
            return true;
        }
        else if(x == 30){
            return true;
        }
        else if(x == 40){
            return true;
        }
        else if(x == 50){
            return true;
        }
        else if(x == 60){
            return true;
        }
        else if(x == 70){
            return true;
        }
        else if(x == 80){
            return true;
        }
        else if(x == 90){
            return true;
        }
        else {return false;}
    }

    // Stage 2: Create the Paddle

    /**
     * Dimensions of the paddle
     */
    public static final double PADDLE_WIDTH = 60;
    public static final double PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    public static final double PADDLE_Y_OFFSET = 30;


    // Stage 3: Create the Bouncing Ball

    /**
     * Radius of the ball in pixels
     */
    public static final double BALL_RADIUS = 10;

    /**
     * The ball's vertical velocity.
     */
    public static final double VELOCITY_Y = 3.0;

    /**
     * The ball's minimum and maximum horizontal velocity; the bounds of the
     * initial random velocity that you should choose (randomly +/-).
     */
    public static final double VELOCITY_X_MIN = 1.0;
    public static final double VELOCITY_X_MAX = 3.0;

    /**
     * Animation delay or pause time between ball moves (ms)
     */
    public static final int DELAY = 1000 / 60;


    // Stage 4: Checking for Collisions (no new constants introduced)

    // Stage 5: Polish and Finishing Up

    /** Number of turns */
    public static final int NTURNS = 3;

    /** Font to use for on-screen text */
    public static final String SCREEN_FONT = "SansSerif-BOLD-18";
}

/*
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NOTE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * ! Your program should work properly with an UNMODIFIED version of this file.  !
 * ! You can and should modify the constants' values for testing, but you should !
 * ! not add any new constants here.  If you want additional constants for your  !
 * ! code, please add them to your own Breakout.java file, NOT here.             !
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */