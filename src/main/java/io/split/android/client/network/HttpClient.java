package io.split.android.client.network;

import java.net.URI;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpClient {
    void addHeaders(Map<String, String> headers);

    void addStreamingHeaders(Map<String, String> headers);

    void close();

    HttpRequest request(URI uri, HttpMethod httpMethod);

    HttpRequest request(URI uri, HttpMethod httpMethod, String body);

    HttpRequest request(URI uri, HttpMethod requestMethod, String body, Map<String, String> headers);

    void setHeader(String name, String value);

    void setStreamingHeader(String name, String value);

    HttpStreamRequest streamRequest(URI uri);
}
