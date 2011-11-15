package com.netlinks.javapuzzle;

public class Piece {
	
	Point position;
	int column;
	int row;

	public Piece(float x, float y) {
		position=new Point(x, y);

	}



	

	public void setX(float x) {
		this.position.setX(x);
	}

	public void setY(float y) {
		this.position.setY(y);
	}

	public void setXY(float x, float y) {
		this.position.setX(x);
		this.position.setY(y);
	}

	public float getX() {
		return this.position.getX();
	}

	public float getY() {
		return this.position.getY();
	}

}
