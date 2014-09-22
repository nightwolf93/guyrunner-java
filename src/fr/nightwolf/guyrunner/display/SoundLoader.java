package fr.nightwolf.guyrunner.display;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.*;

public class SoundLoader {
	
	public static Map<String, Sound> Assets = new HashMap<String, Sound>();
	
	public static Sound LoadSound(String alias, String path) {
		try {
			if(!Assets.containsKey(alias)){
				Sound s = new Sound(path);
				Assets.put(alias, s);
				System.out.println("Sound '" + alias + "' loaded");
				return s;	
			} 
			else{
				return GetSound(alias);
			}
		} catch (SlickException e) {
			return null;
		}			
	}
	
	public static synchronized Sound GetSound(String alias) {
		return Assets.get(alias);
	}
}
