package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
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
import org.apache.hc.core5.http.LengthRequiredException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.BasicHttpConnectionMetrics;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.http.nio.AsyncClientExchangeHandler;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.ContentDecoder;
import org.apache.hc.core5.http.nio.ContentEncoder;
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
public class ClientHttp1StreamDuplexer extends AbstractHttp1StreamDuplexer<HttpResponse, HttpRequest> {
    private final ConnectionReuseStrategy connectionReuseStrategy;
    private final Http1Config http1Config;
    private final HttpProcessor httpProcessor;
    private volatile ClientHttp1StreamHandler incoming;
    private volatile ClientHttp1StreamHandler outgoing;
    private final Http1StreamChannel<HttpRequest> outputChannel;
    private final Queue<ClientHttp1StreamHandler> pipeline;
    private final Http1StreamListener streamListener;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public boolean handleOutgoingMessage(HttpRequest httpRequest) throws HttpException {
        return true;
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

    public ClientHttp1StreamDuplexer(ProtocolIOSession protocolIOSession, HttpProcessor httpProcessor, Http1Config http1Config, CharCodingConfig charCodingConfig, ConnectionReuseStrategy connectionReuseStrategy, NHttpMessageParser<HttpResponse> nHttpMessageParser, NHttpMessageWriter<HttpRequest> nHttpMessageWriter, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, final Http1StreamListener http1StreamListener) {
        super(protocolIOSession, http1Config, charCodingConfig, nHttpMessageParser, nHttpMessageWriter, contentLengthStrategy, contentLengthStrategy2);
        this.httpProcessor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.connectionReuseStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.streamListener = http1StreamListener;
        this.pipeline = new ConcurrentLinkedQueue();
        this.outputChannel = new Http1StreamChannel<HttpRequest>() { // from class: org.apache.hc.core5.http.impl.nio.ClientHttp1StreamDuplexer.1
            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void activate() throws HttpException, IOException {
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void close() {
                ClientHttp1StreamDuplexer.this.shutdownSession(CloseMode.IMMEDIATE);
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void submit(HttpRequest httpRequest, boolean z, FlushMode flushMode) throws HttpException, IOException {
                Http1StreamListener http1StreamListener2 = http1StreamListener;
                if (http1StreamListener2 != null) {
                    http1StreamListener2.onRequestHead(ClientHttp1StreamDuplexer.this, httpRequest);
                }
                ClientHttp1StreamDuplexer.this.commitMessageHead(httpRequest, z, flushMode);
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void suspendOutput() throws IOException {
                ClientHttp1StreamDuplexer.this.suspendSessionOutput();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void requestOutput() {
                ClientHttp1StreamDuplexer.this.requestSessionOutput();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public Timeout getSocketTimeout() {
                return ClientHttp1StreamDuplexer.this.getSessionTimeout();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public void setSocketTimeout(Timeout timeout) {
                ClientHttp1StreamDuplexer.this.setSessionTimeout(timeout);
            }

            @Override // org.apache.hc.core5.http.nio.ContentEncoder
            public int write(ByteBuffer byteBuffer) throws IOException {
                return ClientHttp1StreamDuplexer.this.streamOutput(byteBuffer);
            }

            @Override // org.apache.hc.core5.http.nio.ContentEncoder
            public void complete(List<? extends Header> list) throws IOException {
                ClientHttp1StreamDuplexer.this.endOutputStream(list);
            }

            @Override // org.apache.hc.core5.http.nio.ContentEncoder
            public boolean isCompleted() {
                return ClientHttp1StreamDuplexer.this.isOutputCompleted();
            }

            @Override // org.apache.hc.core5.http.impl.nio.Http1StreamChannel
            public boolean abortGracefully() throws IOException {
                return ClientHttp1StreamDuplexer.this.endOutputStream(null) != AbstractHttp1StreamDuplexer.MessageDelineation.MESSAGE_HEAD;
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
            ClientHttp1StreamHandler clientHttp1StreamHandlerPoll = this.pipeline.poll();
            if (clientHttp1StreamHandlerPoll == null) {
                return;
            }
            clientHttp1StreamHandlerPoll.failed(exc);
            clientHttp1StreamHandlerPoll.releaseResources();
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
            ClientHttp1StreamHandler clientHttp1StreamHandlerPoll = this.pipeline.poll();
            if (clientHttp1StreamHandlerPoll == null) {
                return;
            }
            clientHttp1StreamHandlerPoll.failed(new ConnectionClosedException());
            clientHttp1StreamHandlerPoll.releaseResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public void updateInputMetrics(HttpResponse httpResponse, BasicHttpConnectionMetrics basicHttpConnectionMetrics) {
        if (httpResponse.getCode() >= 200) {
            basicHttpConnectionMetrics.incrementRequestCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public void updateOutputMetrics(HttpRequest httpRequest, BasicHttpConnectionMetrics basicHttpConnectionMetrics) {
        basicHttpConnectionMetrics.incrementRequestCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public boolean handleIncomingMessage(HttpResponse httpResponse) throws HttpException {
        if (this.incoming == null) {
            this.incoming = this.pipeline.poll();
        }
        if (this.incoming == null) {
            throw new HttpException("Unexpected response");
        }
        return MessageSupport.canResponseHaveBody(this.incoming.getRequestMethod(), httpResponse);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    protected ContentDecoder createContentDecoder(long j, ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) throws HttpException {
        if (j >= 0) {
            return new LengthDelimitedDecoder(readableByteChannel, sessionInputBuffer, basicHttpTransportMetrics, j);
        }
        if (j == -1) {
            return new ChunkDecoder(readableByteChannel, sessionInputBuffer, this.http1Config, basicHttpTransportMetrics);
        }
        return new IdentityDecoder(readableByteChannel, sessionInputBuffer, basicHttpTransportMetrics);
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
        throw new LengthRequiredException();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    boolean inputIdle() {
        return this.incoming == null;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    boolean outputIdle() {
        return this.outgoing == null && this.pipeline.isEmpty();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void outputEnd() throws HttpException, IOException {
        if (this.outgoing != null) {
            if (this.outgoing.isCompleted()) {
                this.outgoing.releaseResources();
            }
            this.outgoing = null;
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void execute(RequestExecutionCommand requestExecutionCommand) throws HttpException, IOException {
        AsyncClientExchangeHandler exchangeHandler = requestExecutionCommand.getExchangeHandler();
        HttpCoreContext httpCoreContextCastOrCreate = HttpCoreContext.castOrCreate(requestExecutionCommand.getContext());
        httpCoreContextCastOrCreate.setSSLSession(getSSLSession());
        httpCoreContextCastOrCreate.setEndpointDetails(getEndpointDetails());
        ClientHttp1StreamHandler clientHttp1StreamHandler = new ClientHttp1StreamHandler(this.outputChannel, this.httpProcessor, this.http1Config, this.connectionReuseStrategy, exchangeHandler, httpCoreContextCastOrCreate);
        this.pipeline.add(clientHttp1StreamHandler);
        this.outgoing = clientHttp1StreamHandler;
        if (clientHttp1StreamHandler.isOutputReady()) {
            clientHttp1StreamHandler.produceOutput();
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    public void consumeHeader(HttpResponse httpResponse, EntityDetails entityDetails) throws HttpException, IOException {
        Http1StreamListener http1StreamListener = this.streamListener;
        if (http1StreamListener != null) {
            http1StreamListener.onResponseHead(this, httpResponse);
        }
        Asserts.notNull(this.incoming, "Response stream handler");
        this.incoming.consumeHeader(httpResponse, entityDetails);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void consumeData(ByteBuffer byteBuffer) throws HttpException, IOException {
        Asserts.notNull(this.incoming, "Response stream handler");
        this.incoming.consumeData(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void updateCapacity(CapacityChannel capacityChannel) throws HttpException, IOException {
        Asserts.notNull(this.incoming, "Response stream handler");
        this.incoming.updateCapacity(capacityChannel);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void dataEnd(List<? extends Header> list) throws HttpException, IOException {
        Asserts.notNull(this.incoming, "Response stream handler");
        this.incoming.dataEnd(list);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void inputEnd() throws HttpException, IOException {
        if (this.incoming == null || !this.incoming.isResponseFinal()) {
            return;
        }
        Http1StreamListener http1StreamListener = this.streamListener;
        if (http1StreamListener != null) {
            http1StreamListener.onExchangeComplete(this, isOpen());
        }
        if (this.incoming.isCompleted()) {
            this.incoming.releaseResources();
        }
        this.incoming = null;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    boolean handleTimeout() {
        return this.outgoing != null && this.outgoing.handleTimeout();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer
    void appendState(StringBuilder sb) {
        super.appendState(sb);
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
}
