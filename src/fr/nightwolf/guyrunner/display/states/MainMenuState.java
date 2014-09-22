package fr.nightwolf.guyrunner.display.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

import fr.nightwolf.guyrunner.Game;
import fr.nightwolf.guyrunner.display.AssetLoader;
import fr.nightwolf.guyrunner.display.SoundLoader;

public class MainMenuState implements GameState{

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
			if(menuIndex == 3){
				menuIndex = 0;
			}
		}
		else if(arg0 == 200) {
			menuIndex--;
			if(menuIndex == -1) {
				menuIndex = 2;
			}
		}
		else if(arg0 == 28) {
			switch(menuIndex) {
				case 0:
					Game.ActiveGame.enterState(Game.INGAME_STATE);
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

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		return Game.MAINMENU_STATE;
	}
	
	private float flashOpacity = 1f;
	private float logoBounce = 1f;
	private int menuIndex = 0;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		AssetLoader.LoadAsset("common.flash", "res/common/flash.png");
		//AssetLoader.LoadAsset("common.arrow", "res/common/arrow-select.png");
		
		//Bouton blanc
		AssetLoader.LoadAsset("mainmenu.btplay", "res/mainmenu/bt-play.png");
		AssetLoader.LoadAsset("mainmenu.btopt", "res/mainmenu/bt-opt.png");
		AssetLoader.LoadAsset("mainmenu.btexit", "res/mainmenu/bt-exit.png");
		
		//Bouton jaune
		AssetLoader.LoadAsset("mainmenu.btplaybis", "res/mainmenu/bt-playbis.png");
		AssetLoader.LoadAsset("mainmenu.btoptbis", "res/mainmenu/bt-optbis.png");
		AssetLoader.LoadAsset("mainmenu.btexitbis", "res/mainmenu/bt-exitbis.png");
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		Color alphaFlash = new Color(1f,1f,1f,this.flashOpacity);
		AssetLoader.GetAsset("intro.bg").draw(0, 0);
		AssetLoader.GetAsset("intro.logo").draw(20 - (flashOpacity * 3), -120, logoBounce);
		
		//AssetLoader.GetAsset("common.arrow").draw(80, 180 + (menuIndex * 70));
		
		bouton();
		
		AssetLoader.GetAsset("common.flash").draw(0, 0, alphaFlash);		
	}

	private void bouton(){
		
		switch(menuIndex){
		case 0 :
				AssetLoader.GetAsset("mainmenu.btplaybis").draw(170, 180);
				AssetLoader.GetAsset("mainmenu.btopt").draw(170, 250);
				AssetLoader.GetAsset("mainmenu.btexit").draw(170, 320);
			break;
		case 1 :
				AssetLoader.GetAsset("mainmenu.btplay").draw(170, 180);
				AssetLoader.GetAsset("mainmenu.btoptbis").draw(170, 250);
				AssetLoader.GetAsset("mainmenu.btexit").draw(170, 320);
			break;
		case 2 :	
				AssetLoader.GetAsset("mainmenu.btplay").draw(170, 180);
				AssetLoader.GetAsset("mainmenu.btopt").draw(170, 250);
				AssetLoader.GetAsset("mainmenu.btexitbis").draw(170, 320);
			break;
		default :
			break;
		}
		
	}
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		flashOpacity -= 0.05f;
		logoBounce -= 0.0005f;
		
		if(flashOpacity <= -7){
			flashOpacity = 1.1f;
			logoBounce = 1f;
		}
		
		if(!SoundLoader.GetSound("sound.1").playing()){
			SoundLoader.GetSound("sound.1").play();
		}
	}

}
