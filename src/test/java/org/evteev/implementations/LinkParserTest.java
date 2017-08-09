package org.evteev.implementations;

import org.evteev.interfaces.Parser;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by mike on 03.08.17.
 */
public class LinkParserTest {

    String contents = "<html><body><a href=\"index.html\">dsfsdf</a><b>ghgh</b><a href=\"gallery\">gallery</a></body></html>";

    @Test
    void shouldReturnTwoLinks() {
        Parser linkParser = new LinkParser();
        Set<String> links = linkParser.parse(contents);
        assertEquals(links.size(), 2);
        assertTrue(links.contains("index.html"));
        assertTrue(links.contains("gallery"));
    }
}
