package fr.antonincorp.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

class LogTests {

	@Test
	void testLog() {
		Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
		logger.addAppender(listAppender);

		Log log = new Log();
		log.log();

		List<ILoggingEvent> logsList = listAppender.list;

        assertEquals("Application has started correctly", logsList.get(0).getMessage());

        assertEquals(Level.INFO, logsList.get(0).getLevel());
	}
}
