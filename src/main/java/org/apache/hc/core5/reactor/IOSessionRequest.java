package org.apache.hc.core5.reactor;

import java.net.SocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.concurrent.BasicFuture;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
final class IOSessionRequest implements Future<IOSession> {
    final Object attachment;
    private final AtomicReference<ModalCloseable> closeableRef = new AtomicReference<>();
    final BasicFuture<IOSession> future;
    final SocketAddress localAddress;
    final SocketAddress remoteAddress;
    final NamedEndpoint remoteEndpoint;
    final Timeout timeout;

    public IOSessionRequest(NamedEndpoint namedEndpoint, SocketAddress socketAddress, SocketAddress socketAddress2, Timeout timeout, Object obj, FutureCallback<IOSession> futureCallback) {
        this.remoteEndpoint = namedEndpoint;
        this.remoteAddress = socketAddress;
        this.localAddress = socketAddress2;
        this.timeout = timeout;
        this.attachment = obj;
        this.future = new BasicFuture<>(futureCallback);
    }

    public void completed(ProtocolIOSession protocolIOSession) {
        this.future.completed(protocolIOSession);
        this.closeableRef.set(null);
    }

    public void failed(Exception exc) {
        this.future.failed(exc);
        this.closeableRef.set(null);
    }

    public boolean cancel() {
        boolean zCancel = this.future.cancel();
        ModalCloseable andSet = this.closeableRef.getAndSet(null);
        if (zCancel && andSet != null) {
            andSet.close(CloseMode.IMMEDIATE);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return cancel();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.future.isCancelled();
    }

    public void assign(ModalCloseable modalCloseable) {
        this.closeableRef.set(modalCloseable);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.future.isDone();
    }

    @Override // java.util.concurrent.Future
    public IOSession get() throws ExecutionException, InterruptedException {
        return this.future.get();
    }

    @Override // java.util.concurrent.Future
    public IOSession get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.future.get(j, timeUnit);
    }

    public String toString() {
        return "[remoteEndpoint=" + this.remoteEndpoint + ", remoteAddress=" + this.remoteAddress + ", localAddress=" + this.localAddress + ", attachment=" + this.attachment + AbstractJsonLexerKt.END_LIST;
    }
}
