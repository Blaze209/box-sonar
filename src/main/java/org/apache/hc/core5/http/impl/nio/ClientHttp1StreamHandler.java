package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.UnsupportedHttpVersionException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.http.nio.AsyncClientExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.RequestChannel;
import org.apache.hc.core5.http.nio.ResourceHolder;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
class ClientHttp1StreamHandler implements ResourceHolder {
    public static final Timeout DEFAULT_WAIT_FOR_CONTINUE = Timeout.ofSeconds(3L);
    private volatile HttpRequest committedRequest;
    private final ConnectionReuseStrategy connectionReuseStrategy;
    private final HttpCoreContext context;
    private final AsyncClientExchangeHandler exchangeHandler;
    private final Http1Config http1Config;
    private final HttpProcessor httpProcessor;
    private final DataStreamChannel internalDataChannel;
    private final Http1StreamChannel<HttpRequest> outputChannel;
    private volatile Timeout timeout;
    private final AtomicBoolean requestCommitted = new AtomicBoolean();
    private final AtomicBoolean done = new AtomicBoolean();
    private volatile boolean keepAlive = true;
    private volatile MessageState requestState = MessageState.IDLE;
    private volatile MessageState responseState = MessageState.HEADERS;

    ClientHttp1StreamHandler(final Http1StreamChannel<HttpRequest> http1StreamChannel, HttpProcessor httpProcessor, Http1Config http1Config, ConnectionReuseStrategy connectionReuseStrategy, AsyncClientExchangeHandler asyncClientExchangeHandler, HttpCoreContext httpCoreContext) {
        this.outputChannel = http1StreamChannel;
        this.internalDataChannel = new DataStreamChannel() { // from class: org.apache.hc.core5.http.impl.nio.ClientHttp1StreamHandler.1
            @Override // org.apache.hc.core5.http.nio.DataStreamChannel
            public void requestOutput() {
                http1StreamChannel.requestOutput();
            }

            @Override // org.apache.hc.core5.http.nio.DataStreamChannel
            public void endStream(List<? extends Header> list) throws IOException {
                http1StreamChannel.complete(list);
                ClientHttp1StreamHandler.this.requestState = MessageState.COMPLETE;
            }

            @Override // org.apache.hc.core5.http.nio.DataStreamChannel, org.apache.hc.core5.http.nio.StreamChannel
            public int write(ByteBuffer byteBuffer) throws IOException {
                return http1StreamChannel.write(byteBuffer);
            }

            @Override // org.apache.hc.core5.http.nio.StreamChannel
            public void endStream() throws IOException {
                endStream(null);
            }
        };
        this.httpProcessor = httpProcessor;
        this.http1Config = http1Config;
        this.connectionReuseStrategy = connectionReuseStrategy;
        this.exchangeHandler = asyncClientExchangeHandler;
        this.context = httpCoreContext;
    }

    boolean isResponseFinal() {
        return this.responseState == MessageState.COMPLETE;
    }

    boolean isCompleted() {
        return this.requestState == MessageState.COMPLETE && this.responseState == MessageState.COMPLETE;
    }

    String getRequestMethod() {
        if (this.committedRequest != null) {
            return this.committedRequest.getMethod();
        }
        return null;
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.nio.ClientHttp1StreamHandler$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState;

        static {
            int[] iArr = new int[MessageState.values().length];
            $SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState = iArr;
            try {
                iArr[MessageState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState[MessageState.ACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState[MessageState.BODY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    boolean isOutputReady() {
        int i = AnonymousClass2.$SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState[this.requestState.ordinal()];
        if (i == 1 || i == 2) {
            return true;
        }
        return i == 3 && this.exchangeHandler.available() > 0;
    }

    private void commitRequest(HttpRequest httpRequest, EntityDetails entityDetails) throws HttpException, IOException {
        if (this.requestCommitted.compareAndSet(false, true)) {
            ProtocolVersion version = httpRequest.getVersion();
            if (version != null && !version.lessEquals(this.http1Config.getVersion())) {
                throw new UnsupportedHttpVersionException(version);
            }
            HttpCoreContext httpCoreContext = this.context;
            if (version == null) {
                version = this.http1Config.getVersion();
            }
            httpCoreContext.setProtocolVersion(version);
            this.context.setRequest(httpRequest);
            this.httpProcessor.process(httpRequest, entityDetails, this.context);
            if (entityDetails == null) {
                this.outputChannel.submit(httpRequest, true, FlushMode.IMMEDIATE);
                this.committedRequest = httpRequest;
                this.requestState = MessageState.COMPLETE;
                return;
            }
            Header firstHeader = httpRequest.getFirstHeader("Expect");
            boolean z = firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
            this.outputChannel.submit(httpRequest, false, z ? FlushMode.IMMEDIATE : FlushMode.BUFFER);
            this.committedRequest = httpRequest;
            if (z) {
                this.requestState = MessageState.ACK;
                this.timeout = this.outputChannel.getSocketTimeout();
                this.outputChannel.setSocketTimeout(this.http1Config.getWaitForContinueTimeout() != null ? this.http1Config.getWaitForContinueTimeout() : DEFAULT_WAIT_FOR_CONTINUE);
                return;
            } else {
                this.requestState = MessageState.BODY;
                this.exchangeHandler.produce(this.internalDataChannel);
                return;
            }
        }
        throw new HttpException("Request already committed");
    }

    void produceOutput() throws HttpException, IOException {
        int i = AnonymousClass2.$SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState[this.requestState.ordinal()];
        if (i == 1) {
            this.requestState = MessageState.HEADERS;
            this.exchangeHandler.produceRequest(new RequestChannel() { // from class: org.apache.hc.core5.http.impl.nio.ClientHttp1StreamHandler$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.http.nio.RequestChannel
                public final void sendRequest(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
                    this.f$0.m16635x632607f4(httpRequest, entityDetails, httpContext);
                }
            }, this.context);
        } else if (i == 2) {
            this.outputChannel.suspendOutput();
        } else {
            if (i != 3) {
                return;
            }
            this.exchangeHandler.produce(this.internalDataChannel);
        }
    }

    /* JADX INFO: renamed from: lambda$produceOutput$0$org-apache-hc-core5-http-impl-nio-ClientHttp1StreamHandler, reason: not valid java name */
    /* synthetic */ void m16635x632607f4(HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
        commitRequest(httpRequest, entityDetails);
    }

    void consumeHeader(HttpResponse httpResponse, EntityDetails entityDetails) throws HttpException, IOException {
        if (this.done.get() || this.responseState != MessageState.HEADERS) {
            throw new ProtocolException("Unexpected message head");
        }
        ProtocolVersion version = httpResponse.getVersion();
        if (version != null) {
            if (version.greaterEquals(HttpVersion.HTTP_2)) {
                throw new UnsupportedHttpVersionException(version);
            }
            this.context.setProtocolVersion(version);
        }
        int code = httpResponse.getCode();
        if (code < 100) {
            throw new ProtocolException("Invalid response: " + new StatusLine(httpResponse));
        }
        if (code > 100 && code < 200) {
            this.exchangeHandler.consumeInformation(httpResponse, this.context);
        } else if (!this.connectionReuseStrategy.keepAlive(this.committedRequest, httpResponse, this.context)) {
            this.keepAlive = false;
        }
        if (this.requestState == MessageState.ACK && (code == 100 || code >= 200)) {
            this.outputChannel.setSocketTimeout(this.timeout);
            this.requestState = MessageState.BODY;
            if (code < 400) {
                this.exchangeHandler.produce(this.internalDataChannel);
            }
        }
        if (code < 200) {
            return;
        }
        if (this.requestState == MessageState.BODY && code >= 400) {
            this.requestState = MessageState.COMPLETE;
            if (!this.outputChannel.abortGracefully()) {
                this.keepAlive = false;
            }
        }
        HttpCoreContext httpCoreContext = this.context;
        if (version == null) {
            version = HttpVersion.HTTP_1_1;
        }
        httpCoreContext.setProtocolVersion(version);
        this.context.setResponse(httpResponse);
        this.httpProcessor.process(httpResponse, entityDetails, this.context);
        if (entityDetails == null && !this.keepAlive) {
            this.outputChannel.close();
        }
        this.exchangeHandler.consumeResponse(httpResponse, entityDetails, this.context);
        if (entityDetails == null) {
            this.responseState = MessageState.COMPLETE;
        } else {
            this.responseState = MessageState.BODY;
        }
    }

    void consumeData(ByteBuffer byteBuffer) throws HttpException, IOException {
        if (this.done.get() || this.responseState != MessageState.BODY) {
            throw new ProtocolException("Unexpected message data");
        }
        this.exchangeHandler.consume(byteBuffer);
    }

    void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.exchangeHandler.updateCapacity(capacityChannel);
    }

    void dataEnd(List<? extends Header> list) throws HttpException, IOException {
        if (this.done.get() || this.responseState != MessageState.BODY) {
            throw new ProtocolException("Unexpected message data");
        }
        if (!this.keepAlive) {
            this.outputChannel.close();
        }
        this.responseState = MessageState.COMPLETE;
        this.exchangeHandler.streamEnd(list);
    }

    boolean handleTimeout() {
        if (this.requestState != MessageState.ACK) {
            return false;
        }
        this.requestState = MessageState.BODY;
        this.outputChannel.setSocketTimeout(this.timeout);
        this.outputChannel.requestOutput();
        return true;
    }

    void failed(Exception exc) {
        if (this.done.get()) {
            return;
        }
        this.exchangeHandler.failed(exc);
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        if (this.done.compareAndSet(false, true)) {
            this.responseState = MessageState.COMPLETE;
            this.requestState = MessageState.COMPLETE;
            this.exchangeHandler.releaseResources();
        }
    }

    void appendState(StringBuilder sb) {
        sb.append("requestState=").append(this.requestState).append(", responseState=").append(this.responseState).append(", responseCommitted=").append(this.requestCommitted).append(", keepAlive=").append(this.keepAlive).append(", done=").append(this.done);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        appendState(sb);
        sb.append("]");
        return sb.toString();
    }
}
