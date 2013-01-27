/**
 * 
 */
package com.lambda.map;

import java.awt.Rectangle;

import com.lambda.map.Tile;
import com.lambda.physics.Vector2f;

/**
 * The 'Map' is a storage for 'Tiles'. The rendering of the 'Map' can be
 * optimized by setting a 'clipping range', which will determine which 'Tiles'
 * to render.
 * 
 * @author alex
 * 
 */
public class Map {

	/**
	 * The 'Tiles' the 'Map' stores.
	 */
	protected Tile[][] tiles;

	/**
	 * The 'Area' the clipping of the 'Map' will work for.
	 */
	protected Rectangle clippingArea;

	/**
	 * Creates a new 'Map' with a certain amount of 'Tiles' in x- and in
	 * y-direction.
	 * 
	 * @param width
	 *            The number of 'Tiles' in the x-direction.
	 * @param height
	 *            The number of 'Tiles' in the y-direction.
	 */
	public Map(int width, int height) {
		tiles = new Tile[width][height];
	}

	/**
	 * Gives back the instance of a certain 'Tile' in the 'Map' at the location
	 * (x / y). If the coordinates are negative, or do not exist in the 'Map'
	 * 'null' will be returned.
	 * 
	 * @param x
	 *            The x-coordinate of the 'Tile' in the 'Map'.
	 * @param y
	 *            The y-coordinate of the 'Tile' in the 'Map'.
	 * @return The 'Tile' at (x / y) or 'null' in case of an error.
	 */
	public Tile getTile(int x, int y) {
		Tile tile = null;

		if (x >= 0 && y >= 0 && x < getWidth() && y < getHeight()) {
			tile = tiles[x][y];
		}

		return tile;
	}

	/**
	 * Renders all 'Tiles' of the 'Map' in the order they are stored in the
	 * 'Map'. If a clipping area has been set, every 'Tile' outside of it, will
	 * not be rendered. Additionally an offset for the rendering can be
	 * specified.
	 * 
	 * @param xOffset
	 *            The offset in x-direction for the rendering.
	 * @param yOffset
	 *            The offset in y-direction for the rendering.
	 */
	public void render(float xOffset, float yOffset) {
		for (Tile[] _t : tiles) {
			for (Tile t : _t) {
				if (t != null) {
					Rectangle rec = null;
					boolean render = false;
					if (clippingArea != null) {
						rec = new Rectangle(
								(int) (t.getPosition().getX() + xOffset),
								(int) (t.getPosition().getY() + yOffset),
								(int) (t.getSprite().getWidth() + xOffset),
								(int) (t.getSprite().getHeight() + yOffset));
						if (rec.intersects(clippingArea)) {
							render = true;
						}
					} else {
						render = true;
					}

					if (render == true) {
						t.setPosition(t.getPosition().add(
								new Vector2f(xOffset, yOffset)));
						t.render();
						t.setPosition(t.getPosition().subtract(
								new Vector2f(xOffset, yOffset)));
					}
				}
			}
		}
	}

	/**
	 * Updates every 'Tile' in the 'Map'.
	 * 
	 * @param delta
	 *            The difference in time between the processing of two frames.
	 */
	public void update(double delta) {
		for (Tile[] _t : tiles) {
			for (Tile t : _t) {
				if (t != null) {
					t.update(delta);
				}
			}
		}
	}

	/**
	 * Sets the 'Tile' in the 'Map' at the location (x / y) to the 'Tile'
	 * 'tile'. If 'tile' is 'null', nothing will happen.
	 * 
	 * @param tile
	 *            The 'Tile' to set in the 'Map' at the location (x / y).
	 * @param x
	 *            The x-coordinate of the 'Tile' in the 'Map'.
	 * @param y
	 *            The y-coordinate of the 'Tile' in the 'Map'.
	 */
	public void setTile(Tile tile, int x, int y) {
		if (tile != null) {
			if (x >= 0 && y >= 0 && x < getWidth() && y < getHeight()) {
				tiles[x][y] = tile;
			}
		}
	}

	/**
	 * Gives back the width of the 'Map'.
	 * 
	 * @return The amount of 'Tiles' in x-direction.
	 */
	public int getWidth() {
		int width = 0;
		if (tiles != null) {
			width = tiles.length;
		}
		return width;
	}

	/**
	 * Gives back the height of the 'Map'.
	 * 
	 * @return The amount of 'Tiles' in y-direction.
	 */
	public int getHeight() {
		int height = 0;
		if (tiles != null) {
			height = tiles[0].length;
		}
		return height;
	}

	/**
	 * Gives back the 'Rectangle' that represents the clipping area.
	 * 
	 * @return The area the clipping is active for.
	 */
	public Rectangle getClippingArea() {
		return clippingArea;
	}

	/**
	 * Sets the area the clipping work in to 'clippingArea'. This only works, if
	 * the 'Rectangle' 'clippingArea' is not 'null'.
	 * 
	 * @param clippingArea
	 *            The area the clipping will be active for.
	 */
	public void setClippingArea(Rectangle clippingArea) {
		if (clippingArea != null) {
			this.clippingArea = clippingArea;
		}
	}
}
