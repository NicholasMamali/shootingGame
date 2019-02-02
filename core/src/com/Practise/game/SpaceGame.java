package com.Practise.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.MainMenuScreen;

public class SpaceGame extends Game {
	public SpriteBatch batch;
    public static final int WIDTH=990;
    public static final int HEIGH=590;
  //Gdx.graphics.setDisplayMode(990, 590, false);
    
    
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));

	}

	@Override
	public void render () {
		super.render();

	}
}
