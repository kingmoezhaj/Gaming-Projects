package com.netlinks.javapuzzle;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Puzzeled {

	Texture texture;
	float x;
	float y;
	int srcWidth;
	int score;

	int srcHeight;
	float xScale;
	float yScale;
	float marj;
	int numColumns;
	int numLines;
	Piece[][] pieces;
	Piece touched;
	boolean dragging;
	public Puzzeled(Texture texture, int x, int y, int numColumns,
			int numLines, float xScale, float yScale, float marj) {

		this.texture = texture;
		this.x = x;
		this.y = y;
		srcWidth = (int) texture.getWidth() / numColumns;
		srcHeight = (int) texture.getHeight() / numLines;
		pieces = new Piece[numLines][numColumns];
		this.xScale = xScale;
		this.yScale = yScale;
		this.numColumns = numColumns;
		this.numLines = numLines;
		this.marj = marj;
		dragging=false;
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				pieces[i][j] = new Piece(x + (srcWidth * xScale + marj) * j, y
						- (srcHeight * yScale + marj) * i, j * srcWidth, i
						* srcHeight, srcWidth*xScale, srcHeight*yScale,srcWidth , srcHeight);
			}
		}
		Random r= new Random();
		
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				int rCol = r.nextInt(numColumns);
				int rRoW = r.nextInt(numLines);
				Point p =new Point (pieces[i][j].getX(),pieces[i][j].getY());
				pieces[i][j].setXY( pieces[rRoW][rCol].getX(),pieces[rRoW][rCol].getY());
				pieces[rRoW][rCol].setXY(p.getX(), p.getY());	
			
			}
		}

	}

	public Puzzeled(Texture texture, int x, int y) {
		this(texture, x, y, 8, 8, 0.5f, 0.5f, 10);
	}

	public void DrawPuzzs(SpriteBatch spriteBatch) {
		// draw(Texture texture, float x, float y, float width, float height,
		// int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX,
		// boolean flipY)
		if (dragging){
			touched.setX(touched.getX()+Gdx.input.getDeltaX());
			touched.setY(touched.getY()-Gdx.input.getDeltaY());
		}
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				if(pieces[i][j]!=touched)
						pieces[i][j].Draw(spriteBatch, texture);
						
			}
		}
		if (dragging)
		touched.Draw(spriteBatch, texture);
		
	}
	
	public boolean hitTest(Point point){
		boolean b=false;
		if(!dragging){
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				
					b=	pieces[i][j].hitTest(point);
					if (b) {
						touched=pieces[i][j];
						System.out.print("point nimporte ("+point.getX()+","+point.getY()+") hit hit j="+j+" i="+i+" \n");
						break;
					}
			}
			if (b) break;
		}
		//System.out.print("point("+point.getX()+","+point.getY()+")  ");
		}
		
		return b;
	}

	public void startDrag(float factor){
		touched.setHeight(touched.getsrcHeight()*factor);
		touched.setWidth(touched.getsrcWidth()*factor);
		dragging=true;
	}
	public void stopDrag(float px,float py,float factor){
		if(touched.isApproxamite(60, px, py, factor, texture.getHeight()))
		{
			score+=50;
			touched.setInplace(px, py, factor,texture.getHeight());
		}
		else{
			if(score>=50)score-=50;
			touched.setInitXY();
		}
		
		touched=null;
		dragging=false;
	}
	public int getScore() {
		return score;
	}

	public boolean isDragging(){
		return dragging;
	}
	public Piece getTouched() {
		return touched;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getSrcWidth() {
		return srcWidth;
	}

	public void setSrcWidth(int srcWidth) {
		this.srcWidth = srcWidth;
	}

	public int getSrcHeight() {
		return srcHeight;
	}

	public void setSrcHeight(int srcHeight) {
		this.srcHeight = srcHeight;
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

	public float getMarj() {
		return marj;
	}

	public void setMarj(float marj) {
		this.marj = marj;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	public int getNumLines() {
		return numLines;
	}

	public void setNumLines(int numLines) {
		this.numLines = numLines;
	}
}
