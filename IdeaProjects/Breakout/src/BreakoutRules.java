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

import objectdraw.ActiveObject;
import objectdraw.FilledOval;
import objectdraw.FilledRect;
import objectdraw.Text;

import java.awt.*;

public class BreakoutRules extends ActiveObject {

    public static FilledRect[] Bricks = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    public static FilledRect[] BrickBorderTop = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    public static FilledRect[] BrickBorderLeft = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    public static FilledRect[] BrickBorderRight = new FilledRect[BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS];
    private static FilledRect Paddle;
    public static FilledOval Ball;
    private static FilledRect rBorder;
    private static FilledRect lBorder;
    private static FilledRect tBorder;
    private static Text livesLabel;
    private static Text scoreLabel;
    private static Text gameOver;
    private static Text youWin;

    public static int turns = 3;
    private static int xSpeed = 7;
    private static int ySpeed = 9;
    public static int score = 0;

    public BreakoutRules(FilledRect[] bricks,FilledRect paddle, FilledOval ball,FilledRect right, FilledRect left,
                         FilledRect top, Text lLabel, Text sLabel, Text gOver, FilledRect[] BBTop, FilledRect[] BBLeft, FilledRect[] BBRight, Text yWin){
        Bricks = bricks;
        Paddle = paddle;
        Ball = ball;
        rBorder = right;
        lBorder = left;

        tBorder = top;
        livesLabel = lLabel;
        scoreLabel = sLabel;
        gameOver = gOver;
        BrickBorderTop = BBTop;
        BrickBorderLeft = BBLeft;
        BrickBorderRight = BBRight;
        youWin = yWin;

        start();
    }
    public void run(){

        while(turns > 0) {
            gameOver.hide();

            Ball.move(xSpeed,ySpeed);
            pause(30);

            if(Ball.overlaps(rBorder)){
                xSpeed = -7;
            }
            if(Ball.overlaps(lBorder)) {
                xSpeed = 7;
            }
            if(Ball.overlaps(tBorder)) {
                ySpeed = 9;
            }
            if(Ball.overlaps(Paddle)) {
                ySpeed = -9;
            }
            if(Ball.getY() > BreakoutConstants.CANVAS_HEIGHT) {
                turns--;
                Ball.moveTo(BreakoutConstants.CANVAS_WIDTH / 2, BreakoutConstants.CANVAS_HEIGHT /2 - BreakoutConstants.BALL_RADIUS);
                livesLabel.setText("Lives: "+ Integer.toString(turns));
            }

            for(int i = 0; i < BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS; i++){

                if(Ball.overlaps(BrickBorderTop[i]) && Bricks[i].isHidden()== false){
                    Bricks[i].hide();
                    BrickBorderTop[i].hide();
                    BrickBorderRight[i].hide();
                    BrickBorderLeft[i].hide();
                    score++;
                    scoreLabel.setText("Score: "+ Integer.toString(score));
                    ySpeed = -9;
                }
                if(Ball.overlaps(BrickBorderRight[i]) && Bricks[i].isHidden() == false){
                    Bricks[i].hide();
                    BrickBorderTop[i].hide();
                    BrickBorderRight[i].hide();
                    BrickBorderLeft[i].hide();
                    score++;
                    scoreLabel.setText("Score: "+ Integer.toString(score));
                    xSpeed = 7;
                }
                if(Ball.overlaps(BrickBorderLeft[i]) && Bricks[i].isHidden() == false){
                    Bricks[i].hide();
                    BrickBorderTop[i].hide();
                    BrickBorderRight[i].hide();
                    BrickBorderLeft[i].hide();
                    score++;
                    scoreLabel.setText("Score: "+ Integer.toString(score));
                    xSpeed = -7;
                }
                if(Ball.overlaps(Bricks[i]) && Bricks[i].isHidden() == false){
                   Bricks[i].hide();
                   ySpeed = 9;
                   score++;
                   scoreLabel.setText("Score: "+ Integer.toString(score));
                   BrickBorderTop[i].hide();
                   BrickBorderRight[i].hide();
                   BrickBorderLeft[i].hide();
                }
            }
            if(score == BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS){
                youWin.show();
                xSpeed = 0;
                ySpeed = 0;
                Ball.removeFromCanvas();
                Paddle.removeFromCanvas();
            }
        }

        if(turns == 0){
            gameOver.show();
            Ball.hide();
            Paddle.hide();
            for(int i = 0; i < BreakoutConstants.TOTAL_AMOUNT_OF_BRICKS; i++){
                Bricks[i].hide();
                BrickBorderTop[i].hide();
                BrickBorderRight[i].hide();
                BrickBorderLeft[i].hide();
            }
            gameOver.setFontSize(40);
            gameOver.setColor(Color.red);
        }

    }

}

