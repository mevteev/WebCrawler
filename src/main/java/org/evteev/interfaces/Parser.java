package org.evteev.interfaces;

import java.util.Set;

/**
 * Created by mike on 03.08.17.
 */
@FunctionalInterface
public interface Parser {
    Set<String> parse(String content);
}
