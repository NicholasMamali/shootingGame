package com.Practise.game;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Asteroid {
	
	public static int SPEED =50;
	private static Texture texture ;
	public static int WIDTH=16;
	float x,y;
	public boolean remove=false;
	
	public Asteroid(float x)
 	{
       this.x=50;
       this.y=Gdx.graphics.getHeight();//starting at the to of the screen
       
       if(texture==null)
       {
    	   texture=new Texture("1.png");
       }

	}
	
	public void update(float deltaTime)
	{
		y-=SPEED*deltaTime;
		// 16 is the texture height 
		if(y<-16)
		{
			remove=true;
		}
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(texture,x,y,150,150);
	}
	
	
	
	

}
