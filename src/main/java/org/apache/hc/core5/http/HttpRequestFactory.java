package org.apache.hc.core5.http;

import java.net.URI;
import org.apache.hc.core5.http.HttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRequestFactory<T extends HttpRequest> {
    T newHttpRequest(String str, String str2) throws MethodNotSupportedException;

    T newHttpRequest(String str, URI uri) throws MethodNotSupportedException;
}
