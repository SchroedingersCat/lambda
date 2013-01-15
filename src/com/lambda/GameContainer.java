/**
 * The 'engine' package encloses every functionality the engine has and provides.
 */
package com.lambda;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * The 'GameContainer' class is used as a container for a 'Game'.
 * It provides options to change resolutions or fullscreen options.
 * 
 * @author alex
 *
 */
public class GameContainer {

	/**
	 * The default width if none is specified for the 'GameContainer'.
	 */
	public static final int DEF_WIDTH = 1024;
	
	/**
	 * The default height if none is specified for the 'GameContainer'.
	 */
	public static final int DEF_HEIGHT = 768;
	
	/**
	 * The default frame rate if none is specified for the 'GameContainer'.
	 */
	public static final int DEF_FPS = 60;
	
	/**
	 * The 'Game' the container is going to run.
	 */
	protected Game game;
	
	/**
	 * The 'DisplayMode' the 'GameContainer' runs at.
	 */
	protected DisplayMode displayMode;
	
	/**
	 * Whether vSync is enabled for the 'GameContainer'.
	 */
	protected boolean vSyncEnabled;
	
	/**
	 * Whether the 'GameContainer' is running in fullscreen.
	 */
	protected boolean isFullscreen;
	
	/**
	 * The frames per second the 'GameContainer' renders.
	 */
	protected int frames;
	
	/**
	 * The current framerate.
	 */
	private int fps;
	
	/**
	 * The point in time the last frame was fully rendered.
	 */
	private long lastFrame;
	
	/**
	 * The point in time the last framerate was measured.
	 */
	private long lastFPS;
	
	/**
	 * Creates a new 'GameContainer' that holds the 'Game' app.
	 * 
	 * @param app The 'Game' the 'GameContainer' holds.
	 */
	public GameContainer(Game app) {
		this.game = app;
		
		displayMode = new DisplayMode(DEF_WIDTH, DEF_HEIGHT);
		vSyncEnabled = false;
		isFullscreen = false;
		frames = DEF_FPS;
	}
	
	/**
	 * Starts the 'Game' and it's 'Container'.
	 * 
	 * @throws LWJGLException If 'Display' could not be set according
	 * to the set values.
	 */
	public void start() throws LWJGLException {
		initDisplay();
		initOpenGL();
		
		loop();
	}
	
	/**
	 * Initializes the 'Display'.
	 * 
	 * @throws LWJGLException If 'Display' could not be set according
	 * to the set values.
	 */
	protected void initDisplay() throws LWJGLException {
		Display.setDisplayMode(displayMode);
		Display.setVSyncEnabled(vSyncEnabled);
		Display.setFullscreen(isFullscreen);
		
		Display.create();
	}
	
	/**
	 * Initializes the OpenGL environment.
	 */
	protected void initOpenGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glLoadIdentity();
	}
	
	/**
	 * The 'Game' loop. It calls the 'update()' - and 'render()' - methods for all objects in the 'Game'.
	 */
	protected void loop() {
		init();
		
		getDelta();
		lastFPS = getTime();
		
		while(!Display.isCloseRequested()) {
			int delta = getDelta();
			
			update(delta);
			render();
			
			Display.update();
			Display.sync(frames);
		}
		
		Display.destroy();
	}
	
	/**
	 * Calls the 'init()'-method of the 'Game'.
	 */
	protected void init() {
		game.init();
	}
	
	/**
	 * Configures some options then calls the 'render()'-method
	 * of the 'Game'.
	 */
	protected void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		game.render();
	}
	
	/**
	 * Calls the 'update()'-method of the 'Game' then
	 * updates the FPS counter.
	 * 
	 * @param delta The difference in time between the rendering of two frames.
	 */
	protected void update(int delta) {
		game.update(delta);
		
		updateFPS();
	}
	
	/**
	 * Updates the frames counter.
	 */
	private void updateFPS() {
		if(getTime() - lastFPS > 1000) {
			System.out.println("[FPS] " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	
	/**
	 * Gives back the time passed between the rendering of two frames.
	 * 
	 * @return The delta of two frames.
	 */
	private int getDelta() {
		long time = getTime();
		int delta = (int)(time - lastFrame);
		lastFrame = time;
		
		return delta;
	}
	
	/**
	 * The current time in milliseconds.
	 * 
	 * @return The current time.
	 */
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Gives back the current 'DisplayMode' the 'GameContainer'
	 * is running at.
	 * 
	 * @return The current 'DisplayMode'.
	 */
	public DisplayMode getDisplayMode() {
		return displayMode;
	}

	/**
	 * Tells whether vSync is enabled for the 'GameContainer'.
	 * 
	 * @return 'true' if enabled, 'false' otherwise.
	 */
	public boolean isvSyncEnabled() {
		return vSyncEnabled;
	}

	/**
	 * Tells whether the 'GameContainer' is running in 
	 * fullscreen mode.
	 * 
	 * @return 'true' if in fullscreen mode, 'false' otherwise.
	 */
	public boolean isFullscreen() {
		return isFullscreen;
	}

	/**
	 * Sets a new 'DisplayMode' for the 'GameContainer'.
	 * 
	 * @param displayMode The 'DisplayMode' to be set for the 'GameContainer'.
	 */
	public void setDisplayMode(DisplayMode displayMode) {
		this.displayMode = displayMode;
	}

	/**
	 * Enables or disables the vSync option for the 'GameContainer'.
	 * 
	 * @param vSyncEnabled 'true' for enable, 'false' for disable.
	 */
	public void setvSyncEnabled(boolean vSyncEnabled) {
		this.vSyncEnabled = vSyncEnabled;
	}

	/**
	 * Enables or disables the fullscreen option for the 'GameContainer'.
	 * 
	 * @param fullscreen 'true' to enable fullscreen, 'false' to disable.
	 */
	public void setFullscreen(boolean fullscreen) {
		this.isFullscreen = fullscreen;
	}

	/**
	 * Gives back the frames the 'GameContainer' is currently rendering per second.
	 * 
	 * @return The frames the 'GameContainer' is currently rendering per second.
	 */
	public int getFrames() {
		return frames;
	}

	/**
	 * Sets the frames the 'GameContainer' renders per second.
	 * 
	 * @param frames The framerate to set.
	 */
	public void setFrames(int frames) {
		this.frames = frames;
	}
}
