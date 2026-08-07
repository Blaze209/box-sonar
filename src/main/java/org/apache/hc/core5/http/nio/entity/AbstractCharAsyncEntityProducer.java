package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.http.nio.StreamChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractCharAsyncEntityProducer implements AsyncEntityProducer {
    private static final CharBuffer EMPTY = CharBuffer.wrap(new char[0]);
    private final ByteBuffer bytebuf;
    private final CharsetEncoder charsetEncoder;
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
    public Set<String> getTrailerNames() {
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return false;
    }

    protected abstract void produceData(StreamChannel<CharBuffer> streamChannel) throws IOException;

    public AbstractCharAsyncEntityProducer(int i, int i2, ContentType contentType) {
        Args.positive(i, "Buffer size");
        this.fragmentSizeHint = i2 < 0 ? 0 : i2;
        this.bytebuf = ByteBuffer.allocate(i);
        this.contentType = contentType;
        this.charsetEncoder = ContentType.getCharset(contentType, StandardCharsets.UTF_8).newEncoder();
        this.state = State.ACTIVE;
        this.lock = new ReentrantLock();
    }

    private void flush(StreamChannel<ByteBuffer> streamChannel) throws IOException {
        if (this.bytebuf.position() > 0) {
            this.bytebuf.flip();
            streamChannel.write(this.bytebuf);
            this.bytebuf.compact();
        }
    }

    final int writeData(StreamChannel<ByteBuffer> streamChannel, CharBuffer charBuffer) throws IOException {
        if (charBuffer.remaining() == 0) {
            return 0;
        }
        int iPosition = charBuffer.position();
        CoderResult coderResultEncode = this.charsetEncoder.encode(charBuffer, this.bytebuf, false);
        if (coderResultEncode.isError()) {
            coderResultEncode.throwException();
        }
        if (!this.bytebuf.hasRemaining() || this.bytebuf.position() >= this.fragmentSizeHint) {
            flush(streamChannel);
        }
        return charBuffer.position() - iPosition;
    }

    final void streamEnd(StreamChannel<ByteBuffer> streamChannel) throws IOException {
        if (this.state == State.ACTIVE) {
            this.state = State.FLUSHING;
            if (!this.bytebuf.hasRemaining()) {
                flush(streamChannel);
            }
            CoderResult coderResultEncode = this.charsetEncoder.encode(EMPTY, this.bytebuf, true);
            if (coderResultEncode.isError()) {
                coderResultEncode.throwException();
            }
            if (this.charsetEncoder.flush(this.bytebuf).isError()) {
                coderResultEncode.throwException();
                return;
            }
            if (coderResultEncode.isUnderflow()) {
                flush(streamChannel);
                if (this.bytebuf.position() == 0) {
                    this.state = State.END_STREAM;
                    streamChannel.endStream();
                }
            }
        }
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final String getContentType() {
        return Objects.toString(this.contentType, null);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final int available() {
        if (this.state == State.ACTIVE) {
            return availableData();
        }
        this.lock.lock();
        try {
            return this.bytebuf.position();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public final void produce(final DataStreamChannel dataStreamChannel) throws IOException {
        this.lock.lock();
        try {
            if (this.state == State.ACTIVE) {
                produceData(new StreamChannel<CharBuffer>() { // from class: org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityProducer.1
                    @Override // org.apache.hc.core5.http.nio.StreamChannel
                    public int write(CharBuffer charBuffer) throws IOException {
                        Args.notNull(charBuffer, "Buffer");
                        AbstractCharAsyncEntityProducer.this.lock.lock();
                        try {
                            return AbstractCharAsyncEntityProducer.this.writeData(dataStreamChannel, charBuffer);
                        } finally {
                            AbstractCharAsyncEntityProducer.this.lock.unlock();
                        }
                    }

                    @Override // org.apache.hc.core5.http.nio.StreamChannel
                    public void endStream() throws IOException {
                        AbstractCharAsyncEntityProducer.this.lock.lock();
                        try {
                            AbstractCharAsyncEntityProducer.this.streamEnd(dataStreamChannel);
                        } finally {
                            AbstractCharAsyncEntityProducer.this.lock.unlock();
                        }
                    }
                });
            }
            if (this.state == State.FLUSHING) {
                CoderResult coderResultFlush = this.charsetEncoder.flush(this.bytebuf);
                if (coderResultFlush.isError()) {
                    coderResultFlush.throwException();
                } else if (coderResultFlush.isOverflow()) {
                    flush(dataStreamChannel);
                } else if (coderResultFlush.isUnderflow()) {
                    flush(dataStreamChannel);
                    if (this.bytebuf.position() == 0) {
                        this.state = State.END_STREAM;
                        dataStreamChannel.endStream();
                    }
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.state = State.ACTIVE;
        this.charsetEncoder.reset();
    }
}
