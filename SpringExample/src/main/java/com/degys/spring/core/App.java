package com.degys.spring.core;

import com.degys.spring.core.beans.Client;
import com.degys.spring.core.beans.Event;
import com.degys.spring.core.beans.EventType;
import com.degys.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggerMap;

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("context.xml");

        App app = ctx.getBean("app", App.class);
//        app.client = new com.degys.spring.core.beans.Client("1", "Ser Degys");
//        app.defaultLogger = new com.degys.spring.core.beans.ConsoleEventLogger();

        System.out.println(ctx.getBean("client"));

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event,"Some event for user 1");

        Thread.sleep(1500);
        Event event1 = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event1,"Some event for user 2");

        Thread.sleep(1500);
        Event event2 = ctx.getBean(Event.class);
        app.logEvent(null, event2,"Some event for user 3");


        ctx.close();

    }
    public App(Client client, EventLogger defaultLogger,
               Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggerMap = loggers;
    }

    protected void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggerMap.get(eventType);
        if (logger == null){
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }
}
