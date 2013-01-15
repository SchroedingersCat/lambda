/**
 * The 'entity' package contains everything that has to do with 'Entities'.
 */
package com.lambda.entity;

import static org.lwjgl.opengl.GL11.*;

import com.lambda.gfx.Sprite;
import com.lambda.physics.Vector2f;

/**
 * The 'Entity' is a representation of an 'Object' in the Game.
 * 'Entities' can be rendered to the screen and updated.
 * 
 * @author alex
 *
 */
public abstract class Entity {

	/**
	 * The 'Entities' unique identifier.
	 */
	public final long id;
	
	/**
	 * The graphical representation of the 'Entity'.
	 */
	protected Sprite sprite;
	
	/**
	 * Holds the 'Entity's position (X - / Y - Coordinate) as a 'Vector2f'.
	 */
	protected Vector2f position;
	
	/**
	 * Indicates if the 'Entity' is still considered 'active' and as thus
	 * needs to keep being updated and rendered.
	 */
	protected boolean isActive;
	
	/**
	 * A reference to the 'EntityHandler' of the actual context.
	 */
	public static EntityHandler entityHandler;	

	/**
	 * Creates a new 'Entity'.
	 */
	public Entity() {
		if(entityHandler == null)
			throw new RuntimeException("No EntityHandler.");
		
		// Get an ID from the current EntityHandler, then register.
		
		this.id = EntityHandler.getNextAvailableID(entityHandler.getAll());
		entityHandler.registerEntity(this);
		
		position = new Vector2f();
		isActive = true;
	}
	
	/**
	 * Renders the 'Entity' by calling the 'render()'-method for its 'Sprite'.
	 */
	public void render() {
		glPushMatrix();
		{
			glTranslatef((float) position.getX(), position.getY(), 0.0f);
			sprite.render();
		}
		glPopMatrix();
	}
	
	/**
	 * Updates the 'Entity's logic.
	 * 
	 * @param delta The difference in time between two renderings.
	 */
	public void update(int delta) {
	}
	
	/**
	 * Tells whether the 'Entity' is active.
	 * 
	 * @return 'true' if active, 'false' otherwise.
	 */
	public boolean isActive() {
		return isActive;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entity [id=" + id + ", sprite=" + sprite + ", position="
				+ position + ", isActive=" + isActive + "]";
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
	 * Gives back the 'Vector2f' of this 'Entity',
	 * that contains it's position.
	 * 
	 * @return The 'Entities' position.
	 */
	public Vector2f getPosition() {
		return position;
	}

	/**
	 * Sets the 'Entities' 'Sprite' to sprite.
	 * 
	 * @param sprite The 'Sprite' to set to.
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Sets the 'Entities' position to the 'Vector2f' position.
	 * 
	 * @param position The position to set the 'Entity' to.
	 */
	public void setPosition(Vector2f position) {
		this.position.copy(position);
	}
}