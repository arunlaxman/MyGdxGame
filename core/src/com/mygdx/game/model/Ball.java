package com.mygdx.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball {

    Vector2 position = new Vector2();
    //Vector2 acceleration = new Vector2();
    Vector2 velocity = new Vector2();
    Rectangle bounds = new Rectangle();

    public Ball() {
        position = new Vector2(0, 0);
        velocity = new Vector2(10, 10);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void revertHorizontally() {
        velocity.scl(new Vector2(-1, 1));
    }

    public void revertVertically() {
        velocity.scl(new Vector2(1, -1));
    }

    public void update() {
        position.add(velocity);
    }
}
