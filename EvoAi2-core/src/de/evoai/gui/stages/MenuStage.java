package de.evoai.gui.stages;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kotcrab.vis.ui.widget.VisTextButton;

import de.evoai.main.EvoAiMain;

public class MenuStage extends Stage {
	
	SpriteBatch batch;
	
	VisTextButton startBtn;

	public MenuStage(Viewport viewport) {
		super(viewport);
		init();
	}
	
	public MenuStage() {
		init();
	}
	
	public void init() {
		batch = new SpriteBatch();
		startBtn = new VisTextButton("Start");
		startBtn.setPosition(EvoAiMain.getX(0f), EvoAiMain.getY(0));
		startBtn.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("test");
			}
		});
		EvoAiMain.fixedActors.put(new Vector2(.5f,.5f), startBtn);
		addActor(startBtn);
	}

	@Override
	public void draw() {
		
		batch.setProjectionMatrix(EvoAiMain.getCamera().combined);
		batch.begin();
		
		startBtn.draw(batch, 1);
		
		batch.end();
	}
	
	
	
//	@Override
//	public void act(float delta) {
//		startBtn.act(delta);
//		System.out.println("act");
//		super.act(delta);
//	}
	
	public void reset() {
		dispose();
		init();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
