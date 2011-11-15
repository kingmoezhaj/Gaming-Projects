package com.netlinks.javapuzzle;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Puzzle implements ApplicationListener {
	SpriteBatch spriteBatch;
	Texture texture;
	Texture backgound;
	Texture frame1;
	BitmapFont font;
	Puzzeled puzzs;

	@Override
	public void create() {
		font = new BitmapFont();
		font.setColor(Color.RED);
		texture = new Texture(Gdx.files.internal("data/img1.jpg"));
		backgound= new Texture(Gdx.files.internal("data/bg1.jpg"));
		frame1= new Texture(Gdx.files.internal("data/frame1.png"));
		spriteBatch = new SpriteBatch();
		puzzs = new Puzzeled(texture,	100,500,4,4,0.5f,0.5f,10);
		
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
		
	}
	
	@Override
	public void render() {
		
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		spriteBatch.setColor(Color.WHITE);
		
		//spriteBatch.draw(texture, 0, 0, 100,100, 0, 0, 100, 100, false, false); 
		spriteBatch.draw(backgound,0,0,1300,700);
		
		puzzs.DrawPuzzs(spriteBatch);
		//spriteBatch.draw(frame1,0,50,550,700);
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
