package org.jose4j.http;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Response implements SimpleResponse {
    private String body;
    private Map<String, List<String>> headers = new HashMap();
    private int statusCode;
    private String statusMessage;

    public Response(int i, String str, Map<String, List<String>> map, String str2) {
        this.statusCode = i;
        this.statusMessage = str;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            this.headers.put(normalizeHeaderName(entry.getKey()), entry.getValue());
        }
        this.body = str2;
    }

    @Override // org.jose4j.http.SimpleResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // org.jose4j.http.SimpleResponse
    public String getStatusMessage() {
        return this.statusMessage;
    }

    @Override // org.jose4j.http.SimpleResponse
    public Collection<String> getHeaderNames() {
        return this.headers.keySet();
    }

    @Override // org.jose4j.http.SimpleResponse
    public List<String> getHeaderValues(String str) {
        return this.headers.get(normalizeHeaderName(str));
    }

    @Override // org.jose4j.http.SimpleResponse
    public String getBody() {
        return this.body;
    }

    private String normalizeHeaderName(String str) {
        if (str != null) {
            return str.toLowerCase().trim();
        }
        return null;
    }

    public String toString() {
        return "SimpleResponse{statusCode=" + this.statusCode + ", statusMessage='" + this.statusMessage + "', headers=" + this.headers + ", body='" + this.body + "'}";
    }
}
