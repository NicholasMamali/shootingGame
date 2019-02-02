package Screens;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

import Screens.MainGameScreen.Direction;

public class Entity implements Serializable{
	public MainGameScreen game;
	public float x;
	public float y;
	public float dx;
	public float dy;
	public int width;
	public int height;  
	public float speed;
	
    

	public Entity(MainGameScreen game, Vector2 position, int width, int height, float speed) {
		this.game = game;
		this.x = position.x;
		this.y = position.y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	
	
	
	
	
	
	
	
	
  public void setTexture(Texture t)
  {
	  
  }
	
	

	public void update(float delta) {

	}
	
	public void move(float newX, float newY) {
		x = newX;
		y = newY;		
	}
	
	public void render() {
		
	}

	public void tileCollision(int tile, int tileX, int tileY, float newX, float newY, Direction direction) {
		System.out.println("tile collision at: " + tileX + " " + tileY);
		
		if(direction == Direction.U) {
			y = tileY * game.tileSize + game.tileSize;
		}
		else if(direction == Direction.D) {
			y = tileY * game.tileSize - height;
		}
		else if(direction == Direction.L) {
			x = tileX * game.tileSize + game.tileSize;
		}
		else if(direction == Direction.R) {
			x = tileX * game.tileSize - width;
		}		
	}

	public void entityCollision(Entity e2, float newX, float newY, Direction direction) {
		//System.out.println("entity collision around: " + newX + " " + newY);
		
		//move(newX, newY);
		
		
			
	}














	@Override
	public void write(Json json) {
		// TODO Auto-generated method stub
		
	}














	@Override
	public void read(Json json, JsonValue jsonData) {
		// TODO Auto-generated method stub
		
	}
}
