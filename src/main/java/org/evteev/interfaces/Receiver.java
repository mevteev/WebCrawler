package org.evteev.interfaces;

import java.io.IOException;

/**
 * Created by mike on 03.08.17.
 */
@FunctionalInterface
public interface Receiver {

    String receive(String url) throws IOException;
}
