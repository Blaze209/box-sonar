package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.AbstractHttpEntity;
import org.apache.hc.core5.io.Closer;

/* JADX INFO: loaded from: classes5.dex */
class IncomingHttpEntity implements HttpEntity {
    private final boolean chunked;
    private final InputStream content;
    private final Header contentEncoding;
    private final Header contentType;
    private final long len;

    @Override // org.apache.hc.core5.http.HttpEntity
    public Supplier<List<? extends Header>> getTrailers() {
        return null;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    IncomingHttpEntity(InputStream inputStream, long j, boolean z, Header header, Header header2) {
        this.content = inputStream;
        this.len = j;
        this.chunked = z;
        this.contentType = header;
        this.contentEncoding = header2;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.chunked;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.len;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        Header header = this.contentType;
        if (header != null) {
            return header.getValue();
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        Header header = this.contentEncoding;
        if (header != null) {
            return header.getValue();
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public InputStream getContent() throws IllegalStateException, IOException {
        return this.content;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isStreaming() {
        return this.content != null;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        AbstractHttpEntity.writeTo(this, outputStream);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Closer.close(this.content);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[Content-Type: ");
        sb.append(getContentType());
        sb.append(",Content-Encoding: ");
        sb.append(getContentEncoding());
        sb.append(AbstractJsonLexerKt.COMMA);
        long contentLength = getContentLength();
        if (contentLength >= 0) {
            sb.append("Content-Length: ");
            sb.append(contentLength);
            sb.append(AbstractJsonLexerKt.COMMA);
        }
        sb.append("Chunked: ");
        sb.append(isChunked());
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
