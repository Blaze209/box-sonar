package org.apache.hc.core5.http.io.entity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ByteBufferEntity extends AbstractHttpEntity {
    private final ByteBuffer buffer;
    private final long length;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final boolean isStreaming() {
        return false;
    }

    public ByteBufferEntity(ByteBuffer byteBuffer, ContentType contentType, String str) {
        super(contentType, str);
        Args.notNull(byteBuffer, "Source byte buffer");
        this.buffer = byteBuffer;
        this.length = byteBuffer.remaining();
    }

    public ByteBufferEntity(ByteBuffer byteBuffer, ContentType contentType) {
        this(byteBuffer, contentType, null);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return this.length;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() throws UnsupportedOperationException, IOException {
        return new InputStream() { // from class: org.apache.hc.core5.http.io.entity.ByteBufferEntity.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (ByteBufferEntity.this.buffer.hasRemaining()) {
                    return ByteBufferEntity.this.buffer.get() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (i2 == 0) {
                    return 0;
                }
                if (!ByteBufferEntity.this.buffer.hasRemaining()) {
                    return -1;
                }
                int iMin = Math.min(i2, ByteBufferEntity.this.buffer.remaining());
                ByteBufferEntity.this.buffer.get(bArr, i, iMin);
                return iMin;
            }
        };
    }
}
