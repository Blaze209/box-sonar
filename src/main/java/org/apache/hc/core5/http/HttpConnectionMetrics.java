package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpConnectionMetrics {
    long getReceivedBytesCount();

    long getRequestCount();

    long getResponseCount();

    long getSentBytesCount();
}
