package fr.nightwolf.guyrunner.display.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

import fr.nightwolf.guyrunner.Game;
import fr.nightwolf.guyrunner.display.AssetLoader;

public class GameOverState implements GameState {

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(int arg0, char arg1) {
		if(arg0 == 208) {
			menuIndex++;
			if(menuIndex == 2){
				menuIndex = 0;
			}
		}
		else if(arg0 == 200) {
			menuIndex--;
			if(menuIndex == -1) {
				menuIndex = 1;
			}
		}
		else if(arg0 == 28 || arg0 == 57) {
			switch(menuIndex) {
				case 0:
					Game.ActiveGame.enterState(Game.INGAME_STATE);
					break;
					
				case 1:
					Game.ActiveGame.enterState(Game.MAINMENU_STATE);
					break;
			}
		}
		
	}

	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	
	private float flashOpacity = 1f;
	private float logoBounce = 1f;
	private int menuIndex = 0;

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Game.GAMEOVER_STATE;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		//Bouton blanc
		AssetLoader.LoadAsset("gameover.restart", "res/gameover/bt-replay.png");
		AssetLoader.LoadAsset("gameover.exit", "res/gameover/bt-exit.png");
		
		//Bouton jaune
		AssetLoader.LoadAsset("gameover.restartbis", "res/gameover/bt-replaybis.png");
		AssetLoader.LoadAsset("gameover.exitbis", "res/gameover/bt-exitbis.png");
		
		this.FlashScreen();
		
	}
	


	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		AssetLoader.GetAsset("ingame.bg").draw(0, 0);
		Color alphaFlash = new Color(1f,1f,1f,this.flashOpacity);
		AssetLoader.GetAsset("intro.logo").draw(20 - (flashOpacity * 3), -120, logoBounce);
		//AssetLoader.GetAsset("common.flash").draw(0, 0, alphaFlash);
		
		arg2.setColor(Color.yellow);
		arg2.drawString("Score : " + InGameState.Score, 260,340);
		arg2.drawString("Key press : " + InGameState.KeyPressedCount, 240,365);
		
		bouton();	
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		flashOpacity -= 0.05f;
		logoBounce -= 0.0005f;
		
		if(flashOpacity <= -7){
			flashOpacity = 1.1f;
			logoBounce = 1f;
		}

		
	}
	
	public void FlashScreen(){
		this.flashOpacity = 1f;
	}

	private void bouton(){
		
		switch(menuIndex){
		case 0 :
				AssetLoader.GetAsset("gameover.restartbis").draw(170, 180);
				AssetLoader.GetAsset("gameover.exit").draw(170, 250);
			break;
		case 1 :
			AssetLoader.GetAsset("gameover.restart").draw(170, 180);
			AssetLoader.GetAsset("gameover.exitbis").draw(170, 250);
			break;
		default :
			break;
		}
		
	}
}
