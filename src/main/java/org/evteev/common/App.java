package org.evteev.common;

import org.evteev.service.WebCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mike on 09.08.17.
 */
public class App {

    @Autowired
    private WebCrawlerService service;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        WebCrawlerService service = (WebCrawlerService)context.getBean("WebCrawlerService");

        service.process("http://google.com");

//        App app = new App();
//
//        app.service.process("http://google.com");
    }
}
