/**
 * The 'gfx' package provides functionality for the graphical representation of objects.
 */
package com.lambda.gfx;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.lambda.LambdaException;

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
	 * Creates a new 'Sprite' with a given size and loads the Image for it
	 * for the path 'path' given as a String.
	 * The 'width' and the 'height' of the 'Sprite' may not be less than 0, otherwise
	 * they will be set to 0.
	 * 
	 * @param path The path to the image to use for the 'Sprite'.
	 * @param width The width of the 'Sprite'.
	 * @param height The height of the 'Sprite'.
	 * 
	 * @throws LambdaException If the path does not point to a valid image, or the
	 * image could not be loaded successfully.
	 */
	public Sprite(String path, int width, int height) throws LambdaException {
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
		
		try {
			this.texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			throw new LambdaException("Could not load image for 'Sprite' object.");
		}
	}
	
	/**
	 * Creates a new 'Sprite' with a given size and a 'Texture'.
	 * The 'width' and the 'height' of the 'Sprite' may not be less than 0, otherwise
	 * they will be set to 0.
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
	 * 
	 * @param x The x-coordinate the 'Sprite' will be rendered at.
	 * @param y The y-coordinate the 'Sprite' will be rendered at.
	 */
	public void render(float x, float y) {
		if (texture != null) {
			GL11.glPushMatrix();
			
			GL11.glTranslatef(x, y, 0);
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
