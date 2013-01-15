/**
 * 
 */
package com.lambda.entity.mob;

import com.lambda.entity.Entity;
import com.lambda.physics.Vector2f;

/**
 * The 'Mob' is a non-player character (NPC). A 'Mob' can be an enemy, as well as 
 * an ally.
 * 
 * @author alex
 *
 */
public abstract class Mob extends Entity {

	public Mob(int x, int y) {
		super();
		
		position = new Vector2f(x, y);
	}
}
