package org.apache.hc.core5.http.io.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BufferedHttpEntity extends HttpEntityWrapper {
    private final byte[] buffer;

    @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    public BufferedHttpEntity(HttpEntity httpEntity) throws IOException {
        super(httpEntity);
        if (!httpEntity.isRepeatable() || httpEntity.getContentLength() < 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            httpEntity.writeTo(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            this.buffer = byteArrayOutputStream.toByteArray();
            return;
        }
        this.buffer = null;
    }

    @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            return bArr.length;
        }
        return super.getContentLength();
    }

    @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
    public InputStream getContent() throws IOException {
        if (this.buffer != null) {
            return new ByteArrayInputStream(this.buffer);
        }
        return super.getContent();
    }

    @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.buffer == null && super.isChunked();
    }

    @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        byte[] bArr = this.buffer;
        if (bArr != null) {
            outputStream.write(bArr);
        } else {
            super.writeTo(outputStream);
        }
    }

    @Override // org.apache.hc.core5.http.io.entity.HttpEntityWrapper, org.apache.hc.core5.http.HttpEntity
    public boolean isStreaming() {
        return this.buffer == null && super.isStreaming();
    }
}
