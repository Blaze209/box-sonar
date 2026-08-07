package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.nio.ContentEncoder;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractContentEncoder implements ContentEncoder {
    final SessionOutputBuffer buffer;
    final WritableByteChannel channel;
    boolean completed;
    final BasicHttpTransportMetrics metrics;

    public AbstractContentEncoder(WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) {
        Args.notNull(writableByteChannel, "Channel");
        Args.notNull(sessionOutputBuffer, "Session input buffer");
        Args.notNull(basicHttpTransportMetrics, "Transport metrics");
        this.buffer = sessionOutputBuffer;
        this.channel = writableByteChannel;
        this.metrics = basicHttpTransportMetrics;
    }

    protected WritableByteChannel channel() {
        return this.channel;
    }

    protected SessionOutputBuffer buffer() {
        return this.buffer;
    }

    protected BasicHttpTransportMetrics metrics() {
        return this.metrics;
    }

    @Override // org.apache.hc.core5.http.nio.ContentEncoder
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // org.apache.hc.core5.http.nio.ContentEncoder
    public void complete(List<? extends Header> list) throws IOException {
        this.completed = true;
    }

    public final void complete() throws IOException {
        complete(null);
    }

    protected void assertNotCompleted() {
        Asserts.check(!this.completed, "Encoding process already completed");
    }

    protected int flushToChannel() throws IOException {
        if (!this.buffer.hasData()) {
            return 0;
        }
        int iFlush = this.buffer.flush(this.channel);
        if (iFlush > 0) {
            this.metrics.incrementBytesTransferred(iFlush);
        }
        return iFlush;
    }

    protected int writeToChannel(ByteBuffer byteBuffer) throws IOException {
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        int iWrite = this.channel.write(byteBuffer);
        if (iWrite > 0) {
            this.metrics.incrementBytesTransferred(iWrite);
        }
        return iWrite;
    }

    protected int writeToChannel(ByteBuffer byteBuffer, int i) throws IOException {
        return doWriteChunk(byteBuffer, i, true);
    }

    protected int writeToBuffer(ByteBuffer byteBuffer, int i) throws IOException {
        return doWriteChunk(byteBuffer, i, false);
    }

    private int doWriteChunk(ByteBuffer byteBuffer, int i, boolean z) throws IOException {
        if (byteBuffer.remaining() > i) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(iLimit - (byteBuffer.remaining() - i));
            int iDoWriteChunk = doWriteChunk(byteBuffer, z);
            byteBuffer.limit(iLimit);
            return iDoWriteChunk;
        }
        return doWriteChunk(byteBuffer, z);
    }

    private int doWriteChunk(ByteBuffer byteBuffer, boolean z) throws IOException {
        if (z) {
            int iWrite = this.channel.write(byteBuffer);
            if (iWrite > 0) {
                this.metrics.incrementBytesTransferred(iWrite);
            }
            return iWrite;
        }
        int iRemaining = byteBuffer.remaining();
        this.buffer.write(byteBuffer);
        return iRemaining;
    }
}
