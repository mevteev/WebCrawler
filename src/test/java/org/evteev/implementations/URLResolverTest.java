package org.evteev.implementations;

import org.evteev.interfaces.Resolver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by mike on 04.08.17.
 */
public class URLResolverTest {

    @Test
    void UrlResolveTest() throws Exception {
        Resolver resolver = new URLResolver();
        String baseUrl = "http://google.com";
        assertEquals(baseUrl + "/images.html", resolver.resolve(baseUrl, "images.html"));
        assertEquals(baseUrl + "/gallery/img.html", resolver.resolve(baseUrl, "/gallery/img.html"));
        assertEquals("http://gmail.com", resolver.resolve(baseUrl, "http://gmail.com"));

    }
}
