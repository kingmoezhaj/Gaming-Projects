package com.netlinks.tutorials;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DesktopStarter {
	public static void main(String[] args){
		/******* comments and explanation are in French since the intended audience is Francophonic ********/
		// les com sont ecrit avec des abbriaviation et language chat , et vs allez trouver bcp 
		
		// JoglApplication=  Java OpenGL Application
		// ce JoglApplication objet va créer notre fenetre de va et gérer la communication de notre application avec le systeme
		// il utilise une classe qui implemente l'interface ApplicationListener , une chaine de char pour nommer la fenetre 
		// largeur et hauteur de la fenetre et boolean ki specifie est-ce que on utilise OpenGL ES 2.0
		
		new JoglApplication(new Application(),"A libGDX tutorial",1300,700,true);
		
	}
}
