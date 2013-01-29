/**
 * 
 */
package com.lambda.map;

import com.lambda.graphics.Sprite;
import com.lambda.physics.Vector2f;

/**
 * The 'Tile' is a re-occurring piece of 'Map', that can be reused over and over again.
 * 
 * @author alex
 *
 */
public abstract class Tile {
	
	/**
	 * The position of the 'Tile' on the screen.
	 */
	protected Vector2f position;
	
	/**
	 * The 'Sprite' that gets rendered for this 'Tile'.
	 */
	protected Sprite sprite;
	
	/**
	 * Inddicates whether an 'Entity' can pass thru this 'Tile'.
	 */
	protected boolean isSolid = true;
	
	/**
	 * Creates a new Tile with the coordinates (x / y).
	 * 
	 * @param x The x-coordinate of the 'Tile'.
	 * @param y The y-coordinate of the 'Tile'.
	 */
	public Tile(float x, float y) {
		this.position = new Vector2f(x, y);
	}
	
	/**
	 * Renders the 'Tiles' 'Sprite' to the screen.
	 * Only if the 'Sprite' is not 'null'.
	 */
	public void render() {
		if(sprite != null) {
			sprite.render(position.getX(), position.getY());
		}
	}

	/**
	 * Updates the 'Tiles' logic.
	 */
	public void update(double delta) {
	}

	/**
	 * @return the position
	 */
	public Vector2f getPosition() {
		return position;
	}

	/**
	 * @return the sprite
	 */
	public Sprite getSprite() {
		return sprite;
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
	 * @return the isSolid
	 */
	public boolean isSolid() {
		return isSolid;
	}

	/**
	 * @param isSolid the isSolid to set
	 */
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
}
