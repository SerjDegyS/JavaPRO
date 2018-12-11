package com.degys.spring.core.loggers;

import com.degys.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {


    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
