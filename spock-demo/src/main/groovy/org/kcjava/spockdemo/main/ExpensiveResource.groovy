package org.kcjava.spockdemo.main

/**
 * This class represents an expensive resource to create
 */
class ExpensiveResource {

	// flags if this resource is ready or not to be used
	boolean ready = false
	
	
	/**
	 * Performs initialization 
	 */
	void initExpensively() {
		// do something that you wouldn't want to do over and over, like
		//create connections to external resources
		ready = true
	}
	
	/**
	 * Closes down the resource
	 */
	void close() {
		ready = false
	}
	
	/**
	 * Does something potentially useful
	 */
	String performSomeWork() {
		if(!ready) {
			throw new Exception('not ready for work')
		}
		return 'Ok, here is some useful work.'
	} 
}
