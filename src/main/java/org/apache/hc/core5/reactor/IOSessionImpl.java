package org.apache.hc.core5.reactor;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
class IOSessionImpl implements IOSession {
    private static final AtomicLong COUNT = new AtomicLong(0);
    private final SocketChannel channel;
    private final String id;
    private final SelectionKey key;
    private volatile long lastEventTime;
    private volatile long lastReadTime;
    private volatile long lastWriteTime;
    private final Deque<Command> commandQueue = new ConcurrentLinkedDeque();
    private final Lock lock = new ReentrantLock();
    private volatile Timeout socketTimeout = Timeout.INFINITE;
    private final AtomicReference<IOEventHandler> handlerRef = new AtomicReference<>();
    private final AtomicReference<IOSession.Status> status = new AtomicReference<>(IOSession.Status.ACTIVE);

    public IOSessionImpl(String str, SelectionKey selectionKey, SocketChannel socketChannel) {
        this.key = (SelectionKey) Args.notNull(selectionKey, "Selection key");
        this.channel = (SocketChannel) Args.notNull(socketChannel, "Socket channel");
        this.id = String.format(str + "-%010d", Long.valueOf(COUNT.getAndIncrement()));
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lastReadTime = jCurrentTimeMillis;
        this.lastWriteTime = jCurrentTimeMillis;
        this.lastEventTime = jCurrentTimeMillis;
    }

    @Override // org.apache.hc.core5.util.Identifiable
    public String getId() {
        return this.id;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public IOEventHandler getHandler() {
        return this.handlerRef.get();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void upgrade(IOEventHandler iOEventHandler) {
        this.handlerRef.set(iOEventHandler);
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public Lock getLock() {
        return this.lock;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void enqueue(Command command, Command.Priority priority) {
        if (priority == Command.Priority.IMMEDIATE) {
            this.commandQueue.addFirst(command);
        } else {
            this.commandQueue.add(command);
        }
        setEvent(4);
        if (isStatusClosed()) {
            command.cancel();
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public boolean hasCommands() {
        return !this.commandQueue.isEmpty();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public Command poll() {
        return this.commandQueue.poll();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public ByteChannel channel() {
        return this.channel;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public SocketAddress getLocalAddress() {
        return this.channel.socket().getLocalSocketAddress();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public SocketAddress getRemoteAddress() {
        return this.channel.socket().getRemoteSocketAddress();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public int getEventMask() {
        return this.key.interestOps();
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void setEventMask(int i) {
        this.lock.lock();
        try {
            if (!isStatusClosed()) {
                this.key.interestOps(i);
                this.lock.unlock();
                this.key.selector().wakeup();
                return;
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void setEvent(int i) {
        this.lock.lock();
        try {
            if (!isStatusClosed()) {
                SelectionKey selectionKey = this.key;
                selectionKey.interestOps(i | selectionKey.interestOps());
                this.lock.unlock();
                this.key.selector().wakeup();
                return;
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void clearEvent(int i) {
        this.lock.lock();
        try {
            if (!isStatusClosed()) {
                SelectionKey selectionKey = this.key;
                selectionKey.interestOps((~i) & selectionKey.interestOps());
                this.lock.unlock();
                this.key.selector().wakeup();
                return;
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // org.apache.hc.core5.reactor.IOSession, org.apache.hc.core5.http.SocketModalCloseable
    public Timeout getSocketTimeout() {
        return this.socketTimeout;
    }

    @Override // org.apache.hc.core5.reactor.IOSession, org.apache.hc.core5.http.SocketModalCloseable
    public void setSocketTimeout(Timeout timeout) {
        this.socketTimeout = Timeout.defaultsToInfinite(timeout);
        this.lastEventTime = System.currentTimeMillis();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.channel.read(byteBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.channel.write(byteBuffer);
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void updateReadTime() {
        this.lastReadTime = System.currentTimeMillis();
        this.lastEventTime = this.lastReadTime;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public void updateWriteTime() {
        this.lastWriteTime = System.currentTimeMillis();
        this.lastEventTime = this.lastWriteTime;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastReadTime() {
        return this.lastReadTime;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastWriteTime() {
        return this.lastWriteTime;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public long getLastEventTime() {
        return this.lastEventTime;
    }

    @Override // org.apache.hc.core5.reactor.IOSession
    public IOSession.Status getStatus() {
        return this.status.get();
    }

    private boolean isStatusClosed() {
        return this.status.get() == IOSession.Status.CLOSED;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.status.get() == IOSession.Status.ACTIVE && this.channel.isOpen();
    }

    @Override // org.apache.hc.core5.reactor.IOSession, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(CloseMode.GRACEFUL);
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, IOSession.Status.ACTIVE, IOSession.Status.CLOSED)) {
            if (closeMode == CloseMode.IMMEDIATE) {
                try {
                    this.channel.socket().setSoLinger(true, 0);
                } catch (SocketException unused) {
                }
            }
            this.lock.lock();
            try {
                this.key.cancel();
                this.key.attach(null);
                this.lock.unlock();
                Closer.closeQuietly(this.key.channel());
                if (this.key.selector().isOpen()) {
                    this.key.selector().wakeup();
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
    }

    private static void formatOps(StringBuilder sb, int i) {
        if ((i & 1) > 0) {
            sb.append('r');
        }
        if ((i & 4) > 0) {
            sb.append('w');
        }
        if ((i & 16) > 0) {
            sb.append('a');
        }
        if ((i & 8) > 0) {
            sb.append('c');
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id).append("[");
        sb.append(this.status);
        sb.append("][");
        if (this.key.isValid()) {
            formatOps(sb, this.key.interestOps());
            sb.append(":");
            formatOps(sb, this.key.readyOps());
        }
        sb.append("]");
        return sb.toString();
    }
}
