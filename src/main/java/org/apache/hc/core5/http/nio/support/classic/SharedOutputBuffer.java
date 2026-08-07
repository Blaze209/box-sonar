package org.apache.hc.core5.http.nio.support.classic;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.http.nio.DataStreamChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class SharedOutputBuffer extends AbstractSharedBuffer implements ContentOutputBuffer {
    private volatile DataStreamChannel dataStreamChannel;
    private volatile boolean endStreamPropagated;
    private volatile boolean hasCapacity;

    @Override // org.apache.hc.core5.http.nio.support.classic.AbstractSharedBuffer
    public /* bridge */ /* synthetic */ void abort() {
        super.abort();
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.AbstractSharedBuffer, org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public /* bridge */ /* synthetic */ int capacity() {
        return super.capacity();
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.AbstractSharedBuffer, org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public /* bridge */ /* synthetic */ boolean hasData() {
        return super.hasData();
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.AbstractSharedBuffer
    public /* bridge */ /* synthetic */ boolean isEndStream() {
        return super.isEndStream();
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.AbstractSharedBuffer, org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public /* bridge */ /* synthetic */ int length() {
        return super.length();
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.AbstractSharedBuffer, org.apache.hc.core5.http.nio.support.classic.ContentInputBuffer
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public SharedOutputBuffer(ReentrantLock reentrantLock, int i) {
        super(reentrantLock, i);
        this.hasCapacity = false;
        this.endStreamPropagated = false;
    }

    public SharedOutputBuffer(int i) {
        this(new ReentrantLock(), i);
    }

    public void flush(DataStreamChannel dataStreamChannel) throws IOException {
        this.lock.lock();
        try {
            this.dataStreamChannel = dataStreamChannel;
            this.hasCapacity = true;
            setOutputMode();
            if (buffer().hasRemaining()) {
                this.dataStreamChannel.write(buffer());
            }
            if (!buffer().hasRemaining() && this.endStream) {
                propagateEndStream();
            }
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    private void ensureNotAborted() throws InterruptedIOException {
        if (this.aborted) {
            throw new InterruptedIOException("Operation aborted");
        }
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.ContentOutputBuffer
    public void write(byte[] bArr, int i, int i2) throws IOException {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, i2);
        this.lock.lock();
        try {
            ensureNotAborted();
            setInputMode();
            while (byteBufferWrap.hasRemaining()) {
                if (byteBufferWrap.remaining() < 1024 && buffer().remaining() > byteBufferWrap.remaining()) {
                    buffer().put(byteBufferWrap);
                } else {
                    if (buffer().position() > 0 || this.dataStreamChannel == null) {
                        waitFlush();
                    }
                    if (buffer().position() == 0 && this.dataStreamChannel != null && this.dataStreamChannel.write(byteBufferWrap) == 0) {
                        this.hasCapacity = false;
                        waitFlush();
                    }
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.ContentOutputBuffer
    public void write(int i) throws IOException {
        this.lock.lock();
        try {
            ensureNotAborted();
            setInputMode();
            if (!buffer().hasRemaining()) {
                waitFlush();
            }
            buffer().put((byte) i);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.ContentOutputBuffer
    public void writeCompleted() throws IOException {
        if (this.endStream) {
            return;
        }
        this.lock.lock();
        try {
            if (!this.endStream) {
                this.endStream = true;
                if (this.dataStreamChannel != null) {
                    setOutputMode();
                    if (buffer().hasRemaining()) {
                        this.dataStreamChannel.requestOutput();
                    } else {
                        propagateEndStream();
                    }
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void waitFlush() throws InterruptedIOException {
        setOutputMode();
        if (this.dataStreamChannel != null) {
            this.dataStreamChannel.requestOutput();
        }
        ensureNotAborted();
        while (true) {
            if (buffer().hasRemaining() || !this.hasCapacity) {
                try {
                    this.condition.await();
                    ensureNotAborted();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException(e.getMessage());
                }
            } else {
                setInputMode();
                return;
            }
        }
    }

    private void propagateEndStream() throws IOException {
        if (this.endStreamPropagated) {
            return;
        }
        this.dataStreamChannel.endStream();
        this.endStreamPropagated = true;
    }
}
