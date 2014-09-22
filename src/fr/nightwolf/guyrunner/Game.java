package fr.nightwolf.guyrunner;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.nightwolf.guyrunner.display.states.GameOverState;
import fr.nightwolf.guyrunner.display.states.InGameState;
import fr.nightwolf.guyrunner.display.states.IntroState;
import fr.nightwolf.guyrunner.display.states.MainMenuState;

public class Game extends StateBasedGame {
	
	public static void main(String[] args) {
		initialize();
	}
	
	public static void initialize() {
		try {
			ActiveGame = new Game("GuyRunner | By Nightwolf and Nyura");
			setGameContainer(new AppGameContainer( ActiveGame ));
			getGameContainer().setDisplayMode(CANVAS_WIDTH, CANVAS_HEIGHT, false);
			getGameContainer().setTargetFrameRate(60);
			getGameContainer().start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
		
	public static Game ActiveGame;
	
	private static AppGameContainer container;
	private static int CANVAS_WIDTH = 640;
	private static int CANVAS_HEIGHT = 480;
	
	public static final int INTRO_STATE = 1;
	public static final int MAINMENU_STATE = 2;
	public static final int INGAME_STATE = 3;
	public static final int GAMEOVER_STATE = 4;
	
	public static AppGameContainer getGameContainer() {
		return container;
	}

	public static void setGameContainer(AppGameContainer container) {
		Game.container = container;
	}
	
	public Game(String gamename) {
		super(gamename);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new IntroState());
		this.addState(new MainMenuState());
		this.addState(new InGameState());
		this.addState(new GameOverState());
		
		this.enterState(INTRO_STATE);
	}
}
