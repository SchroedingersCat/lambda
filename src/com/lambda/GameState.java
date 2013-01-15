/**
 * 
 */
package com.lambda;

/**
 * 'GameStates' are used to manage different states of the 'Game' differently and separately.
 * 
 * @author alex
 * 
 */
public abstract class GameState {
	
	/**
	 * Initializes all objects the 'Game' needs to work properly.
	 */
	public abstract void init();
	
	/**
	 * Calls the 'render()'-method for all objects that need rendering to the screen.
	 */
	public abstract void render();
	
	/**
	 * Calls the 'update()'-method for all objects that need updating of their logic.
	 * 
	 * @param delta The difference in time between the processing of two frames.
	 */
	public abstract void update(int delta);
}
