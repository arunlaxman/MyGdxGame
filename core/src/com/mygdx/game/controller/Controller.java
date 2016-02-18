package com.mygdx.game.controller;

import com.mygdx.game.model.Ball;

public class Controller {
    Ball ball;
    int height, width;

    public Controller(Ball ball, int width, int height) {
        this.ball = ball;
        this.width = width;
        this.height = height;
    }

    public void setSize(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void update(float delta) {
        //System.out.println("X : " + ball.getPosition().x + " w : " + width + " Y : " + ball.getPosition().y + " h : " + height);
        ball.update();

        float ballX = ball.getPosition().x, ballY = ball.getPosition().y;

        if(ballX >= (width - 10) || ballX <= 0) {
            ball.revertHorizontally();
            //System.out.println("Going backward...");
        }

        if(ballY >= (height - 10) || ballY <= 0) {
            ball.revertVertically();
            //System.out.println("Going down...");
        }
    }
}
