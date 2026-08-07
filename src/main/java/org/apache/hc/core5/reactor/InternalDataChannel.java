package org.apache.hc.core5.reactor;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.apache.hc.core5.concurrent.CallbackContribution;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.ssl.SSLBufferMode;
import org.apache.hc.core5.reactor.ssl.SSLIOSession;
import org.apache.hc.core5.reactor.ssl.SSLMode;
import org.apache.hc.core5.reactor.ssl.SSLSessionInitializer;
import org.apache.hc.core5.reactor.ssl.SSLSessionVerifier;
import org.apache.hc.core5.reactor.ssl.TlsDetails;
import org.apache.hc.core5.reactor.ssl.TransportSecurityLayer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;
import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
final class InternalDataChannel extends InternalChannel implements ProtocolIOSession {
    private final AtomicBoolean closed;
    private final Queue<InternalDataChannel> closedSessions;
    private final AtomicReference<IOSession> currentSessionRef;
    private final AtomicReference<IOEventHandler> eventHandlerRef;
    private final NamedEndpoint initialEndpoint;
    private final IOSession ioSession;
    private final Decorator<IOSession> ioSessionDecorator;
    private final ConcurrentMap<String, ProtocolUpgradeHandler> protocolUpgradeHandlerMap;
    private final IOSessionListener sessionListener;
    private final AtomicReference<SSLIOSession> tlsSessionRef = new AtomicReference<>();

    InternalDataChannel(IOSession iOSession, NamedEndpoint namedEndpoint, Decorator<IOSession> decorator, IOSessionListener iOSessionListener, Queue<InternalDataChannel> queue) {
        this.ioSession = iOSession;
        this.initialEndpoint = namedEndpoint;
        this.closedSessions = queue;
        this.ioSessionDecorator = decorator;
        this.sessionListener = iOSessionListener;
        this.currentSessionRef = new AtomicReference<>(decorator != null ? decorator.decorate(iOSession) : iOSession);
        this.eventHandlerRef = new AtomicReference<>();
        this.protocolUpgradeHandlerMap = new ConcurrentHashMap();
        this.closed = new AtomicBoolean();
    }

    @Override // org.apache.hc.core5.util.Identifiable
    public String getId() {
        return this.ioSession.getId();
    }

    @Override // org.apache.hc.core5.reactor.ProtocolIOSession
    public NamedEndpoint getInitialEndpoint() {
        return this.initialEndpoint;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public IOEventHandler getHandler() {
        return this.eventHandlerRef.get();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void upgrade(IOEventHandler iOEventHandler) {
        this.currentSessionRef.get().upgrade(iOEventHandler);
        this.eventHandlerRef.set(iOEventHandler);
    }

    private IOEventHandler ensureHandler(IOSession iOSession) {
        IOEventHandler handler = iOSession.getHandler();
        Asserts.notNull(handler, "IO event handler");
        return handler;
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    void onIOEvent(int i) throws IOException {
        if ((i & 8) != 0) {
            IOSession iOSession = this.currentSessionRef.get();
            iOSession.clearEvent(8);
            if (this.tlsSessionRef.get() == null) {
                IOSessionListener iOSessionListener = this.sessionListener;
                if (iOSessionListener != null) {
                    iOSessionListener.connected(iOSession);
                }
                ensureHandler(iOSession).connected(iOSession);
            }
        }
        if ((i & 1) != 0) {
            IOSession iOSession2 = this.currentSessionRef.get();
            iOSession2.updateReadTime();
            IOSessionListener iOSessionListener2 = this.sessionListener;
            if (iOSessionListener2 != null) {
                iOSessionListener2.inputReady(iOSession2);
            }
            ensureHandler(iOSession2).inputReady(iOSession2, null);
        }
        if ((i & 4) == 0 && (this.ioSession.getEventMask() & 4) == 0) {
            return;
        }
        IOSession iOSession3 = this.currentSessionRef.get();
        iOSession3.updateWriteTime();
        IOSessionListener iOSessionListener3 = this.sessionListener;
        if (iOSessionListener3 != null) {
            iOSessionListener3.outputReady(iOSession3);
        }
        ensureHandler(iOSession3).outputReady(iOSession3);
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    Timeout getTimeout() {
        return this.currentSessionRef.get().getSocketTimeout();
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    void onTimeout(Timeout timeout) throws IOException {
        IOSession iOSession = this.currentSessionRef.get();
        IOSessionListener iOSessionListener = this.sessionListener;
        if (iOSessionListener != null) {
            iOSessionListener.timeout(iOSession);
        }
        ensureHandler(iOSession).timeout(iOSession, timeout);
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    void onException(Exception exc) {
        IOSession iOSession = this.currentSessionRef.get();
        IOSessionListener iOSessionListener = this.sessionListener;
        if (iOSessionListener != null) {
            iOSessionListener.exception(iOSession, exc);
        }
        IOEventHandler handler = iOSession.getHandler();
        if (handler != null) {
            handler.exception(iOSession, exc);
        }
    }

    void onTLSSessionStart(SSLIOSession sSLIOSession) {
        IOSession iOSession = this.currentSessionRef.get();
        IOSessionListener iOSessionListener = this.sessionListener;
        if (iOSessionListener != null) {
            iOSessionListener.connected(iOSession);
        }
    }

    void onTLSSessionEnd(SSLIOSession sSLIOSession) {
        if (this.closed.compareAndSet(false, true)) {
            this.closedSessions.add(this);
        }
    }

    void disconnected() {
        IOSession iOSession = this.currentSessionRef.get();
        IOSessionListener iOSessionListener = this.sessionListener;
        if (iOSessionListener != null) {
            iOSessionListener.disconnected(iOSession);
        }
        IOEventHandler handler = iOSession.getHandler();
        if (handler != null) {
            handler.disconnected(iOSession);
        }
    }

    @Override // org.apache.hc.core5.reactor.ssl.TransportSecurityLayer
    public void startTls(SSLContext sSLContext, NamedEndpoint namedEndpoint, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier, Timeout timeout) {
        startTls(sSLContext, namedEndpoint, sSLBufferMode, sSLSessionInitializer, sSLSessionVerifier, timeout, null);
    }

    @Override // org.apache.hc.core5.reactor.ssl.TransportSecurityLayer
    public void startTls(SSLContext sSLContext, NamedEndpoint namedEndpoint, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier, Timeout timeout, final FutureCallback<TransportSecurityLayer> futureCallback) {
        SSLIOSession sSLIOSession = new SSLIOSession(namedEndpoint != null ? namedEndpoint : this.initialEndpoint, this.ioSession, this.initialEndpoint != null ? SSLMode.CLIENT : SSLMode.SERVER, sSLContext, sSLBufferMode, sSLSessionInitializer, sSLSessionVerifier, timeout, new Callback() { // from class: org.apache.hc.core5.reactor.InternalDataChannel$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                this.f$0.onTLSSessionStart((SSLIOSession) obj);
            }
        }, new Callback() { // from class: org.apache.hc.core5.reactor.InternalDataChannel$$ExternalSyntheticLambda1
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                this.f$0.onTLSSessionEnd((SSLIOSession) obj);
            }
        }, new CallbackContribution<SSLSession>(futureCallback) { // from class: org.apache.hc.core5.reactor.InternalDataChannel.1
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(SSLSession sSLSession) {
                FutureCallback futureCallback2 = futureCallback;
                if (futureCallback2 != null) {
                    futureCallback2.completed(InternalDataChannel.this);
                }
            }
        });
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.tlsSessionRef, null, sSLIOSession)) {
            AtomicReference<IOSession> atomicReference = this.currentSessionRef;
            Decorator<IOSession> decorator = this.ioSessionDecorator;
            atomicReference.set(decorator != null ? decorator.decorate(sSLIOSession) : sSLIOSession);
            try {
                IOSessionListener iOSessionListener = this.sessionListener;
                if (iOSessionListener != null) {
                    iOSessionListener.startTls(sSLIOSession);
                }
                sSLIOSession.beginHandshake(this);
                return;
            } catch (Exception e) {
                onException(e);
                return;
            }
        }
        throw new IllegalStateException("TLS already activated");
    }

    @Override // org.apache.hc.core5.reactor.ssl.TransportSecurityLayer
    public TlsDetails getTlsDetails() {
        SSLIOSession sSLIOSession = this.tlsSessionRef.get();
        if (sSLIOSession != null) {
            return sSLIOSession.getTlsDetails();
        }
        return null;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public Lock getLock() {
        return this.ioSession.getLock();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, org.apache.hc.core5.reactor.IOSession, java.nio.channels.Channel
    public void close() {
        close(CloseMode.GRACEFUL);
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        IOSession iOSession = this.currentSessionRef.get();
        if (closeMode == CloseMode.IMMEDIATE) {
            this.closed.set(true);
            iOSession.close(closeMode);
        } else if (this.closed.compareAndSet(false, true)) {
            try {
                iOSession.close(closeMode);
            } finally {
                this.closedSessions.add(this);
            }
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public IOSession.Status getStatus() {
        return this.currentSessionRef.get().getStatus();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.currentSessionRef.get().isOpen();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void enqueue(Command command, Command.Priority priority) {
        this.currentSessionRef.get().enqueue(command, priority);
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public boolean hasCommands() {
        return this.currentSessionRef.get().hasCommands();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public Command poll() {
        return this.currentSessionRef.get().poll();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public ByteChannel channel() {
        return this.currentSessionRef.get().channel();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public SocketAddress getRemoteAddress() {
        return this.ioSession.getRemoteAddress();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public SocketAddress getLocalAddress() {
        return this.ioSession.getLocalAddress();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public int getEventMask() {
        return this.currentSessionRef.get().getEventMask();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void setEventMask(int i) {
        this.currentSessionRef.get().setEventMask(i);
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void setEvent(int i) {
        this.currentSessionRef.get().setEvent(i);
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void clearEvent(int i) {
        this.currentSessionRef.get().clearEvent(i);
    }

    @Override // org.apache.hc.core5.reactor.IOSession, org.apache.hc.core5.http.SocketModalCloseable
    public Timeout getSocketTimeout() {
        return this.ioSession.getSocketTimeout();
    }

    @Override // org.apache.hc.core5.reactor.IOSession, org.apache.hc.core5.http.SocketModalCloseable
    public void setSocketTimeout(Timeout timeout) {
        this.ioSession.setSocketTimeout(timeout);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.currentSessionRef.get().read(byteBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.currentSessionRef.get().write(byteBuffer);
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void updateReadTime() {
        this.ioSession.updateReadTime();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void updateWriteTime() {
        this.ioSession.updateWriteTime();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastReadTime() {
        return this.ioSession.getLastReadTime();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastWriteTime() {
        return this.ioSession.getLastWriteTime();
    }

    @Override // org.apache.hc.core5.reactor.InternalChannel
    public long getLastEventTime() {
        return this.ioSession.getLastEventTime();
    }

    @Override // org.apache.hc.core5.reactor.ProtocolIOSession
    public void switchProtocol(String str, FutureCallback<ProtocolIOSession> futureCallback) {
        Args.notEmpty(str, "Application protocol ID");
        ProtocolUpgradeHandler protocolUpgradeHandler = this.protocolUpgradeHandlerMap.get(TextUtils.toLowerCase(str));
        if (protocolUpgradeHandler != null) {
            protocolUpgradeHandler.upgrade(this, futureCallback);
            return;
        }
        throw new IllegalStateException("Unsupported protocol: " + str);
    }

    @Override // org.apache.hc.core5.reactor.ProtocolIOSession
    public void registerProtocol(String str, ProtocolUpgradeHandler protocolUpgradeHandler) {
        Args.notEmpty(str, "Application protocol ID");
        Args.notNull(protocolUpgradeHandler, "Protocol upgrade handler");
        this.protocolUpgradeHandlerMap.put(TextUtils.toLowerCase(str), protocolUpgradeHandler);
    }

    public String toString() {
        IOSession iOSession = this.currentSessionRef.get();
        if (iOSession == null) {
            iOSession = this.ioSession;
        }
        return Objects.toString(iOSession, null);
    }
}
