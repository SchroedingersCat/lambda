package com.lambda.test;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.lambda.Game;
import com.lambda.GameContainer;
import com.lambda.GameState;
import com.lambda.LambdaException;
import com.lambda.graphics.Sprite;
import com.lambda.graphics.SpriteSheet;

public class MainState extends GameState {

	private Sprite sprite;
	private SpriteSheet sheet;
	
	int x = 0, y = 0;
	
	public void init(GameContainer gc, Game g) {
		super.init(gc, g);
		
		try {
			sprite = new Sprite("resources/testtile.png", 64, 64);
			sheet = new SpriteSheet("resources/sheet.png", 64, 64);
		} catch (LambdaException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void render() {
		sprite.render(x, y);
		sheet.renderSprite(800 - x, 600 - y, 0, 0);
	}

	@Override
	public void update(double delta) {
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			this.game.switchState(2);
		}
		x++;
		y++;
	}

}
