package org.apache.hc.core5.http.io.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.io.IOCallback;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class EntityTemplate extends AbstractHttpEntity {
    private final IOCallback<OutputStream> callback;
    private final long contentLength;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    public EntityTemplate(long j, ContentType contentType, String str, IOCallback<OutputStream> iOCallback) {
        super(contentType, str);
        this.contentLength = j;
        this.callback = (IOCallback) Args.notNull(iOCallback, "I/O callback");
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public InputStream getContent() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        this.callback.execute(outputStream);
    }
}
