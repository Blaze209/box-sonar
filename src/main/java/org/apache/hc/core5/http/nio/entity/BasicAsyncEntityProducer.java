package org.apache.hc.core5.http.nio.entity;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicAsyncEntityProducer implements AsyncEntityProducer {
    private final ByteBuffer bytebuf;
    private final boolean chunked;
    private final ContentType contentType;
    private final AtomicReference<Exception> exception;
    private final int length;

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public int available() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return null;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public boolean isRepeatable() {
        return true;
    }

    public BasicAsyncEntityProducer(byte[] bArr, ContentType contentType, boolean z) {
        Args.notNull(bArr, "Content");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.bytebuf = byteBufferWrap;
        this.length = byteBufferWrap.remaining();
        this.contentType = contentType;
        this.chunked = z;
        this.exception = new AtomicReference<>();
    }

    public BasicAsyncEntityProducer(byte[] bArr, ContentType contentType) {
        this(bArr, contentType, false);
    }

    public BasicAsyncEntityProducer(byte[] bArr) {
        this(bArr, ContentType.APPLICATION_OCTET_STREAM);
    }

    public BasicAsyncEntityProducer(CharSequence charSequence, ContentType contentType, boolean z) {
        Args.notNull(charSequence, "Content");
        this.contentType = contentType;
        ByteBuffer byteBufferEncode = ContentType.getCharset(contentType, StandardCharsets.UTF_8).encode(CharBuffer.wrap(charSequence));
        this.bytebuf = byteBufferEncode;
        this.length = byteBufferEncode.remaining();
        this.chunked = z;
        this.exception = new AtomicReference<>();
    }

    public BasicAsyncEntityProducer(CharSequence charSequence, ContentType contentType) {
        this(charSequence, contentType, false);
    }

    public BasicAsyncEntityProducer(CharSequence charSequence) {
        this(charSequence, ContentType.TEXT_PLAIN);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final String getContentType() {
        return Objects.toString(this.contentType, null);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.chunked;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final void produce(DataStreamChannel dataStreamChannel) throws IOException {
        if (this.bytebuf.hasRemaining()) {
            dataStreamChannel.write(this.bytebuf);
        }
        if (this.bytebuf.hasRemaining()) {
            return;
        }
        dataStreamChannel.endStream();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public final void failed(Exception exc) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.exception, null, exc)) {
            releaseResources();
        }
    }

    public final Exception getException() {
        return this.exception.get();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.bytebuf.clear();
        this.bytebuf.limit(this.length);
    }
}
