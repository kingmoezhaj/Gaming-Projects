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
	BitmapFont font;
	Puzzeled puzzs;

	@Override
	public void create() {
		font = new BitmapFont();
		font.setColor(Color.RED);
		texture = new Texture(Gdx.files.internal("data/img1.jpg"));
		spriteBatch = new SpriteBatch();
		puzzs = new Puzzeled(texture,	0,600,4,4,0.5f,0.5f,10);
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render() {
		
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		spriteBatch.setColor(Color.WHITE);
		puzzs.DrawPuzzs(spriteBatch);
		//spriteBatch.draw(texture, 0, 0, 100,100, 0, 0, 100, 100, false, false); 
		//draw(Texture texture, float x, float y, float width, float height, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY) 
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
