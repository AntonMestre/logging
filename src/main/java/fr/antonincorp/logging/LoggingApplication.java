package fr.antonincorp.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingApplication {

	/*
	 * slf4j is an interface, behind it will be logback, log4j... But slf4j and logback are already include in the starter of springboot : spring-boot-starter
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoggingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
		
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
