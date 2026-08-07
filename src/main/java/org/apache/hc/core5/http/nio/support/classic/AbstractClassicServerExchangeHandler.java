package org.apache.hc.core5.http.nio.support.classic;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.message.HttpResponseWrapper;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractClassicServerExchangeHandler implements AsyncServerExchangeHandler {
    private final Executor executor;
    private final int initialBufferSize;
    private volatile SharedInputBuffer inputBuffer;
    private volatile SharedOutputBuffer outputBuffer;
    private final AtomicReference<Exception> exception = new AtomicReference<>();
    private final AtomicReference<State> state = new AtomicReference<>(State.IDLE);

    private enum State {
        IDLE,
        ACTIVE,
        COMPLETED
    }

    protected abstract void handle(HttpRequest httpRequest, InputStream inputStream, HttpResponse httpResponse, OutputStream outputStream, HttpContext httpContext) throws HttpException, IOException;

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
    }

    public AbstractClassicServerExchangeHandler(int i, Executor executor) {
        this.initialBufferSize = Args.positive(i, "Initial buffer size");
        this.executor = (Executor) Args.notNull(executor, "Executor");
    }

    public Exception getException() {
        return this.exception.get();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncServerExchangeHandler
    public final void handleRequest(final HttpRequest httpRequest, EntityDetails entityDetails, final ResponseChannel responseChannel, final HttpContext httpContext) throws HttpException, IOException {
        ContentInputStream contentInputStream;
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final BasicHttpResponse basicHttpResponse = new BasicHttpResponse(200);
        final HttpResponseWrapper httpResponseWrapper = new HttpResponseWrapper(basicHttpResponse) { // from class: org.apache.hc.core5.http.nio.support.classic.AbstractClassicServerExchangeHandler.1
            private void ensureNotCommitted() {
                Asserts.check(!atomicBoolean.get(), "Response already committed");
            }

            @Override // org.apache.hc.core5.http.message.AbstractMessageWrapper, org.apache.hc.core5.http.HttpMessage
            public void addHeader(String str, Object obj) {
                ensureNotCommitted();
                super.addHeader(str, obj);
            }

            @Override // org.apache.hc.core5.http.message.AbstractMessageWrapper, org.apache.hc.core5.http.HttpMessage
            public void setHeader(String str, Object obj) {
                ensureNotCommitted();
                super.setHeader(str, obj);
            }

            @Override // org.apache.hc.core5.http.message.AbstractMessageWrapper, org.apache.hc.core5.http.HttpMessage
            public void setVersion(ProtocolVersion protocolVersion) {
                ensureNotCommitted();
                super.setVersion(protocolVersion);
            }

            @Override // org.apache.hc.core5.http.message.HttpResponseWrapper, org.apache.hc.core5.http.HttpResponse
            public void setCode(int i) {
                ensureNotCommitted();
                super.setCode(i);
            }

            @Override // org.apache.hc.core5.http.message.HttpResponseWrapper, org.apache.hc.core5.http.HttpResponse
            public void setReasonPhrase(String str) {
                ensureNotCommitted();
                super.setReasonPhrase(str);
            }

            @Override // org.apache.hc.core5.http.message.HttpResponseWrapper, org.apache.hc.core5.http.HttpResponse
            public void setLocale(Locale locale) {
                ensureNotCommitted();
                super.setLocale(locale);
            }
        };
        if (entityDetails != null) {
            this.inputBuffer = new SharedInputBuffer(this.initialBufferSize);
            contentInputStream = new ContentInputStream(this.inputBuffer);
        } else {
            contentInputStream = null;
        }
        final ContentInputStream contentInputStream2 = contentInputStream;
        this.outputBuffer = new SharedOutputBuffer(this.initialBufferSize);
        final ContentOutputStream contentOutputStream = new ContentOutputStream(this.outputBuffer) { // from class: org.apache.hc.core5.http.nio.support.classic.AbstractClassicServerExchangeHandler.2
            private void triggerResponse() throws IOException {
                try {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        responseChannel.sendResponse(basicHttpResponse, new EntityDetails() { // from class: org.apache.hc.core5.http.nio.support.classic.AbstractClassicServerExchangeHandler.2.1
                            @Override // org.apache.hc.core5.http.EntityDetails
                            public long getContentLength() {
                                return -1L;
                            }

                            @Override // org.apache.hc.core5.http.EntityDetails
                            public boolean isChunked() {
                                return false;
                            }

                            @Override // org.apache.hc.core5.http.EntityDetails
                            public String getContentType() {
                                Header firstHeader = basicHttpResponse.getFirstHeader("Content-Type");
                                if (firstHeader != null) {
                                    return firstHeader.getValue();
                                }
                                return null;
                            }

                            @Override // org.apache.hc.core5.http.EntityDetails
                            public String getContentEncoding() {
                                Header firstHeader = basicHttpResponse.getFirstHeader("Content-Encoding");
                                if (firstHeader != null) {
                                    return firstHeader.getValue();
                                }
                                return null;
                            }

                            @Override // org.apache.hc.core5.http.EntityDetails
                            public Set<String> getTrailerNames() {
                                return Collections.emptySet();
                            }
                        }, httpContext);
                    }
                } catch (HttpException e) {
                    throw new IOException(e.getMessage(), e);
                }
            }

            @Override // org.apache.hc.core5.http.nio.support.classic.ContentOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                triggerResponse();
                super.close();
            }

            @Override // org.apache.hc.core5.http.nio.support.classic.ContentOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                triggerResponse();
                super.write(bArr, i, i2);
            }

            @Override // org.apache.hc.core5.http.nio.support.classic.ContentOutputStream, java.io.OutputStream
            public void write(byte[] bArr) throws IOException {
                triggerResponse();
                super.write(bArr);
            }

            @Override // org.apache.hc.core5.http.nio.support.classic.ContentOutputStream, java.io.OutputStream
            public void write(int i) throws IOException {
                triggerResponse();
                super.write(i);
            }
        };
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.state, State.IDLE, State.ACTIVE)) {
            this.executor.execute(new Runnable() { // from class: org.apache.hc.core5.http.nio.support.classic.AbstractClassicServerExchangeHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m16641xf4eca08a(httpRequest, contentInputStream2, httpResponseWrapper, contentOutputStream, httpContext);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$handleRequest$0$org-apache-hc-core5-http-nio-support-classic-AbstractClassicServerExchangeHandler, reason: not valid java name */
    /* synthetic */ void m16641xf4eca08a(HttpRequest httpRequest, InputStream inputStream, HttpResponse httpResponse, OutputStream outputStream, HttpContext httpContext) {
        try {
            try {
                handle(httpRequest, inputStream, httpResponse, outputStream, httpContext);
                Closer.close(inputStream);
                outputStream.close();
            } catch (Exception e) {
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.exception, null, e);
                if (this.inputBuffer != null) {
                    this.inputBuffer.abort();
                }
                this.outputBuffer.abort();
            }
        } finally {
            this.state.set(State.COMPLETED);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        if (this.inputBuffer != null) {
            this.inputBuffer.updateCapacity(capacityChannel);
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        Asserts.notNull(this.inputBuffer, "Input buffer");
        this.inputBuffer.fill(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        Asserts.notNull(this.inputBuffer, "Input buffer");
        this.inputBuffer.markEndStream();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final int available() {
        Asserts.notNull(this.outputBuffer, "Output buffer");
        return this.outputBuffer.length();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final void produce(DataStreamChannel dataStreamChannel) throws IOException {
        Asserts.notNull(this.outputBuffer, "Output buffer");
        this.outputBuffer.flush(dataStreamChannel);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataExchangeHandler
    public final void failed(Exception exc) {
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.exception, null, exc);
        releaseResources();
    }
}
