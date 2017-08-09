package org.evteev.implementations;

import org.evteev.interfaces.Resolver;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mike on 04.08.17.
 */
@Component
public class URLResolver implements Resolver {

    @Override
    public String resolve(String parent, String item) {
        try {
            return new URL(new URL(parent), item).toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return item;
        }
    }
}
