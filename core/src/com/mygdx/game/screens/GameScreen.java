package com.mygdx.game.screens;

import com.mygdx.game.controller.Controller;
import com.mygdx.game.model.Ball;
import com.mygdx.game.model.Shooter;
import com.mygdx.game.view.Renderer;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen, InputProcessor {

	private Ball 		ball;
	private Renderer 	renderer;
	private Controller	controller;
	private Shooter 	shooter;
	private int touchDownX, touchDraggedX;
	private boolean isTouchedDown;
	private int screenWidth, screenHeight;

	@Override
	public void show() {
		ball = new Ball();
		shooter = new Shooter();
		renderer = new Renderer(ball, shooter);
		controller = new Controller(ball);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		controller.update(delta);
		renderer.render();
	}
	
	@Override
	public void resize(int width, int height) {
		System.out.println("Screen width: " + width + " height: " + height);
		this.screenWidth = width;
		this.screenHeight = height;
		controller.setScreenSize(height, width);
		renderer.setScreenSize(height, width);
		shooter.setInitPosX(width);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	}

	// * InputProcessor methods ***************************//

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		//System.out.println(x + ", " + (screenHeight - y) + ", " + shooter.getPosX1() + ", " + shooter.getPosX2() + ", " + shooter.getPosY1() + ", " + shooter.getPosY2());
		if (x >= shooter.getPosX1() && x <= (shooter.getPosX2()) && (screenHeight - y) >= shooter.getPosY1() && (screenHeight - y) <= shooter.getPosY2() ) {
			touchDownX = x;
			isTouchedDown = true;
		}
		return true;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		isTouchedDown = false;
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		if(isTouchedDown) {
			//System.out.println(x + ", " + touchDownX);
			shooter.movePosX(x - touchDownX);
			touchDownX = x;
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
