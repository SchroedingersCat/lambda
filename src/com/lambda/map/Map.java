/**
 * The 'map' package holds everything needed for the correct operation of the 'Map'.
 */
package com.lambda.map;

import java.awt.Rectangle;

import com.lambda.map.tile.Tile;

/**
 * 
 * 
 * @author alex
 *
 */
public class Map {
	
	/**
	 * The 'Tiles' the 'Map' is made out of.
	 */
	protected Tile[][] map;
	
	/**
	 * Creates a new 'Map' with a given size.
	 * 
	 * @param width The amount of 'Tiles' in x - direction.
	 * @param height The amount of 'Tiles' in y - direction.
	 */
	public Map(int width, int height) {
		map = new Tile[width][height];
	}
	
	/**
	 * Gives back the 'Tile' at position (x, y) from the 'Map'.
	 * If the position (x, y) does not exist, 'null' will be returned.
	 * 
	 * @param x The x - position of the 'Tile' in the 'Map'.
	 * @param y The y - position of the 'Tile' in the 'Map'.
	 * @return The 'Tile' at position (x, y).
	 */
	public Tile getTile(int x, int y) {
		if(x >= 0 && x < map.length)
			if(y >= 0 && y < map[x].length)
				return map[x][y];
		
		return null;
	}
	
	/**
	 * Sets the 'Tile' at position (x, y) in the 'Map'.
	 * If the position (x, y) does not exist, nothing will be set.
	 * 
	 * @param tile The 'Tile' to set at (x, y).
	 * @param x The x - position of the 'Tile' in the 'Map'.
	 * @param y The y - position of the 'Tile' in the 'Map'.
	 */
	public void setTile(Tile tile, int x, int y) {
		if(x >= 0 && x < map.length)
			if(y >= 0 && y < map[x].length)
				map[x][y] = tile;
	}

	/**
	 * Renders the whole 'Map' to the screen.
	 */
	public void render() {
		for(Tile[] _t : map) {
			for(Tile t : _t) {
				if(t != null)
					t.render();
			}
		}
	}
	
	/**
	 * Renders a certain area of the 'Map' from (x, y) to (x + width, y + height) to the screen.
	 * 
	 * @param x The start of the area to render in x - direction.
	 * @param y The start of the area to render in y - direction.
	 * @param width The width of the area to render.
	 * @param height The height of the area to render.
	 */
	public void render(int x, int y, int width, int height) {
		this.render(new Rectangle(x, y, width, height));
	}
	
	/**
	 * Renders the area of the 'Map' specified by the 'Rectangle' rec.
	 * 
	 * @param rec The 'Rectangle' that specifies the area to render.
	 */
	public void render(Rectangle rec) {
		for(Tile[] _t : map) {
			for(Tile t : _t) {
				if(t.getPosition().getX() >= rec.x && t.getPosition().getX() <= (rec.x + rec.width)) {
					if(t.getPosition().getY() >= rec.y && t.getPosition().getY() <= (rec.y + rec.height)) {
						if(t != null)
							t.render();
					}
				}
			}
		}
	}
	
	public void update(int delta) {
		for(Tile[] _t : map) {
			for(Tile t : _t) {
				if(t != null)
					t.render();
			}
		}
	}
}
