package org.evteev.model;

/**
 * Created by mike on 03.08.17.
 */
public class WebItem {
    private String uri;
    private String contents;

    public WebItem(String uri) {
        this.uri = uri;
    }

    public WebItem(String uri, String contents) {
        this.uri = uri;
        this.contents = contents;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
