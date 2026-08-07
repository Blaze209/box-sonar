package org.apache.hc.core5.http.io.entity;

import com.pspdfkit.analytics.Analytics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ByteArrayEntity extends AbstractHttpEntity {
    private final byte[] buf;
    private final int len;
    private final int off;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final boolean isStreaming() {
        return false;
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2, ContentType contentType, String str, boolean z) {
        super(contentType, str, z);
        Args.notNull(bArr, "Source byte array");
        Args.notNegative(i, "offset");
        Args.notNegative(i2, Analytics.Data.LENGTH);
        int i3 = i + i2;
        Args.notNegative(i3, "off + len");
        Args.check(i <= bArr.length, "off %s cannot be greater then b.length %s ", Integer.valueOf(i), Integer.valueOf(bArr.length));
        Args.check(i3 <= bArr.length, "off + len  %s cannot be less then b.length %s ", Integer.valueOf(i3), Integer.valueOf(bArr.length));
        this.buf = bArr;
        this.off = i;
        this.len = i2;
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2, ContentType contentType, String str) {
        this(bArr, i, i2, contentType, str, false);
    }

    public ByteArrayEntity(byte[] bArr, ContentType contentType, String str, boolean z) {
        super(contentType, str, z);
        Args.notNull(bArr, "Source byte array");
        this.buf = bArr;
        this.off = 0;
        this.len = bArr.length;
    }

    public ByteArrayEntity(byte[] bArr, ContentType contentType, String str) {
        this(bArr, contentType, str, false);
    }

    public ByteArrayEntity(byte[] bArr, ContentType contentType, boolean z) {
        this(bArr, contentType, (String) null, z);
    }

    public ByteArrayEntity(byte[] bArr, ContentType contentType) {
        this(bArr, contentType, (String) null, false);
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2, ContentType contentType, boolean z) {
        this(bArr, i, i2, contentType, null, z);
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2, ContentType contentType) {
        this(bArr, i, i2, contentType, null, false);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return this.len;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() {
        return new ByteArrayInputStream(this.buf, this.off, this.len);
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.buf, this.off, this.len);
        outputStream.flush();
    }
}
