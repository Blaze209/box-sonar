package org.apache.hc.core5.http.io.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractHttpEntity implements HttpEntity {
    static final int OUTPUT_BUFFER_SIZE = 4096;
    private final boolean chunked;
    private final String contentEncoding;
    private final String contentType;

    @Override // org.apache.hc.core5.http.HttpEntity
    public Supplier<List<? extends Header>> getTrailers() {
        return null;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    protected AbstractHttpEntity(String str, String str2, boolean z) {
        this.contentType = str;
        this.contentEncoding = str2;
        this.chunked = z;
    }

    protected AbstractHttpEntity(ContentType contentType, String str, boolean z) {
        this.contentType = Objects.toString(contentType, null);
        this.contentEncoding = str;
        this.chunked = z;
    }

    protected AbstractHttpEntity(String str, String str2) {
        this(str, str2, false);
    }

    protected AbstractHttpEntity(ContentType contentType, String str) {
        this(contentType, str, false);
    }

    public static void writeTo(HttpEntity httpEntity, OutputStream outputStream) throws IOException {
        Args.notNull(httpEntity, "Entity");
        Args.notNull(outputStream, "Output stream");
        InputStream content = httpEntity.getContent();
        if (content != null) {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = content.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i);
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (content != null) {
            content.close();
        }
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        writeTo(this, outputStream);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final String getContentType() {
        return this.contentType;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final String getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final boolean isChunked() {
        return this.chunked;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }

    public String toString() {
        return "[Entity-Class: " + getClass().getSimpleName() + ", Content-Type: " + this.contentType + ", Content-Encoding: " + this.contentEncoding + ", chunked: " + this.chunked + AbstractJsonLexerKt.END_LIST;
    }
}
