package org.apache.hc.core5.http.nio.support.classic;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractClassicEntityProducer implements AsyncEntityProducer {
    private final SharedOutputBuffer buffer;
    private final ContentType contentType;
    private final Executor executor;
    private final AtomicReference<State> state = new AtomicReference<>(State.IDLE);
    private final AtomicReference<Exception> exception = new AtomicReference<>();

    private enum State {
        IDLE,
        ACTIVE,
        COMPLETED
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return -1L;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final Set<String> getTrailerNames() {
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final boolean isChunked() {
        return false;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public final boolean isRepeatable() {
        return false;
    }

    protected abstract void produceData(ContentType contentType, OutputStream outputStream) throws IOException;

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
    }

    public AbstractClassicEntityProducer(int i, ContentType contentType, Executor executor) {
        this.buffer = new SharedOutputBuffer(i);
        this.contentType = contentType;
        this.executor = (Executor) Args.notNull(executor, "Executor");
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final int available() {
        return this.buffer.length();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final void produce(DataStreamChannel dataStreamChannel) throws IOException {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.state, State.IDLE, State.ACTIVE)) {
            this.executor.execute(new Runnable() { // from class: org.apache.hc.core5.http.nio.support.classic.AbstractClassicEntityProducer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m16640x2cfe2d76();
                }
            });
        }
        this.buffer.flush(dataStreamChannel);
    }

    /* JADX INFO: renamed from: lambda$produce$0$org-apache-hc-core5-http-nio-support-classic-AbstractClassicEntityProducer, reason: not valid java name */
    /* synthetic */ void m16640x2cfe2d76() {
        try {
            try {
                produceData(this.contentType, new ContentOutputStream(this.buffer));
                this.buffer.writeCompleted();
            } catch (Exception unused) {
                this.buffer.abort();
            }
        } finally {
            this.state.set(State.COMPLETED);
        }
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final String getContentType() {
        return Objects.toString(this.contentType, null);
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
}
