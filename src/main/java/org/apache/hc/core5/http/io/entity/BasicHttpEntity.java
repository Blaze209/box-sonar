package org.apache.hc.core5.http.io.entity;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpEntity extends AbstractHttpEntity {
    private final InputStream content;
    private final long length;

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final boolean isStreaming() {
        return true;
    }

    public BasicHttpEntity(InputStream inputStream, long j, ContentType contentType, String str, boolean z) {
        super(contentType, str, z);
        this.content = (InputStream) Args.notNull(inputStream, "Content stream");
        this.length = j;
    }

    public BasicHttpEntity(InputStream inputStream, long j, ContentType contentType, String str) {
        this(inputStream, j, contentType, str, false);
    }

    public BasicHttpEntity(InputStream inputStream, long j, ContentType contentType) {
        this(inputStream, j, contentType, null);
    }

    public BasicHttpEntity(InputStream inputStream, ContentType contentType, String str) {
        this(inputStream, -1L, contentType, str);
    }

    public BasicHttpEntity(InputStream inputStream, ContentType contentType) {
        this(inputStream, -1L, contentType, null);
    }

    public BasicHttpEntity(InputStream inputStream, ContentType contentType, boolean z) {
        this(inputStream, -1L, contentType, null, z);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return this.length;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() throws IllegalStateException {
        return this.content;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Closer.close(this.content);
    }
}
