package fr.nightwolf.guyrunner.managers;

import fr.nightwolf.guyrunner.display.IUpdatable;
import fr.nightwolf.guyrunner.display.scenes.BaseScene;

public class SceneManager implements IUpdatable {

	private static SceneManager _instance;
	public static SceneManager getInstance() {
		if(_instance == null) _instance = new SceneManager();
		return _instance;
	}
	
	/*
	 * ========== Fields ============
	 */
	
	private BaseScene currentScene;
	
	public BaseScene getCurrentScene() {
		return currentScene;
	}

	public void setCurrentScene(BaseScene currentScene) {
		if(this.getCurrentScene() != null) {
			System.out.println("Leave scene : " + this.getCurrentScene().getName());
			this.getCurrentScene().leave();
		}
		System.out.println("Enter in scene : " + currentScene.getName());
		currentScene.enter();
		this.currentScene = currentScene;
	}
	
	/*
	 * ========== Methods ============
	 */
	
	@Override
	public void update(int delta) {
		if(this.getCurrentScene() != null) {
			this.getCurrentScene().update(delta);
		}	
	}
}
