package fr.nightwolf.guyrunner.display.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.newdawn.slick.state.StateBasedGame;

import fr.nightwolf.guyrunner.display.AssetLoader;
import fr.nightwolf.guyrunner.display.states.InGameState;

public class Pipe {

	public Vector2f Position;
	public Image Sprite;
	public ParticleSystem Particles;
	public boolean Passed = false;
	
	public Pipe(Vector2f position) {
		this.Position = position;
		this.Sprite = AssetLoader.GetAsset("ingame.pipe");
		this.Particles = new ParticleSystem(AssetLoader.LoadAsset("common.particle", "res/common/particle.png"));
		this.Particles.addEmitter(new FireEmitter());
	}
	
	public boolean checkCollide(Player p) {
		if(p.Position.x >= this.Position.x && p.Position.x <= this.Position.x + this.Sprite.getWidth()
				&& p.Position.y >= (this.Position.y - 50)
				&& p.Position.y <= (this.Position.y - 50) + this.Sprite.getHeight()) {
			return true;
		}	
		
		if(p.Position.x >= this.Position.x && p.Position.x <= this.Position.x + this.Sprite.getWidth()
				&& p.Position.y >= (this.Position.y + 400)
				&& p.Position.y <= (this.Position.y + 450) + this.Sprite.getHeight()){
			return true;
		}
		
		return false;
	}
	
	public boolean Pass(Player p) {
		if(this.Passed) return false;
		if(p.Position.x >= this.Position.x && p.Position.x <= this.Position.x + this.Sprite.getWidth()){
			this.Passed = true;
			return true;
		}
		return false;
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) {
		this.Position.x -= 4f + InGameState.Speed;
		this.Particles.update(arg2);
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) {
		this.Sprite.draw(this.Position.x, this.Position.y - 50);
		this.Sprite.draw(this.Position.x, this.Position.y + 450);
		//this.Particles.render(this.Position.x + 50, this.Position.y + 450 );
	}
}
