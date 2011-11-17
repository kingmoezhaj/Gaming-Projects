package com.netlinks.javapuzzle;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Piece extends Point {

	int srcX;
	int srcY;
	int width;
	int height;
	float xScale;
	float yScale;

	public Piece(float x, float y, int srcX, int srcY, int width, int height,
			float xScale, float yScale) {
		super(x, y);
		this.xScale = xScale;
		this.yScale = yScale;
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getxScale() {
		return xScale;
	}

	public void setxScale(float xScale) {
		this.xScale = xScale;
	}

	public float getyScale() {
		return yScale;
	}

	public void setyScale(float yScale) {
		this.yScale = yScale;
	}

	public void Draw(SpriteBatch spriteBatch, Texture texture) {
		spriteBatch.draw(texture, x, y, width * xScale, height * yScale, srcX,
				srcY, width, height, false, false);

	}

}
