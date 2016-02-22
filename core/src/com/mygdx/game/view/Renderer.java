package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Ball;
import com.mygdx.game.model.Bricks;

public class Renderer {
    Ball ball;
    SpriteBatch batch;
    BitmapFont font;
    Texture imgBall, imgBrick;
    int screenHeight, screenWidth;

    public Renderer(Ball ball) {
        this.ball = ball;
        batch = new SpriteBatch();
        imgBall = new Texture("orange-ball.png");
        imgBrick = new Texture("rect.png");
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
    }

    public void setScreenSize(int height, int width) {
        this.screenWidth = width;
        this.screenHeight = height;
    }

    public void render() {
        batch.begin();
        for(int i = 0 ; i < Bricks.pattern.length ; ++i)
            for(int j = 0 ; j < Bricks.pattern[i].length ; ++j) {
                if(Bricks.pattern[i][j] == 1) {
                    batch.draw(imgBrick, ((j * 72)), (screenHeight - (i * 30)));
                }
            }
        batch.draw(imgBall, ball.getPosition().x, ball.getPosition().y);
        //font.draw(batch, "Height: " + Gdx.graphics.getHeight(), 300, 300);
        //font.draw(batch, "Width: " + Gdx.graphics.getWidth(), 350, 350);
        batch.end();
    }
}
