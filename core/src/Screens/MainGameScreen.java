package Screens;

import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.Practise.game.Asteroid;
import com.Practise.game.SpaceGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGameScreen implements Screen{

	
	private State state = State.RUN;

	float helth=1;
	public SpriteBatch batch;
	int screenWidth;
	int screenHeight;
	int nextlevel=0;
    //ArrayList<Collidable> b=new ArrayList();
	int tileSize = 20;
	Texture tileTexture;
	
	Vector2 player1;
	Vector2 enemy1;
	Vector2 enemy2;
	Vector2 enemy3;
	Vector2 enemy4,enemy5;
	int b=0;
	
	public static int WIDTH1=20;
	public static int HEIGHT1=20;
	public static float SPEED=120.0f;

	 PrintWriter writer;
	
	
	ArrayList<Entity> entities = new ArrayList<Entity>();
	ArrayList<Texture> texture = new ArrayList<Texture>();

	
	enum Axis { X, Y };
	enum Direction { U, D, L, R };
	Player player;
	Texture mario;

	
  Stage stage;
  Label label;
  Label label5;

  Label label2;
  Label label3,label4;

  LabelStyle style;
  BitmapFont font;
  int score=0;
  int health=5;
  int level=0;
  
	int mapWidth = 31;
	int mapHeight = 22;
  int map [][] = new int[31][22];
  
  Circle bounda,boundb,bulet2,loverec;
  Texture t1,t2,t4,t3,blank;

  
  public ArrayList<Bullet> bulletmanager=new ArrayList<Bullet>();
  Texture bulet,bulet6;
  
  Texture bg,bulet3,life;
  Bullet bullet;
  
  Rectangle pbound,ebound;
  String move="";
  float ai=1.5f;
  Texture r=new Texture("main33.png");

  int check=0;
  boolean change=false;
  int g=1000;
 Sound sound;
	
public MainGameScreen()
	{   
		
	    
		  batch = new SpriteBatch();
		  blank=new Texture("blank.png");

		 
	}
	
	
public void backgroundtMusic()
{
	  		sound = Gdx.audio.newSound(Gdx.files.internal("background.mp3"));

	  		sound.play(1.0f);
	  		
	  		long id = sound.play(1.0f); 
	  		sound.setPitch(id, 2);     
	  		id = sound.play(1.0f); 
	  		sound.setPan(id, -1, 1); 
	  		sound.setLooping(id, true);
	  		sound.stop(id);   
	  }
	 
public void bulletMusic()
{
		sound = Gdx.audio.newSound(Gdx.files.internal("sound.wav"));

		sound.play(1.0f);
		
		long id = sound.play(1.0f); 
		sound.setPitch(id, 2);     
		id = sound.play(1.0f); 
		sound.setPan(id, -1, 1); 
		sound.setLooping(id, true);
		sound.stop(id);   
}

public void painMusic()
{
		sound = Gdx.audio.newSound(Gdx.files.internal("pain.wav"));

		sound.play(1.0f);
		
		long id = sound.play(1.0f); 
		sound.stop(id);             
		sound.setPitch(id, 2);     

		id = sound.play(1.0f);     
		sound.setPan(id, -1, 1);    
		sound.setLooping(id, true); 
		sound.stop(id);
}

   ArrayList<Bullet> bul=new ArrayList<Bullet>();
  
public void test2()
    {   
    	
    	

 	    
 	    
 	  /* 
 	    
  	    //if the AI collides with another enemy
  	    if(c1.overlaps(boundb) && check!=160)
  	    {
  	    	System.out.println("Collided");
  	    	
  	    	
  	    	Random rand = new Random();

  	    	int  n = rand.nextInt(590) + 1;
  	    	int  n2 = rand.nextInt(400) + 1;

  	    	
  	    	entities.get(0).x=n;
  	    	entities.get(0).y=n2;
  	    	check=0;
  	    }*/
  	        	
    	
    	if(check==160){
    		
    		
    	Random rand = new Random();

    	int  n = rand.nextInt(590) + 1;
    	int  n2 = rand.nextInt(400) + 1;

    	
    	entities.get(2).x=n;
    	entities.get(2).y=n2;
   		int a1=(int) entities.get(2).x;
   		int b1=(int) entities.get(2).y;
   		Bullet mybullet1=new Bullet(new Vector2(a1,b1),new Vector2(0,-5));
   		Bullet mybullet2=new Bullet(new Vector2(a1,b1),new Vector2(0,5));
   		
   		Bullet mybullet3=new Bullet(new Vector2(a1,b1),new Vector2(5,0));
   		Bullet mybullet4=new Bullet(new Vector2(a1,b1),new Vector2(-5,0));

   		
   		
   		
		bul.add(mybullet1);
		bul.add(mybullet2);
		bul.add(mybullet3);
		bul.add(mybullet4);



		check=0;
    	}
    }
  
 int j=3;  
public void update(float delta)
	{  	
		
		int h=Gdx.graphics.getHeight();
		int w=Gdx.graphics.getWidth();
		
		  pbound.set(entities.get(0).x,entities.get(0).y,30,30);
		  ebound.set(entities.get(1).x,entities.get(1).y,30,30);
		
		  bounda.set(entities.get(0).x, entities.get(0).y, 15);
		  boundb.set(entities.get(1).x, entities.get(1).y, 15);
		
		
		
		
	 	if(Gdx.input.isKeyPressed(Keys.RIGHT))
	 	{ 
	 		if(entities.get(0).x<w-50)
	 			entities.get(0).x+=j;
	 	}
	 	
	 	
		
	 	if(Gdx.input.isKeyPressed(Keys.LEFT))
	 	{    move="l";
  
	 		if(entities.get(0).x>0)
	 		entities.get(0).x-=j;
	 	}
		
	 	if(Gdx.input.isKeyPressed(Keys.UP))
	 	{   
	 		if(entities.get(0).y<h-120)
	 		{
	 			entities.get(0).y+=j;
	 		}
	 	}
	 	
		
	 	if(Gdx.input.isKeyPressed(Keys.DOWN))
	 	{  if(entities.get(0).y>0)
	 			entities.get(0).y-=j;
	 	}
		
		
		
	   	if(Gdx.input.isKeyJustPressed(Keys.W))
    	{
            this.bulletMusic();
	   		b=20;
	   		int a=(int) entities.get(0).x;
	   		int b=(int) entities.get(0).y;
	   		Bullet mybullet=new Bullet(new Vector2(a,b),new Vector2(0,20));
    		bulletmanager.add(mybullet);
    	}
	   	
	   	
		
	   	if(Gdx.input.isKeyJustPressed(Keys.S))
    	{   
            this.bulletMusic();

	   		int a=(int) entities.get(0).x;
	   		int b=(int) entities.get(0).y;
	   		Bullet mybullet=new Bullet(new Vector2(a,b),new Vector2(0,-20));
    		bulletmanager.add(mybullet);
    		b=0;
    	}
	   	
	   	
	   	
	   	if(Gdx.input.isKeyJustPressed(Keys.A))
    	{
            this.bulletMusic();

	   		int a=(int) entities.get(0).x;
	   		int b=(int) entities.get(0).y;
	   		Bullet mybullet=new Bullet(new Vector2(a,b),new Vector2(-20,0));
    		bulletmanager.add(mybullet);
    		b=0;
    	}
	   	
	   	
	   	if(Gdx.input.isKeyJustPressed(Keys.D))
    	{
    		
            this.bulletMusic();

	   		int a=(int) entities.get(0).x;
	   		int b=(int) entities.get(0).y;
	   		Bullet mybullet=new Bullet(new Vector2(a,b),new Vector2(20,0));
    		bulletmanager.add(mybullet);
    		b=0;
    	}
		
		
		
		
	      //label=new Label("LEVEL  "+level+"  of  3",style);

	    label.setText("LEVEL  "+level+"  of  2");

		
		label3.setText("SCORE         "+score);

	      stage.addActor(label);
	      //stage.addActor(label2);

	      stage.addActor(label3);
	      
	    //my AI code  
	      

		
	}
  
boolean condition=true;
Texture bos=new Texture("boss.png");

int check2=0;
ArrayList<Bullet> bul2=new ArrayList<Bullet>();
public void ai()
{
 
	
if(condition)
{
	
	if(entities.get(0).x> entities.get(1).x)
	{
		entities.get(1).x+=ai;
	}
	else{
		entities.get(1).x-=ai;
	}
	
	
	if(entities.get(0).y>entities.get(1).y)
	{
		entities.get(1).y+=ai;
	}
	else{
		entities.get(1).y-=ai;
	}
	check2=0;

}

else{
	
	
	
	if(entities.get(0).x> entities.get(5).x)
	{
		entities.get(5).x+=ai;
	}
	else{
		entities.get(5).x-=ai;
	}
	
	
	if(entities.get(0).y>entities.get(5).y)
	{
		entities.get(5).y+=ai;
	}
	else{
		entities.get(5).y-=ai;
	}
	
		
		

	System.out.println(check2);
	
	if(check2==200){
	
		int a1=(int) entities.get(5).x;
		int b1=(int) entities.get(5).y;
		
		
		
		Bullet mybullet1=new Bullet(new Vector2(a1,b1),new Vector2(0,-9));
		Bullet mybullet2=new Bullet(new Vector2(a1,b1),new Vector2(0,9));
		
		Bullet mybullet3=new Bullet(new Vector2(a1,b1),new Vector2(9,0));
		Bullet mybullet4=new Bullet(new Vector2(a1,b1),new Vector2(-9,0));

		
		
		
	bul2.add(mybullet1);
	bul2.add(mybullet2);
	bul2.add(mybullet3);
	bul2.add(mybullet4);
	
	check2=0;

	}
	
   }

}
  
 public void dispose()
  {  
	  
	  
	  
	  
		
	    
		String FILENAME = "player.txt";
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content1 = ""+(int) player.x+"\n";
	        String content2=""+(int) player.y;;

			
			
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content1);
			bw.write(content2);

			System.out.println("Done");

		}
		catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	  
  } 
   

	@Override
public void resize(int width, int height) {
		
	}

	
	@Override
public void hide() {
		
	}

	
	

	
@Override
public void show() {
		
	   //loverec=new Circle(100,100,15);

		this.backgroundtMusic();
		  bulet=new Texture("f4.png");
	

		  
			for (int y=0; y<22;y++){
				for (int x =0;x<31;x++){
					
					map[x][y]=0;
				}
				
			}

		  
		  level=1;
		  health=8;
		  batch = new SpriteBatch();
		  
		  //batch=game.batch;
		  tileTexture = new Texture("block.png");  
		  stage=new Stage();
		  font=new BitmapFont(false);
		  style=new LabelStyle(font,Color.WHITE);
	      label=new Label("LEVEL  "+level+"  of  2",style);
	      
	      label5=new Label("Health",style);

	      
	      label2=new Label("HEALTH  "+health,style);
	      
	      label4=new Label("HEALTH",style);

	      label3=new Label("SCORE"+score,style);

	      label.setPosition(50, 550);
	      label2.setPosition(200, 550);
	      
	      label5.setPosition(400, 520);
	      
	      stage.addActor(label5);

	      label3.setPosition(350, 550);

	      
	      //Gdx.graphics.setTitle("Shooting Game");
	    //Gdx.graphics.setDisplayMode(990, 590, false);



		  player1=new Vector2(100,150);
		  enemy1=new Vector2(50,150);
		  enemy2=new Vector2(100,200);
		  enemy3=new Vector2(400,20);
		  enemy4=new Vector2(400,200);
		  
		  enemy5=new Vector2(600,100);

		  


		  
		  File f = new File("player.txt");
		  
		  if(!f.exists()) { 
			  try {
					writer = new PrintWriter("player.txt", "UTF-8");
				} catch (FileNotFoundException | UnsupportedEncodingException e) {
					e.printStackTrace();
				} 
			  
			  System.out.println("FILE DOES NOT EXIST");
			  
			}
		  
		  else{

			  try {
					File file = new File("player.txt");
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					StringBuffer stringBuffer = new StringBuffer();
					String line;
					String p1=null;
					int i=0;
					while ((line = bufferedReader.readLine()) != null) {
						
						System.out.println(line);
						
						if(i==0)
						{
							p1=line.substring(0,line.length());
						    player1.x=Integer.parseInt(p1);
						    i++;
						}
						else{
							p1=line.substring(0,line.length());
						    player1.y=Integer.parseInt(p1);
							
						}
						
					}
					fileReader.close();
					
					
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			  
			  
			  
			  
			  Texture life=new Texture("heart.png");


			  //player1=new Vector2(100,150);

			  player=new Player(this, player1, WIDTH1,HEIGHT1, SPEED);
	        
		  	  System.out.println("FILE EXISTS");
		  }


		 
		  player=new Player(this, player1, WIDTH1,HEIGHT1, SPEED);

		  entities.add(player);
		  entities.add(new Entity(this,enemy1, WIDTH1,HEIGHT1, SPEED));
		  entities.add(new Entity(this, enemy2, WIDTH1, HEIGHT1,SPEED));
		  entities.add(new Entity(this, enemy3, WIDTH1, HEIGHT1, SPEED));
		  entities.add(new Entity(this, enemy4, WIDTH1, HEIGHT1, SPEED));
		  entities.add(new Entity(this, enemy5, WIDTH1, HEIGHT1, SPEED));

		   life=new Texture("heart.png");

		  
		  
		  pbound=new Rectangle(entities.get(0).x,entities.get(0).y,30,30);
		  ebound=new Rectangle(entities.get(1).x,entities.get(1).y,30,30);
		  
		  bounda=new Circle(entities.get(0).x, entities.get(0).y, 35);
		  boundb=new Circle(entities.get(1).x, entities.get(1).y, 35);
		  bulet2=new Circle(entities.get(2).x, entities.get(2).y, 35);


		  
		  t1=new Texture("enemy2.png");
		  t2=new Texture("e_f4.png");
		  t3=new Texture("e_f4.png");
		  t4=new Texture("obstacles.png");
		  
		  texture.add(t1);
		  texture.add(t2);
		  texture.add(t3);
		  texture.add(t4);

		 
		  bg=new Texture("marry4.jpg");
		  //bulet3=new Texture("f4.png"); // player bullet
		  
		  bulet3=new Texture("ex.png"); // player bullet

		  
	
	}
	
	
public enum State
{
	    PAUSE,
	    RUN,
	    RESUME,
	    STOPPED
}

@Override
public void pause()
{
    this.state = State.PAUSE;
}

@Override
public void resume()
{
    this.state = State.RESUME;
}


public void setGameState(State s){
    this.state = s;
}

	
	
	
Texture tx=new Texture("levelcomplete.png");

int seconds=400;
int healthcounter=0;
int lost=100;

 int xc = 0;
 int yc = 100;
 int checkx=10000000;
 int checky=100;

int control=100000;
@Override
public void render(float delt) {
	
	  
	
	
	  check2++;
	   check++;

	   this.ai();
	   

	   healthcounter++;

	   batch.begin();
      
	   
	   
	   


	    loverec=new Circle(lost,yc,25);
	    Circle c1=new Circle((int) entities.get(2).x, (int) entities.get(2).y, 30);
	    Circle c12=new Circle((int) entities.get(5).x, (int) entities.get(5).y, 30);

		   
		   if(loverec.overlaps(boundb))
		   {
			   
			   lost=100000000;
			   checkx=10030;
			   
			   
			   
		   }
		   
		   if(loverec.overlaps(c12))
		   {
			   
			   lost=100000000;
			   checkx=10030;
			   
			   
			   
		   }
		   
		   
	    
		   if(c12.overlaps(bounda))
	 	    {
	 	    	
	 	    	
	 	    	
	 	    	Random rand = new Random();

	 	    	int  n = rand.nextInt(590) + 1;
	 	    	int  n2 = rand.nextInt(400) + 1;

	 	    	
	 	    	entities.get(0).x=n;
	 	    	entities.get(0).y=n2;
	 	    	helth-=0.1f;
	 	    }
	    
	    
	    //if the AI collides with the player 
	   if(c1.overlaps(bounda))
 	    {
 	    	System.out.println("Collided");
 	    	
 	    	
 	    	Random rand = new Random();

 	    	int  n = rand.nextInt(590) + 1;
 	    	int  n2 = rand.nextInt(400) + 1;

 	    	
 	    	entities.get(2).x=n;
 	    	entities.get(2).y=n2;
 	    	helth-=0.1f;
 	    }
	   
	   //collission between ai and another enemy
	   if(c1.overlaps(boundb))
	    {
	    	System.out.println("Collided");
	    	
	    	
	    	Random rand = new Random();

	    	int  n = rand.nextInt(590) + 1;
	    	int  n2 = rand.nextInt(400) + 1;

	    	
	    	entities.get(2).x=n;
	    	entities.get(2).y=n2;
	    }
	   
	   


	  //collission between AI and the layer
	  if(bounda.overlaps(boundb))
	  {   
		  
		   helth-=0.1f;
		    Random rand=new Random();
	    	int  n = rand.nextInt(590) + 1;
	    	int  n2 = rand.nextInt(400) + 1;
	    	
	    	entities.get(0).x=n;
	    	entities.get(0).y=n2;
            health--;
			
		    this.painMusic();
			
			
			
			

	  }
	  
	  float delta = Gdx.graphics.getDeltaTime();
	  update(delta);
	  // update all entities
	  for(int i = entities.size() - 1; i >= 0; i--) {
		  Entity e = entities.get(i);
		  e.update(delta);
		  //moveEntity(e, e.x + e.dx, e.y + e.dy);
	  }	  
	  
	  
	  
	  Gdx.gl.glClearColor(0, 0, 0, 1);
	  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	  batch.draw(bg,0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

	   if(nextlevel==100)
	   {   
		   
		   level++;
		   
		   
		   bg=new Texture("level2.jpg");
		   t1=new Texture("enemy2.png");
		   t2=new Texture("f6.png");
		   t3=new Texture("f6.png");
			g=5;
			j+=2;
		   
			  
		  batch.draw(tx, entities.get(3).x+g, entities.get(4).y+g);
		  try {
			TimeUnit.SECONDS.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				   
		   ai++;
		   //score=0;
		   nextlevel=0;
		   
		   
	   }
	  
	  
	  
	  
	
      
	   
	  if(healthcounter==2000)
	   {
		  healthcounter=0;
		  checkx=0;
		    Random rand=new Random();
	    	yc = rand.nextInt(400) + 1;
	    	lost = rand.nextInt(400) + 1;
		  
		 // lost=100;
	   }
	   
	   
	  batch.draw(t1, entities.get(0).x, entities.get(0).y,40,40);
	  batch.draw(t2, entities.get(1).x, entities.get(1).y,40,40);
	  batch.draw(t3, entities.get(2).x, entities.get(2).y,40,40);
	  batch.draw(bos, entities.get(5).x+control, entities.get(5).y,40,40);
	  

  	
	   batch.draw(life,lost,yc+checkx,30,30);

	   

	   
	   if(loverec.overlaps(bounda))
	   {
		   helth=1f;
		   lost=100000000;
		   checkx=10030;
		   
		   
		   
	   }   
	  
	  

	  
	  
	  
	  
	  
	  
	  
	  
	  


	  

	  
	  
		for(int i=0;i<bulletmanager.size();i++)
		{
			Bullet current=bulletmanager.get(i);
			current.update();
			float temp=current.bulletLocation.x;
			Circle c=new Circle(current.bulletLocation.x,current.bulletLocation.y,20);
			
			// collision between the AI and player's bullet
			if(c.overlaps(boundb))
			{   //bulet3=new Texture("explo.png");

				score++;
				nextlevel++;
				bulletmanager.remove(current);
				
			}
			
			// collision between the AI and player's bullet
			if(c.overlaps(c12))
			{   //bulet3=new Texture("explo.png");

				score++;
				nextlevel++;
				bulletmanager.remove(current);
				
			}
			
			
			
			
			// Random AI
	 	    Circle c2=new Circle((int) entities.get(2).x, (int) entities.get(2).y, 30);

			if(c.overlaps(c2))
			{
				bulletmanager.remove(current);

			}
			
			
			batch.draw(bulet3,current.bulletLocation.x-b,current.bulletLocation.y,80,80);

		}
		
		test2();
		for(int i=0;i<bul.size();i++)
		{
			Bullet current=bul.get(i);
			current.update();
			
			Circle c=new Circle(current.bulletLocation.x,current.bulletLocation.y,5);
			
			// if the player collides with the bullet
			if(c.overlaps(bounda))
			{   
				health--;
				bul.remove(current);
				this.painMusic(); //calling the music method
				t1=new Texture("frame-1.png");
				change=true;
				helth-=0.1f;
				
			}
			else if(change){
				t1=new Texture("enemy2.png");
            change=false;
			}
			
			
	
			
			batch.draw(bulet,current.bulletLocation.x,current.bulletLocation.y);

		}
		
		
		
		
		
		
		
		
		
		for(int i=0;i<bul2.size();i++)
		{
			Bullet current=bul2.get(i);
			current.update();
			
			Circle c=new Circle(current.bulletLocation.x,current.bulletLocation.y,5);
			
			// if the player collides with the bullet
			if(c.overlaps(bounda))
			{   
				bul2.remove(current);
				this.painMusic(); //calling the music method
				//t1=new Texture("frame-1.png");
				change=true;
				helth-=0.1f;
				
			}
			else if(change){
				//t1=new Texture("enemy2.png");
            //change=false;
			}
			
			
	
			
			batch.draw(bulet,current.bulletLocation.x,current.bulletLocation.y);

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		if(helth<=0)
		{
			//bg=new Texture("gameover.png");
			//Texture r=new Texture("main33.png");

			//Texture r=new Texture("mbiso.png");

			batch.draw(r,0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			
			//batch.draw(r,350, 150,200,100);

			label3.setText("");
			label2.setText("");
			label.setText("");
			nextlevel=0;
			sound.dispose();
			
			


			
			
		}
		
		
		if(Gdx.input.isKeyPressed(Keys.R))
		{
			helth=1;
			health=8;
			score=0;

            
			//r.dispose();
			


			
			
		}
		
		
		
		
		if(helth >0.6f)
			batch.setColor(Color.GREEN);
		else if(helth > 0.2f)
			batch.setColor(Color.ORANGE);
		else
			batch.setColor(Color.RED);
		
		batch.draw(blank, 0, 510, Gdx.graphics.getWidth()*helth, 35);  
		batch.setColor(Color.WHITE);

		
		
		//winnning condition
		if (score>=100)
		{
			
			


		}
		
		if(score>=150)
		{
			entities.get(1).x=100000;
			control=0;
			condition=false;

		}
		
		if(score>200)
		{
			label5.setText("");
			label.setText("");

			label3.setText("");
			label4.setText("");

			label2.setText("");

			batch.draw(new Texture("wiiner.jpg"),0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			sound.dispose();
		}
	  batch.end();
	  stage.draw();

		
		
		
		
		
		
		
		
		
		
		
		
	}


	

}
