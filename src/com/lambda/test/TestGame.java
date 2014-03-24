package com.lambda.test;

import com.lambda.Game;
import com.lambda.GameContainer;
import com.lambda.LambdaException;

public class TestGame extends Game {
	
	public void init(GameContainer gc) {
		super.init(gc);
		
		registerState(new IntroState(), 0);
		registerState(new MainState(), 1);
		registerState(new OutroState(), 2);
		switchState(0);
	}

	public static void main(String[] args) {
		TestGame g = new TestGame();
		
		try {
			GameContainer gc = new GameContainer(g, 800, 600);
			
			gc.setFrameRate(60);
			gc.setvSync(false);
			
			gc.start();
		} catch (LambdaException e) {
			e.printStackTrace();
		}
	}

}
