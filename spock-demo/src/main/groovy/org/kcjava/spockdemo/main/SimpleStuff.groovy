package org.kcjava.spockdemo.main

/**
 * This is a simple class that does not do very useful stuff
 */
class SimpleStuff {

	// simple property
	String defaultMessage = 'not a useful number'
	
	/**
	 * Default constructor
	 */
	SimpleStuff() { super() }
	
	/**
	 * Constructor that takes a message value
	 * @param message The message to use as the default message when performing logic
	 */
	SimpleStuff(String message) {
		defaultMessage = message
	}
	
	/**
	 * Returns a string based on the input integer
	 * @param i The integer that determines what gets returned
	 * @return A possibly useful string value
	 */
	String performOddLogic(int i) {
		if(i == 0) {
			return 'zero'
		}
		if(i % 2 == 0) {
			return 'even'
		}
		if(i % 3 == 0) {
			return 'divisible by 3'
		}
		return defaultMessage
	}
	
	/**
	 * A basic static method that calls performOddLogic on a newly created SimpleStuff instance.
	 * @param i The integer that determines what gets returned
	 * @return A possibly useful string value
	 */
	static String aStaticMethod(int i) {
		new SimpleStuff().performOddLogic(i)
	}
}
