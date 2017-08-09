package org.evteev.interfaces;

/**
 * Created by mike on 04.08.17.
 */
@FunctionalInterface
public interface Resolver {
    String resolve(String parent, String item);

}
