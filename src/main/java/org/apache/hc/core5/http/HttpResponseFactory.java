package org.apache.hc.core5.http;

import org.apache.hc.core5.http.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpResponseFactory<T extends HttpResponse> {
    T newHttpResponse(int i);

    T newHttpResponse(int i, String str);
}
