package fr.nightwolf.guyrunner.display.game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.newdawn.slick.state.StateBasedGame;

import fr.nightwolf.guyrunner.display.AssetLoader;
import fr.nightwolf.guyrunner.display.states.InGameState;

public class Player {

	public Vector2f Position;
	public Image Sprite;
	public float Scale;
	public ParticleSystem Particles;
	public int CharacterType = 0;
	public InGameState State;
	
	private ArrayList<Vector2f> _traces = new ArrayList<>();
	
	public Player(InGameState state) {
		this.State = state;
		this.Position = new Vector2f(50, 200);
		this.Sprite = AssetLoader.GetAsset("ingame.nyan");
		//this.Scale = 0.3f;
		this.Particles = new ParticleSystem(AssetLoader.LoadAsset("common.particle", "res/common/particle.png"));
		this.Particles.addEmitter(new FireEmitter());
		this.Sprite.setCenterOfRotation(10, 15);
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) {
		this.Particles.update(arg2);
		for(Vector2f t : this._traces) {
			t.x -= 4;
		}
		_traces.add(new Vector2f(this.Position.x, this.Position.y));
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) {
		this.Sprite.draw(this.Position.x, this.Position.y);
		for(Vector2f t : this._traces) {
			AssetLoader.GetAsset("ingame.trace").draw(t.x + 15, t.y + 7);
		}
		//arg2.drawRect(this.Sprite., this.Position.y, 4, 4);
	}
	
	public void SwitchCharacter() {
		this.State.FlashScreen();
		this.CharacterType = this.CharacterType == 0 ? 1 : 0;
		switch(this.CharacterType) {
		case 0:// Nyan
				this.Sprite = AssetLoader.GetAsset("ingame.nyan");
			break;
			
		case 1: // wolf
				this.Sprite = AssetLoader.GetAsset("ingame.wolf");
			break;
		}
	}
}
