package org.apache.hc.core5.reactor;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.UnknownHostException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.io.SocketSupport;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
class SingleCoreIOReactor extends AbstractSingleCoreIOReactor implements ConnectionInitiator {
    private static final int MAX_CHANNEL_REQUESTS = 10000;
    private final Queue<ChannelEntry> channelQueue;
    private final Queue<InternalDataChannel> closedSessions;
    private final IOEventHandlerFactory eventHandlerFactory;
    private final Decorator<IOSession> ioSessionDecorator;
    private volatile long lastTimeoutCheckMillis;
    private final IOReactorConfig reactorConfig;
    private final Queue<IOSessionRequest> requestQueue;
    private final long selectTimeoutMillis;
    private final IOSessionListener sessionListener;
    private final Callback<IOSession> sessionShutdownCallback;
    private final AtomicBoolean shutdownInitiated;

    SingleCoreIOReactor(Callback<Exception> callback, IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, Decorator<IOSession> decorator, IOSessionListener iOSessionListener, Callback<IOSession> callback2) {
        super(callback);
        this.eventHandlerFactory = (IOEventHandlerFactory) Args.notNull(iOEventHandlerFactory, "Event handler factory");
        IOReactorConfig iOReactorConfig2 = (IOReactorConfig) Args.notNull(iOReactorConfig, "I/O reactor config");
        this.reactorConfig = iOReactorConfig2;
        this.ioSessionDecorator = decorator;
        this.sessionListener = iOSessionListener;
        this.sessionShutdownCallback = callback2;
        this.shutdownInitiated = new AtomicBoolean();
        this.closedSessions = new ConcurrentLinkedQueue();
        this.channelQueue = new ConcurrentLinkedQueue();
        this.requestQueue = new ConcurrentLinkedQueue();
        this.selectTimeoutMillis = iOReactorConfig2.getSelectInterval().toMilliseconds();
    }

    void enqueueChannel(ChannelEntry channelEntry) throws IOReactorShutdownException {
        if (getStatus().compareTo(IOReactorStatus.ACTIVE) > 0) {
            throw new IOReactorShutdownException("I/O reactor has been shut down");
        }
        this.channelQueue.add(channelEntry);
        this.selector.wakeup();
    }

    @Override // org.apache.hc.core5.reactor.AbstractSingleCoreIOReactor
    void doTerminate() {
        closePendingChannels();
        closePendingConnectionRequests();
        processClosedSessions();
    }

    @Override // org.apache.hc.core5.reactor.AbstractSingleCoreIOReactor
    void doExecute() throws IOException {
        while (!Thread.currentThread().isInterrupted()) {
            int iSelect = this.selector.select(this.selectTimeoutMillis);
            if (getStatus().compareTo(IOReactorStatus.SHUTTING_DOWN) >= 0) {
                if (this.shutdownInitiated.compareAndSet(false, true)) {
                    initiateSessionShutdown();
                }
                closePendingChannels();
            }
            if (getStatus() == IOReactorStatus.SHUT_DOWN) {
                return;
            }
            if (iSelect > 0) {
                processEvents(this.selector.selectedKeys());
            }
            validateActiveChannels();
            processClosedSessions();
            if (getStatus() == IOReactorStatus.ACTIVE) {
                processPendingChannels();
                processPendingConnectionRequests();
            }
            if ((getStatus() == IOReactorStatus.SHUTTING_DOWN && this.selector.keys().isEmpty()) || getStatus() == IOReactorStatus.SHUT_DOWN) {
                return;
            }
        }
    }

    private void initiateSessionShutdown() {
        if (this.sessionShutdownCallback != null) {
            Iterator<SelectionKey> it = this.selector.keys().iterator();
            while (it.hasNext()) {
                InternalChannel internalChannel = (InternalChannel) it.next().attachment();
                if (internalChannel instanceof InternalDataChannel) {
                    this.sessionShutdownCallback.execute((InternalDataChannel) internalChannel);
                }
            }
        }
    }

    private void validateActiveChannels() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastTimeoutCheckMillis >= this.selectTimeoutMillis) {
            this.lastTimeoutCheckMillis = jCurrentTimeMillis;
            Iterator<SelectionKey> it = this.selector.keys().iterator();
            while (it.hasNext()) {
                checkTimeout(it.next(), jCurrentTimeMillis);
            }
        }
    }

    private void processEvents(Set<SelectionKey> set) {
        for (SelectionKey selectionKey : set) {
            InternalChannel internalChannel = (InternalChannel) selectionKey.attachment();
            if (internalChannel != null) {
                try {
                    internalChannel.handleIOEvent(selectionKey.readyOps());
                } catch (CancelledKeyException unused) {
                    internalChannel.close(CloseMode.GRACEFUL);
                }
            }
        }
        set.clear();
    }

    private void processPendingChannels() throws IOException {
        ChannelEntry channelEntryPoll;
        for (int i = 0; i < 10000 && (channelEntryPoll = this.channelQueue.poll()) != null; i++) {
            SocketChannel socketChannel = channelEntryPoll.channel;
            Object obj = channelEntryPoll.attachment;
            try {
                prepareSocket(socketChannel);
                socketChannel.configureBlocking(false);
                try {
                    SelectionKey selectionKeyRegister = socketChannel.register(this.selector, 1);
                    InternalDataChannel internalDataChannel = new InternalDataChannel(new IOSessionImpl(CmcdData.OBJECT_TYPE_AUDIO_ONLY, selectionKeyRegister, socketChannel), null, this.ioSessionDecorator, this.sessionListener, this.closedSessions);
                    internalDataChannel.setSocketTimeout(this.reactorConfig.getSoTimeout());
                    internalDataChannel.upgrade(this.eventHandlerFactory.createHandler(internalDataChannel, obj));
                    selectionKeyRegister.attach(internalDataChannel);
                    internalDataChannel.handleIOEvent(8);
                } catch (ClosedChannelException unused) {
                    return;
                }
            } catch (IOException e) {
                logException(e);
                try {
                    socketChannel.close();
                    throw e;
                } catch (IOException e2) {
                    logException(e2);
                    throw e;
                }
            }
        }
    }

    private void processClosedSessions() {
        while (true) {
            InternalDataChannel internalDataChannelPoll = this.closedSessions.poll();
            if (internalDataChannelPoll == null) {
                return;
            } else {
                try {
                    internalDataChannelPoll.disconnected();
                } catch (CancelledKeyException unused) {
                }
            }
        }
    }

    private void checkTimeout(SelectionKey selectionKey, long j) {
        InternalChannel internalChannel = (InternalChannel) selectionKey.attachment();
        if (internalChannel != null) {
            internalChannel.checkTimeout(j);
        }
    }

    @Override // org.apache.hc.core5.reactor.ConnectionInitiator
    public Future<IOSession> connect(NamedEndpoint namedEndpoint, SocketAddress socketAddress, SocketAddress socketAddress2, Timeout timeout, Object obj, FutureCallback<IOSession> futureCallback) throws IOReactorShutdownException {
        Args.notNull(namedEndpoint, "Remote endpoint");
        if (socketAddress == null) {
            socketAddress = new InetSocketAddress(namedEndpoint.getHostName(), namedEndpoint.getPort());
        }
        IOSessionRequest iOSessionRequest = new IOSessionRequest(namedEndpoint, socketAddress, socketAddress2, timeout, obj, futureCallback);
        this.requestQueue.add(iOSessionRequest);
        this.selector.wakeup();
        return iOSessionRequest;
    }

    private void prepareSocket(SocketChannel socketChannel) throws IOException {
        Socket socket = socketChannel.socket();
        socket.setTcpNoDelay(this.reactorConfig.isTcpNoDelay());
        socket.setKeepAlive(this.reactorConfig.isSoKeepAlive());
        if (this.reactorConfig.getSndBufSize() > 0) {
            socket.setSendBufferSize(this.reactorConfig.getSndBufSize());
        }
        if (this.reactorConfig.getRcvBufSize() > 0) {
            socket.setReceiveBufferSize(this.reactorConfig.getRcvBufSize());
        }
        if (this.reactorConfig.getTrafficClass() > 0) {
            socket.setTrafficClass(this.reactorConfig.getTrafficClass());
        }
        int secondsIntBound = this.reactorConfig.getSoLinger().toSecondsIntBound();
        if (secondsIntBound >= 0) {
            socket.setSoLinger(true, secondsIntBound);
        }
        if (this.reactorConfig.getTcpKeepIdle() > 0) {
            setExtendedSocketOption(socketChannel, SocketSupport.TCP_KEEPIDLE, Integer.valueOf(this.reactorConfig.getTcpKeepIdle()));
        }
        if (this.reactorConfig.getTcpKeepInterval() > 0) {
            setExtendedSocketOption(socketChannel, SocketSupport.TCP_KEEPINTERVAL, Integer.valueOf(this.reactorConfig.getTcpKeepInterval()));
        }
        if (this.reactorConfig.getTcpKeepInterval() > 0) {
            setExtendedSocketOption(socketChannel, SocketSupport.TCP_KEEPCOUNT, Integer.valueOf(this.reactorConfig.getTcpKeepCount()));
        }
    }

    <T> void setExtendedSocketOption(SocketChannel socketChannel, String str, T t) throws IOException {
        SocketOption<T> extendedSocketOptionOrNull = SocketSupport.getExtendedSocketOptionOrNull(str);
        if (extendedSocketOptionOrNull == null) {
            throw new UnsupportedOperationException(str + " is not supported in the current jdk");
        }
        socketChannel.setOption((SocketOption) extendedSocketOptionOrNull, (Object) t);
    }

    private void validateAddress(SocketAddress socketAddress) throws UnknownHostException {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            if (inetSocketAddress.isUnresolved()) {
                throw new UnknownHostException(inetSocketAddress.getHostName());
            }
        }
    }

    private void processPendingConnectionRequests() {
        IOSessionRequest iOSessionRequestPoll;
        for (int i = 0; i < 10000 && (iOSessionRequestPoll = this.requestQueue.poll()) != null; i++) {
            if (!iOSessionRequestPoll.isCancelled()) {
                try {
                    SocketChannel socketChannelOpen = SocketChannel.open();
                    try {
                        processConnectionRequest(socketChannelOpen, iOSessionRequestPoll);
                    } catch (IOException | RuntimeException e) {
                        Closer.closeQuietly(socketChannelOpen);
                        iOSessionRequestPoll.failed(e);
                    }
                } catch (IOException e2) {
                    iOSessionRequestPoll.failed(e2);
                    return;
                }
            }
        }
    }

    private void processConnectionRequest(SocketChannel socketChannel, IOSessionRequest iOSessionRequest) throws IOException {
        socketChannel.configureBlocking(false);
        prepareSocket(socketChannel);
        validateAddress(iOSessionRequest.localAddress);
        if (iOSessionRequest.localAddress != null) {
            Socket socket = socketChannel.socket();
            socket.setReuseAddress(this.reactorConfig.isSoReuseAddress());
            socket.bind(iOSessionRequest.localAddress);
        }
        SocketAddress socksProxyAddress = this.reactorConfig.getSocksProxyAddress();
        if (socksProxyAddress == null) {
            socksProxyAddress = iOSessionRequest.remoteAddress;
        }
        validateAddress(socksProxyAddress);
        boolean zConnect = socketChannel.connect(socksProxyAddress);
        SelectionKey selectionKeyRegister = socketChannel.register(this.selector, 9);
        InternalDataChannel internalDataChannel = new InternalDataChannel(new IOSessionImpl("c", selectionKeyRegister, socketChannel), iOSessionRequest.remoteEndpoint, this.ioSessionDecorator, this.sessionListener, this.closedSessions);
        internalDataChannel.setSocketTimeout(this.reactorConfig.getSoTimeout());
        InternalConnectChannel internalConnectChannel = new InternalConnectChannel(selectionKeyRegister, socketChannel, iOSessionRequest, internalDataChannel, this.eventHandlerFactory, this.reactorConfig);
        if (zConnect) {
            internalConnectChannel.handleIOEvent(8);
        } else {
            selectionKeyRegister.attach(internalConnectChannel);
            iOSessionRequest.assign(internalConnectChannel);
        }
    }

    private void closePendingChannels() {
        while (true) {
            ChannelEntry channelEntryPoll = this.channelQueue.poll();
            if (channelEntryPoll == null) {
                return;
            }
            try {
                channelEntryPoll.channel.close();
            } catch (IOException e) {
                logException(e);
            }
        }
    }

    private void closePendingConnectionRequests() {
        while (true) {
            IOSessionRequest iOSessionRequestPoll = this.requestQueue.poll();
            if (iOSessionRequestPoll == null) {
                return;
            } else {
                iOSessionRequestPoll.cancel();
            }
        }
    }
}
