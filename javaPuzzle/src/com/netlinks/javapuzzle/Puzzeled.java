package com.netlinks.javapuzzle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Puzzeled {

	Texture texture;
	float x;
	float y;
	int srcWidth;
	

	int srcHeight;
	float xScale;
	float yScale;
	float marj;
	int numColumns;
	int numLines;
	Piece[][] pieces;

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
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				pieces[i][j] = new Piece(x + (srcWidth * xScale + marj) * j, y
						- (srcHeight * yScale + marj) * i, j * srcWidth, i
						* srcHeight, srcWidth*xScale, srcHeight*yScale,srcWidth , srcHeight);
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

		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numColumns; j++) {
				
						pieces[i][j].Draw(spriteBatch, texture);
						
			}
		}
		
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
