/**
 * The 'physics' package contains physical computations, such as collisions.
 */
package com.lambda.physics;

/**
 * A implementation of a physical Vector. Its values can either be interpreted as coordinates,
 * or as forces.
 * 
 * @author alex
 *
 */
public class Vector2f {
	
	/**
	 * The 'Vector2f's x value.
	 */
	private float x;
	
	/**
	 * The 'Vector2f's y value.
	 */
	private float y;
	
	/**
	 * Creates a new 'Vector2f' object, with the default values of 0.00.
	 */
	public Vector2f() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	/**
	 * Creates a new 'Vector2f' object, with the specified values.
	 * 
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Clones the current 'Vector2f' object and gives back a new one with the same values.
	 * 
	 * @return A new 'Vector2f' object, with the same values as the current one.
	 */
	public Vector2f clone() {
		Vector2f vec = new Vector2f();
		vec.copy(this);
		return vec;
	}
	
	/**
	 * Copies another 'Vector2f' objects values and copies them onto the current one.
	 * 
	 * @param vec The 'Vector2f' object the values are copied from.
	 */
	public void copy(Vector2f vec) {
		this.x = vec.x;
		this.y = vec.y;
	}
	
	/**
	 * Compares two 'Vector2f' objects. If they reference the same values they are considered 'equal'.
	 * 
	 * @return 'true' if they are equal, 'false' otherwise.
	 */
	public boolean equals(Vector2f vec) {
		boolean equal = false;
		
		if(vec != null) {
			if(this.x == vec.x && this.y == vec.y)
				equal = true;
		}
		
		return equal;
	}

	/**
	 * Adds the current 'Vector2f' to another 'Vector2f' vec.
	 * 
	 * @param vec The second 'Vector2f' to be added.
	 * @return A new 'Vector2f' containing the sum of the values.
	 */
	public Vector2f add(Vector2f vec) {
		return new Vector2f(x + vec.x, y + vec.y);
	}
	
	/**
	 * Subtracts the current 'Vector2f' from another 'Vector2f' vec.
	 * 
	 * @param vec The 'Vector2f' to be subtracted.
	 * @return A new 'Vector2f' containing the difference of the values.
	 */
	public Vector2f subtract(Vector2f vec) {
		return new Vector2f(x - vec.x, y - vec.y);
	}
	
	/**
	 * Multiplies the current 'Vector2f' and another 'Vector2f' vec.
	 * 
	 * @param vec The 'Vector2f' to be multiplied by.
	 * @return A new 'Vector2f' containing the product of the values.
	 */
	public Vector2f multiply(Vector2f vec) {
		return new Vector2f(x * vec.x, y * vec.y);
	}
	
	/**
	 * Gives back a String-representation of the 'Vector2f'.
	 * 
	 * @return The String that represents the 'Vector2f'.
	 */
	public String toString() {
		return "[" + x + "][" + y + "]";
	}

	/**
	 * Gives back the current x value of the 'Vector2f'.
	 * 
	 * @return The x value of the 'Vector2f'.
	 */
	public float getX() {
		return x;
	}

	/**
	 * Gives back the current y value of the 'Vector2f'.
	 * 
	 * @return The y value of the 'Vector2f'.
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the x value of the 'Vector2f'.
	 * 
	 * @param x The x value to set.
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Sets the y value of the 'Vector2f'.
	 * 
	 * @param y The y value to set.
	 */
	public void setY(float y) {
		this.y = y;
	}
}