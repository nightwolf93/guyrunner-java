package fr.nightwolf.guyrunner.display;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
public class AssetLoader {

	public static Map<String, Image> Assets = new HashMap<String, Image>();
	
	public static Image LoadAsset(String alias, String path) {
		try {
			if(!Assets.containsKey(alias)){
				Image img = new Image(path);
				Assets.put(alias, img);
				System.out.println("Asset '" + alias + "' loaded");
				return img;	
			} 
			else{
				return GetAsset(alias);
			}
		} catch (SlickException e) {
			return null;
		}			
	}
	
	public static synchronized Image GetAsset(String alias) {
		return Assets.get(alias);
	}
	
}
