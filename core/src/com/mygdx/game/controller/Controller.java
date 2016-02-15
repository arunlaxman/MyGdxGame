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

        if(ball.getPosition().x >= (width - 50)) {
            ball.goBackward();
            //System.out.println("Going backward...");
        } else if(ball.getPosition().x <= 0) {
            ball.goForward();
            //System.out.println("Going forward...");
        }

        if(ball.getPosition().y >= (height - 50)) {
            ball.goDown();
            //System.out.println("Going down...");
        } else if(ball.getPosition().y <= 0) {
            ball.goUp();
            //System.out.println("Going up...");
        }
    }
}
