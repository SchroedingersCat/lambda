/**
 * The 'entity' package contains everything that has to do with 'Entities'.
 */
package com.lambda.entity;

import java.util.ArrayList;
import java.util.Random;

/**
 * The 'EntityHandler' handles all 'Entities' in the actual context. It's easily
 * possible to manage 'Entities' using this class.
 * 
 * @author alex
 * 
 */
public class EntityHandler {

	/**
	 * Stores all entities the 'EntityHandler' manages.
	 */
	protected ArrayList<Entity> entityList;
	
	/**
	 * Contains 'Entities' that have been removed from the list of active entities,
	 * and are waiting for final removal.
	 */
	protected ArrayList<Entity> zombieList;
	
	/**
	 * Creates a new 'EntityHandler' object and initializes all needed values.
	 */
	public EntityHandler() {
		entityList = new ArrayList<Entity>();
		zombieList = new ArrayList<Entity>();
	}
	
	/**
	 * Prints a String representation of all 'Entities' in the 'EntityHandler' to the console.
	 */
	public void dump() {
		for(Entity e : entityList) {
			System.out.println(e);
		}
	}
	
	/**
	 * Registers an 'Entity' in the 'EntityHandler'.
	 * 
	 * @param e
	 */
	public void registerEntity(Entity e) {
		entityList.add(e);
	}
	
	/**
	 * Gives back the Entity with the Identifier id.
	 * 
	 * @param id The ID the 'Entity' has.
	 * @return The corresponding 'Entity' or 'null' upon failure.
	 */
	public Entity getEntity(long id) {
		Entity e = null;
		
		for(Entity t : entityList) {
			if(t.id == id) {
				e = t;
				break;
			}
		}
		
		return e;
	}

	/**
	 * Gives back the list of 'Entities' managed by this 'EntityHandler'.
	 * 
	 * @return An ArrayList of 'Entities' containing every 'Entity' handled by the 'EntityHandler'.
	 */
	public ArrayList<Entity> getAll() {
		return entityList;
	}
	
	/**
	 * Removes an 'Entity' from the context of the 'EntityHandler'.
	 * 
	 * @param e The 'Entity' that has to be removed.
	 */
	public void removeEntity(Entity e) {
		removeEntity(e.id);
	}
	
	/**
	 * Removes an 'Entity' from the context of the 'EntityHandler'.
	 * 
	 * @param id The ID of the 'Entity' that has to be removed.
	 */
	public void removeEntity(long id) {
		for(int i = entityList.size() - 1; i >= 0; i--) {
			if(entityList.get(i).id == id) {
				entityList.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Removes all 'Entities' from the 'EntityHandler'.
	 */
	public void removeAll() {
		entityList.clear();
	}
	
	/**
	 * Calls the 'render'-method for every 'Entity' the 'EntityHandler' manages.
	 */
	public void render() {
		for(Entity e : entityList) {
			e.render();
		}
	}
	
	/**
	 * Calls the 'update'-method for every 'Entity' the 'EntityHandler' manages.
	 * 
	 * @param delta
	 */
	public void update(int delta) {
		for(Entity e : entityList) {
			if(e.isActive())
				e.update(delta);
			else
				zombieList.add(e);
		}
		
		for(Entity e : zombieList) {
			entityList.remove(e);
		}
		
		if(!zombieList.isEmpty())
			zombieList.clear();
	}
	
	/**
	 * Sets the 'EntityHandler' 'eh' as the current 'EntityHandler' for 'Entities'.
	 * 
	 * @param eh The new 'EntityHandler'.
	 */
	public static void registerEntityHandler(EntityHandler eh) {
		Entity.entityHandler = eh;
	}

	/**
	 * Gives the next ID that has not already been used in the List list.
	 * 
	 * @return The next ID that has not been used.
	 */
	public static long getNextAvailableID(ArrayList<Entity> list) {
		Random random = new Random();
		long id = random.nextLong();

		if (!list.isEmpty()) {
			boolean isAvailable = false;
			while (!isAvailable) {
				isAvailable = true;
				for (Entity e : list) {
					if (e.id == id)
						isAvailable = false;
				}
			}
		}

		return id;
	}
}

