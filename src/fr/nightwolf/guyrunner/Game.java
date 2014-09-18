package fr.nightwolf.guyrunner;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import fr.nightwolf.guyrunner.display.scenes.IntroScene;
import fr.nightwolf.guyrunner.helpers.TimeHelper;
import fr.nightwolf.guyrunner.managers.SceneManager;

public final class Game {
	
	private static Game _instance;
	public static Game getInstance() {
		if(_instance == null) _instance = new Game();
		return _instance;
	}

	public static void main(String[] args) {
		Game.getInstance();
	}
		
	private static int CANVAS_WIDTH = 600;
	private static int CANVAS_HEIGHT = 400;
	
	public Game() {
		this.initialiaze();
	}

	public void initialiaze() {
		try {
			Display.setDisplayMode(new DisplayMode(CANVAS_WIDTH, CANVAS_HEIGHT));
			Display.create();
			
			SceneManager.getInstance().setCurrentScene(new IntroScene());
			
			while (!Display.isCloseRequested()) {			
				this.update(TimeHelper.getDelta());
				
				Display.update();
				Display.sync(60);
			}
			
			Display.destroy();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	private void update(int delta) {
		SceneManager.getInstance().update(delta);
	}
}
