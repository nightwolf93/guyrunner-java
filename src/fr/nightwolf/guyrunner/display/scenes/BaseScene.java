package fr.nightwolf.guyrunner.display.scenes;

import fr.nightwolf.guyrunner.display.IUpdatable;

public abstract class BaseScene implements IUpdatable{

	public abstract String getName();
	public abstract void enter();
	public abstract void leave();
}
