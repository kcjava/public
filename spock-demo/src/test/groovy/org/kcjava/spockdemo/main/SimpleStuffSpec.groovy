package org.kcjava.spockdemo.main

import spock.lang.Specification
import spock.lang.Unroll;

/**
 * This class tests that the methods in the SimpleStuff class work as expected
 */
class SimpleStuffSpec extends Specification {

	@Unroll
	def 'test_that_performOddLogic_behaves_as_expected [#input, #output]'() {		
		given:
		SimpleStuff ss = new SimpleStuff()		
		
		expect:
		ss.performOddLogic(input) == output 		
		
		where:
		input 	| output
		0		| 'zero'
		1		| 'not a useful number'
		2		| 'even'
		3		| 'divisible by 3'
		4		| 'event'
		5		| 'not a useful number'
		6		| 'even'		
	}
	
}
