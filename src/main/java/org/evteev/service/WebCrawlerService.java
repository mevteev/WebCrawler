package org.evteev.service;

import org.apache.log4j.Logger;
import org.evteev.implementations.LinkParser;
import org.evteev.implementations.LogSaver;
import org.evteev.implementations.URLResolver;
import org.evteev.implementations.WebPageReceiver;
import org.evteev.interfaces.Parser;
import org.evteev.interfaces.Receiver;
import org.evteev.interfaces.Resolver;
import org.evteev.interfaces.Saver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by mike on 03.08.17.
 */
@Service
public class WebCrawlerService {

    public static String DUMMY_STOP = "dummy stop";

    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private Set<String> processedItems = new CopyOnWriteArraySet<>();

    final static Logger logger = Logger.getLogger(WebCrawlerService.class);


    @Autowired
    private Parser parser;

    @Autowired
    private Receiver receiver;

    @Autowired
    private Saver saver;

    @Autowired
    private Resolver resolver;

    boolean isStarted = false;

    private Executor exec = Executors.newFixedThreadPool(10);

    public void process(String initialURL) {
        if (!isStarted) {
            queue.add(initialURL);
            try {
                processQueue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.error("Service already started");

        }
    }

    private void processQueue() throws InterruptedException {
        while(true) {
            String url = queue.take();

            if (url.equals(DUMMY_STOP)) {
                break;
            }

            if (processedItems.contains(url)) {
                continue;
            }

            exec.execute(() -> processUrl(url));

        }
    }

    private void processUrl(final String url) {
        String html;
        try {
            processedItems.add(url);
            html = receiver.receive(url);
            saver.save(url, html);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        parser.parse(html).stream().filter((s) -> !processedItems.contains(s)).
                forEach((p) -> queue.add(resolver.resolve(url, p)));

    }
}
