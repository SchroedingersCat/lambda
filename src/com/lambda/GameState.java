/**
 * 
 */
package com.lambda;

/**
 * The 'GameState' represents a certain state of the 'Game'.
 * 
 * @author alex
 * 
 */
public abstract class GameState {
	
	/**
	 * The 'GameContainer' that contains the 'Game' 'game'.
	 */
	protected GameContainer gameContainer;
	
	/**
	 * The 'Game' this 'GameState' is registered at.
	 */
	protected Game game;
	
	/**
	 * Initializes all objects the 'Game' needs to work properly.
	 */
	public void init(GameContainer gc, Game g) {
		setGameContainer(gc);
		setGame(g);
	}
	
	/**
	 * Calls the 'render()'-method for all objects that need rendering to the screen.
	 */
	public abstract void render();
	
	/**
	 * Calls the 'update()'-method for all objects that need updating of their logic.
	 * 
	 * @param delta The difference in time between the processing of two frames.
	 */
	public abstract void update(double delta);

	/**
	 * Gives back the 'GameContainer' that holds the 'Game' ,the 'GameState' is registered at.
	 * 
	 * @return The 'GameContainer' that holds the 'Game'.
	 */
	public GameContainer getGameContainer() {
		return gameContainer;
	}

	/**
	 * Gives back the 'Game' the 'GameState' is registered at.
	 * 
	 * @return The 'Game' the 'GameState' is registered at.
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Sets the 'GameContainer' that holds the 'Game', the 'GameState' is registered at to 'gameContainer'.
	 * 
	 * @param gameContainer The 'GameContainer' that holds the 'Game'.
	 */
	protected void setGameContainer(GameContainer gameContainer) {
		if(gameContainer != null) {
			this.gameContainer = gameContainer;
		}
	}

	/**
	 * Sets the 'Game' the 'GameState' is registered at to 'game'.
	 * 
	 * @param game The 'Game' the 'GameState' is registered at.
	 */
	protected void setGame(Game game) {
		if(game != null) {
			this.game = game;
		}
	}
}
