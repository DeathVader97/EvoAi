package de.evoai.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.kotcrab.vis.ui.VisUI;

import de.evoai.gui.stages.MenuStage;

public class EvoAiMain extends ApplicationAdapter {
	
	static Camera camera;
	public static int w,h;
	
	public static Map<Vector2, Actor> fixedActors = new HashMap<>();
	
	Stage currentStage;
	
//	SpriteBatch batch;
//	Texture img;
	
	@Override
	public void create () {
		VisUI.load();
		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(w, h);
//		camera.translate(-w, -h, 0);
		camera.update();
		
		currentStage = new MenuStage();
		Gdx.input.setInputProcessor(currentStage);
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		currentStage.act();
		currentStage.draw();
		if (currentStage instanceof MenuStage)
			((MenuStage)currentStage).reset();
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		w = width;
		h = height;
		camera = new OrthographicCamera(w, h);
//		camera.translate(-w/2, -h/2, 0);
		camera.update();
		for (Entry<Vector2, Actor> e : fixedActors.entrySet()) {
			e.getValue().setPosition(e.getKey().x*w-e.getValue().getWidth(), e.getKey().y*h-e.getValue().getHeight());
		}
		super.resize(width, height);
	}
	
	public static Camera getCamera() {
		return camera;
	}
	
	public static float getX(float relX) {
		return w*relX;
	}
	
	public static float getY(float relY) {
		return h*relY;
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}
}
