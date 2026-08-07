package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSession;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.BasicHttpConnectionMetrics;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.ContentDecoder;
import org.apache.hc.core5.http.nio.ContentEncoder;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.nio.NHttpMessageParser;
import org.apache.hc.core5.http.nio.NHttpMessageWriter;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;
import org.apache.hc.core5.http.nio.command.RequestExecutionCommand;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.reactor.ProtocolIOSession;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class ServerHttp1StreamDuplexer extends AbstractHttp1StreamDuplexer<HttpRequest, HttpResponse> {
    private final ConnectionReuseStrategy connectionReuseStrategy;
    private final HandlerFactory<AsyncServerExchangeHandler> exchangeHandlerFactory;
    private final Http1Config http1Config;
    private final HttpProcessor httpProcessor;
    private volatile ServerHttp1StreamHandler incoming;
    private volatile ServerHttp1StreamHandler outgoing;
    private final Http1StreamChannel<HttpResponse> outputChannel;
    private final Queue<ServerHttp1StreamHandler> pipeline;
    private final String scheme;
    private final Http1StreamListener streamListener;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public boolean handleIncomingMessage(HttpRequest httpRequest) throws HttpException {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public boolean handleOutgoingMessage(HttpResponse httpResponse) throws HttpException {
        return true;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    boolean handleTimeout() {
        return false;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.io.ModalCloseable
    public /* bridge */ /* synthetic */ void close(CloseMode closeMode) {
        super.close(closeMode);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ EndpointDetails getEndpointDetails() {
        return super.getEndpointDetails();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.util.Identifiable
    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SocketAddress getLocalAddress() {
        return super.getLocalAddress();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ ProtocolVersion getProtocolVersion() {
        return super.getProtocolVersion();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SocketAddress getRemoteAddress() {
        return super.getRemoteAddress();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SSLSession getSSLSession() {
        return super.getSSLSession();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.SocketModalCloseable
    public /* bridge */ /* synthetic */ Timeout getSocketTimeout() {
        return super.getSocketTimeout();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer, org.apache.hc.core5.http.SocketModalCloseable
    public /* bridge */ /* synthetic */ void setSocketTimeout(Timeout timeout) {
        super.setSocketTimeout(timeout);
    }

    public ServerHttp1StreamDuplexer(ProtocolIOSession protocolIOSession, HttpProcessor httpProcessor, HandlerFactory<AsyncServerExchangeHandler> handlerFactory, String str, Http1Config http1Config, CharCodingConfig charCodingConfig, ConnectionReuseStrategy connectionReuseStrategy, NHttpMessageParser<HttpRequest> nHttpMessageParser, NHttpMessageWriter<HttpResponse> nHttpMessageWriter, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, final Http1StreamListener http1StreamListener) {
        super(protocolIOSession, http1Config, charCodingConfig, nHttpMessageParser, nHttpMessageWriter, contentLengthStrategy, contentLengthStrategy2);
        this.httpProcessor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.exchangeHandlerFactory = (HandlerFactory) Args.notNull(handlerFactory, "Exchange handler factory");
        this.scheme = str == null ? URIScheme.HTTP.getId() : str;
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.connectionReuseStrategy = connectionReuseStrategy != null ? connectionReuseStrategy : DefaultConnectionReuseStrategy.INSTANCE;
        this.streamListener = http1StreamListener;
        this.pipeline = new ConcurrentLinkedQueue();
        this.outputChannel = new Http1StreamChannel<HttpResponse>() { // from class: org.apache.hc.core5.http.impl.nio.ServerHttp1StreamDuplexer.1
            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void activate() throws HttpException, IOException {
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void close() {
                ServerHttp1StreamDuplexer.this.close(CloseMode.GRACEFUL);
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void submit(HttpResponse httpResponse, boolean z, FlushMode flushMode) throws HttpException, IOException {
                Http1StreamListener http1StreamListener2 = http1StreamListener;
                if (http1StreamListener2 != null) {
                    http1StreamListener2.onResponseHead(ServerHttp1StreamDuplexer.this, httpResponse);
                }
                ServerHttp1StreamDuplexer.this.commitMessageHead(httpResponse, z, flushMode);
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void requestOutput() {
                ServerHttp1StreamDuplexer.this.requestSessionOutput();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void suspendOutput() throws IOException {
                ServerHttp1StreamDuplexer.this.suspendSessionOutput();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public Timeout getSocketTimeout() {
                return ServerHttp1StreamDuplexer.this.getSessionTimeout();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void setSocketTimeout(Timeout timeout) {
                ServerHttp1StreamDuplexer.this.setSessionTimeout(timeout);
            }

            @Override // org.apache.hc.core5.http.nio.ContentEncoder
            public int write(ByteBuffer byteBuffer) throws IOException {
                return ServerHttp1StreamDuplexer.this.streamOutput(byteBuffer);
            }

            @Override // org.apache.hc.core5.http.nio.ContentEncoder
            public void complete(List<? extends Header> list) throws IOException {
                ServerHttp1StreamDuplexer.this.endOutputStream(list);
            }

            @Override // org.apache.hc.core5.http.nio.ContentEncoder
            public boolean isCompleted() {
                return ServerHttp1StreamDuplexer.this.isOutputCompleted();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public boolean abortGracefully() throws IOException {
                return ServerHttp1StreamDuplexer.this.endOutputStream(null) != AbstractHttp1StreamDuplexer.MessageDelineation.MESSAGE_HEAD;
            }

            public String toString() {
                return "Http1StreamChannel[" + ServerHttp1StreamDuplexer.this + "]";
            }
        };
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void terminate(Exception exc) {
        if (this.incoming != null) {
            this.incoming.failed(exc);
            this.incoming.releaseResources();
            this.incoming = null;
        }
        if (this.outgoing != null) {
            this.outgoing.failed(exc);
            this.outgoing.releaseResources();
            this.outgoing = null;
        }
        while (true) {
            ServerHttp1StreamHandler serverHttp1StreamHandlerPoll = this.pipeline.poll();
            if (serverHttp1StreamHandlerPoll == null) {
                return;
            }
            serverHttp1StreamHandlerPoll.failed(exc);
            serverHttp1StreamHandlerPoll.releaseResources();
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void disconnected() {
        if (this.incoming != null) {
            if (!this.incoming.isCompleted()) {
                this.incoming.failed(new ConnectionClosedException());
            }
            this.incoming.releaseResources();
            this.incoming = null;
        }
        if (this.outgoing != null) {
            if (!this.outgoing.isCompleted()) {
                this.outgoing.failed(new ConnectionClosedException());
            }
            this.outgoing.releaseResources();
            this.outgoing = null;
        }
        while (true) {
            ServerHttp1StreamHandler serverHttp1StreamHandlerPoll = this.pipeline.poll();
            if (serverHttp1StreamHandlerPoll == null) {
                return;
            }
            serverHttp1StreamHandlerPoll.failed(new ConnectionClosedException());
            serverHttp1StreamHandlerPoll.releaseResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public void updateInputMetrics(HttpRequest httpRequest, BasicHttpConnectionMetrics basicHttpConnectionMetrics) {
        basicHttpConnectionMetrics.incrementRequestCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public void updateOutputMetrics(HttpResponse httpResponse, BasicHttpConnectionMetrics basicHttpConnectionMetrics) {
        if (httpResponse.getCode() >= 200) {
            basicHttpConnectionMetrics.incrementResponseCount();
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    protected ContentDecoder createContentDecoder(long j, ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) throws HttpException {
        if (j >= 0) {
            return new LengthDelimitedDecoder(readableByteChannel, sessionInputBuffer, basicHttpTransportMetrics, j);
        }
        if (j == -1) {
            return new ChunkDecoder(readableByteChannel, sessionInputBuffer, this.http1Config, basicHttpTransportMetrics);
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    protected ContentEncoder createContentEncoder(long j, WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) throws HttpException {
        int chunkSizeHint = this.http1Config.getChunkSizeHint() >= 0 ? this.http1Config.getChunkSizeHint() : 2048;
        if (j >= 0) {
            return new LengthDelimitedEncoder(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics, j, chunkSizeHint);
        }
        if (j == -1) {
            return new ChunkEncoder(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics, chunkSizeHint);
        }
        return new IdentityEncoder(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics, chunkSizeHint);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    boolean inputIdle() {
        return this.incoming == null;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    boolean outputIdle() {
        return this.outgoing == null && this.pipeline.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public HttpRequest parseMessageHead(boolean z) throws HttpException, IOException {
        try {
            return (HttpRequest) super.parseMessageHead(z);
        } catch (HttpException e) {
            terminateExchange(e);
            return null;
        }
    }

    void terminateExchange(HttpException httpException) throws HttpException, IOException {
        ServerHttp1StreamHandler serverHttp1StreamHandler;
        suspendSessionInput();
        HttpCoreContext httpCoreContextCreate = HttpCoreContext.create();
        httpCoreContextCreate.setSSLSession(getSSLSession());
        httpCoreContextCreate.setEndpointDetails(getEndpointDetails());
        if (this.outgoing == null) {
            serverHttp1StreamHandler = new ServerHttp1StreamHandler(this.outputChannel, this.httpProcessor, this.http1Config, this.connectionReuseStrategy, this.exchangeHandlerFactory, httpCoreContextCreate);
            this.outgoing = serverHttp1StreamHandler;
        } else {
            serverHttp1StreamHandler = new ServerHttp1StreamHandler(new DelayedOutputChannel(this.outputChannel), this.httpProcessor, this.http1Config, this.connectionReuseStrategy, this.exchangeHandlerFactory, httpCoreContextCreate);
            this.pipeline.add(serverHttp1StreamHandler);
        }
        serverHttp1StreamHandler.terminateExchange(httpException);
        this.incoming = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public void consumeHeader(HttpRequest httpRequest, EntityDetails entityDetails) throws HttpException, IOException {
        ServerHttp1StreamHandler serverHttp1StreamHandler;
        Http1StreamListener http1StreamListener = this.streamListener;
        if (http1StreamListener != null) {
            http1StreamListener.onRequestHead(this, httpRequest);
        }
        HttpCoreContext httpCoreContextCreate = HttpCoreContext.create();
        httpCoreContextCreate.setSSLSession(getSSLSession());
        httpCoreContextCreate.setEndpointDetails(getEndpointDetails());
        if (this.outgoing == null) {
            serverHttp1StreamHandler = new ServerHttp1StreamHandler(this.outputChannel, this.httpProcessor, this.http1Config, this.connectionReuseStrategy, this.exchangeHandlerFactory, httpCoreContextCreate);
            this.outgoing = serverHttp1StreamHandler;
        } else {
            serverHttp1StreamHandler = new ServerHttp1StreamHandler(new DelayedOutputChannel(this.outputChannel), this.httpProcessor, this.http1Config, this.connectionReuseStrategy, this.exchangeHandlerFactory, httpCoreContextCreate);
            this.pipeline.add(serverHttp1StreamHandler);
        }
        httpRequest.setScheme(this.scheme);
        serverHttp1StreamHandler.consumeHeader(httpRequest, entityDetails);
        this.incoming = serverHttp1StreamHandler;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void consumeData(ByteBuffer byteBuffer) throws HttpException, IOException {
        Asserts.notNull(this.incoming, "Request stream handler");
        this.incoming.consumeData(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void updateCapacity(CapacityChannel capacityChannel) throws HttpException, IOException {
        Asserts.notNull(this.incoming, "Request stream handler");
        this.incoming.updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void dataEnd(List<? extends Header> list) throws HttpException, IOException {
        Asserts.notNull(this.incoming, "Request stream handler");
        this.incoming.dataEnd(list);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void inputEnd() throws HttpException, IOException {
        if (this.incoming != null) {
            if (this.incoming.isCompleted()) {
                this.incoming.releaseResources();
            }
            this.incoming = null;
        }
        if (isShuttingDown() && outputIdle() && inputIdle()) {
            shutdownSession(CloseMode.IMMEDIATE);
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void execute(RequestExecutionCommand requestExecutionCommand) throws HttpException {
        throw new HttpException("Illegal command: " + requestExecutionCommand.getClass());
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    boolean isOutputReady() {
        return this.outgoing != null && this.outgoing.isOutputReady();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void produceOutput() throws HttpException, IOException {
        if (this.outgoing != null) {
            this.outgoing.produceOutput();
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void outputEnd() throws HttpException, IOException {
        ServerHttp1StreamHandler serverHttp1StreamHandlerPoll;
        if (this.outgoing != null && this.outgoing.isResponseFinal()) {
            Http1StreamListener http1StreamListener = this.streamListener;
            if (http1StreamListener != null) {
                http1StreamListener.onExchangeComplete(this, this.outgoing.keepAlive());
            }
            if (this.outgoing.isCompleted()) {
                this.outgoing.releaseResources();
            }
            this.outgoing = null;
        }
        if (this.outgoing == null && isActive() && (serverHttp1StreamHandlerPoll = this.pipeline.poll()) != null) {
            this.outgoing = serverHttp1StreamHandlerPoll;
            serverHttp1StreamHandlerPoll.activateChannel();
            if (serverHttp1StreamHandlerPoll.isOutputReady()) {
                serverHttp1StreamHandlerPoll.produceOutput();
            }
        }
        if (isShuttingDown() && outputIdle() && inputIdle()) {
            shutdownSession(CloseMode.IMMEDIATE);
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void appendState(StringBuilder sb) {
        super.appendState(sb);
        sb.append(", incoming=[");
        if (this.incoming != null) {
            this.incoming.appendState(sb);
        }
        sb.append("], outgoing=[");
        if (this.outgoing != null) {
            this.outgoing.appendState(sb);
        }
        sb.append("], pipeline=");
        sb.append(this.pipeline.size());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        appendState(sb);
        sb.append("]");
        return sb.toString();
    }

    private static class DelayedOutputChannel implements Http1StreamChannel<HttpResponse> {
        private final Http1StreamChannel<HttpResponse> channel;
        private volatile boolean completed;
        private volatile HttpResponse delayedResponse;
        private volatile boolean direct;
        private final ReentrantLock lock;

        private DelayedOutputChannel(Http1StreamChannel<HttpResponse> http1StreamChannel) {
            this.lock = new ReentrantLock();
            this.channel = http1StreamChannel;
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public void close() {
            this.channel.close();
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public void submit(HttpResponse httpResponse, boolean z, FlushMode flushMode) throws HttpException, IOException {
            this.lock.lock();
            try {
                if (this.direct) {
                    this.channel.submit(httpResponse, z, flushMode);
                } else {
                    this.delayedResponse = httpResponse;
                    this.completed = z;
                }
            } finally {
                this.lock.unlock();
            }
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public void suspendOutput() throws IOException {
            this.channel.suspendOutput();
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public void requestOutput() {
            this.channel.requestOutput();
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public Timeout getSocketTimeout() {
            return this.channel.getSocketTimeout();
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public void setSocketTimeout(Timeout timeout) {
            this.channel.setSocketTimeout(timeout);
        }

        @Override // org.apache.hc.core5.http.nio.ContentEncoder
        public int write(ByteBuffer byteBuffer) throws IOException {
            this.lock.lock();
            try {
                return this.direct ? this.channel.write(byteBuffer) : 0;
            } finally {
                this.lock.unlock();
            }
        }

        @Override // org.apache.hc.core5.http.nio.ContentEncoder
        public void complete(List<? extends Header> list) throws IOException {
            this.lock.lock();
            try {
                if (this.direct) {
                    this.channel.complete(list);
                } else {
                    this.completed = true;
                }
            } finally {
                this.lock.unlock();
            }
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public boolean abortGracefully() throws IOException {
            boolean zAbortGracefully;
            this.lock.lock();
            try {
                if (this.direct) {
                    zAbortGracefully = this.channel.abortGracefully();
                } else {
                    zAbortGracefully = true;
                    this.completed = true;
                }
                return zAbortGracefully;
            } finally {
                this.lock.unlock();
            }
        }

        @Override // org.apache.hc.core5.http.nio.ContentEncoder
        public boolean isCompleted() {
            this.lock.lock();
            try {
                return this.direct ? this.channel.isCompleted() : this.completed;
            } finally {
                this.lock.unlock();
            }
        }

        @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
        public void activate() throws HttpException, IOException {
            this.lock.lock();
            try {
                this.direct = true;
                if (this.delayedResponse != null) {
                    this.channel.submit(this.delayedResponse, this.completed, this.completed ? FlushMode.IMMEDIATE : FlushMode.BUFFER);
                    this.delayedResponse = null;
                }
            } finally {
                this.lock.unlock();
            }
        }
    }
}
