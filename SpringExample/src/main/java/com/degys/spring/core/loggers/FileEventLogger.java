package com.degys.spring.core.loggers;

import com.degys.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String filename;

    public String getFilename() {
        return filename;
    }

    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }


    public void init() throws IOException {
        file = new File(filename);
        if(file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("Can't write to file " + filename);
        } else if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
            System.out.println("Event recorded!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
