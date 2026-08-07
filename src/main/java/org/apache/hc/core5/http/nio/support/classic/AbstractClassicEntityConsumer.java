package org.apache.hc.core5.http.nio.support.classic;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractClassicEntityConsumer<T> implements AsyncEntityConsumer<T> {
    private final SharedInputBuffer buffer;
    private final Executor executor;
    private final AtomicReference<State> state = new AtomicReference<>(State.IDLE);
    private final AtomicReference<T> resultRef = new AtomicReference<>();
    private final AtomicReference<Exception> exceptionRef = new AtomicReference<>();

    private enum State {
        IDLE,
        ACTIVE,
        COMPLETED
    }

    protected abstract T consumeData(ContentType contentType, InputStream inputStream) throws IOException;

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
    }

    public AbstractClassicEntityConsumer(int i, Executor executor) {
        this.executor = (Executor) Args.notNull(executor, "Executor");
        this.buffer = new SharedInputBuffer(i);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.buffer.updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public final void streamStart(EntityDetails entityDetails, final FutureCallback<T> futureCallback) throws HttpException, IOException {
        try {
            final ContentType contentType = ContentType.parse(entityDetails.getContentType());
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.state, State.IDLE, State.ACTIVE)) {
                this.executor.execute(new Runnable() { // from class: org.apache.hc.core5.http.nio.support.classic.AbstractClassicEntityConsumer$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m16639x8c1b42b8(contentType, futureCallback);
                    }
                });
            }
        } catch (UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: lambda$streamStart$0$org-apache-hc-core5-http-nio-support-classic-AbstractClassicEntityConsumer, reason: not valid java name */
    /* synthetic */ void m16639x8c1b42b8(ContentType contentType, FutureCallback futureCallback) {
        try {
            try {
                T tConsumeData = consumeData(contentType, new ContentInputStream(this.buffer));
                this.resultRef.set(tConsumeData);
                futureCallback.completed(tConsumeData);
            } catch (Exception e) {
                this.buffer.abort();
                futureCallback.failed(e);
            }
        } finally {
            this.state.set(State.COMPLETED);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        this.buffer.fill(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        this.buffer.markEndStream();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public final void failed(Exception exc) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.exceptionRef, null, exc)) {
            releaseResources();
        }
    }

    public final Exception getException() {
        return this.exceptionRef.get();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public final T getContent() {
        return this.resultRef.get();
    }
}
