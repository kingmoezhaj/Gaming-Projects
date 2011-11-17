package com.netlinks.javapuzzle;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Piece extends Point {

	int srcX;
	int srcY;
	float width;
	float height;
	int srcWidth;
	int srcHeight;

	public Piece(float x, float y, int srcX, int srcY, float width, float height,
			int srcWidth, int srcHeight) {
		super(x, y);
		this.srcWidth = srcWidth;
		this.srcHeight = srcHeight;
		this.srcX = srcX;
		this.srcY = srcY;
		this.width = width;
		this.height = height;

	}

	//this function is not complete ==> to be done by abdelhay
	/*
	public boolean hitTest(Point point){
		return true;
	}*/

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getsrcWidth() {
		return srcWidth;
	}

	public void setsrcWidth(int srcWidth) {
		this.srcWidth = srcWidth;
	}

	public float getsrcHeight() {
		return srcHeight;
	}

	public void setsrcHeight(int srcHeight) {
		this.srcHeight = srcHeight;
	}

	public void Draw(SpriteBatch spriteBatch, Texture texture) {
		spriteBatch.draw(texture, x, y, width , height , srcX,
				srcY,srcWidth, srcHeight, false, false);

	}

}
