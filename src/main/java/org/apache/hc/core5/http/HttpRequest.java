package org.apache.hc.core5.http;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hc.core5.net.URIAuthority;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRequest extends HttpMessage {
    URIAuthority getAuthority();

    String getMethod();

    String getPath();

    String getRequestUri();

    String getScheme();

    URI getUri() throws URISyntaxException;

    void setAuthority(URIAuthority uRIAuthority);

    void setPath(String str);

    void setScheme(String str);

    void setUri(URI uri);
}
