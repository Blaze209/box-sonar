package org.apache.hc.core5.http.nio.entity;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.nio.StreamChannel;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;

/* JADX INFO: loaded from: classes5.dex */
public class StringAsyncEntityProducer extends AbstractCharAsyncEntityProducer {
    private final CharBuffer content;
    private final AtomicReference<Exception> exception;

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityProducer
    protected int availableData() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public boolean isRepeatable() {
        return true;
    }

    public StringAsyncEntityProducer(CharSequence charSequence, int i, int i2, ContentType contentType) {
        super(i, i2, contentType);
        Args.notNull(charSequence, "Content");
        this.content = CharBuffer.wrap(charSequence);
        this.exception = new AtomicReference<>();
    }

    public StringAsyncEntityProducer(CharSequence charSequence, int i, ContentType contentType) {
        this(charSequence, i, -1, contentType);
    }

    public StringAsyncEntityProducer(CharSequence charSequence, ContentType contentType) {
        this(charSequence, 4096, contentType);
    }

    public StringAsyncEntityProducer(CharSequence charSequence) {
        this(charSequence, ContentType.TEXT_PLAIN);
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityProducer
    protected void produceData(StreamChannel<CharBuffer> streamChannel) throws IOException {
        Asserts.notNull(streamChannel, "Channel");
        streamChannel.write(this.content);
        if (this.content.hasRemaining()) {
            return;
        }
        streamChannel.endStream();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public void failed(Exception exc) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.exception, null, exc)) {
            releaseResources();
        }
    }

    public Exception getException() {
        return this.exception.get();
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityProducer, org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.content.clear();
        super.releaseResources();
    }
}
