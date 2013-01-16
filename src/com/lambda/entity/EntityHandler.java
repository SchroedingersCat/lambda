/**
 * The 'entity' package contains everything that has to do with 'Entities'.
 */
package com.lambda.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * The 'EntityHandler' handles the updating and rendering of 'Entities'.
 * 
 * @author alex
 *
 */
public class EntityHandler {
	
	/**
	 * A 'HashMap' that maps 'Entities' to their IDs.
	 */
	protected Map<Integer, Entity> entityMap;
	
	/**
	 * Creates a new 'EntityHandler'.
	 */
	public EntityHandler() {
		this.entityMap = new HashMap<Integer, Entity>();
	}
	
	/**
	 * Registers the 'Entity' at the 'EntityHandler'.
	 * The 'Entity' 'e' may not be 'null', else 'null' will be returned.
	 * 
	 * @param e The 'Entity' to register.
	 * @param id The ID the 'Entity' will be identified with.
	 */
	public void registerEntity(Entity e, int id) {
		if(e != null) {
			entityMap.put(id, e);
		}
	}
	
	/**
	 * Gives back the 'Entity' with the ID 'id'.
	 * If the 'Entity' with the ID 'id' doesn't exist, 'null' will be
	 * returned.
	 * 
	 * @param id The ID of the 'Entity'.
	 * @return The 'Entity' with the 'ID' 'id'.
	 */
	public Entity getEntity(int id) {
		Entity e = null;
		
		if(entityMap.containsKey(id)) {
			e = entityMap.get(id);
		}
		
		return e;
	}
	
	/**
	 * Gives back the 'Map' that contains all registered 'Entities'.
	 * 
	 * @return The 'Map' containg the 'Entities'.
	 */
	public Map<Integer, Entity> getAll() {
		return entityMap;
	}
	
	/**
	 * Removes an 'Entity' with the ID 'id' from the 'HashMap'.
	 * 
	 * @param id The ID of the 'Entity' to remove.
	 */
	public void removeEntity(int id) {
		if(entityMap.containsKey(id)) {
			entityMap.remove(id);
		}
	}
	
	/**
	 * Clears the 'HashMap' of every 'Entity'.
	 */
	public void clear() {
		entityMap.clear();
	}
	
	/**
	 * Calls the 'init()'-method for every 'Entity' in the 'HashMap'.
	 */
	public void init() {
		for(Entity e : entityMap.values()) {
			e.init();
		}
	}
	
	/**
	 * Calls the 'render()'-method for every 'Entity' in the 'HashMap'.
	 */
	public void render() {
		for(Entity e : entityMap.values()) {
			e.render();
		}
	}
	
	/**
	 * Calls the 'update()'-method for every 'Entity' in the 'HashMap'.
	 * 
	 * @param delta The difference in time between the processing of two frames.
	 */
	public void update(double delta) {
		for(Entity e : entityMap.values()) {
			e.update(delta);
		}
	}
	
	/**
	 * Calculates a random ID that has not been used in the 'Map' map yet.
	 * 
	 * @param map The 'Map' to find the ID for.
	 * @return The new unused ID.
	 */
	public static int nextID(Map<Integer, Entity> map) {
		int id = -1;
		
		Random random = new Random();
		do {
			id = random.nextInt();
		} while(map.containsKey(id));
		
		return id;
	}
}

