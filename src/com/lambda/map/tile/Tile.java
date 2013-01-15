/**
 * 
 */
package com.lambda.map.tile;

import org.lwjgl.opengl.GL11;

import com.lambda.gfx.Sprite;
import com.lambda.physics.Vector2f;

/**
 * @author alex
 *
 */
public class Tile {

	/**
	 * The 'Tiles' position in the coordinate system.
	 */
	protected Vector2f position;
	
	/**
	 * The 'Tiles' 'Sprite'.
	 */
	protected Sprite sprite;
	
	/**
	 * Whether an 'Entity' can move through this 'Tile'.
	 */
	protected boolean isBlocking;
	
	public Tile(Sprite sprite, int x, int y) {
		this.sprite = sprite;
		
		this.position = new Vector2f(x, y);
	}

	/**
	 * Gives back the 'Tiles' position.
	 * 
	 * @return The 'Tiles' position.
	 */
	public Vector2f getPosition() {
		return position;
	}

	/**
	 * Gives back the 'Tiles' 'Sprite'.
	 * 
	 * @return The 'Tiles' 'Sprite'.
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * Whether the 'Tile' blocks movement from 'Entities'.
	 * 
	 * @return 'true' if 'Entities' can move through, 'false' otherwise.
	 */
	public boolean isBlocking() {
		return isBlocking;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Vector2f position) {
		this.position = position;
	}

	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @param isBlocking the isBlocking to set
	 */
	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}

	/**
	 * 
	 */
	public void render() {
		GL11.glPushMatrix();
		{
			GL11.glTranslatef(position.getX(), position.getY(), 0);
			sprite.render();
		}
		
		GL11.glPopMatrix();
	}
}
