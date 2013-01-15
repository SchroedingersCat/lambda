/**
 * 
 */
package com.lambda;

/**
 * The 'LambdaException' is an 'Exception' used in the 'Lambda' game engine, to indicate certain errors.
 * Most errors can be identified by their description and error code.
 * 
 * @author alex
 *
 */
public class LambdaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new 'LambdaException' with a message.
	 * 
	 * @param message The message the 'Exception' delivers.
	 */
	public LambdaException(String message) {
		super(message);
	}
}
