package Screens;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
	
	public Vector2 bulletLocation=new Vector2(0,0);
	public Vector2 bulletVelocity=new Vector2(0,0);
	MainGameScreen t;
	
	public Bullet(Vector2 bulletlocation,Vector2 bulletspeed)
	{
		this.bulletLocation=new Vector2(bulletlocation.x,bulletlocation.y);
		this.bulletVelocity=new Vector2(bulletspeed.x,bulletspeed.y);
	}
	
	public void update()
	{
		bulletLocation.x+=bulletVelocity.x;
		bulletLocation.y+=bulletVelocity.y;
	}
	
	

}
