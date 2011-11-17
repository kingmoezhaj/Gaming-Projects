package com.netlinks.javapuzzle;

public class MouseState {
	Boolean isPressed;
	Point hitPoint;
	public MouseState(){
		isPressed=false;
		hitPoint=new Point(0, 0);
	}
	public Boolean getIsPressed() {
		return isPressed;
	}
	public void setIsPressed(Boolean isPressed) {
		this.isPressed = isPressed;
	}
	public Point getHitPoint() {
		return hitPoint;
	}
	public void setHitPoint(Point hitPoint) {
		this.hitPoint = hitPoint;
	}
	

}
