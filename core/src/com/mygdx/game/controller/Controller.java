package com.mygdx.game.controller;

import com.mygdx.game.model.Ball;
import com.mygdx.game.model.Bricks;

public class Controller {
    Ball ball;
    int screenHeight, screenWidth, brickBlockY;
    boolean revertedHorizontal = false;

    public Controller(Ball ball) {
        this.ball = ball;
    }

    public void setScreenSize(int height, int width) {
        this.screenWidth = width;
        this.screenHeight = height;

        //the boundary where the brick blocks start
        this.brickBlockY = height - (int)(Bricks.pattern.length * Bricks.height);
    }

    public void update(float delta) {
        //System.out.println("X : " + ball.getPosition().x + " w : " + screenWidth + " Y : " + ball.getPosition().y + " h : " + screenHeight);
        ball.update();

        float ballX = ball.getPosition().x, ballY = ball.getPosition().y;

        if(ballX >= (screenWidth - 20) || ballX <= 0) {
            revertedHorizontal = true;
            ball.revertHorizontally();
            //System.out.println("Going backward...");
        }

        if(ballY >= (screenHeight - 20) || ballY <= 0) {
            revertedHorizontal = false;
            ball.revertVertically();
            //System.out.println("Going down...");
        }

        if(ballY >= brickBlockY) {
            int i = (int) ((screenHeight - ballY) / Bricks.height);
            int j = (int) (ballX / Bricks.width);
            if(Bricks.pattern[i][j] == 1) {
                //System.out.println("Broke brick at " + i + ", " + j + ". RevertedHorizontal: " + revertedHorizontal);
                Bricks.pattern[i][j] = 0;
                if(revertedHorizontal) {
                    revertedHorizontal = false;
                    ball.revertHorizontally();
                } else {
                    revertedHorizontal = true;
                    ball.revertVertically();
                }
            }
            //System.out.println("Current Block : " + i + ", " + j);
        }

    }
}
