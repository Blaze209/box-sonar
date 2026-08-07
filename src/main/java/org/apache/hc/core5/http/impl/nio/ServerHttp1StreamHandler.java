package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.MisdirectedRequestException;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.UnsupportedHttpVersionException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.ServerSupport;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.apache.hc.core5.http.nio.AsyncPushProducer;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.nio.ResourceHolder;
import org.apache.hc.core5.http.nio.ResponseChannel;
import org.apache.hc.core5.http.nio.support.BasicResponseProducer;
import org.apache.hc.core5.http.nio.support.ImmediateResponseExchangeHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.http.protocol.HttpProcessor;

/* JADX INFO: loaded from: classes5.dex */
class ServerHttp1StreamHandler implements ResourceHolder {
    private final ConnectionReuseStrategy connectionReuseStrategy;
    private final HttpCoreContext context;
    private final AtomicBoolean done;
    private volatile AsyncServerExchangeHandler exchangeHandler;
    private final HandlerFactory<AsyncServerExchangeHandler> exchangeHandlerFactory;
    private final Http1Config http1Config;
    private final HttpProcessor httpProcessor;
    private final DataStreamChannel internalDataChannel;
    private volatile boolean keepAlive;
    private final Http1StreamChannel<HttpResponse> outputChannel;
    private volatile HttpRequest receivedRequest;
    private volatile MessageState requestState;
    private final ResponseChannel responseChannel = new ResponseChannel() { // from class: org.apache.hc.core5.http.impl.nio.ServerHttp1StreamHandler.2
        @Override // org.apache.hc.core5.http.nio.ResponseChannel
        public void sendInformation(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
            ServerHttp1StreamHandler.this.commitInformation(httpResponse);
        }

        @Override // org.apache.hc.core5.http.nio.ResponseChannel
        public void sendResponse(HttpResponse httpResponse, EntityDetails entityDetails, HttpContext httpContext) throws HttpException, IOException {
            ServerHttp1StreamHandler.this.commitResponse(httpResponse, entityDetails);
        }

        @Override // org.apache.hc.core5.http.nio.ResponseChannel
        public void pushPromise(HttpRequest httpRequest, AsyncPushProducer asyncPushProducer, HttpContext httpContext) throws HttpException, IOException {
            ServerHttp1StreamHandler.this.commitPromise();
        }

        public String toString() {
            return super.toString() + " " + ServerHttp1StreamHandler.this;
        }
    };
    private final AtomicBoolean responseCommitted;
    private volatile MessageState responseState;

    ServerHttp1StreamHandler(final Http1StreamChannel<HttpResponse> http1StreamChannel, HttpProcessor httpProcessor, Http1Config http1Config, ConnectionReuseStrategy connectionReuseStrategy, HandlerFactory<AsyncServerExchangeHandler> handlerFactory, HttpCoreContext httpCoreContext) {
        this.outputChannel = http1StreamChannel;
        this.internalDataChannel = new DataStreamChannel() { // from class: org.apache.hc.core5.http.impl.nio.ServerHttp1StreamHandler.1
            @Override // org.apache.hc.core5.http.nio.DataStreamChannel
            public void requestOutput() {
                http1StreamChannel.requestOutput();
            }

            @Override // org.apache.hc.core5.http.nio.DataStreamChannel
            public void endStream(List<? extends Header> list) throws IOException {
                http1StreamChannel.complete(list);
                if (!ServerHttp1StreamHandler.this.keepAlive) {
                    http1StreamChannel.close();
                }
                ServerHttp1StreamHandler.this.responseState = MessageState.COMPLETE;
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
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.connectionReuseStrategy = connectionReuseStrategy;
        this.exchangeHandlerFactory = handlerFactory;
        this.context = httpCoreContext;
        this.responseCommitted = new AtomicBoolean();
        this.done = new AtomicBoolean();
        this.keepAlive = true;
        this.requestState = MessageState.HEADERS;
        this.responseState = MessageState.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitResponse(HttpResponse httpResponse, EntityDetails entityDetails) throws HttpException, IOException {
        boolean z = true;
        if (this.responseCommitted.compareAndSet(false, true)) {
            ProtocolVersion version = httpResponse.getVersion();
            if (version != null) {
                if (!version.lessEquals(this.http1Config.getVersion())) {
                    throw new UnsupportedHttpVersionException(version);
                }
                this.context.setProtocolVersion(version);
            }
            int code = httpResponse.getCode();
            if (code < 200) {
                throw new HttpException("Invalid response: " + code);
            }
            this.context.setResponse(httpResponse);
            this.httpProcessor.process(httpResponse, entityDetails, this.context);
            if (entityDetails != null && (this.receivedRequest == null || !Method.HEAD.isSame(this.receivedRequest.getMethod()))) {
                z = false;
            }
            if (!this.connectionReuseStrategy.keepAlive(this.receivedRequest, httpResponse, this.context)) {
                this.keepAlive = false;
            }
            this.outputChannel.submit(httpResponse, z, z ? FlushMode.IMMEDIATE : FlushMode.BUFFER);
            if (z) {
                if (!this.keepAlive) {
                    this.outputChannel.close();
                }
                this.responseState = MessageState.COMPLETE;
                return;
            } else {
                this.responseState = MessageState.BODY;
                this.exchangeHandler.produce(this.internalDataChannel);
                return;
            }
        }
        throw new HttpException("Response already committed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitInformation(HttpResponse httpResponse) throws HttpException, IOException {
        if (this.responseCommitted.get()) {
            throw new HttpException("Response already committed");
        }
        int code = httpResponse.getCode();
        if (code < 100 || code >= 200) {
            throw new HttpException("Invalid intermediate response: " + code);
        }
        this.outputChannel.submit(httpResponse, true, FlushMode.IMMEDIATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitPromise() throws HttpException {
        throw new HttpException("HTTP/1.1 does not support server push");
    }

    void activateChannel() throws HttpException, IOException {
        this.outputChannel.activate();
    }

    boolean isResponseFinal() {
        return this.responseState == MessageState.COMPLETE;
    }

    boolean keepAlive() {
        return this.keepAlive;
    }

    boolean isCompleted() {
        return this.requestState == MessageState.COMPLETE && this.responseState == MessageState.COMPLETE;
    }

    void terminateExchange(HttpException httpException) throws HttpException, IOException {
        if (this.done.get() || this.requestState != MessageState.HEADERS) {
            throw new ProtocolException("Unexpected message head");
        }
        this.receivedRequest = null;
        this.requestState = MessageState.COMPLETE;
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(ServerSupport.toStatusCode(httpException));
        basicHttpResponse.addHeader("Connection", HeaderElements.CLOSE);
        this.exchangeHandler = new ImmediateResponseExchangeHandler(new BasicResponseProducer(basicHttpResponse, ServerSupport.toErrorMessage(httpException)));
        this.exchangeHandler.handleRequest(null, null, this.responseChannel, this.context);
    }

    void consumeHeader(HttpRequest httpRequest, EntityDetails entityDetails) throws HttpException, IOException {
        ImmediateResponseExchangeHandler immediateResponseExchangeHandler;
        AsyncServerExchangeHandler immediateResponseExchangeHandler2;
        if (this.done.get() || this.requestState != MessageState.HEADERS) {
            throw new ProtocolException("Unexpected message head");
        }
        this.receivedRequest = httpRequest;
        this.requestState = entityDetails == null ? MessageState.COMPLETE : MessageState.BODY;
        ProtocolVersion version = httpRequest.getVersion();
        if (version != null && version.greaterEquals(HttpVersion.HTTP_2)) {
            throw new UnsupportedHttpVersionException(version);
        }
        HttpCoreContext httpCoreContext = this.context;
        if (version == null) {
            version = this.http1Config.getVersion();
        }
        httpCoreContext.setProtocolVersion(version);
        this.context.setRequest(httpRequest);
        try {
            this.httpProcessor.process(httpRequest, entityDetails, this.context);
            try {
                try {
                    immediateResponseExchangeHandler2 = (AsyncServerExchangeHandler) this.exchangeHandlerFactory.create(httpRequest, this.context);
                } catch (HttpException e) {
                    immediateResponseExchangeHandler = new ImmediateResponseExchangeHandler(500, e.getMessage());
                    immediateResponseExchangeHandler2 = immediateResponseExchangeHandler;
                }
            } catch (MisdirectedRequestException e2) {
                immediateResponseExchangeHandler = new ImmediateResponseExchangeHandler(421, e2.getMessage());
                immediateResponseExchangeHandler2 = immediateResponseExchangeHandler;
            }
            if (immediateResponseExchangeHandler2 == null) {
                immediateResponseExchangeHandler2 = new ImmediateResponseExchangeHandler(404, "Cannot handle request");
            }
            this.exchangeHandler = immediateResponseExchangeHandler2;
            this.exchangeHandler.handleRequest(httpRequest, entityDetails, this.responseChannel, this.context);
        } catch (HttpException e3) {
            if (!this.responseCommitted.get()) {
                BasicHttpResponse basicHttpResponse = new BasicHttpResponse(ServerSupport.toStatusCode(e3));
                basicHttpResponse.addHeader("Connection", HeaderElements.CLOSE);
                this.exchangeHandler = new ImmediateResponseExchangeHandler(new BasicResponseProducer(basicHttpResponse, ServerSupport.toErrorMessage(e3)));
                this.exchangeHandler.handleRequest(httpRequest, entityDetails, this.responseChannel, this.context);
                return;
            }
            throw e3;
        }
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.nio.ServerHttp1StreamHandler$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState;

        static {
            int[] iArr = new int[MessageState.values().length];
            $SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState = iArr;
            try {
                iArr[MessageState.BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    boolean isOutputReady() {
        return AnonymousClass3.$SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState[this.responseState.ordinal()] == 1 && this.exchangeHandler.available() > 0;
    }

    void produceOutput() throws IOException {
        if (AnonymousClass3.$SwitchMap$org$apache$hc$core5$http$impl$nio$MessageState[this.responseState.ordinal()] != 1) {
            return;
        }
        this.exchangeHandler.produce(this.internalDataChannel);
    }

    void consumeData(ByteBuffer byteBuffer) throws HttpException, IOException {
        if (this.done.get() || this.requestState != MessageState.BODY) {
            throw new ProtocolException("Unexpected message data");
        }
        if (this.responseState == MessageState.ACK) {
            this.outputChannel.requestOutput();
        }
        this.exchangeHandler.consume(byteBuffer);
    }

    void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.exchangeHandler.updateCapacity(capacityChannel);
    }

    void dataEnd(List<? extends Header> list) throws HttpException, IOException {
        if (this.done.get() || this.requestState != MessageState.BODY) {
            throw new ProtocolException("Unexpected message data");
        }
        this.requestState = MessageState.COMPLETE;
        this.exchangeHandler.streamEnd(list);
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
            this.requestState = MessageState.COMPLETE;
            this.responseState = MessageState.COMPLETE;
            this.exchangeHandler.releaseResources();
        }
    }

    void appendState(StringBuilder sb) {
        sb.append("requestState=").append(this.requestState).append(", responseState=").append(this.responseState).append(", responseCommitted=").append(this.responseCommitted).append(", keepAlive=").append(this.keepAlive).append(", done=").append(this.done);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        appendState(sb);
        sb.append("]");
        return sb.toString();
    }
}
