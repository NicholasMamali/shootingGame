package Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{
	
	public Player(MainGameScreen game, Vector2 position, int width, int height, float speed) {
		
		super(game,position, width, height, speed);
	}

	@Override
	public void update(float delta) {
		
		dx = 0;
		dy = 0;

		// move
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			dy = speed * delta;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			dy = -speed * delta;
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			dx = -speed * delta;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			dx = speed * delta;
		}
	}
	
}

	
	