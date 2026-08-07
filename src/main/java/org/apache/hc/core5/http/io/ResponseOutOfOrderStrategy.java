package org.apache.hc.core5.http.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.ClassicHttpRequest;

/* JADX INFO: loaded from: classes5.dex */
public interface ResponseOutOfOrderStrategy {
    boolean isEarlyResponseDetected(ClassicHttpRequest classicHttpRequest, HttpClientConnection httpClientConnection, InputStream inputStream, long j, long j2) throws IOException;
}
