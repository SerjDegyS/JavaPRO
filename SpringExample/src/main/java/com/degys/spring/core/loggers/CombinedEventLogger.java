package com.degys.spring.core.loggers;

import com.degys.spring.core.beans.Event;

import java.util.Collection;
import java.util.Collections;

public class CombinedEventLogger implements EventLogger {

    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
//        loggers.forEach(logger->logEvent(event));

        for (EventLogger logger: loggers) {
            logger.logEvent(event);
        }
    }
}
