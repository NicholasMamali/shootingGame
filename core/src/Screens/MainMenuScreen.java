package Screens;

import java.io.IOException;

import com.Practise.game.SpaceGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen{

	public SpaceGame game;
	
	private static final int EXIT_BUTTON_WIDTH = 200;
	private static final int EXIT_BUTTON_HEIGHT = 80;
	private static final int PLAY_BUTTON_WIDTH = 200;
	private static final int PLAY_BUTTON_HEIGHT = 80;
	private static final int EXIT_BUTTON_Y = 100;
	private static final int PLAY_BUTTON_Y = 230;
	private static final int LOGO_WIDTH = 400;
	private static final int LOGO_HEIGHT = 250;
	private static final int LOGO_Y = 450;
	
	
	Texture playButtonActive;
	Texture playButtonInactive;
	Texture exitButtonActive;
	Texture exitButtonInactive;
	Texture tetris;
    Texture	helpInactive;
    Texture helpActive;

	Texture logo;
	
	
	public MainMenuScreen(SpaceGame game)
	{
		this.game=game;
		playButtonActive = new Texture("play3active.png");
		playButtonInactive = new Texture("play3.png");
		exitButtonActive = new Texture("exit2active.png");
		exitButtonInactive = new Texture("exit2inactive.png");
		
		helpActive = new Texture("help.png");
		helpInactive = new Texture("helpinactive.png");
		
		// setting the background picture for Main menu
		tetris= new Texture("bg3.jpg");	
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin(); 
		game.batch.draw(tetris,0,0,SpaceGame.WIDTH,SpaceGame.HEIGH);

		
		//hover for exit button
		int x=SpaceGame.WIDTH/2-EXIT_BUTTON_WIDTH/2;
		//if (game.cam.getInputInGameWorld().x < x + EXIT_BUTTON_WIDTH && game.cam.getInputInGameWorld().x > x && SpaceGame.HEIGHT - game.cam.getInputInGameWorld().y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && SpaceGame.HEIGHT - game.cam.getInputInGameWorld().y > EXIT_BUTTON_Y)
		
		if(Gdx.input.getX()<x+EXIT_BUTTON_WIDTH  && Gdx.input.getX()>x  && SpaceGame.HEIGH-Gdx.input.getY()<EXIT_BUTTON_Y+EXIT_BUTTON_HEIGHT  && SpaceGame.HEIGH-Gdx.input.getY()>EXIT_BUTTON_Y ){
			//half of the screen-image width
			game.batch.draw(exitButtonActive ,x, 100,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT);
			
			if(Gdx.input.isTouched())
			{
				Gdx.app.exit();
			}
			
			
		}
		else{
			//half of the screen-image width
			game.batch.draw(exitButtonInactive ,x, 100,EXIT_BUTTON_WIDTH,EXIT_BUTTON_HEIGHT);
			
		}
		
		
		
		
		//hover for play button
		x=SpaceGame.WIDTH/2-PLAY_BUTTON_WIDTH/2;
		
		
		if(Gdx.input.getX()<x+PLAY_BUTTON_WIDTH  && Gdx.input.getX()>x  && SpaceGame.HEIGH-Gdx.input.getY()<PLAY_BUTTON_Y+PLAY_BUTTON_HEIGHT  && SpaceGame.HEIGH-Gdx.input.getY()>PLAY_BUTTON_Y ){
			//half of the screen-image width
			game.batch.draw(playButtonActive ,x,PLAY_BUTTON_Y,PLAY_BUTTON_WIDTH,PLAY_BUTTON_HEIGHT);
			
			
			if(Gdx.input.isTouched())
			{   this.dispose();  //dispose the current screen
				game.setScreen(new MainGameScreen());

			}
		}
		else{
			//half of the screen-image width
			game.batch.draw(playButtonInactive ,x, PLAY_BUTTON_Y,PLAY_BUTTON_WIDTH,PLAY_BUTTON_HEIGHT);
			
		}
		
		
		
		
		game.batch.end();		
		
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
		
		playButtonActive.dispose();
		playButtonInactive.dispose();
		exitButtonActive.dispose();
		exitButtonInactive.dispose();
		tetris.dispose();
	    helpInactive.dispose();
	    helpActive.dispose();

       		
		
		
		
		
		
		
	}

}
