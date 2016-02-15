package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Ball;

public class Renderer {
    Ball ball;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;

    public Renderer(Ball ball) {
        this.ball = ball;
        batch = new SpriteBatch();
        img = new Texture("orange-ball.png");
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
    }

    public void render() {
        batch.begin();
        batch.draw(img, ball.getPosition().x, ball.getPosition().y);
        //font.draw(batch, "Height: " + Gdx.graphics.getHeight(), 300, 300);
        //font.draw(batch, "Width: " + Gdx.graphics.getWidth(), 350, 350);
        batch.end();
    }
}
