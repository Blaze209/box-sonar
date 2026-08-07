package org.apache.hc.core5.reactor.ssl;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.SocketTimeoutExceptionFactory;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.reactor.Command;
import org.apache.hc.core5.reactor.IOEventHandler;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class SSLIOSession implements IOSession {
    private static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocate(0);
    private int appEventMask;
    private volatile boolean endOfStream;
    private final AtomicReference<FutureCallback<SSLSession>> handshakeCallbackRef;
    private final AtomicReference<TLSHandShakeState> handshakeStateRef;
    private final Timeout handshakeTimeout;
    private final SSLManagedBuffer inEncrypted;
    private final SSLManagedBuffer inPlain;
    private final SSLSessionInitializer initializer;
    private final IOEventHandler internalEventHandler;
    private final SSLManagedBuffer outEncrypted;
    private final AtomicInteger outboundClosedCount;
    private final IOSession session;
    private final Callback<SSLIOSession> sessionEndCallback;
    private final Callback<SSLIOSession> sessionStartCallback;
    private volatile Timeout socketTimeout;
    private final SSLEngine sslEngine;
    private final SSLMode sslMode;
    private volatile IOSession.Status status;
    private final NamedEndpoint targetEndpoint;
    private volatile TlsDetails tlsDetails;
    private final SSLSessionVerifier verifier;

    enum TLSHandShakeState {
        READY,
        INITIALIZED,
        HANDSHAKING,
        COMPLETE
    }

    public SSLIOSession(NamedEndpoint namedEndpoint, IOSession iOSession, SSLMode sSLMode, SSLContext sSLContext, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier, Callback<SSLIOSession> callback, Callback<SSLIOSession> callback2, Timeout timeout) {
        this(namedEndpoint, iOSession, sSLMode, sSLContext, sSLBufferMode, sSLSessionInitializer, sSLSessionVerifier, timeout, callback, callback2, null);
    }

    public SSLIOSession(NamedEndpoint namedEndpoint, final IOSession iOSession, SSLMode sSLMode, SSLContext sSLContext, SSLBufferMode sSLBufferMode, SSLSessionInitializer sSLSessionInitializer, SSLSessionVerifier sSLSessionVerifier, final Timeout timeout, Callback<SSLIOSession> callback, Callback<SSLIOSession> callback2, FutureCallback<SSLSession> futureCallback) {
        this.status = IOSession.Status.ACTIVE;
        Args.notNull(iOSession, "IO session");
        Args.notNull(sSLContext, "SSL context");
        this.targetEndpoint = namedEndpoint;
        this.session = iOSession;
        this.sslMode = sSLMode;
        this.initializer = sSLSessionInitializer;
        this.verifier = sSLSessionVerifier;
        this.sessionStartCallback = callback;
        this.sessionEndCallback = callback2;
        this.handshakeCallbackRef = new AtomicReference<>(futureCallback);
        this.appEventMask = iOSession.getEventMask();
        if (sSLMode == SSLMode.CLIENT && namedEndpoint != null) {
            this.sslEngine = sSLContext.createSSLEngine(namedEndpoint.getHostName(), namedEndpoint.getPort());
        } else {
            this.sslEngine = sSLContext.createSSLEngine();
        }
        SSLSession session = this.sslEngine.getSession();
        int packetBufferSize = session.getPacketBufferSize();
        this.inEncrypted = SSLManagedBuffer.create(sSLBufferMode, packetBufferSize);
        this.outEncrypted = SSLManagedBuffer.create(sSLBufferMode, packetBufferSize);
        this.inPlain = SSLManagedBuffer.create(sSLBufferMode, session.getApplicationBufferSize());
        this.outboundClosedCount = new AtomicInteger(0);
        this.handshakeStateRef = new AtomicReference<>(TLSHandShakeState.READY);
        this.handshakeTimeout = timeout;
        this.internalEventHandler = new IOEventHandler() { // from class: org.apache.hc.core5.reactor.ssl.SSLIOSession.1
            @Override // org.apache.hc.core5.reactor.IOEventHandler
            public void connected(IOSession iOSession2) throws IOException {
                SSLIOSession.this.beginHandshake(iOSession2);
            }

            @Override // org.apache.hc.core5.reactor.IOEventHandler
            public void inputReady(IOSession iOSession2, ByteBuffer byteBuffer) throws IOException {
                SSLIOSession.this.receiveEncryptedData();
                SSLIOSession.this.doHandshake(iOSession2);
                SSLIOSession.this.decryptData(iOSession2);
                SSLIOSession.this.updateEventMask();
            }

            @Override // org.apache.hc.core5.reactor.IOEventHandler
            public void outputReady(IOSession iOSession2) throws IOException {
                SSLIOSession.this.encryptData(iOSession2);
                SSLIOSession.this.sendEncryptedData();
                SSLIOSession.this.doHandshake(iOSession2);
                SSLIOSession.this.updateEventMask();
            }

            @Override // org.apache.hc.core5.reactor.IOEventHandler
            public void timeout(IOSession iOSession2, Timeout timeout2) throws IOException {
                if (SSLIOSession.this.sslEngine.isInboundDone() && !SSLIOSession.this.sslEngine.isInboundDone()) {
                    SSLIOSession.this.close(CloseMode.IMMEDIATE);
                }
                if (SSLIOSession.this.handshakeStateRef.get() == TLSHandShakeState.COMPLETE) {
                    SSLIOSession.this.ensureHandler().timeout(iOSession2, timeout2);
                } else {
                    exception(iOSession2, SocketTimeoutExceptionFactory.create(timeout));
                }
            }

            @Override // org.apache.hc.core5.reactor.IOEventHandler
            public void exception(IOSession iOSession2, Exception exc) {
                FutureCallback futureCallback2 = (FutureCallback) SSLIOSession.this.handshakeCallbackRef.getAndSet(null);
                if (futureCallback2 != null) {
                    futureCallback2.failed(exc);
                }
                IOEventHandler handler = iOSession.getHandler();
                if (SSLIOSession.this.handshakeStateRef.get() != TLSHandShakeState.COMPLETE) {
                    if (exc instanceof SSLHandshakeException) {
                        SSLIOSession.this.close(CloseMode.GRACEFUL);
                    } else {
                        iOSession.close(CloseMode.GRACEFUL);
                        SSLIOSession.this.close(CloseMode.IMMEDIATE);
                    }
                }
                if (handler != null) {
                    handler.exception(iOSession2, exc);
                }
            }

            @Override // org.apache.hc.core5.reactor.IOEventHandler
            public void disconnected(IOSession iOSession2) {
                IOEventHandler handler = iOSession.getHandler();
                if (handler != null) {
                    handler.disconnected(iOSession2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IOEventHandler ensureHandler() {
        IOEventHandler handler = this.session.getHandler();
        Asserts.notNull(handler, "IO event handler");
        return handler;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public IOEventHandler getHandler() {
        return this.internalEventHandler;
    }

    public void beginHandshake(IOSession iOSession) throws IOException {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.handshakeStateRef, TLSHandShakeState.READY, TLSHandShakeState.INITIALIZED)) {
            initialize(iOSession);
        }
    }

    private void initialize(IOSession iOSession) throws IOException {
        this.socketTimeout = this.session.getSocketTimeout();
        Timeout timeout = this.handshakeTimeout;
        if (timeout != null) {
            this.session.setSocketTimeout(timeout);
        }
        this.session.getLock().lock();
        try {
            if (this.status.compareTo(IOSession.Status.CLOSING) < 0) {
                int i = AnonymousClass2.$SwitchMap$org$apache$hc$core5$reactor$ssl$SSLMode[this.sslMode.ordinal()];
                if (i == 1) {
                    this.sslEngine.setUseClientMode(true);
                } else if (i == 2) {
                    this.sslEngine.setUseClientMode(false);
                }
                SSLSessionInitializer sSLSessionInitializer = this.initializer;
                if (sSLSessionInitializer != null) {
                    sSLSessionInitializer.initialize(this.targetEndpoint, this.sslEngine);
                }
                this.handshakeStateRef.set(TLSHandShakeState.HANDSHAKING);
                this.sslEngine.beginHandshake();
                this.inEncrypted.release();
                this.outEncrypted.release();
                doHandshake(iOSession);
                updateEventMask();
            }
        } finally {
            this.session.getLock().unlock();
        }
    }

    private SSLException convert(RuntimeException runtimeException) {
        Throwable cause = runtimeException.getCause();
        if (cause != null) {
            runtimeException = cause;
        }
        return new SSLException(runtimeException);
    }

    private SSLEngineResult doWrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        try {
            return this.sslEngine.wrap(byteBuffer, byteBuffer2);
        } catch (RuntimeException e) {
            throw convert(e);
        }
    }

    private SSLEngineResult doUnwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        try {
            return this.sslEngine.unwrap(byteBuffer, byteBuffer2);
        } catch (RuntimeException e) {
            throw convert(e);
        }
    }

    private void doRunTask() {
        Runnable delegatedTask = this.sslEngine.getDelegatedTask();
        if (delegatedTask != null) {
            delegatedTask.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHandshake(IOSession iOSession) throws IOException {
        String applicationProtocol;
        boolean z = true;
        SSLEngineResult sSLEngineResultDoWrap = null;
        while (z) {
            SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
            if (handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && this.outboundClosedCount.get() > 0) {
                handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            int i = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
            if (i == 1) {
                this.session.getLock().lock();
                try {
                    sSLEngineResultDoWrap = doWrap(EMPTY_BUFFER, this.outEncrypted.acquire());
                    if (sSLEngineResultDoWrap.getStatus() != SSLEngineResult.Status.OK || sSLEngineResultDoWrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                        z = false;
                    }
                    this.session.getLock().unlock();
                } catch (Throwable th) {
                    this.session.getLock().unlock();
                    throw th;
                }
            } else if (i == 2) {
                ByteBuffer byteBufferAcquire = this.inEncrypted.acquire();
                ByteBuffer byteBufferAcquire2 = this.inPlain.acquire();
                byteBufferAcquire.flip();
                try {
                    SSLEngineResult sSLEngineResultDoUnwrap = doUnwrap(byteBufferAcquire, byteBufferAcquire2);
                    byteBufferAcquire.compact();
                    try {
                        if (!byteBufferAcquire.hasRemaining() && sSLEngineResultDoUnwrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                            throw new SSLException("Input buffer is full");
                        }
                        if (byteBufferAcquire.position() == 0) {
                            this.inEncrypted.release();
                        }
                        if (this.status.compareTo(IOSession.Status.CLOSING) >= 0) {
                            this.inPlain.release();
                        }
                        if (sSLEngineResultDoUnwrap.getStatus() != SSLEngineResult.Status.OK) {
                            sSLEngineResultDoWrap = sSLEngineResultDoUnwrap;
                            z = false;
                        } else {
                            sSLEngineResultDoWrap = sSLEngineResultDoUnwrap;
                        }
                    } catch (Throwable th2) {
                        if (byteBufferAcquire.position() == 0) {
                            this.inEncrypted.release();
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    byteBufferAcquire.compact();
                    throw th3;
                }
            } else if (i == 3) {
                doRunTask();
            } else if (i == 4) {
                z = false;
            }
        }
        if (sSLEngineResultDoWrap == null || sSLEngineResultDoWrap.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.FINISHED) {
            return;
        }
        this.handshakeStateRef.set(TLSHandShakeState.COMPLETE);
        this.session.setSocketTimeout(this.socketTimeout);
        SSLSessionVerifier sSLSessionVerifier = this.verifier;
        if (sSLSessionVerifier != null) {
            this.tlsDetails = sSLSessionVerifier.verify(this.targetEndpoint, this.sslEngine);
        }
        if (this.tlsDetails == null) {
            SSLSession session = this.sslEngine.getSession();
            try {
                applicationProtocol = this.sslEngine.getApplicationProtocol();
            } catch (UnsupportedOperationException unused) {
                applicationProtocol = "http/1.1";
            }
            this.tlsDetails = new TlsDetails(session, applicationProtocol);
        }
        ensureHandler().connected(iOSession);
        Callback<SSLIOSession> callback = this.sessionStartCallback;
        if (callback != null) {
            callback.execute(this);
        }
        FutureCallback<SSLSession> andSet = this.handshakeCallbackRef.getAndSet(null);
        if (andSet != null) {
            andSet.completed(this.sslEngine.getSession());
        }
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.reactor.ssl.SSLIOSession$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$reactor$ssl$SSLMode;

        static {
            int[] iArr = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr;
            try {
                iArr[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SSLMode.values().length];
            $SwitchMap$org$apache$hc$core5$reactor$ssl$SSLMode = iArr2;
            try {
                iArr2[SSLMode.CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$reactor$ssl$SSLMode[SSLMode.SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEventMask() {
        this.session.getLock().lock();
        try {
            if (this.status == IOSession.Status.ACTIVE && (this.endOfStream || this.sslEngine.isInboundDone())) {
                this.status = IOSession.Status.CLOSING;
                FutureCallback<SSLSession> andSet = this.handshakeCallbackRef.getAndSet(null);
                if (andSet != null) {
                    andSet.failed(new SSLHandshakeException("TLS handshake failed"));
                }
            }
            if (this.status == IOSession.Status.CLOSING && !this.outEncrypted.hasData()) {
                this.sslEngine.closeOutbound();
                this.outboundClosedCount.incrementAndGet();
            }
            SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
            if (this.status == IOSession.Status.CLOSING && ((handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED) && !this.outEncrypted.hasData() && this.sslEngine.isOutboundDone() && (this.endOfStream || this.sslEngine.isInboundDone()))) {
                this.status = IOSession.Status.CLOSED;
            }
            if (this.status.compareTo(IOSession.Status.CLOSING) <= 0 && this.endOfStream && handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                this.status = IOSession.Status.CLOSED;
            }
            if (this.status == IOSession.Status.CLOSED) {
                this.session.close();
                Callback<SSLIOSession> callback = this.sessionEndCallback;
                if (callback != null) {
                    callback.execute(this);
                }
            } else {
                if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                    doRunTask();
                }
                int eventMask = this.session.getEventMask();
                int i = AnonymousClass2.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[this.sslEngine.getHandshakeStatus().ordinal()];
                int i2 = 1;
                if (i == 1) {
                    i2 = 5;
                } else if (i != 2) {
                    i2 = i != 4 ? eventMask : this.appEventMask;
                }
                if (this.endOfStream && !this.inPlain.hasData()) {
                    i2 &= -2;
                } else if (this.status == IOSession.Status.CLOSING) {
                    i2 |= 1;
                }
                if (this.outEncrypted.hasData()) {
                    i2 |= 4;
                } else if (this.sslEngine.isOutboundDone()) {
                    i2 &= -5;
                }
                if (eventMask != i2) {
                    this.session.setEventMask(i2);
                }
            }
        } finally {
            this.session.getLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sendEncryptedData() throws IOException {
        int iWrite;
        this.session.getLock().lock();
        try {
            if (this.status == IOSession.Status.ACTIVE && !this.outEncrypted.hasData()) {
                int iWrite2 = this.session.write(EMPTY_BUFFER);
                this.session.getLock().unlock();
                return iWrite2;
            }
            ByteBuffer byteBufferAcquire = this.outEncrypted.acquire();
            if (this.status == IOSession.Status.CLOSED) {
                byteBufferAcquire.clear();
            }
            if (byteBufferAcquire.position() > 0) {
                byteBufferAcquire.flip();
                try {
                    iWrite = this.session.write(byteBufferAcquire);
                    byteBufferAcquire.compact();
                } catch (Throwable th) {
                    byteBufferAcquire.compact();
                    throw th;
                }
            } else {
                iWrite = 0;
            }
            if (byteBufferAcquire.position() == 0) {
                this.outEncrypted.release();
            }
            this.session.getLock().unlock();
            return iWrite;
        } catch (Throwable th2) {
            this.session.getLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int receiveEncryptedData() throws IOException {
        if (this.endOfStream) {
            return -1;
        }
        ByteBuffer byteBufferAcquire = this.inEncrypted.acquire();
        int i = this.session.read(byteBufferAcquire);
        if (byteBufferAcquire.position() == 0) {
            this.inEncrypted.release();
        }
        if (i == -1) {
            this.endOfStream = true;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decryptData(IOSession iOSession) throws IOException {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
        if ((handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED) && this.inEncrypted.hasData()) {
            ByteBuffer byteBufferAcquire = this.inEncrypted.acquire();
            byteBufferAcquire.flip();
            while (byteBufferAcquire.hasRemaining()) {
                try {
                    ByteBuffer byteBufferAcquire2 = this.inPlain.acquire();
                    try {
                        SSLEngineResult sSLEngineResultDoUnwrap = doUnwrap(byteBufferAcquire, byteBufferAcquire2);
                        if (!byteBufferAcquire.hasRemaining() && sSLEngineResultDoUnwrap.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                            throw new SSLException("Unable to complete SSL handshake");
                        }
                        if (this.sslEngine.isInboundDone()) {
                            this.endOfStream = true;
                        }
                        if (byteBufferAcquire2.position() > 0) {
                            byteBufferAcquire2.flip();
                            try {
                                ensureHandler().inputReady(iOSession, byteBufferAcquire2.hasRemaining() ? byteBufferAcquire2 : null);
                                byteBufferAcquire2.clear();
                            } catch (Throwable th) {
                                byteBufferAcquire2.clear();
                                throw th;
                            }
                        }
                        if (sSLEngineResultDoUnwrap.getStatus() != SSLEngineResult.Status.OK) {
                            if (sSLEngineResultDoUnwrap.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW && this.endOfStream) {
                                throw new SSLException("Unable to decrypt incoming data due to unexpected end of stream");
                            }
                            this.inPlain.release();
                            break;
                        }
                        this.inPlain.release();
                    } catch (Throwable th2) {
                        this.inPlain.release();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    byteBufferAcquire.compact();
                    if (byteBufferAcquire.position() == 0) {
                        this.inEncrypted.release();
                    }
                    throw th3;
                }
            }
            byteBufferAcquire.compact();
            if (byteBufferAcquire.position() == 0) {
                this.inEncrypted.release();
            }
        }
        if (!this.endOfStream || this.inEncrypted.hasData()) {
            return;
        }
        ensureHandler().inputReady(iOSession, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encryptData(IOSession iOSession) throws IOException {
        this.session.getLock().lock();
        try {
            boolean z = (this.appEventMask & 4) > 0 && this.status == IOSession.Status.ACTIVE && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            this.session.getLock().unlock();
            if (z) {
                ensureHandler().outputReady(iOSession);
            }
        } catch (Throwable th) {
            this.session.getLock().unlock();
            throw th;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        Args.notNull(byteBuffer, "Byte buffer");
        this.session.getLock().lock();
        try {
            if (this.status != IOSession.Status.ACTIVE) {
                throw new ClosedChannelException();
            }
            if (this.handshakeStateRef.get() != TLSHandShakeState.READY) {
                int iBytesConsumed = doWrap(byteBuffer, this.outEncrypted.acquire()).bytesConsumed();
                this.session.getLock().unlock();
                return iBytesConsumed;
            }
            this.session.getLock().unlock();
            return 0;
        } catch (Throwable th) {
            this.session.getLock().unlock();
            throw th;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.endOfStream ? -1 : 0;
    }

    @Override // org.apache.hc.core5.util.Identifiable
    public String getId() {
        return this.session.getId();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public Lock getLock() {
        return this.session.getLock();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void upgrade(IOEventHandler iOEventHandler) {
        this.session.upgrade(iOEventHandler);
    }

    public TlsDetails getTlsDetails() {
        return this.tlsDetails;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.status == IOSession.Status.ACTIVE && this.session.isOpen();
    }

    @Override // org.apache.hc.core5.reactor.IOSession, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(CloseMode.GRACEFUL);
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        this.session.getLock().lock();
        try {
            if (closeMode == CloseMode.GRACEFUL) {
                if (this.status.compareTo(IOSession.Status.CLOSING) < 0) {
                    this.status = IOSession.Status.CLOSING;
                    if (this.session.getSocketTimeout().isDisabled()) {
                        this.session.setSocketTimeout(Timeout.ofMilliseconds(1000L));
                    }
                    try {
                        doHandshake(this);
                        sendEncryptedData();
                        updateEventMask();
                    } catch (CancelledKeyException unused) {
                        this.session.close(CloseMode.GRACEFUL);
                    } catch (Exception unused2) {
                        this.session.close(CloseMode.IMMEDIATE);
                    }
                }
            } else if (this.status != IOSession.Status.CLOSED) {
                this.inEncrypted.release();
                this.outEncrypted.release();
                this.inPlain.release();
                this.status = IOSession.Status.CLOSED;
                this.session.close(closeMode);
            }
            this.session.getLock().unlock();
        } catch (Throwable th) {
            this.session.getLock().unlock();
            throw th;
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public IOSession.Status getStatus() {
        return this.status;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void enqueue(Command command, Command.Priority priority) {
        this.session.getLock().lock();
        try {
            this.session.enqueue(command, priority);
            setEvent(4);
        } finally {
            this.session.getLock().unlock();
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public boolean hasCommands() {
        return this.session.hasCommands();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public Command poll() {
        return this.session.poll();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public ByteChannel channel() {
        return this.session.channel();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public SocketAddress getLocalAddress() {
        return this.session.getLocalAddress();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public SocketAddress getRemoteAddress() {
        return this.session.getRemoteAddress();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public int getEventMask() {
        this.session.getLock().lock();
        try {
            return this.appEventMask;
        } finally {
            this.session.getLock().unlock();
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void setEventMask(int i) {
        this.session.getLock().lock();
        try {
            this.appEventMask = i;
            updateEventMask();
        } finally {
            this.session.getLock().unlock();
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void setEvent(int i) {
        this.session.getLock().lock();
        try {
            this.appEventMask = i | this.appEventMask;
            updateEventMask();
        } finally {
            this.session.getLock().unlock();
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void clearEvent(int i) {
        this.session.getLock().lock();
        try {
            this.appEventMask = (~i) & this.appEventMask;
            updateEventMask();
        } finally {
            this.session.getLock().unlock();
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession, org.apache.hc.core5.http.SocketModalCloseable
    public Timeout getSocketTimeout() {
        return this.session.getSocketTimeout();
    }

    @Override // org.apache.hc.core5.reactor.IOSession, org.apache.hc.core5.http.SocketModalCloseable
    public void setSocketTimeout(Timeout timeout) {
        this.socketTimeout = timeout;
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
            this.session.setSocketTimeout(timeout);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void updateReadTime() {
        this.session.updateReadTime();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void updateWriteTime() {
        this.session.updateWriteTime();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastReadTime() {
        return this.session.getLastReadTime();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastWriteTime() {
        return this.session.getLastWriteTime();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastEventTime() {
        return this.session.getLastEventTime();
    }

    private static void formatOps(StringBuilder sb, int i) {
        if ((i & 1) > 0) {
            sb.append('r');
        }
        if ((i & 4) > 0) {
            sb.append('w');
        }
    }

    public String toString() {
        this.session.getLock().lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.session);
            sb.append("[");
            sb.append(this.status);
            sb.append("][");
            formatOps(sb, this.appEventMask);
            sb.append("][");
            sb.append(this.sslEngine.getHandshakeStatus());
            if (this.sslEngine.isInboundDone()) {
                sb.append("][inbound done][");
            }
            if (this.sslEngine.isOutboundDone()) {
                sb.append("][outbound done][");
            }
            if (this.endOfStream) {
                sb.append("][EOF][");
            }
            sb.append("][");
            int iPosition = 0;
            sb.append(!this.inEncrypted.hasData() ? 0 : this.inEncrypted.acquire().position());
            sb.append("][");
            sb.append(!this.inPlain.hasData() ? 0 : this.inPlain.acquire().position());
            sb.append("][");
            if (this.outEncrypted.hasData()) {
                iPosition = this.outEncrypted.acquire().position();
            }
            sb.append(iPosition);
            sb.append("]");
            return sb.toString();
        } finally {
            this.session.getLock().unlock();
        }
    }
}
