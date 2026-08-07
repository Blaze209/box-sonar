package org.apache.hc.core5.http.nio.support.classic;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.http.nio.CapacityChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class SharedInputBuffer extends AbstractSharedBuffer implements ContentInputBuffer {
    private volatile CapacityChannel capacityChannel;
    private final AtomicInteger capacityIncrement;
    private final int initialBufferSize;

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

    public SharedInputBuffer(ReentrantLock reentrantLock, int i) {
        super(reentrantLock, i);
        this.initialBufferSize = i;
        this.capacityIncrement = new AtomicInteger(0);
    }

    public SharedInputBuffer(int i) {
        this(new ReentrantLock(), i);
    }

    public int fill(ByteBuffer byteBuffer) {
        this.lock.lock();
        try {
            setInputMode();
            ensureAdjustedCapacity(buffer().position() + byteBuffer.remaining());
            buffer().put(byteBuffer);
            int iRemaining = buffer().remaining();
            this.condition.signalAll();
            return iRemaining;
        } finally {
            this.lock.unlock();
        }
    }

    private void incrementCapacity() throws IOException {
        int andSet;
        if (this.capacityChannel == null || (andSet = this.capacityIncrement.getAndSet(0)) <= 0) {
            return;
        }
        this.capacityChannel.update(andSet);
    }

    public void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        this.lock.lock();
        try {
            this.capacityChannel = capacityChannel;
            setInputMode();
            if (buffer().position() == 0) {
                capacityChannel.update(this.initialBufferSize);
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void awaitInput() throws InterruptedIOException {
        if (buffer().hasRemaining()) {
            return;
        }
        setInputMode();
        while (buffer().position() == 0 && !this.endStream && !this.aborted) {
            try {
                this.condition.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException(e.getMessage());
            }
        }
        setOutputMode();
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.ContentInputBuffer
    public int read() throws IOException {
        this.lock.lock();
        try {
            setOutputMode();
            awaitInput();
            if (!this.aborted && (buffer().hasRemaining() || !this.endStream)) {
                int i = buffer().get() & 255;
                this.capacityIncrement.incrementAndGet();
                if (!buffer().hasRemaining()) {
                    incrementCapacity();
                }
                return i;
            }
            return -1;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.nio.support.classic.ContentInputBuffer
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        this.lock.lock();
        try {
            setOutputMode();
            awaitInput();
            if (!this.aborted && (buffer().hasRemaining() || !this.endStream)) {
                int iMin = Math.min(buffer().remaining(), i2);
                buffer().get(bArr, i, iMin);
                this.capacityIncrement.addAndGet(iMin);
                if (!buffer().hasRemaining()) {
                    incrementCapacity();
                }
                return iMin;
            }
            return -1;
        } finally {
            this.lock.unlock();
        }
    }

    public void markEndStream() {
        if (this.endStream) {
            return;
        }
        this.lock.lock();
        try {
            if (!this.endStream) {
                this.endStream = true;
                this.capacityChannel = null;
                this.condition.signalAll();
            }
        } finally {
            this.lock.unlock();
        }
    }
}
