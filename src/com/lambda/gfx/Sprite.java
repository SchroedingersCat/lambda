/**
 * The 'gfx' package provides functionality for the graphical representation of objects.
 */
package com.lambda.gfx;

import java.awt.Rectangle;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 * The 'Sprite' holds the representation of an 'Object'.
 * It is what is displayed to the screen, when anything is being
 * rendered.
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
	 * The 'Sprites' border, as a 'Rectangle'.
	 */
	protected Rectangle border;
	
	/**
	 * Creates a new 'Sprite' with a given size and a 'Texture'.
	 * 
	 * @param width
	 * @param height
	 */
	public Sprite(Texture texture, int width, int height) {
		this.width = width;
		this.height = height;
		
		this.texture = texture;
		
		this.border = new Rectangle(width, height);
	}
	
	/**
	 * Renders the 'Sprite' to the screen.
	 */
	public void render() {
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
	
	/**
	 * Executes the 'Sprites' logic.
	 */
	public void update() {
		
	}

	/**
	 * Gives back the border of the 'Sprite' as a 'Rectangle'.
	 * 
	 * @return The border of the 'Sprite'.
	 */
	public Rectangle getBorder() {
		return border;
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
	 * Sets the width of the 'Sprite'.
	 * 
	 * @param width The width of the 'Sprite' to set.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Set the height of the 'Sprite'.
	 * 
	 * @param height The height of the 'Sprite' to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
