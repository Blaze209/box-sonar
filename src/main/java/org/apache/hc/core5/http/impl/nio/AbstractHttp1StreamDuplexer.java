package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.Message;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.BasicEndpointDetails;
import org.apache.hc.core5.http.impl.BasicHttpConnectionMetrics;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.impl.CharCodingSupport;
import org.apache.hc.core5.http.impl.DefaultContentLengthStrategy;
import org.apache.hc.core5.http.impl.IncomingEntityDetails;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.http.nio.ContentDecoder;
import org.apache.hc.core5.http.nio.ContentEncoder;
import org.apache.hc.core5.http.nio.NHttpMessageParser;
import org.apache.hc.core5.http.nio.NHttpMessageWriter;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;
import org.apache.hc.core5.http.nio.command.CommandSupport;
import org.apache.hc.core5.http.nio.command.RequestExecutionCommand;
import org.apache.hc.core5.http.nio.command.ShutdownCommand;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.SocketTimeoutExceptionFactory;
import org.apache.hc.core5.reactor.Command;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.reactor.ProtocolIOSession;
import org.apache.hc.core5.reactor.ssl.TlsDetails;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Identifiable;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractHttp1StreamDuplexer<IncomingMessage extends HttpMessage, OutgoingMessage extends HttpMessage> implements Identifiable, HttpConnection {
    private volatile CapacityWindow capacityWindow;
    private final BasicHttpConnectionMetrics connMetrics;
    private volatile ConnectionState connState;
    private final ByteBuffer contentBuffer;
    private volatile EndpointDetails endpointDetails;
    private final Http1Config http1Config;
    private final BasicHttpTransportMetrics inTransportMetrics;
    private final SessionInputBufferImpl inbuf;
    private final ContentLengthStrategy incomingContentStrategy;
    private volatile Message<IncomingMessage, ContentDecoder> incomingMessage;
    private final NHttpMessageParser<IncomingMessage> incomingMessageParser;
    private final ProtocolIOSession ioSession;
    private final BasicHttpTransportMetrics outTransportMetrics;
    private final SessionOutputBufferImpl outbuf;
    private final ContentLengthStrategy outgoingContentStrategy;
    private volatile Message<OutgoingMessage, ContentEncoder> outgoingMessage;
    private final NHttpMessageWriter<OutgoingMessage> outgoingMessageWriter;
    private final AtomicInteger outputRequests;
    private volatile ProtocolVersion version;

    private enum ConnectionState {
        READY,
        ACTIVE,
        GRACEFUL_SHUTDOWN,
        SHUTDOWN
    }

    enum MessageDelineation {
        NONE,
        CHUNK_CODED,
        MESSAGE_HEAD
    }

    abstract void consumeData(ByteBuffer byteBuffer) throws HttpException, IOException;

    abstract void consumeHeader(IncomingMessage incomingmessage, EntityDetails entityDetails) throws HttpException, IOException;

    abstract ContentDecoder createContentDecoder(long j, ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) throws HttpException;

    abstract ContentEncoder createContentEncoder(long j, WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) throws HttpException;

    abstract void dataEnd(List<? extends Header> list) throws HttpException, IOException;

    abstract void disconnected();

    abstract void execute(RequestExecutionCommand requestExecutionCommand) throws HttpException, IOException;

    abstract boolean handleIncomingMessage(IncomingMessage incomingmessage) throws HttpException;

    abstract boolean handleOutgoingMessage(OutgoingMessage outgoingmessage) throws HttpException;

    abstract boolean handleTimeout();

    abstract void inputEnd() throws HttpException, IOException;

    abstract boolean inputIdle();

    abstract boolean isOutputReady();

    abstract void outputEnd() throws HttpException, IOException;

    abstract boolean outputIdle();

    abstract void produceOutput() throws HttpException, IOException;

    abstract void terminate(Exception exc);

    abstract void updateCapacity(CapacityChannel capacityChannel) throws HttpException, IOException;

    abstract void updateInputMetrics(IncomingMessage incomingmessage, BasicHttpConnectionMetrics basicHttpConnectionMetrics);

    abstract void updateOutputMetrics(OutgoingMessage outgoingmessage, BasicHttpConnectionMetrics basicHttpConnectionMetrics);

    AbstractHttp1StreamDuplexer(ProtocolIOSession protocolIOSession, Http1Config http1Config, CharCodingConfig charCodingConfig, NHttpMessageParser<IncomingMessage> nHttpMessageParser, NHttpMessageWriter<OutgoingMessage> nHttpMessageWriter, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        this.ioSession = (ProtocolIOSession) Args.notNull(protocolIOSession, "I/O session");
        http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.http1Config = http1Config;
        int bufferSize = http1Config.getBufferSize();
        this.inbuf = new SessionInputBufferImpl(bufferSize, Math.min(bufferSize, 512), http1Config.getMaxLineLength(), CharCodingSupport.createDecoder(charCodingConfig));
        this.outbuf = new SessionOutputBufferImpl(bufferSize, Math.min(bufferSize, 512), CharCodingSupport.createEncoder(charCodingConfig));
        BasicHttpTransportMetrics basicHttpTransportMetrics = new BasicHttpTransportMetrics();
        this.inTransportMetrics = basicHttpTransportMetrics;
        BasicHttpTransportMetrics basicHttpTransportMetrics2 = new BasicHttpTransportMetrics();
        this.outTransportMetrics = basicHttpTransportMetrics2;
        this.connMetrics = new BasicHttpConnectionMetrics(basicHttpTransportMetrics, basicHttpTransportMetrics2);
        this.incomingMessageParser = nHttpMessageParser;
        this.outgoingMessageWriter = nHttpMessageWriter;
        this.incomingContentStrategy = contentLengthStrategy == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2 == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy2;
        this.contentBuffer = ByteBuffer.allocate(http1Config.getBufferSize());
        this.outputRequests = new AtomicInteger(0);
        this.connState = ConnectionState.READY;
    }

    @Override // org.apache.hc.core5.util.Identifiable
    public String getId() {
        return this.ioSession.getId();
    }

    boolean isActive() {
        return this.connState == ConnectionState.ACTIVE;
    }

    boolean isShuttingDown() {
        return this.connState.compareTo(ConnectionState.GRACEFUL_SHUTDOWN) >= 0;
    }

    void shutdownSession(CloseMode closeMode) {
        if (closeMode == CloseMode.GRACEFUL) {
            this.connState = ConnectionState.GRACEFUL_SHUTDOWN;
            this.ioSession.enqueue(ShutdownCommand.GRACEFUL, Command.Priority.NORMAL);
        } else {
            this.connState = ConnectionState.SHUTDOWN;
            this.ioSession.close();
        }
    }

    void shutdownSession(Exception exc) {
        CloseMode closeMode;
        CloseMode closeMode2;
        this.connState = ConnectionState.SHUTDOWN;
        try {
            terminate(exc);
            if (!(exc instanceof ConnectionClosedException) && !(exc instanceof SSLHandshakeException) && (exc instanceof IOException)) {
                closeMode2 = CloseMode.IMMEDIATE;
            } else {
                closeMode2 = CloseMode.GRACEFUL;
            }
            this.ioSession.close(closeMode2);
        } catch (Throwable th) {
            if (!(exc instanceof ConnectionClosedException) && !(exc instanceof SSLHandshakeException) && (exc instanceof IOException)) {
                closeMode = CloseMode.IMMEDIATE;
            } else {
                closeMode = CloseMode.GRACEFUL;
            }
            this.ioSession.close(closeMode);
            throw th;
        }
    }

    private void processCommands() throws HttpException, IOException {
        while (true) {
            Command commandPoll = this.ioSession.poll();
            if (commandPoll == null) {
                return;
            }
            if (commandPoll instanceof ShutdownCommand) {
                requestShutdown(((ShutdownCommand) commandPoll).getType());
            } else if (commandPoll instanceof RequestExecutionCommand) {
                if (this.connState.compareTo(ConnectionState.GRACEFUL_SHUTDOWN) >= 0) {
                    commandPoll.cancel();
                } else {
                    execute((RequestExecutionCommand) commandPoll);
                    return;
                }
            } else {
                throw new HttpException("Unexpected command: " + commandPoll.getClass());
            }
        }
    }

    public final void onConnect() throws HttpException, IOException {
        if (this.connState == ConnectionState.READY) {
            this.connState = ConnectionState.ACTIVE;
            processCommands();
        }
    }

    IncomingMessage parseMessageHead(boolean z) throws HttpException, IOException {
        IncomingMessage incomingmessage = (IncomingMessage) this.incomingMessageParser.parse(this.inbuf, z);
        if (incomingmessage != null) {
            this.incomingMessageParser.reset();
        }
        return incomingmessage;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x013c A[LOOP:0: B:20:0x0049->B:67:0x013c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:70:0x0115 A[EDGE_INSN: B:70:0x0115->B:56:0x0115 BREAK  A[LOOP:0: B:20:0x0049->B:67:0x013c], SYNTHETIC] */
    public final void onInput(ByteBuffer byteBuffer) throws HttpException, IOException {
        AbstractHttp1StreamDuplexer<IncomingMessage, OutgoingMessage> abstractHttp1StreamDuplexer;
        ContentDecoder contentDecoderCreateContentDecoder;
        if (byteBuffer != null) {
            int iRemaining = byteBuffer.remaining();
            this.inbuf.put(byteBuffer);
            this.inTransportMetrics.incrementBytesTransferred(iRemaining);
        }
        if (this.connState.compareTo(ConnectionState.GRACEFUL_SHUTDOWN) >= 0 && this.inbuf.hasData() && inputIdle()) {
            this.ioSession.clearEvent(1);
            return;
        }
        boolean z = false;
        if (this.incomingMessage == null) {
            int iFill = this.inbuf.fill(this.ioSession);
            if (iFill > 0) {
                this.inTransportMetrics.incrementBytesTransferred(iFill);
            }
            if (iFill == -1) {
                z = true;
            }
        }
        while (true) {
            if (this.incomingMessage == null) {
                HttpMessage messageHead = this.parseMessageHead(z);
                if (messageHead == null) {
                    abstractHttp1StreamDuplexer = this;
                    break;
                }
                this.version = messageHead.getVersion();
                this.updateInputMetrics(messageHead, this.connMetrics);
                if (this.handleIncomingMessage(messageHead)) {
                    long jDetermineLength = this.incomingContentStrategy.determineLength(messageHead);
                    abstractHttp1StreamDuplexer = this;
                    contentDecoderCreateContentDecoder = abstractHttp1StreamDuplexer.createContentDecoder(jDetermineLength, this.ioSession, this.inbuf, this.inTransportMetrics);
                    abstractHttp1StreamDuplexer.consumeHeader(messageHead, contentDecoderCreateContentDecoder != null ? new IncomingEntityDetails(messageHead, jDetermineLength) : null);
                } else {
                    abstractHttp1StreamDuplexer = this;
                    abstractHttp1StreamDuplexer.consumeHeader(messageHead, null);
                    contentDecoderCreateContentDecoder = null;
                }
                abstractHttp1StreamDuplexer.capacityWindow = new CapacityWindow(abstractHttp1StreamDuplexer.http1Config.getInitialWindowSize(), abstractHttp1StreamDuplexer.ioSession);
                if (contentDecoderCreateContentDecoder != null) {
                    abstractHttp1StreamDuplexer.incomingMessage = new Message<>(messageHead, contentDecoderCreateContentDecoder);
                } else {
                    abstractHttp1StreamDuplexer.inputEnd();
                    if (abstractHttp1StreamDuplexer.connState.compareTo(ConnectionState.ACTIVE) == 0) {
                        abstractHttp1StreamDuplexer.ioSession.setEvent(1);
                    }
                }
            } else {
                abstractHttp1StreamDuplexer = this;
            }
            if (abstractHttp1StreamDuplexer.incomingMessage != null) {
                ContentDecoder body = abstractHttp1StreamDuplexer.incomingMessage.getBody();
                int i = body.read(abstractHttp1StreamDuplexer.contentBuffer);
                if (i > 0) {
                    abstractHttp1StreamDuplexer.contentBuffer.flip();
                    abstractHttp1StreamDuplexer.consumeData(abstractHttp1StreamDuplexer.contentBuffer);
                    abstractHttp1StreamDuplexer.contentBuffer.clear();
                    if (abstractHttp1StreamDuplexer.capacityWindow.removeCapacity(i) <= 0 && !body.isCompleted()) {
                        abstractHttp1StreamDuplexer.updateCapacity(abstractHttp1StreamDuplexer.capacityWindow);
                    }
                }
                if (!body.isCompleted()) {
                    if (i != 0) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    abstractHttp1StreamDuplexer.dataEnd(body.getTrailers());
                    abstractHttp1StreamDuplexer.capacityWindow.close();
                    abstractHttp1StreamDuplexer.incomingMessage = null;
                    abstractHttp1StreamDuplexer.ioSession.setEvent(1);
                    abstractHttp1StreamDuplexer.inputEnd();
                }
                if (!abstractHttp1StreamDuplexer.inbuf.hasData()) {
                    break;
                    break;
                }
                this = abstractHttp1StreamDuplexer;
            } else if (!abstractHttp1StreamDuplexer.inbuf.hasData()) {
                break;
            } else {
                this = abstractHttp1StreamDuplexer;
            }
        }
        if (!z || abstractHttp1StreamDuplexer.inbuf.hasData()) {
            return;
        }
        if (abstractHttp1StreamDuplexer.outputIdle() && abstractHttp1StreamDuplexer.inputIdle()) {
            abstractHttp1StreamDuplexer.requestShutdown(CloseMode.GRACEFUL);
        } else {
            abstractHttp1StreamDuplexer.shutdownSession(new ConnectionClosedException("Connection closed by peer"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0064 A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:12:0x004d, B:14:0x0055, B:16:0x005d, B:18:0x006a, B:20:0x006e, B:17:0x0064), top: B:47:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    /* JADX WARN: Code duplicated, block: B:27:0x008f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0093  */
    public final void onOutput() throws HttpException, IOException {
        int iFlush;
        this.ioSession.getLock().lock();
        try {
            if (this.outbuf.hasData() && (iFlush = this.outbuf.flush(this.ioSession)) > 0) {
                this.outTransportMetrics.incrementBytesTransferred(iFlush);
            }
            this.ioSession.getLock().unlock();
            if (this.connState.compareTo(ConnectionState.SHUTDOWN) < 0) {
                int i = this.outputRequests.get();
                produceOutput();
                boolean zIsOutputReady = isOutputReady();
                this.ioSession.getLock().lock();
                boolean z = false;
                if (!zIsOutputReady) {
                    try {
                        if (!this.outbuf.hasData() && this.outputRequests.compareAndSet(i, 0)) {
                            this.ioSession.clearEvent(4);
                        } else {
                            this.outputRequests.addAndGet(-i);
                        }
                        if (this.outgoingMessage == null && !this.outbuf.hasData()) {
                            z = true;
                        }
                        this.ioSession.getLock().unlock();
                        if (z) {
                            outputEnd();
                            if (this.connState.compareTo(ConnectionState.ACTIVE) == 0) {
                                processCommands();
                            } else if (this.connState.compareTo(ConnectionState.GRACEFUL_SHUTDOWN) >= 0 && inputIdle() && outputIdle()) {
                                this.connState = ConnectionState.SHUTDOWN;
                            }
                        }
                    } catch (Throwable th) {
                        this.ioSession.getLock().unlock();
                        throw th;
                    }
                } else {
                    this.outputRequests.addAndGet(-i);
                    if (this.outgoingMessage == null) {
                        z = true;
                    }
                    this.ioSession.getLock().unlock();
                    if (z) {
                        outputEnd();
                        if (this.connState.compareTo(ConnectionState.ACTIVE) == 0) {
                            processCommands();
                        } else if (this.connState.compareTo(ConnectionState.GRACEFUL_SHUTDOWN) >= 0) {
                            this.connState = ConnectionState.SHUTDOWN;
                        }
                    }
                }
            }
            if (this.connState.compareTo(ConnectionState.SHUTDOWN) >= 0) {
                this.ioSession.close();
            }
        } catch (Throwable th2) {
            this.ioSession.getLock().unlock();
            throw th2;
        }
    }

    public final void onTimeout(Timeout timeout) throws HttpException, IOException {
        if (handleTimeout()) {
            return;
        }
        onException(SocketTimeoutExceptionFactory.create(timeout));
    }

    public final void onException(Exception exc) {
        shutdownSession(exc);
        CommandSupport.failCommands(this.ioSession, exc);
    }

    public final void onDisconnect() {
        disconnected();
        CommandSupport.cancelCommands(this.ioSession);
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.nio.AbstractHttp1StreamDuplexer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$io$CloseMode;

        static {
            int[] iArr = new int[CloseMode.values().length];
            $SwitchMap$org$apache$hc$core5$io$CloseMode = iArr;
            try {
                iArr[CloseMode.GRACEFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$io$CloseMode[CloseMode.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    void requestShutdown(CloseMode closeMode) {
        int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$io$CloseMode[closeMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.connState = ConnectionState.SHUTDOWN;
            }
        } else if (this.connState == ConnectionState.ACTIVE) {
            this.connState = ConnectionState.GRACEFUL_SHUTDOWN;
        }
        this.ioSession.setEvent(4);
    }

    void commitMessageHead(OutgoingMessage outgoingmessage, boolean z, FlushMode flushMode) throws Throwable {
        AbstractHttp1StreamDuplexer<IncomingMessage, OutgoingMessage> abstractHttp1StreamDuplexer;
        int iFlush;
        ContentEncoder contentEncoderCreateContentEncoder;
        this.ioSession.getLock().lock();
        try {
            this.outgoingMessageWriter.write(outgoingmessage, this.outbuf);
            updateOutputMetrics(outgoingmessage, this.connMetrics);
            if (z) {
                abstractHttp1StreamDuplexer = this;
            } else {
                if (handleOutgoingMessage(outgoingmessage)) {
                    abstractHttp1StreamDuplexer = this;
                    try {
                        contentEncoderCreateContentEncoder = abstractHttp1StreamDuplexer.createContentEncoder(this.outgoingContentStrategy.determineLength(outgoingmessage), this.ioSession, this.outbuf, this.outTransportMetrics);
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        abstractHttp1StreamDuplexer.ioSession.getLock().unlock();
                        throw th2;
                    }
                } else {
                    abstractHttp1StreamDuplexer = this;
                    contentEncoderCreateContentEncoder = null;
                }
                if (contentEncoderCreateContentEncoder != null) {
                    abstractHttp1StreamDuplexer.outgoingMessage = new Message<>(outgoingmessage, contentEncoderCreateContentEncoder);
                }
            }
            abstractHttp1StreamDuplexer.outgoingMessageWriter.reset();
            if (flushMode == FlushMode.IMMEDIATE && (iFlush = abstractHttp1StreamDuplexer.outbuf.flush(abstractHttp1StreamDuplexer.ioSession)) > 0) {
                abstractHttp1StreamDuplexer.outTransportMetrics.incrementBytesTransferred(iFlush);
            }
            abstractHttp1StreamDuplexer.ioSession.setEvent(4);
            abstractHttp1StreamDuplexer.ioSession.getLock().unlock();
        } catch (Throwable th3) {
            th = th3;
            abstractHttp1StreamDuplexer = this;
        }
    }

    void requestSessionInput() {
        this.ioSession.setEvent(1);
    }

    void requestSessionOutput() {
        this.outputRequests.incrementAndGet();
        this.ioSession.setEvent(4);
    }

    Timeout getSessionTimeout() {
        return this.ioSession.getSocketTimeout();
    }

    void setSessionTimeout(Timeout timeout) {
        this.ioSession.setSocketTimeout(timeout);
    }

    void suspendSessionInput() {
        this.ioSession.clearEvent(1);
    }

    void suspendSessionOutput() throws IOException {
        this.ioSession.getLock().lock();
        try {
            if (this.outbuf.hasData()) {
                int iFlush = this.outbuf.flush(this.ioSession);
                if (iFlush > 0) {
                    this.outTransportMetrics.incrementBytesTransferred(iFlush);
                }
            } else {
                this.ioSession.clearEvent(4);
            }
        } finally {
            this.ioSession.getLock().unlock();
        }
    }

    int streamOutput(ByteBuffer byteBuffer) throws IOException {
        this.ioSession.getLock().lock();
        try {
            if (this.outgoingMessage == null) {
                throw new ConnectionClosedException();
            }
            int iWrite = this.outgoingMessage.getBody().write(byteBuffer);
            if (iWrite > 0) {
                this.ioSession.setEvent(4);
            }
            this.ioSession.getLock().unlock();
            return iWrite;
        } catch (Throwable th) {
            this.ioSession.getLock().unlock();
            throw th;
        }
    }

    MessageDelineation endOutputStream(List<? extends Header> list) throws IOException {
        MessageDelineation messageDelineation;
        this.ioSession.getLock().lock();
        try {
            if (this.outgoingMessage == null) {
                messageDelineation = MessageDelineation.NONE;
            } else {
                ContentEncoder body = this.outgoingMessage.getBody();
                body.complete(list);
                this.ioSession.setEvent(4);
                this.outgoingMessage = null;
                messageDelineation = body instanceof ChunkEncoder ? MessageDelineation.CHUNK_CODED : MessageDelineation.MESSAGE_HEAD;
            }
            return messageDelineation;
        } finally {
            this.ioSession.getLock().unlock();
        }
    }

    boolean isOutputCompleted() {
        this.ioSession.getLock().lock();
        try {
            if (this.outgoingMessage != null) {
                return this.outgoingMessage.getBody().isCompleted();
            }
            return true;
        } finally {
            this.ioSession.getLock().unlock();
        }
    }

    @Override // org.apache.hc.core5.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ioSession.enqueue(ShutdownCommand.GRACEFUL, Command.Priority.NORMAL);
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        this.ioSession.enqueue(new ShutdownCommand(closeMode), Command.Priority.IMMEDIATE);
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public boolean isOpen() {
        return this.connState == ConnectionState.ACTIVE;
    }

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    public Timeout getSocketTimeout() {
        return this.ioSession.getSocketTimeout();
    }

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    public void setSocketTimeout(Timeout timeout) {
        this.ioSession.setSocketTimeout(timeout);
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public EndpointDetails getEndpointDetails() {
        if (this.endpointDetails == null) {
            this.endpointDetails = new BasicEndpointDetails(this.ioSession.getRemoteAddress(), this.ioSession.getLocalAddress(), this.connMetrics, this.ioSession.getSocketTimeout());
        }
        return this.endpointDetails;
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public ProtocolVersion getProtocolVersion() {
        return this.version;
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SocketAddress getRemoteAddress() {
        return this.ioSession.getRemoteAddress();
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SocketAddress getLocalAddress() {
        return this.ioSession.getLocalAddress();
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SSLSession getSSLSession() {
        TlsDetails tlsDetails = this.ioSession.getTlsDetails();
        if (tlsDetails != null) {
            return tlsDetails.getSSLSession();
        }
        return null;
    }

    void appendState(StringBuilder sb) {
        sb.append("connState=").append(this.connState).append(", inbuf=").append(this.inbuf).append(", outbuf=").append(this.outbuf).append(", inputWindow=").append(this.capacityWindow != null ? this.capacityWindow.getWindow() : 0);
    }

    static class CapacityWindow implements CapacityChannel {
        private boolean closed;
        private final IOSession ioSession;
        private final ReentrantLock lock = new ReentrantLock();
        private int window;

        CapacityWindow(int i, IOSession iOSession) {
            this.window = i;
            this.ioSession = iOSession;
        }

        @Override // org.apache.hc.core5.http.nio.CapacityChannel
        public void update(int i) throws IOException {
            this.lock.lock();
            try {
                if (!this.closed && i > 0) {
                    updateWindow(i);
                    this.ioSession.setEvent(1);
                }
            } finally {
                this.lock.unlock();
            }
        }

        int removeCapacity(int i) {
            this.lock.lock();
            try {
                updateWindow(-i);
                if (this.window <= 0) {
                    this.ioSession.clearEvent(1);
                }
                return this.window;
            } finally {
                this.lock.unlock();
            }
        }

        private void updateWindow(int i) {
            int i2 = this.window;
            int i3 = i2 + i;
            if (((i2 ^ i3) & (i ^ i3)) < 0) {
                i3 = i < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            this.window = i3;
        }

        void close() {
            this.lock.lock();
            try {
                this.closed = true;
            } finally {
                this.lock.unlock();
            }
        }

        int getWindow() {
            return this.window;
        }
    }
}
