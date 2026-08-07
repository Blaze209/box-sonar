package org.apache.hc.core5.http.io.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class InputStreamEntity extends AbstractHttpEntity {
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

    public InputStreamEntity(InputStream inputStream, long j, ContentType contentType, String str) {
        super(contentType, str);
        this.content = (InputStream) Args.notNull(inputStream, "Source input stream");
        this.length = j;
    }

    public InputStreamEntity(InputStream inputStream, long j, ContentType contentType) {
        this(inputStream, j, contentType, null);
    }

    public InputStreamEntity(InputStream inputStream, ContentType contentType) {
        this(inputStream, -1L, contentType, null);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return this.length;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() throws IOException {
        return this.content;
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final void writeTo(OutputStream outputStream) throws IOException {
        int i;
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[4096];
            long j = this.length;
            if (j < 0) {
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i2);
                    }
                }
            } else {
                while (j > 0 && (i = inputStream.read(bArr, 0, (int) Math.min(4096L, j))) != -1) {
                    outputStream.write(bArr, 0, i);
                    j -= (long) i;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.content.close();
    }
}
