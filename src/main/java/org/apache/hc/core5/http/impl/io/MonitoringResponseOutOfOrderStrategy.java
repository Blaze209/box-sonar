package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.HttpClientConnection;
import org.apache.hc.core5.http.io.ResponseOutOfOrderStrategy;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public final class MonitoringResponseOutOfOrderStrategy implements ResponseOutOfOrderStrategy {
    private static final int DEFAULT_CHUNK_SIZE = 8192;
    public static final MonitoringResponseOutOfOrderStrategy INSTANCE = new MonitoringResponseOutOfOrderStrategy();
    private final long chunkSize;
    private final long maxChunksToCheck;

    public MonitoringResponseOutOfOrderStrategy() {
        this(8192L);
    }

    public MonitoringResponseOutOfOrderStrategy(long j) {
        this(j, Long.MAX_VALUE);
    }

    public MonitoringResponseOutOfOrderStrategy(long j, long j2) {
        this.chunkSize = Args.positive(j, "chunkSize");
        this.maxChunksToCheck = Args.positive(j2, "maxChunksToCheck");
    }

    @Override // org.apache.hc.core5.http.io.ResponseOutOfOrderStrategy
    public boolean isEarlyResponseDetected(ClassicHttpRequest classicHttpRequest, HttpClientConnection httpClientConnection, InputStream inputStream, long j, long j2) throws IOException {
        if (nextWriteStartsNewChunk(j, j2)) {
            if (httpClientConnection.getSSLSession() != null) {
                return httpClientConnection.isDataAvailable(Timeout.ONE_MILLISECOND);
            }
            if (inputStream.available() > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean nextWriteStartsNewChunk(long j, long j2) {
        return Math.min(j / this.chunkSize, this.maxChunksToCheck) < Math.min((j + j2) / this.chunkSize, this.maxChunksToCheck);
    }

    public String toString() {
        return "DefaultResponseOutOfOrderStrategy{chunkSize=" + this.chunkSize + ", maxChunksToCheck=" + this.maxChunksToCheck + AbstractJsonLexerKt.END_OBJ;
    }
}
