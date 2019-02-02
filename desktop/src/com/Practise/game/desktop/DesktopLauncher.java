package com.Practise.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.Practise.game.SpaceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.height=SpaceGame.HEIGH;
		config.width= SpaceGame.WIDTH;
		config.resizable=false;
		config.title="SHOOTING";
		
		new LwjglApplication(new SpaceGame(), config);
	}
}
