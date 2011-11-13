package com.netlinks.javapuzzle;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DesktopStarter {
	public static void main(String[] args){
		new JoglApplication(new Puzzle(),"A Puzzle made with java",1300,700,false);
	}

}
