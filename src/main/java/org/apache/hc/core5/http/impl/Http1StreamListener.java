package org.apache.hc.core5.http.impl;

import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface Http1StreamListener {
    void onExchangeComplete(HttpConnection httpConnection, boolean z);

    void onRequestHead(HttpConnection httpConnection, HttpRequest httpRequest);

    void onResponseHead(HttpConnection httpConnection, HttpResponse httpResponse);
}
