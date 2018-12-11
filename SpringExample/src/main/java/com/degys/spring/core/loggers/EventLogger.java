package com.degys.spring.core.loggers;

import com.degys.spring.core.beans.Event;

public interface EventLogger {
    public void logEvent(Event event);
}
