package org.kcjava.spockdemo.main

import spock.lang.Specification
import org.kcjava.spockdemo.interfaces.SimpleInterface

/**
 * Tests that the methods in the Interdependent class work as expected
 */
class InterdependentSpec extends Specification {

	def 'test that simpleDependentMethod() properly calls the dependent class'() {
		// create an instance of our class to play with
		Interdependent interdependent = new Interdependent()
		// create a mock interface to inject into our class
		SimpleInterface simpleInterfaceMock = Mock(SimpleInterface)
		// inject the mock into our concrete instance
		interdependent.simpleInterface = simpleInterfaceMock 
		
		when:	'calling the simpleDependentMethod()..'
		interdependent.simpleDependentMethod()
		
		then:	'the appropriate method in SimpleInterface is called'
		1 * simpleInterfaceMock.voidReturningMethod()
	}
	
	
	def 'test that calling slightlyMoreComplexDependentMethod() returns expected results'() {
		// create an instance of our class to play with
		Interdependent interdependent = new Interdependent()
		// create a mock interface to inject into our class
		SimpleInterface simpleInterfaceMock = Mock(SimpleInterface)
		// inject the mock into our concrete instance
		interdependent.simpleInterface = simpleInterfaceMock

		when: 	'the slightly more completed interdependent method is called with hello..'
		int output = interdependent.slightlyMoreComplexDependentMethod('hello')
		
		then:	'the output from the dependency class is returned'
		1 * simpleInterfaceMock.intReturningMethod('hello', 'world') >> 2
		output == 2
		
		
		when: 	'the slightly more completed interdependent method is called with hola..'
		output = interdependent.slightlyMoreComplexDependentMethod('hola')
		
		then:	'the depedency class is called differently, but the output is still returned'
		1 * simpleInterfaceMock.intReturningMethod( {it.contains('ola')}, 'mundo' ) >> 7
		output == 7

				
		when: 	'the slightly more completed interdependent method is called with something else..'
		output = interdependent.slightlyMoreComplexDependentMethod('something else')
		
		then:	'the depedency class is called differently, but the output is still returned'
		0 * simpleInterfaceMock.intReturningMethod(_, _)
		output == 0		
	}
	
	
	def 'test that a call to simpleStuffPassthrough() properly passes the call to SimpleStuff'() {
		// create an instance of SimpleStuff that we can spy on
		SimpleStuff simpleStuffSpy = Spy(SimpleStuff)
		SimpleStuff simpleStuffSpy2 = Spy(SimpleStuff, constructorArgs: ['a very useful number!'])
		// create an instance of our class to play with
		Interdependent interdependent = new Interdependent()
		// inject our spy into our concrete instance
		interdependent.simpleStuff = simpleStuffSpy
		
		when:	'the passthrough is called with an int of 1'
		String output = interdependent.simpleStuffPassthrough(1)
		
		then:	'the default message of SimpleStuff is returned'
		1 * simpleStuffSpy.performOddLogic(1)
		output == 'not a useful number'
		
		
		when:	'a new spy of SimpleStuff is created with constructor arguments, then the passthrough is called'
		interdependent.simpleStuff = simpleStuffSpy2
		output = interdependent.simpleStuffPassthrough(1)
		
		then:	'the default message of SimpleStuff is returned'
		1 * simpleStuffSpy2.performOddLogic(1)
		output == 'a very useful number!'
		

		when:	'the passthrough is called, but we override the output from SimpleStuff'
		output = interdependent.simpleStuffPassthrough(1)
		
		then:	'the default message of SimpleStuff is returned'
		1 * simpleStuffSpy2.performOddLogic(1) >> 'the number confuses me'
		output == 'the number confuses me'
		
	}
	
}
