package org.kcjava.spockdemo.interfaces

/**
 * This interface declares very simple methods
 *
 */
interface SimpleInterface {

	/**
	 * Does not return anything
	 */
	void voidReturningMethod()
	
	/**
	 * This method returns an integer value given 2 different string values
	 * @return An integer given 2 different string values
	 */
	int intReturningMethod(String s1, String s2)
		
}
