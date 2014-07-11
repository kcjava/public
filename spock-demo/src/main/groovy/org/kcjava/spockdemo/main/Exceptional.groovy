package org.kcjava.spockdemo.main

/**
 * This class has simple methods that throw exceptions 
 */
class Exceptional {

	/**
	 * Throws an exception if the parameter is 1 or 2, otherwise returns a string
	 * @param i Upon 1 or 2, throws an exception
	 * @return A string value if no exception is thrown
	 */
	String maybeThrowException(int i) {
		switch(i) {
			case 1:
				throw new FileNotFoundException('could not find it!')
			case 2: 
				throw new IllegalArgumentException('that is not legal!')
		}
		return 'no problem here!'
	}
	
}
