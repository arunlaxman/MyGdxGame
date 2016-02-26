package com.mygdx.game.model;

public class Shooter {
    int posX1, posX2, posY1 = 100, posY2 = 200, shooterWidth = 200, screenWidth;

    public void setInitPosX(int screenWidth) {
        posX1 = (screenWidth / 2) - (shooterWidth / 2);
        posX2 = posX1 + shooterWidth;
        this.screenWidth = screenWidth;
    }

    public int getPosX1() {
        return posX1;
    }

    public int getPosX2() {
        return posX2;
    }

    public int getPosY1() {
        return posY1;
    }

    public int getPosY2() {
        return posY2;
    }

    public int getShooterWidth () {
        return shooterWidth;
    }

    public void movePosX(int delta) {
        if((posX1 + delta) >= 0 && (posX2 + delta) <= screenWidth) {
            posX1 += delta;
            posX2 += delta;
        }
    }
}
