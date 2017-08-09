package org.evteev.implementations;

import org.evteev.interfaces.Receiver;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by mike on 03.08.17.
 */
@Component
public class WebPageReceiver implements Receiver {

    @Override
    public String receive(String url) throws IOException {
        URL u = new URL(url);
        URLConnection uc = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while((inputLine = in.readLine()) != null) {
            a.append(inputLine);
        }
        in.close();

        return a.toString();
    }
}
