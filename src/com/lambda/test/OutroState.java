package com.lambda.test;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.lambda.GameState;

public class OutroState extends GameState {

	@Override
	public void render() {
	}

	@Override
	public void update(double delta) {
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.game.switchState(0);
		}
	}

}
