package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.concurrent.BasicFuture;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.io.Closer;

/* JADX INFO: loaded from: classes5.dex */
class SingleCoreListeningIOReactor extends AbstractSingleCoreIOReactor implements ConnectionAcceptor {
    private final Callback<ChannelEntry> callback;
    private final ConcurrentMap<ListenerEndpointImpl, Boolean> endpoints;
    private final AtomicBoolean paused;
    private final IOReactorConfig reactorConfig;
    private final Queue<ListenerEndpointRequest> requestQueue;
    private final long selectTimeoutMillis;

    SingleCoreListeningIOReactor(Callback<Exception> callback, IOReactorConfig iOReactorConfig, Callback<ChannelEntry> callback2) {
        super(callback);
        iOReactorConfig = iOReactorConfig == null ? IOReactorConfig.DEFAULT : iOReactorConfig;
        this.reactorConfig = iOReactorConfig;
        this.callback = callback2;
        this.requestQueue = new ConcurrentLinkedQueue();
        this.endpoints = new ConcurrentHashMap();
        this.paused = new AtomicBoolean();
        this.selectTimeoutMillis = iOReactorConfig.getSelectInterval().toMilliseconds();
    }

    @Override // org.apache.hc.core5.reactor.AbstractSingleCoreIOReactor
    void doTerminate() {
        while (true) {
            ListenerEndpointRequest listenerEndpointRequestPoll = this.requestQueue.poll();
            if (listenerEndpointRequestPoll == null) {
                return;
            } else {
                listenerEndpointRequestPoll.cancel();
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.AbstractSingleCoreIOReactor
    protected final void doExecute() throws IOException {
        while (!Thread.currentThread().isInterrupted() && getStatus() == IOReactorStatus.ACTIVE) {
            int iSelect = this.selector.select(this.selectTimeoutMillis);
            if (getStatus() != IOReactorStatus.ACTIVE) {
                return;
            } else {
                processEvents(iSelect);
            }
        }
    }

    private void processEvents(int i) throws IOException {
        if (!this.paused.get()) {
            processSessionRequests();
        }
        if (i > 0) {
            Set<SelectionKey> setSelectedKeys = this.selector.selectedKeys();
            Iterator<SelectionKey> it = setSelectedKeys.iterator();
            while (it.hasNext()) {
                processEvent(it.next());
            }
            setSelectedKeys.clear();
        }
    }

    private void processEvent(SelectionKey selectionKey) throws IOException {
        try {
            if (!selectionKey.isAcceptable()) {
                return;
            }
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            while (true) {
                SocketChannel socketChannelAccept = serverSocketChannel.accept();
                if (socketChannelAccept == null) {
                    return;
                }
                this.callback.execute(new ChannelEntry(socketChannelAccept, ((ListenerEndpointRequest) selectionKey.attachment()).attachment));
            }
        } catch (CancelledKeyException unused) {
            this.endpoints.remove((ListenerEndpointImpl) selectionKey.attachment());
            selectionKey.attach(null);
        }
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, Object obj, FutureCallback<ListenerEndpoint> futureCallback) {
        if (getStatus().compareTo(IOReactorStatus.SHUTTING_DOWN) >= 0) {
            throw new IOReactorShutdownException("I/O reactor has been shut down");
        }
        BasicFuture basicFuture = new BasicFuture(futureCallback);
        this.requestQueue.add(new ListenerEndpointRequest(socketAddress, obj, basicFuture));
        this.selector.wakeup();
        return basicFuture;
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, FutureCallback<ListenerEndpoint> futureCallback) {
        return listen(socketAddress, null, futureCallback);
    }

    private void processSessionRequests() throws IOException {
        while (true) {
            ListenerEndpointRequest listenerEndpointRequestPoll = this.requestQueue.poll();
            if (listenerEndpointRequestPoll == null) {
                return;
            }
            if (!listenerEndpointRequestPoll.isCancelled()) {
                SocketAddress socketAddress = listenerEndpointRequestPoll.address;
                ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
                try {
                    ServerSocket serverSocketSocket = serverSocketChannelOpen.socket();
                    serverSocketSocket.setReuseAddress(this.reactorConfig.isSoReuseAddress());
                    if (this.reactorConfig.getRcvBufSize() > 0) {
                        serverSocketSocket.setReceiveBufferSize(this.reactorConfig.getRcvBufSize());
                    }
                    serverSocketChannelOpen.configureBlocking(false);
                    try {
                        serverSocketSocket.bind(socketAddress, this.reactorConfig.getBacklogSize());
                        SelectionKey selectionKeyRegister = serverSocketChannelOpen.register(this.selector, 16);
                        selectionKeyRegister.attach(listenerEndpointRequestPoll);
                        ListenerEndpointImpl listenerEndpointImpl = new ListenerEndpointImpl(selectionKeyRegister, listenerEndpointRequestPoll.attachment, serverSocketSocket.getLocalSocketAddress());
                        this.endpoints.put(listenerEndpointImpl, Boolean.TRUE);
                        listenerEndpointRequestPoll.completed(listenerEndpointImpl);
                    } catch (BindException e) {
                        BindException bindException = new BindException(String.format("Socket bind failure for socket %s, address=%s, BacklogSize=%d: %s", serverSocketSocket, socketAddress, Integer.valueOf(this.reactorConfig.getBacklogSize()), e));
                        bindException.setStackTrace(e.getStackTrace());
                        throw bindException;
                    }
                } catch (IOException e2) {
                    Closer.closeQuietly(serverSocketChannelOpen);
                    listenerEndpointRequestPoll.failed(e2);
                }
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Set<ListenerEndpoint> getEndpoints() {
        HashSet hashSet = new HashSet();
        Iterator<ListenerEndpointImpl> it = this.endpoints.keySet().iterator();
        while (it.hasNext()) {
            ListenerEndpointImpl next = it.next();
            if (!next.isClosed()) {
                hashSet.add(next);
            } else {
                it.remove();
            }
        }
        return hashSet;
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public void pause() throws IOException {
        if (this.paused.compareAndSet(false, true)) {
            Iterator<ListenerEndpointImpl> it = this.endpoints.keySet().iterator();
            while (it.hasNext()) {
                ListenerEndpointImpl next = it.next();
                if (!next.isClosed()) {
                    next.close();
                    this.requestQueue.add(new ListenerEndpointRequest(next.address, next.attachment, null));
                }
                it.remove();
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public void resume() throws IOException {
        if (this.paused.compareAndSet(true, false)) {
            this.selector.wakeup();
        }
    }
}
