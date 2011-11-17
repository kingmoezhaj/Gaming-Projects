package com.netlinks.javapuzzle;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class Piece extends Point {

	int srcX;
	int srcY;
	float initX;
	float initY;
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
		initX=x;
		initY=y;

	}

	public void setInitXY(){
		x=initX;
		y=initY;
		width=srcWidth*0.5f;
		height=srcHeight*0.5f;
		
	}
	
	
	public boolean isApproxamite(int d,float px,float py,float factor,float h){
		return (( Math.abs(x-(srcX*factor+px))<d ) && (Math.abs(y-((h-srcHeight)*factor-(srcY*factor)+py))<d));
	}
	
	public void setInplace(float px,float py,float factor,float h){
		x=srcX*factor+px;
		y=(h-srcHeight)*factor-(srcY*factor)+py;
		width=srcWidth*factor;
		height=srcHeight*factor;
	}
	
	public boolean hitTest(Point point){
		return (point.getX()>x)&&(point.getX()<x+width)&&(point.getY()>y)&&(point.getY()<y+height);
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
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
