package fr.nightwolf.guyrunner.helpers;

import org.lwjgl.Sys;

public final class TimeHelper {
	
	private static long lastFrame;
	
	public static int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
 
	    return delta;
	}
 
	public static long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
 
}
