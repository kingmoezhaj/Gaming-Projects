package com.netlinks.javapuzzle;

public class Point {

	float x;
	float y;
	
	public Point (float x,float y){
		this.x=x;
		this.y=y;
	}
	
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}
}
