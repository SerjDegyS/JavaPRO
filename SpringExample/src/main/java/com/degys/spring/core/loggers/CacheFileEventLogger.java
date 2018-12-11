package com.degys.spring.core.loggers;

import com.degys.spring.core.beans.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

//    public CacheFileEventLogger(String filename, int cacheSize) {
//        super(filename);
//        this.cacheSize = cacheSize;
//        this.cache = new ArrayList<Event>(cacheSize);
//    }

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>(cacheSize);
    }

    public void logEvent(Event event){
        cache.add(event);

        if (cache.size() == cacheSize){
            if(!writeEventsFromCache()){
                System.out.println("Can't write from cache!");
            }else cache.clear();
        }
    }

    private boolean writeEventsFromCache() {
        boolean rez = false;
        try{
            cache.stream().forEach(super::logEvent);
            System.out.println("Cache entry to file " + super.getFilename());
            rez = true;
        }finally {
            System.out.println("Cache was processed!");
        }
        return rez;
    }

    public void destroy(){
        if (!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

}
