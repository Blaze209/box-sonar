package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.StreamChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinAsyncEntityProducer implements AsyncEntityProducer {
    private final ByteBuffer byteBuffer;
    private final ContentType contentType;
    private final int fragmentSizeHint;
    private final ReentrantLock lock;
    private volatile State state;

    enum State {
        ACTIVE,
        FLUSHING,
        END_STREAM
    }

    protected abstract int availableData();

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return -1L;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return false;
    }

    protected abstract void produceData(StreamChannel<ByteBuffer> streamChannel) throws IOException;

    public AbstractBinAsyncEntityProducer(int i, ContentType contentType) {
        i = i < 0 ? 0 : i;
        this.fragmentSizeHint = i;
        this.byteBuffer = ByteBuffer.allocate(i);
        this.contentType = contentType;
        this.state = State.ACTIVE;
        this.lock = new ReentrantLock();
    }

    private void flush(StreamChannel<ByteBuffer> streamChannel) throws IOException {
        if (this.byteBuffer.position() > 0) {
            this.byteBuffer.flip();
            streamChannel.write(this.byteBuffer);
            this.byteBuffer.compact();
        }
    }

    final int writeData(StreamChannel<ByteBuffer> streamChannel, ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return 0;
        }
        if (iRemaining > this.fragmentSizeHint) {
            flush(streamChannel);
            if (this.byteBuffer.position() == 0) {
                return streamChannel.write(byteBuffer);
            }
        } else {
            if (this.byteBuffer.remaining() < iRemaining) {
                flush(streamChannel);
            }
            if (this.byteBuffer.remaining() >= iRemaining) {
                this.byteBuffer.put(byteBuffer);
                if (!this.byteBuffer.hasRemaining()) {
                    flush(streamChannel);
                }
                return iRemaining;
            }
        }
        return 0;
    }

    final void streamEnd(StreamChannel<ByteBuffer> streamChannel) throws IOException {
        if (this.state == State.ACTIVE) {
            this.state = State.FLUSHING;
            flush(streamChannel);
            if (this.byteBuffer.position() == 0) {
                this.state = State.END_STREAM;
                streamChannel.endStream();
            }
        }
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final String getContentType() {
        return Objects.toString(this.contentType, null);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final int available() {
        if (this.state == State.ACTIVE) {
            return availableData();
        }
        this.lock.lock();
        try {
            return this.byteBuffer.position();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final void produce(final DataStreamChannel dataStreamChannel) throws IOException {
        this.lock.lock();
        try {
            if (this.state == State.ACTIVE) {
                produceData(new StreamChannel<ByteBuffer>() { // from class: org.apache.hc.core5.http.nio.entity.AbstractBinAsyncEntityProducer.1
                    @Override // org.apache.hc.core5.http.nio.StreamChannel
                    public int write(ByteBuffer byteBuffer) throws IOException {
                        Args.notNull(byteBuffer, "Buffer");
                        AbstractBinAsyncEntityProducer.this.lock.lock();
                        try {
                            return AbstractBinAsyncEntityProducer.this.writeData(dataStreamChannel, byteBuffer);
                        } finally {
                            AbstractBinAsyncEntityProducer.this.lock.unlock();
                        }
                    }

                    @Override // org.apache.hc.core5.http.nio.StreamChannel
                    public void endStream() throws IOException {
                        AbstractBinAsyncEntityProducer.this.lock.lock();
                        try {
                            AbstractBinAsyncEntityProducer.this.streamEnd(dataStreamChannel);
                        } finally {
                            AbstractBinAsyncEntityProducer.this.lock.unlock();
                        }
                    }
                });
            }
            if (this.state == State.FLUSHING) {
                flush(dataStreamChannel);
                if (this.byteBuffer.position() == 0) {
                    this.state = State.END_STREAM;
                    dataStreamChannel.endStream();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.state = State.ACTIVE;
    }
}
