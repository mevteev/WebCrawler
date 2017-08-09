package org.evteev.implementations;

import org.apache.log4j.Logger;
import org.evteev.interfaces.Saver;
import org.springframework.stereotype.Component;


/**
 * Created by mike on 03.08.17.
 */
@Component
public class LogSaver implements Saver {

    final static Logger logger = Logger.getLogger(LogSaver.class);

    @Override
    public void save(String url, String contents) {
        logger.info("Processed " + url + "; contents: " + contents.substring(0, Math.min(contents.length(), 20)));
    }
}
