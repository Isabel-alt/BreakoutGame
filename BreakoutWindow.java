/*Isabel Sitoe
 * Assignment: BreakOut Room
 * 18/10/2020
 * In this assignment I had the prompt to write the classic arcade Breakout room game which consisted of writing prompts for the following
 * Bricks
 * Paddle
 * Ball and Bouncing
 * Collisions
 *Turns and End of Game
 * */

import objectdraw.*;
import objectdraw.Location;
import java.awt.*;

public class BreakoutWindow extends WindowController {

    public FilledRect[] bricks = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    public FilledRect[] BrickBorderTop = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    public FilledRect[] BrickBorderLeft = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    public FilledRect[] BrickBorderRight = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    private double BrickSeperationX = BreakoutConstants.BRICK_SEP;
    private double BrickSeperationY = BreakoutConstants.BRICK_Y_OFFSET;
    public double BrickBorderTopSepX = BreakoutConstants.BRICK_SEP;
    public double BrickBorderTopSepY = BreakoutConstants.BRICK_BORDER_TOP_OFFSET;
    public double BrickBorderLeftSepX = BreakoutConstants.BRICK_SEP;
    public double BrickBorderLeftSepY = BreakoutConstants.BRICK_BORDER_TOP_OFFSET;
    public double BrickBorderRightSepX = BreakoutConstants.BRICK_SEP + BreakoutConstants.BRICK_WIDTH;
    public double BrickBorderRightSepY = BreakoutConstants.BRICK_BORDER_TOP_OFFSET;
    public FilledRect Paddle;
    public FilledOval Ball;
    public FilledRect LeftBorder;
    public FilledRect TopBorder;
    public FilledRect RightBorder;
    public final int BORDER_WIDTH = 1;
    public Text livesCounter;
    public Text Score;
    public Text gameOver;
    public Text youWin;
    public int BallDropX = 105;

    public void onMouseMove(Location point){
        Paddle.moveTo(point.getX(),BreakoutConstants.CANVAS_HEIGHT - BreakoutConstants.BRICK_Y_OFFSET);
        if(Paddle.overlaps(RightBorder)){
            Paddle.moveTo(BreakoutConstants.CANVAS_WIDTH - BreakoutConstants.PADDLE_WIDTH,BreakoutConstants.CANVAS_HEIGHT - BreakoutConstants.BRICK_Y_OFFSET);
        }
    }

    public void begin() {

        Ball= new FilledOval(BallDropX, BreakoutConstants.CANVAS_HEIGHT /2 - BreakoutConstants.BALL_RADIUS, BreakoutConstants.BALL_RADIUS, BreakoutConstants.BALL_RADIUS, Color.black, canvas);
        LeftBorder = new FilledRect(BreakoutConstants.CANVAS_WIDTH - BreakoutConstants.CANVAS_WIDTH - BORDER_WIDTH,BreakoutConstants.CANVAS_HEIGHT - BreakoutConstants.CANVAS_HEIGHT , BORDER_WIDTH, BreakoutConstants.CANVAS_HEIGHT, Color.white, canvas );
        RightBorder = new FilledRect(BreakoutConstants.CANVAS_WIDTH , BreakoutConstants.CANVAS_HEIGHT - BreakoutConstants.CANVAS_HEIGHT, BORDER_WIDTH,BreakoutConstants.CANVAS_HEIGHT, Color.white, canvas);
        TopBorder = new FilledRect(BreakoutConstants.CANVAS_WIDTH - BreakoutConstants.CANVAS_WIDTH, BreakoutConstants.CANVAS_HEIGHT - BreakoutConstants.CANVAS_HEIGHT - BORDER_WIDTH,BreakoutConstants.CANVAS_WIDTH,BORDER_WIDTH, Color.white, canvas);
        livesCounter = new Text("Lives: "+ BreakoutRules.turns,BreakoutConstants.CANVAS_WIDTH / 40, (BreakoutConstants.CANVAS_HEIGHT / 8) * 7,canvas);
        Score = new Text("Score: "+ BreakoutRules.score, BreakoutConstants.CANVAS_WIDTH - 60, (BreakoutConstants.CANVAS_HEIGHT / 8) *7,canvas);
        gameOver = new Text("Game Over", BreakoutConstants.CANVAS_WIDTH / 2 - 95, BreakoutConstants.CANVAS_HEIGHT / 2, canvas);
        youWin = new Text("Winner",BreakoutConstants.CANVAS_WIDTH / 2 - 95, BreakoutConstants.CANVAS_HEIGHT / 2, canvas );

        youWin.setFontSize(40);
        youWin.setColor(Color.cyan);
        youWin.hide();

        for(int i= 0; i < BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS; i++){
            bricks[i] = new FilledRect(BrickSeperationX , BrickSeperationY, BreakoutConstants.BRICK_WIDTH, BreakoutConstants.BRICK_HEIGHT, Color.red, canvas);
            BrickBorderTop[i] = new FilledRect(BrickBorderTopSepX,BrickBorderTopSepY, BreakoutConstants.BRICK_WIDTH, 2, Color.black, canvas);
            BrickBorderLeft[i] = new FilledRect(BrickBorderLeftSepX, BrickBorderLeftSepY, 2, BreakoutConstants.BRICK_HEIGHT + 1, Color.black, canvas);
            BrickBorderRight[i] = new FilledRect(BrickBorderRightSepX, BrickBorderRightSepY, 2, BreakoutConstants.BRICK_HEIGHT + 1,Color.black, canvas);
            BrickBorderTop[i].setColor(Color.red);
            BrickBorderRight[i].setColor(Color.red);
            BrickBorderLeft[i].setColor(Color.red);

            if(BreakoutConstants.LINE_COUNTER_BOOL(i) == true) {
                BrickSeperationY += bricks[i - BreakoutConstants.NBRICK_ROWS].getHeight() + BreakoutConstants.BRICK_SEP;
                BrickSeperationX = bricks[BreakoutConstants.ROW_ZERO_INDEX].getX();
                bricks[i].moveTo(BrickSeperationX,BrickSeperationY);
                BrickBorderTopSepY += bricks[i - BreakoutConstants.NBRICK_ROWS].getHeight() + bricks[i].getHeight() - BreakoutConstants.BRICK_SEP;
                BrickBorderTopSepX = BrickBorderTop[BreakoutConstants.ROW_ZERO_INDEX].getX();
                BrickBorderTop[i].moveTo(BrickBorderTopSepX, BrickBorderTopSepY);
                BrickBorderLeftSepY += bricks[i - BreakoutConstants.NBRICK_ROWS].getHeight() + bricks[i].getHeight() - BreakoutConstants.BRICK_SEP;
                BrickBorderLeftSepX = BrickBorderTop[BreakoutConstants.ROW_ZERO_INDEX].getX();
                BrickBorderLeft[i].moveTo(BrickBorderLeftSepX, BrickBorderLeftSepY);
                BrickBorderRightSepY += bricks[i - BreakoutConstants.NBRICK_ROWS].getHeight() + bricks[i].getHeight() - BreakoutConstants.BRICK_SEP;
                BrickBorderRightSepX = BrickBorderRight[BreakoutConstants.ROW_ZERO_INDEX].getX();
                BrickBorderRight[i].moveTo(BrickBorderRightSepX,BrickBorderRightSepY);
            }

            BrickSeperationX = bricks[i].getX() + BreakoutConstants.BRICK_WIDTH + BreakoutConstants.BRICK_SEP;
            BrickBorderTopSepX = (BrickBorderTop[i].getX() + BrickBorderTop[i].getWidth() + BreakoutConstants.BRICK_SEP);
            BrickBorderLeftSepX = (BrickBorderLeft[i].getX() + BreakoutConstants.BRICK_WIDTH + BreakoutConstants.BRICK_SEP);
            BrickBorderRightSepX = (BrickBorderRight[i].getX() + BreakoutConstants.BRICK_WIDTH + BreakoutConstants.BRICK_SEP);

            if(i >=  (BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS / 5) && i < (BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS/5) *2 ){
                bricks[i].setColor(Color.orange);
                BrickBorderTop[i].setColor(Color.orange);
                BrickBorderRight[i].setColor(Color.orange);
                BrickBorderLeft[i].setColor(Color.orange);
            }
            if(i >= (BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS / 5) *2 && i <(BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS/5) *3 ){
                bricks[i].setColor(Color.yellow);
                BrickBorderTop[i].setColor(Color.yellow);
                BrickBorderRight[i].setColor(Color.yellow);
                BrickBorderLeft[i].setColor(Color.yellow);
            }
            if(i >= (BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS / 5) *3 && i <(BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS / 5) *4 ){
                bricks[i].setColor(Color.green);
                BrickBorderTop[i].setColor(Color.green);
                BrickBorderRight[i].setColor(Color.green);
                BrickBorderLeft[i].setColor(Color.green);
            }
            if(i >= (BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS / 5) *4 && i <(BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS / 5) *5){
                bricks[i].setColor(Color.cyan);
               BrickBorderTop[i].setColor(Color.cyan);
               BrickBorderRight[i].setColor(Color.cyan);
               BrickBorderLeft[i].setColor(Color.cyan);
            }
        }
        Paddle = new FilledRect(BreakoutConstants.CANVAS_WIDTH / 2  - BreakoutConstants.PADDLE_WIDTH , BreakoutConstants.CANVAS_HEIGHT - BreakoutConstants.BRICK_Y_OFFSET , BreakoutConstants.PADDLE_WIDTH , BreakoutConstants.PADDLE_HEIGHT, Color.BLACK, canvas);
        new BreakoutRules(bricks,Paddle,Ball,RightBorder,LeftBorder,TopBorder, livesCounter,Score,gameOver, BrickBorderTop ,BrickBorderLeft, BrickBorderRight,youWin);
    }
    public static void main(String[] args) {
       new BreakoutWindow().startController(BreakoutConstants.CANVAS_WIDTH,BreakoutConstants.CANVAS_HEIGHT);
    }
}

