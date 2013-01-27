/**
 * The 'entity' package contains everything that has to do with 'Entities'.
 */
package com.lambda.entity;

import com.lambda.graphics.Sprite;
import com.lambda.physics.Vector2f;

/**
 * The 'Entity' is an object in the 'Game'.
 * 
 * @author alex
 *
 */
public abstract class Entity {
	
	/**
	 * A 'Vector2f' that represents the 'Entities' position.
	 */
	protected Vector2f position;
	
	/**
	 * The 'Sprite' that gets render to the screen. 
	 */
	protected Sprite sprite;
	
	/**
	 * Whether the 'Entity' is active, and as thus needs to be rendered and updated.
	 */
	protected boolean isActive;
	
	/**
	 * The 'EntityHandler' that manages the 'Entity'.
	 */
	protected EntityHandler entityHandler;
	
	/**
	 * Creates a new 'Entity' with the give coordinates.
	 * 
	 * @param x The x-coordinate of the 'Entity'.
	 * @param y The y-coordinate of the 'Entity'.
	 */
	public Entity(float x, float y) {
		position = new Vector2f(x, y);
	}
	
	/**
	 * Initializes everything needed for the 'Entity' to work.
	 */
	public void init() {
	
	}
	
	/**
	 * Renders the 'Sprite' 
	 */
	public void render() {
		if(sprite != null) {
			sprite.render(position.getX(), position.getY());
		}
	}
	
	/**
	 * Executes the 'Entities' logic.
	 * 
	 * @param delta The difference in time between processing two frames.
	 */
	public void update(double delta) {
	}

	/**
	 * Gives back the 'Vector2f' containg the position of the 'Entity'.
	 * 
	 * @return The position of the 'Entity'.
	 */
	public Vector2f getPosition() {
		return position;
	}

	/**
	 * Gives back the 'Sprite' of this 'Entity'.
	 * 
	 * @return The 'Sprite'.
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * Tells whether the 'Entity' is active.
	 * 
	 * @return 'true' if the 'Entity' is active, 'false' otherwise.
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Gives back the 'EntityHandler' the 'Entity' is registered at.
	 * 
	 * @return The 'EntityHandler' the 'Entity' is registered at.
	 */
	public EntityHandler getEntityHandler() {
		return entityHandler;
	}

	/**
	 * Sets the position of the 'Entity' to the 'Vector2f' position.
	 * This will only work if the 'Vector2f' position is not 'null'.
	 * 
	 * @param position The new position of the 'Entity'.
	 */
	public void setPosition(Vector2f position) {
		if(position != null) {
			this.position = position;
		}	
	}

	/**
	 * Sets the 'Sprite' of the 'Entity' to 'sprite'.
	 * This will only work if the 'Sprite' 'sprite' is not 'null'.
	 * 
	 * @param sprite The 'Sprite' to set.
	 */
	public void setSprite(Sprite sprite) {
		if(sprite != null) {
			this.sprite = sprite;
		}
	}

	/**
	 * Changes the 'isActive' flag of the 'Entity'.
	 * 
	 * @param isActive 'true' to enable, 'false' otherwise.
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Sets the 'EntityHandler' that handles the 'Entity' to 'entityHandler'.
	 * This will only work if the specified 'EntityHandler' is not 'null'.
	 * 
	 * @param entityHandler The 'EntityHandler' that handles the 'Entity'.
	 */
	public void setEntityHandler(EntityHandler entityHandler) {
		if(entityHandler != null) {
			this.entityHandler = entityHandler;
		}
	}
}