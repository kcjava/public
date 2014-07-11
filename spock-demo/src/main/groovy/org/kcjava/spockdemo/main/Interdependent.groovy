package org.kcjava.spockdemo.main

import org.kcjava.spockdemo.interfaces.SimpleInterface

/**
 * This class has a dependency on the SimpleInterface, and also for SimpleStuff
 */
class Interdependent {

	/**
	 * Injected resource
	 */
	SimpleInterface simpleInterface
	
	/**
	 * Injected resource
	 */
	SimpleStuff simpleStuff
	
	/**
	 * This method calls SimpleInterface.voidReturningMethod()
	 */
	void simpleDependentMethod() {
		// make a call to the interface
		simpleInterface.voidReturningMethod()
	}
	
	/**
	 * This method calls SimpleInterface.intReturningMethod
	 */
	int slightlyMoreComplexDependentMethod(String s1) {
		if(s1 == 'hello') {
			return simpleInterface.intReturningMethod(s1, 'world')
		}
		if(s1 == 'hola') {
			return simpleInterface.intReturningMethod(s1, 'mundo')
		}
		return 0
	}

	/**
	 * Returns the output after passing through the input to SimpleStuff
	 * @param i A basic int
	 * @return The string value from calling SimpleStuff.performOddLogic()
	 */
	String simpleStuffPassthrough(int i) {
		simpleStuff.performOddLogic(i)
	}
	
	
	/**
	 * Returns the output after passing through the input to the static method on SimpleStuff
	 * @param i A basic int
	 * @return The string value from calling SimpleStuff.aStaticMethod()
	 */
	int  interdependentPassthrough(int i) {
		slightlyMoreComplexDependentMethod(simpleStuff.performOddLogic(i))		
	}
	
	
}
