/**
 * The 'physics' package contains physical computations, such as collisions.
 */
package com.lambda.physics;

/**
 * The 'Vector2f' is the implementation of a physical vector. It values are up
 * to interpretation.
 * 
 * @author alex
 * 
 */
public class Vector2f {

	/**
	 * The first component of the ordered pair describing this 'Vector2f'.
	 */
	protected float x = 0.0f;

	/**
	 * The second component of the ordered pair describing this 'Vector2f'.
	 */
	protected float y = 0.0f;

	/**
	 * Creates a new 'Vector2f' with the given values. The values may not be
	 * 'Infinity' or 'NaN', else they will be set to 0.0f.
	 * 
	 * @param x
	 *            The first component of the ordered pair describing this
	 *            'Vector2f'.
	 * @param y
	 *            The second component of the ordered pair describing this
	 *            'Vector2f'.
	 */
	public Vector2f(float x, float y) {
		if (isValid(x)) {
			this.x = x;
		}

		if (isValid(y)) {
			this.y = y;
		}
	}

	/**
	 * Gives back a new 'Vector2f' object with the same values as the one the
	 * method was invoked on.
	 * 
	 * @return A new 'Vector2f' with the same values.
	 */
	public Vector2f clone() {
		return new Vector2f(x, y);
	}

	/**
	 * Copies the values from the 'Vector2f' 'vec' to the one the method was
	 * invoked on.
	 * 
	 * @param vec
	 *            The 'Vector2f' to copy from.
	 */
	public void copy(Vector2f vec) {
		if (vec != null) {
			this.x = vec.getX();
			this.y = vec.getY();
		}
	}

	/**
	 * Check if two 'Vector2f' objects are equal, meaning they have the same
	 * values. This will only work if the 'Vector2f' vec is not 'null'.
	 * 
	 * @param vec
	 *            The 'Vector2f' to compare with.
	 * @return 'true' if they are considered equal, 'false' otherwise.
	 */
	public boolean equals(Vector2f vec) {
		boolean equal = false;

		if (vec != null) {
			if (x == vec.getX() && y == vec.getY()) {
				equal = true;
			}
		}

		return equal;
	}
	
	/**
	 * Adds one 'Vector2f' to another 'Vector2f'.
	 * If the 'Vector2f' v is 'null', 'null' will be returned.
	 * 
	 * @param v The 'Vector2f' to add.
	 * @return A new 'Vector2f' containing the sum of the values of the two 'Vector2f' objects.
	 */
	public Vector2f add(Vector2f v) {
		Vector2f n = null;
		
		if(v != null) {
			n = new Vector2f(x + v.getX(), y + v.getY());
		}
		
		return n;
	}
	
	/**
	 * Subtracts one 'Vector2f' from another 'Vector2f'.
	 * If the 'Vector2f' v is 'null', 'null' will be returned.
	 * 
	 * @param v The 'Vector2f' to subtract from.
	 * @return A new 'Vector2f' containing the difference of the values of the two 'Vector2f' objects.
	 */
	public Vector2f subtract(Vector2f v) {
		Vector2f n = null;
		
		if(v != null) {
			n = new Vector2f(x - v.getX(), y - v.getY());
		}
		
		return n;
	}
	
	/**
	 * Multiplies one 'Vector2f' with another 'Vector2f'.
	 * If the 'Vector2f' v is 'null', 'null' will be returned.
	 * 
	 * @param v The 'Vector2f' to multiply with.
	 * @return A new 'Vector2f' containing the product of the values of the two 'Vector2f' objects.
	 */
	public Vector2f multiply(Vector2f v) {
		Vector2f n = null;
		
		if(v != null) {
			n = new Vector2f(x * v.getX(), y * v.getY());
		}
		
		return n;
	}
	
	/**
	 * Divides one 'Vector2f' by another 'Vector2f'.
	 * If one of the 'Vector2f's values is 0 or the 'Vector2f' 'v'
	 * is 'null' will be returned.
	 * 
	 * @param v The 'Vector2f' to divide by.
	 * @return A new 'Vector2f' containing the quotient of the values of the two 'Vector2f' objects.
	 */
	public Vector2f divide(Vector2f v) {
		Vector2f n = null;
		
		if(v != null) {
			if(x != 0 && y != 0) {
				n = new Vector2f(x / v.getX(), y / v.getY());
			}
		}
		
		return n;
	}

	/**
	 * Checks if the component 'c' of the 'Vector2f' is a valid value.
	 * 
	 * @param c
	 *            The component of the 'Vector2f' to check.
	 * @return 'true' if the value is not 'Infinity' nor 'NaN', 'false'
	 *         otherwise.
	 */
	public boolean isValid(float c) {
		boolean valid = false;

		if (!Float.isInfinite(c) && !Float.isNaN(c)) {
			valid = true;
		}

		return valid;
	}

	/**
	 * Gives back the first component of the 'Vector2f' object.
	 * 
	 * @return The 'x' value of the 'Vector2f'.
	 */
	public float getX() {
		return x;
	}

	/**
	 * Gives back the second component of the 'Vector2f' object.
	 * 
	 * @return The 'y' value of the 'Vector2f'.
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the components of the 'Vector2f' object to 'x' and 'y'.
	 * The 'x' and 'y' values may not be 'Infinity' nor 'NaN'.
	 * 
	 * @param x The new value for the first component of the 'Vector2f'.
	 * @param y The new value for the second component of the 'Vector2f'.
	 */
	public void set(float x, float y) {
		if(isValid(x)) {
			this.x = x;
		}
		
		if(isValid(y)) {
			this.y = y;
		}
	}
}