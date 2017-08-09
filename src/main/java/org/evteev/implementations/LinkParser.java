package org.evteev.implementations;

import org.evteev.interfaces.Parser;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mike on 03.08.17.
 */
@Component
public class LinkParser implements Parser {

    @Override
    public Set<String> parse(String content) {
        if (content == null) {
            return Collections.EMPTY_SET;
        }
        Set<String> links = new HashSet<>();
        // parse contents
        // The HTML page as a String
        String HTMLPage;
        Pattern linkPattern = Pattern.compile("<a[^>]+href=[\"']?([^\"'>]+)[\"']?[^>]*>(.+?)<\\/a>",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
        Matcher pageMatcher = linkPattern.matcher(content);
        while(pageMatcher.find()){
            links.add(pageMatcher.group(1));
        }

        return links;

    }
}
