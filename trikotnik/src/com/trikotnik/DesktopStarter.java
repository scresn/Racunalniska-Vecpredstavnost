package com.trikotnik;

import org.lwjgl.opengl.Drawable;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DesktopStarter {
	public static void main(String[] argv) {
		
		new JoglApplication(new TrikotnikDesktop(), "kocka", 480, 320, false);
		
	}
}
