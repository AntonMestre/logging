package fr.antonincorp.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    /*
	 * slf4j is an interface, behind it will be logback, log4j... But slf4j and logback are already include in the starter of springboot : spring-boot-starter
	 */
	private static final Logger logger = LoggerFactory.getLogger(Log.class);

    public Log(){}

    public void log(){
        /*
		 * Information of the expected behavior of the application
		 */
		logger.info("Application has started correctly");
		logger.info("Application has started {}", "incorrectly");

		/*
		 * Possible problem or thing that require attention
		 */
		logger.warn("Attention here");

		/*
		 * gradle bootRun --args='--logging.level.fr.antonincorp.logging=TRACE'
		 * or
		 * logging.level.fr.antonincorp.logging=TRACE
		 * 
		 * No trace of debug in production
		 * Debug during dev
		 * Trace is more precise debugging
		*/
		logger.trace("Let's trace this");
		logger.debug("let's debug");		

		/*
		 * Problem with the application, have a look now
		 */
		logger.error("Application got a null pointer exception", NullPointerException.class);
    }
}
