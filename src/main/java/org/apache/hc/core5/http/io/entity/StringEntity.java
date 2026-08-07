package org.apache.hc.core5.http.io.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class StringEntity extends AbstractHttpEntity {
    private final byte[] content;

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

    public StringEntity(String str, ContentType contentType, String str2, boolean z) {
        super(contentType, str2, z);
        Args.notNull(str, "Source string");
        this.content = str.getBytes(ContentType.getCharset(contentType, StandardCharsets.UTF_8));
    }

    public StringEntity(String str, ContentType contentType, boolean z) {
        this(str, contentType, null, z);
    }

    public StringEntity(String str, ContentType contentType) {
        this(str, contentType, null, false);
    }

    public StringEntity(String str, Charset charset) {
        this(str, ContentType.TEXT_PLAIN.withCharset(charset));
    }

    public StringEntity(String str, Charset charset, boolean z) {
        this(str, ContentType.TEXT_PLAIN.withCharset(charset), z);
    }

    public StringEntity(String str) {
        this(str, ContentType.DEFAULT_TEXT);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return this.content.length;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.content);
        outputStream.flush();
    }
}
