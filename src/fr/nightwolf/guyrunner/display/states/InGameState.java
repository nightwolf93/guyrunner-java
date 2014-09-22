package fr.nightwolf.guyrunner.display.states;

import java.awt.Font;
import java.util.ArrayList;

import net.java.games.input.Keyboard;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.*;

import fr.nightwolf.guyrunner.Game;
import fr.nightwolf.guyrunner.display.AssetLoader;
import fr.nightwolf.guyrunner.display.SoundLoader;
import fr.nightwolf.guyrunner.display.game.Pipe;
import fr.nightwolf.guyrunner.display.game.Player;
import fr.nightwolf.guyrunner.helpers.TimeHelper;

public class InGameState implements GameState {

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
		if(arg0 == 30){
			this.PlayerEntity.SwitchCharacter();
		}
		if(arg0 == 57){
			KeyPressedCount++;
		}
		if(arg0 == 34){
			godmodeG = godmodeG ? false : true;			
		}
		if(arg0 == 74){
			Speed -= 0.5f;
		}else if (arg0 == 78){
			Speed += 0.5f;
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
	
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
	
	public Player PlayerEntity;
	public ArrayList<Pipe> Pipes = new ArrayList<>();
	public ArrayList<fr.nightwolf.guyrunner.display.game.Bonus> Bonus = new ArrayList<>();
	public static int Score = 0;
	public static float Speed = 1;
	public static int KeyPressedCount = 0;
	
	private int lastCreatedPipeTime = 0;
	private float bgOffset = 0;
	private float flashOpacity = 1f;
	private boolean godmodeG = false;
	
	private boolean godmode = false;

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		SoundLoader.LoadSound("sound.2", "res/sound/2.ogg");
		SoundLoader.LoadSound("sound.3", "res/sound/3.ogg");
		
		SoundLoader.GetSound("sound.1").stop();
		SoundLoader.GetSound("sound.2").stop();
		SoundLoader.GetSound("sound.3").stop();
		
		if(TimeHelper.getRandomNum(0, 2) == 0) {
			SoundLoader.GetSound("sound.2").play();
		}
		else {
			SoundLoader.GetSound("sound.3").play();
		}
		
		AssetLoader.LoadAsset("ingame.bg", "res/ingame/bg.png");
		AssetLoader.LoadAsset("ingame.pipe", "res/ingame/pipe.png");
		AssetLoader.LoadAsset("ingame.nyan", "res/ingame/nyan.png");
		AssetLoader.LoadAsset("ingame.wolf", "res/ingame/wolf.png");
		AssetLoader.LoadAsset("ingame.trace", "res/ingame/trace.png");
		
		Score = 0;
		Speed = 1;
		KeyPressedCount = 0;
		this.PlayerEntity = new Player(this);
		this.Pipes.clear();
		this.Bonus.clear();
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return Game.INGAME_STATE;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
		
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void FlashScreen(){
		this.flashOpacity = 1f;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		AssetLoader.GetAsset("ingame.bg").draw(0 - this.bgOffset, 0);
		AssetLoader.GetAsset("ingame.bg").draw(640 - this.bgOffset, 0);
		
		this.PlayerEntity.render(arg0, arg1, arg2);
		
		for(Pipe p : this.Pipes){
			p.render(arg0, arg1, arg2);
		}
		
		for(fr.nightwolf.guyrunner.display.game.Bonus b : this.Bonus){
			b.render(arg0, arg1, arg2);
		}
		
		Color alphaFlash = new Color(1f,1f,1f,this.flashOpacity);		
		AssetLoader.GetAsset("common.flash").draw(0, 0, alphaFlash);
		
		arg2.setColor(Color.yellow);
		arg2.drawString("Score : " + Score,500,10);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {

		this.PlayerEntity.update(arg0, arg1, arg2);
		Speed += 0.01f;
		flashOpacity -= 0.05f;
		
		lastCreatedPipeTime++;
		if(lastCreatedPipeTime == 75) {
			int nbAlea = TimeHelper.getRandomNum(25, 250);
			Pipes.add(new Pipe(new Vector2f(640, 0 - nbAlea)));
			//if(TimeHelper.getRandomNum(0, 10) == 2){
			if(true){
				Bonus.add(new fr.nightwolf.guyrunner.display.game.Bonus(new Vector2f(640 + 20, 350 - nbAlea), 
						TimeHelper.getRandomNum(0, 2), this));
			}
			lastCreatedPipeTime = 0;
		}
		
		for(Pipe p : this.Pipes){
			p.update(arg0, arg1, arg2);
		}
		
		for(fr.nightwolf.guyrunner.display.game.Bonus b : this.Bonus){
			b.update(arg0, arg1, arg2);
			if(b.checkCollide(this.PlayerEntity)){
				b.applyBonus(this.PlayerEntity);
			}
		}
		
		if(org.lwjgl.input.Keyboard.isKeyDown(57)) {
			this.PlayerEntity.Position.y -= 5;
			//this.PlayerEntity.Sprite.rotate(-1);
		}else{
			this.PlayerEntity.Position.y += 8;
			//this.PlayerEntity.Sprite.rotate(1);
		}
			
		/* if(this.PlayerEntity.Sprite.getRotation() > 20f){
			this.PlayerEntity.Sprite.setRotation(20f);
		}
		else if(this.PlayerEntity.Sprite.getRotation() < -20f) {
			this.PlayerEntity.Sprite.setRotation(-20f);
		}*/
		
		
		if(this.PlayerEntity.Position.y > 440) {
			this.PlayerEntity.Position.y = 440;
		} else if(this.PlayerEntity.Position.y < 0) {
			this.PlayerEntity.Position.y = 0;
		}
		//System.out.println("Rot : " + this.PlayerEntity.Sprite.getRotation());
		
		this.bgOffset += 1f + Speed;
		if(this.bgOffset >= 640) {
			this.bgOffset = 0;
		}
		
		if(this.collideWithPipe(this.PlayerEntity)) {
			if(godmodeG == false){
				Game.ActiveGame.enterState(Game.GAMEOVER_STATE);
			}
		}
	}
	
	private boolean collideWithPipe(Player p) {
		for(Pipe pipe : this.Pipes) {
			if(pipe.Pass(p)) {
				Score++;
			}
		}
		
		for(Pipe pipe : this.Pipes) {
			if(pipe.checkCollide(p)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public void GodeMode_star(){
		godmode = godmode ? false : true;
	}
}
