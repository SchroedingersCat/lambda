/**
 * 
 */
package com.test;

import org.lwjgl.LWJGLException;

import com.lambda.Game;
import com.lambda.GameContainer;
import com.test.state.TestState;

/**
 * @author alex
 *
 */
public class TestGame extends Game {

	public TestGame() {
		
	}
	
	public void init() {
		super.init();
		
		this.registerState(new TestState(), 0);
		
		this.switchState(0);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestGame game = new TestGame();
		
		GameContainer gc = new GameContainer(game);
		
		try {
			gc.start();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

}
