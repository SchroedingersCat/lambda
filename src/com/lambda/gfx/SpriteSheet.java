/**
 * The 'gfx' package provides functionality for the graphical representation of objects.
 */
package com.lambda.gfx;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 * @author alex
 * 
 */
public class SpriteSheet extends Sprite {

	/**
	 * Creates a new 'SpriteSheet' from a 'Texture' and with a size for it's
	 * 'Sprites'.
	 * 
	 * @param texture The 'Texture' the 'SpriteSheet' gets its 'Sprites' from.
	 * @param width The width of one 'Sprite' in the 'SpriteSheet'.
	 * @param height The height of one 'Sprite' in the 'SpriteSheet'.
	 */
	public SpriteSheet(Texture texture, int width, int height) {
		super(texture, width, height);
	}

	/**
	 * Renders the whole 'SpriteSheet' to the screen.
	 */
	public void render() {
		GL11.glPushMatrix();

		texture.bind();
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex2f(0, 0);

			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex2f(texture.getImageWidth(), 0);

			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex2f(texture.getImageWidth(), texture.getImageHeight());

			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex2f(0, texture.getImageHeight());
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	/**
	 * Renders a certain 'Sprite' from the 'SpriteSheet' to the screen.
	 * @param col The column the 'Sprite' is in the 'SpriteSheet'.
	 * @param row The row the 'Sprite' is in the 'SpriteSheet'.
	 */
	public void renderSprite(int col, int row) {
		GL11.glPushMatrix();

		texture.bind();
		
		float w = 1 / (float) (texture.getImageWidth() / width);
		float h = 1 / (float) (texture.getImageHeight() / height);
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			
			GL11.glTexCoord2f((w * row), (h * col));
			GL11.glVertex2f(0, 0);

			GL11.glTexCoord2f((w * row) + w, (h * col));
			GL11.glVertex2f(width, 0);

			GL11.glTexCoord2f((w * row) + w, (h * col) + h);
			GL11.glVertex2f(width, height);

			GL11.glTexCoord2f((w * row), (h * col) + h);
			GL11.glVertex2f(0, height);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}
