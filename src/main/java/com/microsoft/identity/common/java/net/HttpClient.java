package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.StringUtil;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface HttpClient {
    HttpResponse delete(URL url, Map<String, String> map, byte[] bArr) throws ClientException;

    HttpResponse get(URL url, Map<String, String> map) throws ClientException;

    HttpResponse head(URL url, Map<String, String> map) throws ClientException;

    HttpResponse method(HttpMethod httpMethod, URL url, Map<String, String> map, byte[] bArr) throws ClientException;

    HttpResponse method(String str, URL url, Map<String, String> map, byte[] bArr) throws ClientException;

    HttpResponse options(URL url, Map<String, String> map) throws ClientException;

    HttpResponse patch(URL url, Map<String, String> map, byte[] bArr) throws ClientException;

    HttpResponse post(URL url, Map<String, String> map, byte[] bArr) throws ClientException;

    HttpResponse put(URL url, Map<String, String> map, byte[] bArr) throws ClientException;

    HttpResponse trace(URL url, Map<String, String> map) throws ClientException;

    public enum HttpMethod {
        GET,
        HEAD,
        PUT,
        POST,
        OPTIONS,
        PATCH,
        DELETE,
        TRACE;

        private static final Map<String, HttpMethod> validMethods = new LinkedHashMap(values().length);

        static {
            for (HttpMethod httpMethod : values()) {
                validMethods.put(httpMethod.name(), httpMethod);
            }
        }

        public static HttpMethod validateAndNormalizeMethod(String str) {
            if (str == null) {
                throw new NullPointerException("httpMethod is marked non-null but is null");
            }
            if (StringUtil.isNullOrEmpty(str)) {
                throw new IllegalArgumentException("HTTP method cannot be null or blank");
            }
            HttpMethod httpMethod = validMethods.get(str);
            if (httpMethod != null) {
                return httpMethod;
            }
            throw new IllegalArgumentException("Unknown or unsupported HTTP method: " + str);
        }
    }
}
