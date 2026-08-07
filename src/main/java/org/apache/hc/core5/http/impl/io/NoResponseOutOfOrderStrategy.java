package org.apache.hc.core5.http.impl.io;

import java.io.InputStream;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.HttpClientConnection;
import org.apache.hc.core5.http.io.ResponseOutOfOrderStrategy;

/* JADX INFO: loaded from: classes5.dex */
public final class NoResponseOutOfOrderStrategy implements ResponseOutOfOrderStrategy {
    public static final NoResponseOutOfOrderStrategy INSTANCE = new NoResponseOutOfOrderStrategy();

    @Override // org.apache.hc.core5.http.io.ResponseOutOfOrderStrategy
    public boolean isEarlyResponseDetected(ClassicHttpRequest classicHttpRequest, HttpClientConnection httpClientConnection, InputStream inputStream, long j, long j2) {
        return false;
    }
}
