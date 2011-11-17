package com.netlinks.javapuzzle;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Puzzle implements ApplicationListener {
	SpriteBatch spriteBatch;
	Texture texture;
	Texture backgound;
	Texture frame1;
	BitmapFont font;
	Puzzeled puzzs;
	MouseState oldState;
	Sprite sprite;
	

	@Override
	public void create() {
		
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.scale(2);
		texture = new Texture(Gdx.files.internal("data/img1.jpg"));
		backgound= new Texture(Gdx.files.internal("data/bg1.jpg"));
		frame1= new Texture(Gdx.files.internal("data/Netlinks4.png"));
		spriteBatch = new SpriteBatch();
		puzzs = new Puzzeled(texture,	10,500,4,4,0.5f,0.5f,10);
		oldState =new MouseState();
		sprite = new Sprite(texture,(int)(texture.getWidth()*0.85f),(int)(texture.getHeight()*0.85f));
		sprite.setColor(Color.BLACK);
		sprite.setPosition(500, 15);
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	public void update(){
		if(Gdx.input.isTouched()&& !oldState.getIsPressed()){
			
			if(puzzs.hitTest(new Point(Gdx.input.getX(),700- Gdx.input.getY()))){
				puzzs.startDrag(0.85f);
			}
		}
		
		if(!Gdx.input.isTouched()&& oldState.getIsPressed()){
			if(puzzs.isDragging()){
			puzzs.stopDrag(sprite.getX(),sprite.getY(),0.85f);
			}
		}
		
		oldState.setIsPressed(Gdx.input.isTouched());
	}
	
	@Override
	public void render() {
		update();
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		spriteBatch.setColor(Color.WHITE);
		
		//spriteBatch.draw(texture, 0, 0, 100,100, 0, 0, 100, 100, false, false); 
		spriteBatch.draw(backgound,0,0,1300,700);
		sprite.draw(spriteBatch);
		//spriteBatch.draw(texture,0,0,texture.getWidth()*0.85f,texture.getHeight()*0.85f);
		puzzs.DrawPuzzs(spriteBatch);
		spriteBatch.draw(frame1,0,0,117,128);
		font.drawWrapped(spriteBatch,"Score: "+puzzs.getScore()+"", 150, 100, 400);
		spriteBatch.end();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
