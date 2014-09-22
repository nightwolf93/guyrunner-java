package fr.nightwolf.guyrunner;

public class GameOptions {
	
	private static GameOptions _instance;
	public static GameOptions getInstance() {
		if(_instance == null) _instance = new GameOptions();
		return _instance;
	}
	
	public float SoundVolume = 1f;
	public int Difficulty = 1;
	public int DefaultCharacter = 0; // Nyan
}
