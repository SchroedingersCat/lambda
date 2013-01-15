/**
 * The 'gfx' package provides functionality for the graphical representation of objects.
 */
package com.lambda.gfx;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 * The 'Sprite' holds the representation of an 'Object'. It is what is displayed
 * to the screen, when anything is being rendered.
 * 
 * @author alex
 * 
 */
public class Sprite {

	/**
	 * The width of the 'Sprite'.
	 */
	protected int width;

	/**
	 * The height of the 'Sprite'.
	 */
	protected int height;

	/**
	 * The 'Texture' to draw for this 'Sprite'.
	 */
	protected Texture texture;

	/**
	 * Creates a new 'Sprite' with a given size and a 'Texture'.
	 * The 'width' and the 'height' of the 'Sprite' may not be less than 0.
	 * 
	 * @param texture The 'Texture' the 'Sprite' will use.
	 * @param width The width of the 'Sprite'.
	 * @param height The height of the 'Sprite'.
	 */
	public Sprite(Texture texture, int width, int height) {
		if(width >= 0) {
			this.width = width;
		} else {
			width = 0;
		}
		
		if(height >= 0) {
			this.height = height;
		} else {
			height = 0;
		}
		
		this.texture = texture;
	}

	/**
	 * Renders the 'Sprite' to the screen.
	 * This will only work if the 'texture' of the 'Sprite' is not 'null'.
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
				GL11.glVertex2f(width, 0);

				GL11.glTexCoord2f(1.0f, 1.0f);
				GL11.glVertex2f(width, height);

				GL11.glTexCoord2f(0.0f, 1.0f);
				GL11.glVertex2f(0, height);
			}
			GL11.glEnd();
			GL11.glPopMatrix();
		}
	}

	/**
	 * Executes the 'Sprites' logic.
	 */
	public void update() {

	}

	/**
	 * Gives back the width of the 'Sprite'.
	 * 
	 * @return The width of the 'Sprite'.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gives back the height of the 'Sprite'.
	 * 
	 * @return The height of the 'Sprite'.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the width of the 'Sprite' to 'width' and its height to 'height'.
	 * 
	 * @param width
	 *            The new width of the 'Sprite'.
	 * @param height
	 *            The new height of the 'Sprite'.
	 */
	public void setSize(int width, int height) {
		if (width >= 0 && height >= 0) {
			this.width = width;
			this.height = height;
		}
	}
}
