package org.kcjava.spockdemo.main;

import spock.lang.Specification;

/**
 * Tests that the method in the Exceptional class works as expected
 */
public class ExceptionalSpec extends Specification {

	def 'test that maybeThrowException() throws the proper exceptions'() {
		Exceptional exceptional = new Exceptional()
		
		when:
		String output = exceptional.maybeThrowException(1)
		
		then:
		//notThrown(FileNotFoundException)	
		//notThrown(IOException)
		//thrown(FileNotFoundException)
		thrown(IOException)
		
	
		when:
		output = exceptional.maybeThrowException(2)
		
		then:
		//def e = thrown(FileNotFoundException)
		//def e = thrown(IllegalArgumentException)
		def e = thrown(RuntimeException)
		e.cause == null
		e.message.contains('that is not legal!')
	}
	
}
