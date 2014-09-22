package fr.nightwolf.guyrunner.display.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import fr.nightwolf.guyrunner.display.AssetLoader;
import fr.nightwolf.guyrunner.display.states.InGameState;

public class Bonus {
	public Vector2f Position;
	public int Type;
	public Image Sprite;
	public boolean Alive = true;
	public InGameState GameState;
	
	public Bonus(Vector2f pos, int type, InGameState InGameState){
		this.Position = pos;
		this.GameState = InGameState;
		//Suivant le type, on change l'image
		this.Type = type;
		switch(Type){
		case 0 :
			this.Sprite = AssetLoader.LoadAsset("ingame.bonus-star", "res/ingame/bonus-star.png");
			break;
		case 1 :
			this.Sprite = AssetLoader.LoadAsset("ingame.bonus-cake", "res/ingame/bonus-cake.png");
			break;
		}
		
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) {
		this.Position.x -= 4f + InGameState.Speed;
		
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) {
		this.Sprite.draw(this.Position.x, this.Position.y);
	}
	
	public boolean checkCollide(Player p) {
		if(p.Position.x >= this.Position.x && p.Position.x <= this.Position.x + this.Sprite.getWidth()
				&& p.Position.y >= (this.Position.y)
				&& p.Position.y <= (this.Position.y) + this.Sprite.getHeight()) {
			return true;
		}	
		
		return false;
	}
	
	public void applyBonus(Player p){
		switch(this.Type) {
		case 0 :
				GameState.GodeMode_star();
			break;
		case 1 :
			break;
		}
	}
}
