/**
 * The 'gfx' package provides functionality for the graphical representation of objects.
 */
package com.lambda.gfx;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 * The 'SpriteSheet' class allows to load a 'Texture' and split it into multiple
 * smaller 'Sprites'.
 * 
 * @author alex
 * 
 */
public class SpriteSheet extends Sprite {

	/**
	 * Creates a new 'SpriteSheet' from a 'Texture' and with a size for it's
	 * 'Sprites'. The 'width' and the 'height' of the 'SpriteSheet' may not be
	 * less than 0.
	 * 
	 * @param texture
	 *            The 'Texture' the 'SpriteSheet' gets its 'Sprites' from.
	 * @param width
	 *            The width of one 'Sprite' in the 'SpriteSheet'.
	 * @param height
	 *            The height of one 'Sprite' in the 'SpriteSheet'.
	 */
	public SpriteSheet(Texture texture, int width, int height) {
		super(texture, width, height);
	}

	/**
	 * Renders the whole 'SpriteSheet' to the screen.
	 * This will only work if the 'Texture' of this 'SpriteSheet' is not 'null'.
	 */
	public void render() {
		if (texture != null) {
			GL11.glPushMatrix();

			texture.bind();
			GL11.glBegin(GL11.GL_QUADS);
			{
				GL11.glTexCoord2f(0.0f, 0.0f);
				GL11.glVertex2f(0, 0);

				GL11.glTexCoord2f(1.0f, 0.0f);
				GL11.glVertex2f(texture.getImageWidth(), 0);

				GL11.glTexCoord2f(1.0f, 1.0f);
				GL11.glVertex2f(texture.getImageWidth(),
						texture.getImageHeight());

				GL11.glTexCoord2f(0.0f, 1.0f);
				GL11.glVertex2f(0, texture.getImageHeight());
			}
			GL11.glEnd();
			GL11.glPopMatrix();
		}
	}

	/**
	 * Renders a certain 'Sprite' from the 'SpriteSheet' to the screen.
	 * This will only work if the 'Texture' of this 'SpriteSheet' is not 'null'.
	 * 
	 * @param col
	 *            The column the 'Sprite' is at, in the 'SpriteSheet'.
	 * @param row
	 *            The row the 'Sprite' is at, in the 'SpriteSheet'.
	 */
	public void renderSprite(int col, int row) {
		if (texture != null) {
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
}
