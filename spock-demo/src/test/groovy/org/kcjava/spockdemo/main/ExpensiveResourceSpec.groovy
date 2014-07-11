package org.kcjava.spockdemo.main

import groovy.util.logging.Log4j;
import spock.lang.Specification
import spock.lang.Shared

/**
 * Shows how to use shared resources, and how to setup and cleanup.
 */
class ExpensiveResourceSpec extends Specification {

	@Shared ExpensiveResource expensiveResource
	
	/**
	 * Prepare the expensive resource for use
	 */
	def setupSpec() {
		expensiveResource = new ExpensiveResource()
		expensiveResource.initExpensively()
		println "after expensiveResource initialization, ready=${expensiveResource.ready}"
	}

	/**
	 * close down the expensive resource
	 */
	def cleanupSpec() {
		expensiveResource.close()
		println "just closed down the expensiveResource, ready=${expensiveResource.ready}"
	}
	
	/**
	 * Resets the ready flag to true to ensure it is ready before each test
	 */
	def setup() {
		if(expensiveResource != null) {
			expensiveResource.ready = true
		}
	}
		
	
	/**
	 * does nothing
	 */
	def cleanup() { }
	
	
	def 'test that performSomeWork() will throw an exception if the resource is not ready'() {
		given:
		expensiveResource.ready = false
				
		when:	'the resource is requested to do some work'
		String output = expensiveResource.performSomeWork()
		
		then:	'work is performed and no exception is thrown'
		def exception = thrown(Exception)
		exception.message.contains('not ready for work')		
	}
	
	
	def 'test that performSomeWork() does what it says'() {
		when:	'the resource is requested to do some work'
		String output = expensiveResource.performSomeWork()
		
		then:	'work is performed and no exception is thrown'
		output.contains('work')
		notThrown(Exception)			
	}
	
	
}
