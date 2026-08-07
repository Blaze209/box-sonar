package org.apache.hc.core5.reactor;

import java.net.SocketAddress;
import java.nio.channels.ByteChannel;
import java.util.concurrent.locks.Lock;
import org.apache.hc.core5.http.SocketModalCloseable;
import org.apache.hc.core5.util.Identifiable;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface IOSession extends ByteChannel, SocketModalCloseable, Identifiable {

    public enum Status {
        ACTIVE,
        CLOSING,
        CLOSED
    }

    ByteChannel channel();

    void clearEvent(int i);

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    void close();

    void enqueue(Command command, Command.Priority priority);

    int getEventMask();

    IOEventHandler getHandler();

    long getLastEventTime();

    long getLastReadTime();

    long getLastWriteTime();

    SocketAddress getLocalAddress();

    Lock getLock();

    SocketAddress getRemoteAddress();

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    Timeout getSocketTimeout();

    Status getStatus();

    boolean hasCommands();

    Command poll();

    void setEvent(int i);

    void setEventMask(int i);

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    void setSocketTimeout(Timeout timeout);

    void updateReadTime();

    void updateWriteTime();

    void upgrade(IOEventHandler iOEventHandler);
}
