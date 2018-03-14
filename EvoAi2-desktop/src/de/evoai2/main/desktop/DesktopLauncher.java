package de.evoai2.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.evoai.main.EvoAiMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.out.println(config.width+", "+config.height);
//		config.width = 1920;
//		config.height = 1080;
//		config.fullscreen = true;
		new LwjglApplication(new EvoAiMain(), config);
	}
}
