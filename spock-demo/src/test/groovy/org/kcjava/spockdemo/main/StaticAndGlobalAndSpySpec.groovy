package org.kcjava.spockdemo.main;

import spock.lang.Specification;

public class StaticAndGlobalAndSpySpec extends Specification {

	
	def 'test that SimpleStuff.aStaticMethod() returns the default message'() {
		when:	'SimpleStuff.someStaticMethod() gets called with the default values'
		String output = SimpleStuff.aStaticMethod(1)
		
		then:	'the default message is returned'
		output == 'not a useful number'
	}
	

	def 'test that SimpleStuff.someStaticMethod() can be overridden'() {
		GroovySpy(SimpleStuff, global: true)
		
		when:	'SimpleStuff.someStaticMethod() gets called with the default values'
		String output = SimpleStuff.aStaticMethod(1)
				
		then:	'the default message is returned'
		1 * SimpleStuff.aStaticMethod(1) >> 'a different message'
		output == 'a different message'
	}
	
	
	def 'test that Interdependent can spy on itself and change behavior'() {
		// create a spy for the SimpleStuff instance
		SimpleStuff simpleStuffSpy = Spy(SimpleStuff)
		// create a spy on our instance
		Interdependent interdependentSpy = Spy(Interdependent)
		interdependentSpy.simpleStuff = simpleStuffSpy		
		
		when:	'interdependentPassthrough() is called with all default values, then the expected output is returned'
		int output = interdependentSpy.interdependentPassthrough(1)
						
		then:	'the overridden message is returned'
		1 * simpleStuffSpy.performOddLogic(1)
		1 * interdependentSpy.slightlyMoreComplexDependentMethod('not a useful number')
		output == 0
		
		
		when:	'interdependentPassthrough() is called but is overridden'
		output = interdependentSpy.interdependentPassthrough(1)
						
		then:	'the overridden message is returned'
		1 * simpleStuffSpy.performOddLogic(1)
		1 * interdependentSpy.slightlyMoreComplexDependentMethod(_) >> 1
		output == 1
	}
	
		

}
